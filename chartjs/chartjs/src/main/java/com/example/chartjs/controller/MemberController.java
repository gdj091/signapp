package com.example.chartjs.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.chartjs.dto.LoginHistory;
import com.example.chartjs.dto.Member;
import com.example.chartjs.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberMapper memberMapper;
    
    // 비밀번호 변경 처리
    @PostMapping("/updatePassword")
    public String updatePassword(@RequestParam String id,
                                 @RequestParam String newPw,
                                 Model model,
                                 HttpSession session) {
        int count = memberMapper.countPwHistory(id, newPw);
        if (count > 0) { // 이미 사용한 비밀번호일때(중복일때)
            model.addAttribute("msg", "이미 사용한 비밀번호입니다. 다른 비밀번호를 입력하세요.");
        } else {
            memberMapper.updateMemberPassword(id, newPw); // 비밀번호변경
            memberMapper.insertPwHistory(id, newPw);	  // 비번기록저장
            model.addAttribute("msg", "비밀번호가 성공적으로 변경되었습니다.");
        }

        Member loginMember = (Member) session.getAttribute("loginMember"); // 로그인에서 회원세션 정보 가져오기
        List<LoginHistory> loginHistories = memberMapper.findLoginHistoryById(loginMember.getId()); // 로그인 기록 조회
        model.addAttribute("loginMember", loginMember);
        model.addAttribute("loginHistories", loginHistories);

        return "main"; 
    }
    // AJAX 중복검사
    @PostMapping("/checkPwHistory")
    @ResponseBody
    public String checkPwHistory(@RequestParam String id, @RequestParam String pw) {
        // 해당 ID의 과거 비밀번호 사용 여부를 확인
        int count = memberMapper.countPwHistory(id, pw);

        if (count > 0) {
            // 과거에 사용한 비밀번호인 경우
            return "used";
        } else {
            // 처음 사용하는 비밀번호인 경우
            return "ok";
        }
    }
    
    @GetMapping("/main")
    public String mainPage(HttpSession session, Model model) {
        Member loginMember = (Member) session.getAttribute("loginMember");
        
        if (loginMember == null) {
            return "redirect:/login"; // 로그인 안 된 경우
        }

        List<LoginHistory> loginHistories = memberMapper.findLoginHistoryById(loginMember.getId());
        model.addAttribute("loginHistories", loginHistories);
        model.addAttribute("loginMember", loginMember);
        return "main"; // → main.jsp
    }
    @GetMapping("/login")
    public String loginForm() {
        return "login"; // → views/login.jsp 로 이동
    }
    @PostMapping("/login")
    public String login(@ModelAttribute Member member, Model model, HttpSession session) {
        Member loginMember = memberMapper.login(member);

        if (loginMember != null) {
            // 로그인 성공
        	memberMapper.insertLoginHistory(member.getId());
            session.setAttribute("loginMember", loginMember); // 로그인 정보 저장
            return "redirect:/main";
        } else {
            // 로그인 실패
            model.addAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login"; // forward로 login.jsp 다시 보여줌
        }
    }
    
}