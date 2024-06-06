package com.poly.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Configuration class for defining resource beans.
 */
@Configuration
public class ResourceConfig {
	/**
	 * Creates a bean for the message resource.
	 *
	 * @return the message source bean
	 */
	@Bean("messageResource")
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasename("classpath:messages/ErrorMessages");
		ms.setDefaultEncoding("utf-8");
		return ms;
	}

	/**
	 * Creates a bean for the local validator factory.
	 *
	 * @return the local validator factory bean
	 */
	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(getMessageSource());
		return bean;
	}
}
