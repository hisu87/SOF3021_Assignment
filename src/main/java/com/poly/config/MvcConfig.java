package com.poly.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class is responsible for configuring the MVC (Model-View-Controller)
 * framework.
 * It implements the WebMvcConfigurer interface to customize the configuration.
 */
public class MvcConfig implements WebMvcConfigurer {

	/**
	 * Adds resource handlers for serving static resources.
	 *
	 * @param registry the resource handler registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		exposeDirectory("images/", registry);
	}

	/**
	 * Exposes a directory to be accessible by the web application.
	 *
	 * @param dirName  the name of the directory to be exposed
	 * @param registry the ResourceHandlerRegistry to configure the resource
	 *                 handling
	 */
	public void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
		Path uploadDir = Paths.get(dirName);
		String uploadPath = uploadDir.toFile().getAbsolutePath();
		if (dirName.startsWith("../")) {
			dirName = dirName.replace("../", "");
		}

		registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");
	}
}
