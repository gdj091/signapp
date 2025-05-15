package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mbboard.dto.Member;
import com.example.mbboard.service.ILoginServic;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired ILoginServic loginService;
	
	@GetMapping("/member/memberHome")
	public String memberHome() {
	    return "/member/memberHome"; // ViewResolver가 /WEB-INF/views/member/memberHome.jsp 찾음
	}
	
	@GetMapping("/updatePw")
	public String updatePw() {
	    return "/updatePw"; // 비밀번호 변경 입력 폼
	}
	@PostMapping("/updatePw")
	public String updatePw(@RequestParam String memberId,
            @RequestParam String newPassword) {
		Member member = new Member();
	    member.setMemberId(memberId);
	    member.setNewPassword(newPassword); 
		loginService.update(member);
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, Member paramMember) {
		Member loginMember = loginService.login(paramMember);
		if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			return "/member/memberHome";
		}else {
	        return "redirect:/login?error=1"; // 실패 시 다시 로그인 페이지
	    }
		
	}
	
	@GetMapping("/member/info") // 세션안에 상세정보를 보여주는 요청 -> 로그인 상태에서 요청가능 -> 필터1
	public String info() {
		
		return "/member/info";
	}
	
	@GetMapping("/admin/adminHome") // 관리자 페이지 요청 -> 로그인 상태이고 role이 'ADMIN'요청가능 -> 필터2
	public String adminHome(Model model) {
		model.addAttribute("memberList", loginService.findAllMembers());
		return "/admin/adminHome";
	}
	
    @PostMapping("/admin/updateRole")
    public String updateRole(@RequestParam int memberNo,
    						 @RequestParam String memberId,
    						 @RequestParam String memberData,
    						 @RequestParam String memberSub,
                             @RequestParam String memberRole,
                             @RequestParam String memberPosition) {
        Member member = new Member();
        member.setMemberNo(memberNo);
        member.setMemberId(memberId);
        member.setMemberSub(memberSub);
        member.setMemberData(memberData);
        member.setMemberRole(memberRole);
        member.setMemberPosition(memberPosition);
        loginService.updateRole(member);
        return "redirect:/admin/adminHome";
    }
    
    @PostMapping("/admin/insertMember")
    public String insertMember(Member member) {
        loginService.insertMember(member);  
        return "redirect:/admin/adminHome"; 
    }
    
    @PostMapping("/admin/deleteMember")
    public String deleteMember(@RequestParam String memberId) {
        loginService.deleteMember(memberId);
        return "redirect:/admin/adminHome";
    }
    
    @GetMapping("/admin/match")
    public String matchList(Model model) {
        List<Member> matchList = loginService.findMatchMembers(); 
        model.addAttribute("matchList", matchList);
        return "/admin/match"; 
    }
    
}
