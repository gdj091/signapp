package com.example.signapp2.dto;

import lombok.Data;

@Data
public class Document {
	private int documentNo;
	private String title;
	private String content;
	private String writer;
}
