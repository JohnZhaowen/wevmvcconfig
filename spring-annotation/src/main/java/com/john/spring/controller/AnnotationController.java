package com.john.spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.john.spring.annotation.RequestBodyExtention;
import com.john.spring.entity.Stu;
import com.john.spring.entity.User;

@RestController
public class AnnotationController {
	
	@RequestMapping("/annotation")
	public String annotation(@RequestBodyExtention User user, @RequestBodyExtention Stu stu) {
		return "user: " + user.getName() + ", stu: " + stu.getName();
	}
	
	@RequestMapping("/user")
	public String user(User user) {
		return user.toString();
	}
	
	@PostMapping("/test")
	public String test(String type, String img_id) {
		System.out.println(type);
		return type + img_id;
	}
	
}
