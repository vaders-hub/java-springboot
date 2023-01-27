package com.tutorial.board.controller;

import com.tutorial.board.domain.entity.Member;
import com.tutorial.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("member")
@Controller
public class LoginController {
    @Autowired
    private MemberService memberService;

    public LoginController() {

    }

    //    @GetMapping("/login")
//    public String loginView() {
//        return "login.html";
//    }
    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/loginSuccess")
    public void loginSuccess() {
    }

    @GetMapping("/accessDenied")
    public void accessDenied() {
    }

    
    @GetMapping("/logout")
    public String logoutView(SessionStatus status) {
        status.setComplete();
        return "/index.html";
    }

    @PostMapping("/login")
    public String login(Member member, Model model) {
        Member findMember = memberService.getMember(member);

        if (findMember != null && findMember.getPassword().equals(member.getPassword())) {
            model.addAttribute("member", findMember);

            return "redirect:/member/list";
        } else {
            return "redirect:register";
        }
    }

}
