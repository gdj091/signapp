package com.example.chartjs.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SampleForm {
	@NotEmpty(message="아이디를 입력하세요")
	@Size(min = 4, max = 10, message="아이디는 4자이상 10자이하입니다.")
	private String name;
	
	@Min(value=0, message = "나이는 0~200 사이입니다.")
	@Max(value=200, message = "나이는 0~200 사이입니다.")
	private int age;
}
