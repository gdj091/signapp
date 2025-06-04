package com.example.signapp.dto;

import lombok.Data;

@Data
public class Document {
	private int docId;
	private String title;
	private String content;
	private int uploaderNo;
	private String createdAt;
}