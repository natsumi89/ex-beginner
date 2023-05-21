package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;


@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	@Autowired
	private ServletContext application;
	
	@GetMapping("")
	public String index(Model model) {
		return "exam03";
	}
	@PostMapping("/result")
	public String index2(Integer num1,Integer num2,Integer num3) {
		int answer = num1 + num2 + num3;
		int total = (int)(answer * 1.1);
		
		application.setAttribute("answer", answer);
		application.setAttribute("total", total);
		
		return "exam03-result";
	}

}
