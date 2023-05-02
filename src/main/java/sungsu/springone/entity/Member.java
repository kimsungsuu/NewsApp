package sungsu.springone.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;

//    private String password; login과 멤버는 다르다. login 기능은 나중에 추가하자

//    @OneToMany(mappedBy = "member")
//    private List<News> newsList = new ArrayList<>();

    public Member(){
    }

    @Builder
    public Member(String name, String email){
        this.name = name;
        this.email = email;
    }

    /**
     * 로그인을 한다
     * 뉴스를 작성한다.(C)
     * 뉴스 리스트에서 내 뉴스가 맨 상단에 위치한다.
     * 뉴스를 삭제하거나, 수정할 수 있다.(UD)
     * 뉴스를 클릭하면 해당 뉴스 페이지로 들어가진다(Read)
     */
}
