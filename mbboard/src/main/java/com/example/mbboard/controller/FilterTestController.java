package com.example.mbboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FilterTestController {
	@GetMapping("/a")
	public String a() {
		log.info("/a 요청 실행");
		return "";
	}
	
	@GetMapping("/b")
	public String b() {
		log.info("/b 요청 실행");
		return "";
	}
	
	@GetMapping("/a/x")
	public String ax() {
		log.info("/ax 요청 실행");
		return "";
	}
	
	@GetMapping("/a/y")
	public String ay() {
		log.info("/ay 요청 실행");
		return "";
	}
}
