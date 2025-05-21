package com.example.chartjs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.chartjs.dto.LoginHistory;
import com.example.chartjs.dto.Member;

@Mapper
public interface MemberMapper {
	int countPwHistory(String id, String pw);
	void insertPwHistory(String id, String pw);
	void updateMemberPassword(String id,String pw);
    void insertLoginHistory(String id);
    List<String> findInactiveMembers();
    void updateMemberActive(String id);
    String findEmailById(String id);
	Member login(Member member);
	List<LoginHistory> findLoginHistoryById(String id);
	void deleteOldLoginHistory();
}
