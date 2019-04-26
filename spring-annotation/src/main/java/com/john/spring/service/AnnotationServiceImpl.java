package com.john.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.john.spring.entity.User;

@Service
public class AnnotationServiceImpl {
	
	@Autowired
	private User user;
	
	public AnnotationServiceImpl() {
		
	}
	
	public String getName() {
		return user.getName();
	}
}
