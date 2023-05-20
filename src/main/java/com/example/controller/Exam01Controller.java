package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam01")
public class Exam01Controller {
	@GetMapping("")
	public String index() {
		return "exam01";
	}
	@PostMapping("/result")
	public String index2() {
		return "exam-01";
	}

}