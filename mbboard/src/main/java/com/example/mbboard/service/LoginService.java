package com.example.mbboard.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.controller.FilterTestController;
import com.example.mbboard.dto.Member;
import com.example.mbboard.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class LoginService implements ILoginServic {
    private final FilterTestController filterTestController;
	@Autowired JavaMailSender javaMailSender;
	@Autowired LoginMapper loginMapper;

    LoginService(FilterTestController filterTestController) {
        this.filterTestController = filterTestController;
    }

    @Override
    public int rechangeMemberPw(Member member) {
    	return loginMapper.rechangeMemberPw(member);
    }
    
    
	@Override
	public void changeMemberPwByAdmin(Member member) {
		// 새로운 패스워드 생성
		String randomPw = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		member.setMemberPw(randomPw);
		int row = loginMapper.updateMemberPwByAdmin(member);
		if( row == 1) {
			//메일로 변경된 비밀번호 전송
			log.info("변경된 비밀번호 : " +randomPw);
			
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("admin@localhost.com");
			msg.setTo(member.getEmail());
			msg.setSubject("변경된 비밀번호를 알려드립니다.");
			msg.setText("변경된 임시 비밀번호는 [" + randomPw + "] 입니다.\n10분 안에 로그인하여 비밀번호를 변경해주세요.");
			
			javaMailSender.send(msg);
		}
	}
	
	@Override
	public Member login(Member paramMember) {
		return loginMapper.login(paramMember);
	}
	
	@Override
	public int update(Member paramMember) {
		return loginMapper.update(paramMember);
	}
	
	@Override
	public List<Member> findAllMembers() {
	    return loginMapper.findAllMembers();
	}

	@Override
	public int updateRole(Member member) {
	    return loginMapper.updateRole(member);
	}
	
	@Override
	public int insertMember(Member member) {
	    return loginMapper.insertMember(member);
	}
	
	@Override
	public int deleteMember(String memberId) {
	    return loginMapper.deleteMember(memberId);
	}
	
	@Override
    public List<Member> findMatchMembers() {
        return loginMapper.findMatchMembers();
    }
	
}
