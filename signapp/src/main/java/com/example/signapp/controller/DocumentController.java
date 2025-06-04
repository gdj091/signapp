package com.example.signapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.signapp.dto.Document;
import com.example.signapp.dto.Employee;
import com.example.signapp.service.DocumentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentService;
    

    @GetMapping("/docList")
    public String docList(Model model, HttpSession session) {
        Employee loginMember = (Employee) session.getAttribute("loginMember");
        if (loginMember == null) {
            return "redirect:/login";
        }

        List<Document> docList = documentService.findAll();
        model.addAttribute("docList", docList);
        return "docList";
    }
    
    @GetMapping("/uploadDoc")
    public String uploadForm(HttpSession session) {
        Employee loginMember = (Employee) session.getAttribute("loginMember");
        if (loginMember == null || loginMember.getLevel() < 1) {
            return "redirect:/login";
        }
        return "uploadDoc";
    }

    @PostMapping("/uploadDoc")
    public String uploadDoc(@ModelAttribute Document document, HttpSession session) {
        Employee loginMember = (Employee) session.getAttribute("loginMember");
        if (loginMember == null || loginMember.getLevel() < 1) {
            return "redirect:/login";
        }

        document.setUploaderNo(loginMember.getNo());
        boolean success = documentService.upload(document);
        return success ? "redirect:/docList" : "uploadDoc";
    }
}
