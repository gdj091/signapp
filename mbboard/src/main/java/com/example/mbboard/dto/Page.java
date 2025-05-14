package com.example.mbboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Page {
	private int currentPage;
	private int rowPerPage;
	private int beginRow;
	private int totalCount;
	
	private String searchWord;

	public Page(int rowPerPage, int currentPage, int totalCount, String searchWord) {
		this.rowPerPage = rowPerPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.searchWord = searchWord;
		this.beginRow = (currentPage - 1) * rowPerPage;
		
	}
	
	public int getLastPage() {
		int lastPage = this.totalCount/this.rowPerPage;
		if(this.totalCount%this.rowPerPage != 0) {
			lastPage += 1;
		}
		return lastPage;
	}
	
}
