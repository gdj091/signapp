package com.example.mbboard.service;

import java.util.List;

import com.example.mbboard.dto.Member;

public interface ILoginServic {
	Member login(Member paramMember);
	int update(Member paramMember);
	List<Member> findAllMembers();
	int updateRole(Member member);
	int insertMember(Member member);
	int deleteMember(String memberId);
	List<Member> findMatchMembers();
}
