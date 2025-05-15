package com.example.mbboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Member;
import com.example.mbboard.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class LoginService implements ILoginServic {
	@Autowired LoginMapper loginMapper;
	
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
