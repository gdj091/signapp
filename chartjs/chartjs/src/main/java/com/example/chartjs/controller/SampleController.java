package com.example.chartjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.chartjs.dto.SampleForm;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	@GetMapping("/addSample")
	public String addSample() {
		return "addSample";
	}
	
	@PostMapping("/addSample")
	public String addSample(@Valid SampleForm sampleForm, Errors err, Model model) {
		// 커맨드객체 sampleForm이 생성될때 @Valid 유효성 검증이 먼저 선행된다. -> 에러발생시 Errors 객체에 에러정보가 추가
		log.info(sampleForm.toString());
		// @Valid선행작업에서 Errors가 발생한다면 : 입력값 유효성 검사 후 입력실패
		if(err.hasErrors()) {
			log.info("validation error 발생");
			for(FieldError fe : err.getFieldErrors()) {
				
				model.addAttribute(fe.getField()+"ErrMsg", fe.getDefaultMessage());
				// model.addAttribute("nameErrMsg", "아이디는 4자이상 10자이하로 하셔야 합니다");
			}
			return "addSample";
		}
		
		// 유효성 검사 성공시 Sample이 DB에 입력
		
		return "redirect:/"; // 입력성공시 리다렉트 URL
	}
	
}
