package sungsu.springone.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import sungsu.springone.controller.MemberFormDto;
import sungsu.springone.entity.Member;
import sungsu.springone.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Test
    @DisplayName("회원 이메일 중복 시 예외처리")
    void test1() throws Exception{
        //given
        Member member = Member.builder()
                .name("김성수")
                .email("1234@naver.com")
                .address("경기도")
                .password("김성수")
                .build();

        Member member2 = Member.builder()
                .name("김성수2")
                .email("1234@naver.com")
                .address("경기도")
                .password("김성수")
                .build();

        //when
        memberService.join(member);

        DuplicateKeyException exception = assertThrows(DuplicateKeyException.class, () -> {
            memberService.join(member2);
        });

        //then
        assertEquals("이미 가입된 회원입니다.", exception.getMessage());
        assertEquals("1234@naver.com",
                memberRepository.findByEmail(member.getEmail()).getEmail());
    }


    @Test
    @DisplayName("비밀번호 암호화 테스트")
    void test2(){
        //given

        String password = passwordEncoder.encode("김성수");

        Member member = Member.builder()
                .name("김성수")
                .email("1234@naver.com")
                .address("경기도")
                .password(password)
                .build();


        //when
        memberService.join(member);


        //then
        assertEquals(password, memberRepository.find(member.getId()).getPassword());
    }

    @Test
    @DisplayName("로그인 기능 테스트")
    void test3(){
        //given

        String password = passwordEncoder.encode("김성수");

        MemberFormDto memberFormDto = new MemberFormDto();

        memberFormDto.setName("김성수");
        memberFormDto.setEmail("1234@naver.com");
        memberFormDto.setPassword("1234");
        memberFormDto.setAddress("경기도");

        Member member = Member.createMember(memberFormDto, passwordEncoder);


        //when
        memberService.join(member);

        UserDetails userDetails = memberService.loadUserByUsername(member.getEmail());

        //then
        assertEquals("1234@naver.com", userDetails.getUsername());
    }
}