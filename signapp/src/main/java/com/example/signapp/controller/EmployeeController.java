package com.example.signapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.signapp.dto.Employee;
import com.example.signapp.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; 

    @GetMapping("/join")
    public String joinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String join(Employee employee) {
        boolean result = employeeService.join(employee);
        return result ? "redirect:/login" : "join";
    }
    
    @GetMapping("/login")
    public String loginForm() {
        return "login"; 
    }

    @PostMapping("/login")
    public String login(Employee employee, HttpSession session) {
        Employee loginMember = employeeService.login(employee);
        if (loginMember != null) {
            session.setAttribute("loginMember", loginMember);
            return "redirect:/docList";        
            } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}