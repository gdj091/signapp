package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.dto.Member;
import com.example.mbboard.service.ILoginServic;
import com.example.mbboard.service.IRootService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

    private final BoardController boardController;

	@Autowired ILoginServic loginService;
	@Autowired IRootService rootService;

    LoginController(BoardController boardController) {
        this.boardController = boardController;
    }
    
    @GetMapping("/rechangeMemberPw")
    public String rechangeMemberPwForm() {
        return "/rechangeMemberPw"; // 비밀번호 재설정 입력 폼
    }
    
    @PostMapping("/rechangeMemberPw")
    public String rechangeMemberPw(Member member, Model model) {
        int result = loginService.rechangeMemberPw(member);
        
        if (result == 1) {
            // 비밀번호 재설정 성공
            return "redirect:/login";
        } else {
            // 실패 시 에러 메시지 전달 후 다시 폼으로
            model.addAttribute("error", "입력한 현재 비밀번호가 맞지 않거나 시간이 초과되었습니다.");
            return "/rechangeMemberPw";
        }
    }
    
    @GetMapping("/findMemberPw")
    public String findMemberPw() {
    	return "findMemberPw";
    }
    
    @PostMapping("/findMemberPw")
    public String findMemberPw(Member member) {
    	// 비밀번호를 변경
    	loginService.changeMemberPwByAdmin(member);
    	// 분실 비밀번호 변경페이지로 redirect
		return "rechangeMemberPw";
    }
    
	
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
	public String login(HttpSession session, Member paramMember, HttpServletResponse response) {
		Member loginMember = loginService.login(paramMember);
		if(loginMember != null) {
			
			log.info(paramMember.toString());
			
			// 쿠키에도 로그인에 성공한 ID만 저장
			if(paramMember.getSaveIdCk() != null) {
				Cookie c = new Cookie("saveId", paramMember.getMemberId());
				response.addCookie(c);
			} else {
				Cookie c = new Cookie("saveId", "");
				response.addCookie(c);
			}
			
			session.setAttribute("loginMember", loginMember);
			ConnectCount cc =new ConnectCount();
			cc.setMemberRole(loginMember.getMemberRole());
			if(rootService.getConnectDateByKey(cc) == null) {
				rootService.addConnectCount(cc); // 오늘날짜 loginMember.getMemberRole()로 1행을 추가 카운터 1
			}else {
				rootService.modifyConnectCount(cc);
			}
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
