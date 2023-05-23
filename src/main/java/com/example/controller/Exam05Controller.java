package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
	@Autowired
	private MemberRepository repository;
	@GetMapping("")
	public String index() {
		return "exam05";
	}
	
	@PostMapping("/result")
	public String index2(String name,Model model) {
		List<Member> memberList = repository.findAll(name);
		model.addAttribute("memberList", memberList);
		
		return "exam05-result";
	}

}
