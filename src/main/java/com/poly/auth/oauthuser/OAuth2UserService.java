package com.poly.auth.oauthuser;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.poly.auth.UserRoot;
import com.poly.dao.UserDAO;
import com.poly.entity.User;
import com.poly.utils._enum.AuthTypeEnum;

@Service
public class OAuth2UserService extends DefaultOAuth2UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);
		String typeOAuth = userRequest.getClientRegistration().getClientName();

		OAuth2UserInfo oAuth2UserInfo = switch (typeOAuth) {
		case "Google" -> new GoogleUserInfo(oAuth2User.getAttributes());
		case "Facebook" -> new FacebookUserInfo(oAuth2User.getAttributes());
		default -> throw new IllegalArgumentException("Unexpected value: " + typeOAuth);
		};

		User user;
		Optional<User> optionalUser = userDAO.findByEmail(oAuth2UserInfo.getEmail());

		if (optionalUser.isPresent()) {
			// Update
			user = optionalUser.get();

			user.setName(oAuth2UserInfo.getName());
			user.setAuthType(typeOAuth.equals("Google") ? AuthTypeEnum.GOOGLE : AuthTypeEnum.FACEBOOK);

			user = userDAO.save(user);
		} else {
			// Create
			user = userDAO.save(User.builder()
					.name(oAuth2UserInfo.getName())
					.email(oAuth2UserInfo.getEmail())
					.authType(typeOAuth.equals("Google") ? AuthTypeEnum.GOOGLE : AuthTypeEnum.FACEBOOK)
					.build());
		}

		return UserRoot.create(user, oAuth2UserInfo.getAttributes());
	}

}
