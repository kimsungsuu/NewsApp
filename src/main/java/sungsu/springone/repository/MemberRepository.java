package sungsu.springone.repository;

import org.springframework.stereotype.Repository;
import sungsu.springone.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }


    public Member find(Long id){
        Member member = em.find(Member.class, id);
        return member;
    }

    public List<Member> findByEmail(String email){

        List<Member> result = em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();

        return result;
    }


    public List<Member> findAll() {
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        return result;
    }

    public int count(){
        return findAll().size();
    }
}
