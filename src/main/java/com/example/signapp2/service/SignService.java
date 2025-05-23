package com.example.signapp2.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.signapp2.dto.Document;
import com.example.signapp2.dto.Employee;
import com.example.signapp2.dto.Page;
import com.example.signapp2.dto.SignForm;
import com.example.signapp2.mapper.SignMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class SignService {
	@Autowired SignMapper signMapper;
	
	// 로그인
	public Employee login(Employee employee) {
		return signMapper.login(employee);
	}
	
	// 아이디 중복 확인
	public String searchId(String id) {
		return signMapper.searchId(id);
	}
	
	// 문서 전체 개수
	public int documentCount() {
		return signMapper.documentCount();
	}
	
	// 문서 리스트 
	public List<Document> documentList(Page page){
		return signMapper.documentList(page);
	}
	// 회원가입
	public void signUp(Employee employee) {
		signMapper.signUp(employee);
	}


	public boolean addSign(SignForm signForm) {
		// 0) signImg 파일이름 생성
		String ext = ".png"; // data:image/png;Base64,... 에서 png 구해서 ext에 입력
		String filename = UUID.randomUUID().toString().replace("-","")+ext;
		
		// 1) 이미지를 디코딩해서 원하는 위치에 저장
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("c:\\sign_img\\"+filename); // FileNotFoundException
			// 파일을 만들 수 있는 비어있는 OutputStream에 signImg안에 이미지문자를 디코딩
			fos.write(Base64.getDecoder().decode(signForm.getSignImg().split(",")[1])); // IOException
			
		} catch (FileNotFoundException e) {
			log.error("파일 생성 실패");
			throw new RuntimeException(); // class SignException extends RuntimeException
		} catch (IOException e) {
			log.error("파일 디코딩 실패");
			throw new RuntimeException();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 2) mapper 호출
		// signMapper.addSign(signForm);
		
		return true;
	
	}

}
