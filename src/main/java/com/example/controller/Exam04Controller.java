package com.example.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	@GetMapping("")
	public String index(Model model,UserForm userForm) {
		return "exam04";
	}
	
	@PostMapping("/result")
	public String index2(@Validated UserForm form,BindingResult result,RedirectAttributes redirectAttributes,Model model) {
		if(result.hasErrors()) {
			return index(model,form);
		}
		
		User user = new User();
		redirectAttributes.addFlashAttribute("user",form);
		BeanUtils.copyProperties(form, user);
		return "redirect:/exam04/toresult";
	}
	
	@GetMapping("/toresult")
	public String toresult() {
		return "exam04-result";
	}

}
