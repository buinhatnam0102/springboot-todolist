package com.todolist;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
				String rawPassword= "12345";
		String encodePassword =  encoder.encode(rawPassword);
		System.out.println(encodePassword);		
	}

}
