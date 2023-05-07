package sungsu.springone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
                         Model model,
                         RedirectAttributes redirectAttributes){

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

        redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다.");

        return "redirect:/members/login";
    }

    @GetMapping("members/login")
    public String loginMember(){
        return "/member/memberLoginForm";
    }

    @GetMapping("members/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "/member/memberLoginForm";
    }
}
