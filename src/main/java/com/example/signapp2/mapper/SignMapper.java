package com.example.signapp2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.signapp2.dto.Document;
import com.example.signapp2.dto.Employee;
import com.example.signapp2.dto.Page;
import com.example.signapp2.dto.SignForm;

@Mapper
public interface SignMapper {
	void signUp(Employee employee);
	void addSign(SignForm signForm);
	String searchId(String id);
	Employee login(Employee employee);
	List<Document> documentList(Page page);
	int documentCount();
}
