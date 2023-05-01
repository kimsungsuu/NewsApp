package sungsu.springone.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    public Member(){
    }

    @Builder
    public Member(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * 로그인을 한다
     * 뉴스를 작성한다.(C)
     * 뉴스 리스트에서 내 뉴스가 맨 상단에 위치한다.
     * 뉴스를 삭제하거나, 수정할 수 있다.(UD)
     * 뉴스를 클릭하면 해당 뉴스 페이지로 들어가진다(Read)
     */
}
