package com.poly.config;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.poly.auth.UserRootService;
import com.poly.auth.oauthuser.OAuth2UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	UserRootService userRootService;

	@Autowired
	OAuth2UserService oAuth2UserService;

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userRootService);
		authProvider.setPasswordEncoder(getPasswordEncoder());
		return authProvider;
	}
	/*
	 * Lớp DaoAuthenticationProvider có một số phương thức và thuộc tính quan trọng:
	 * 
	 * passwordEncoder: Đây là một instance của PasswordEncoder, được sử dụng để mã
	 * hóa và xác minh mật khẩu. Phương thức setPasswordEncoder được sử dụng để
	 * thiết lập thuộc tính này, và nó cũng đảm bảo rằng PasswordEncoder được cung
	 * cấp không null.
	 * userDetailsService: Đây là một instance của UserDetailsService, được sử dụng
	 * để tải dữ liệu cụ thể của người dùng. Phương thức setUserDetailsService được
	 * sử dụng để thiết lập thuộc tính này.
	 * additionalAuthenticationChecks: Phương thức này được sử dụng để thực hiện các
	 * kiểm tra bổ sung trên thông tin xác thực của người dùng, chẳng hạn như xác
	 * minh rằng mật khẩu được cung cấp khớp với mật khẩu đã lưu trữ cho người dùng.
	 * retrieveUser: Phương thức này được sử dụng để lấy thông tin người dùng từ
	 * UserDetailsService. Nó cũng bao gồm bảo vệ chống lại các cuộc tấn công đo
	 * thời gian, đó là một loại cuộc tấn công mà kẻ tấn công cố gắng đoán mật khẩu
	 * bằng cách đo thời gian hệ thống phản hồi.
	 * 
	 */

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(req -> req
						.requestMatchers("/account/profile", "/account/change-password", "/cart/**", "/checkout/**",
								"/order/**")
						.authenticated()
						 .requestMatchers("/admin/**").hasAnyAuthority("admin")
						.anyRequest().permitAll())
				.formLogin(form -> form
						.loginPage("/account/login")
						.usernameParameter("email")
						.passwordParameter("password")
						.loginProcessingUrl("/account/login-check")
						.defaultSuccessUrl("/account/login/success")
						.failureUrl("/account/login/failure"))
				.oauth2Login(ou -> ou
						.authorizationEndpoint(e -> e.baseUri("/oauth2/authorization"))
						.redirectionEndpoint(e -> e.baseUri("/login/oauth2/code/*"))
						.userInfoEndpoint(e -> e.userService(oAuth2UserService))
						.defaultSuccessUrl("/account/login/success"))
				.exceptionHandling(e -> e.accessDeniedPage("/account/accessDenied"))
				.logout((logout) -> logout.logoutUrl("/account/logout"))
				.build();
	}

	// Phương thức filterChain(HttpSecurity http) là nơi định nghĩa cấu hình bảo mật
	// HTTP.
	// Nó nhận một đối tượng HttpSecurity làm tham số, được sử dụng để cấu hình chi
	// tiết bảo mật.

	// Dòng csrf(AbstractHttpConfigurer::disable) được sử dụng để vô hiệu hóa bảo vệ
	// Cross-Site Request Forgery (CSRF).
	// CSRF là một cuộc tấn công lừa đảo người dùng gửi yêu cầu độc hại. Ở đây, nó
	// được vô hiệu hóa để đơn giản hóa,
	// nhưng trong ứng dụng thực tế, bạn nên bật và cấu hình bảo vệ CSRF một cách
	// đúng đắn.

	// Phương thức authorizeHttpRequests được sử dụng để xác định các yêu cầu nào
	// cần xác thực.
	// Trong trường hợp này, bất kỳ yêu cầu nào đến "/account/profile",
	// "/account/change-password", "/cart/", "/checkout/", "/order/**"
	// phải được xác thực. Các yêu cầu khác được phép mà không cần xác thực.

	// Phương thức formLogin được sử dụng để cấu hình xác thực dựa trên biểu mẫu.
	// Nó chỉ định URL trang đăng nhập, các tham số cho tên người dùng và mật khẩu,
	// URL mà dữ liệu biểu mẫu đăng nhập sẽ được gửi để xử lý, và các URL để chuyển
	// hướng sau khi đăng nhập thành công hoặc thất bại.

	// Phương thức oauth2Login được sử dụng để cấu hình Đăng nhập OAuth 2.0.
	// Nó chỉ định URI cơ sở cho điểm cuối ủy quyền và điểm cuối chuyển hướng,
	// OAuth2UserService để sử dụng để lấy chi tiết người dùng, và URL mặc định để
	// chuyển hướng sau khi đăng nhập thành công.

	// Phương thức exceptionHandling được sử dụng để xử lý các ngoại lệ.
	// Trong trường hợp này, nó được cấu hình để chuyển hướng đến
	// "/account/accessDenied" khi một AccessDeniedException được ném ra.

	// Phương thức logout được sử dụng để cấu hình xử lý đăng xuất.
	// Nó chỉ định URL để kích hoạt đăng xuất.

	// Cuối cùng, phương thức build được gọi để xây dựng và trả về
	// SecurityFilterChain.

}
