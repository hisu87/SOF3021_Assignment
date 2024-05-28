package com.poly.auth.oauthuser;

import java.util.Map;

import lombok.Getter;

@Getter
public abstract class OAuth2UserInfo {

	protected Map<String, Object> attributes;

	public OAuth2UserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	protected abstract String getName();

	protected abstract String getEmail();

}
