package com.john.spring.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.john.spring.annotation.RequestBodyExtentionHandler;

@Configuration
public class SpringWebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private RequestBodyExtentionHandler requestBodyExtentionHandler;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
		resolvers.add(requestBodyExtentionHandler);
	}
}
