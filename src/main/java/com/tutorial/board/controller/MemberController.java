package com.tutorial.board.controller;

import com.tutorial.board.dto.MemberDto;
import com.tutorial.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/member")
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    public MemberController() {
    }

    @GetMapping("/")
    public String list() {
        return "member/list.html";
    }

    @GetMapping("/register")
    public String register() {
        return "member/register.html";
    }

    @PostMapping("/register")
    public String register(MemberDto memberDto) {
        try {
            memberService.addMember(memberDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
