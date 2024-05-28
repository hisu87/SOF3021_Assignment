package com.poly.config;

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

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(req -> req
						.requestMatchers("/account/profile", "/account/change-password", "/cart/**", "/checkout/**", "/order/**").authenticated()
						//.requestMatchers("/admin/**").hasRole("ADMIN")
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

}
