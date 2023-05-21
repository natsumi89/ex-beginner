package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	@Autowired
	private HttpSession session;

	@GetMapping("")
	public String index(Model model) {
		return "exam02";
	}
	@PostMapping("/result")
	public String result(Integer num1,Integer num2,Model model
		,RedirectAttributes redirectAttributes) {
		session.setAttribute("num1",num1);
		session.setAttribute("num2",num2);
		Integer answer  = num1 + num2;
        redirectAttributes.addFlashAttribute("answer",answer);
		System.out.println(answer);
		
		return "redirect:/exam02/toresult";
	}
	@GetMapping("/toresult")
	public String toresult() {
		return "exam02-result";
	}
	
	@GetMapping("/toresult2")
	public String toresult2() {
		return "exam02-result2";
	}

}
