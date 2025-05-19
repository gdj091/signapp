package com.example.mbboard.dto;

import lombok.Data;

@Data
public class Member {
	private int memberNo;
	private String memberId;
	private String memberData;
	private String memberSub;
	private String memberPw;
	private String memberRole;
	private String memberPosition;
	private String newPassword;
	private String saveIdCk;
	private String email;
	private String pwcktime;
	private String reMemberPw;
}
