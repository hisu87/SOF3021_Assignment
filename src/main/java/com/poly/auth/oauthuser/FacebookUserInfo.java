package com.poly.auth.oauthuser;

import java.util.Map;

public class FacebookUserInfo extends OAuth2UserInfo {

	public FacebookUserInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	protected String getName() {
		return (String) attributes.get("name");
	}

	@Override
	protected String getEmail() {
		return (String) attributes.get("email");
	}

}
