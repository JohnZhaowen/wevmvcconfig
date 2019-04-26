package com.john.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.john.spring.entity.User;

@Configuration
public class UserConfig {
	
	@Bean
	public User user() {
		return new User("zhangsan");
	}
}
