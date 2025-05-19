package com.example.mbboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mbboard.dto.Member;

@Mapper
public interface LoginMapper {
	Member login(Member paramMember);
	int update(Member paramMember);
	List<Member> findAllMembers();
	int updateRole(Member member);
	int insertMember(Member member);
	int deleteMember(String memberId);
	List<Member> findMatchMembers();
	int updateMemberPwByAdmin(Member member);
	int rechangeMemberPw(Member member);
}
