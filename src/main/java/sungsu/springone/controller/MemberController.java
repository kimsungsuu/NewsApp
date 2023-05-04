package sungsu.springone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sungsu.springone.dto.MemberFormDto;
import sungsu.springone.entity.Member;
import sungsu.springone.service.MemberService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "/member/createMemberForm";
    }


    @PostMapping("/members/new")
    public String create(@Valid MemberFormDto memberFormDto,
                         BindingResult bindingResult,
                         Model model){

        if (bindingResult.hasErrors()) {
            return "member/createMemberForm";
        }

        try{
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.join(member);
        }catch (DuplicateKeyException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "member/createMemberForm";
        }

        return "redirect:/";
    }
}
