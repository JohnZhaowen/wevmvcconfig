package com.john.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.john.spring.entity.Stu;

@Configuration
public class StuConfig {
	
	@Bean
	public Stu stu() {
		return new Stu("stu - lisi");
	}
}
