package sungsu.springone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungsu.springone.entity.Member;
import sungsu.springone.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = false)
    public void join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        List<Member> findMember = memberRepository.findByEmail(member.getEmail());

        if(findMember.size() != 0){
            throw new DuplicateKeyException("이미 가입된 회원입니다.");
        }
    }

    public Member find(Long id){
        return memberRepository.find(id);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }
}
