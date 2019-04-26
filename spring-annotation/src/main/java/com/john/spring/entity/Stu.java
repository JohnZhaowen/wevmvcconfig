package com.john.spring.entity;

public class Stu {
	
	private String name;
	
	public Stu(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
