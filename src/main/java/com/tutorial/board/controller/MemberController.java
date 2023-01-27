package com.tutorial.board.controller;

import com.tutorial.board.domain.entity.Member;
import com.tutorial.board.dto.MemberDto;
import com.tutorial.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SessionAttributes("member")
@RequestMapping(value = "/member")
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    public MemberController() {
    }

    @ModelAttribute("member")
    public Member setMember() {
        return new Member();
    }

    @GetMapping("/list")
    public String memberList(@ModelAttribute("member") Member member, Model model) {
        if (member.getId() == null) {
            return "redirect:/login";
        }
        List<MemberDto> memberDtoList = memberService.getMemberList();
        model.addAttribute("memberList", memberDtoList);
        System.out.println("memberList");
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
