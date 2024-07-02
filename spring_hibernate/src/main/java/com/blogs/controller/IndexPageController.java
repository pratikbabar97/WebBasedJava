package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {
	public IndexPageController() {
		System.out.println("inside the index CTOR");
	}
	@GetMapping("/")
	public String indexRendering() {
		return "/index";
	}

}
