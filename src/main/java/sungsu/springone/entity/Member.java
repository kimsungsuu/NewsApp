package sungsu.springone.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;
import sungsu.springone.constant.Role;
import sungsu.springone.controller.MemberFormDto;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;


//    @OneToMany(mappedBy = "member")
//    private List<News> newsList = new ArrayList<>();

    public Member(){
    }

    @Builder
    private Member(String name, String email, String address, String password){
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    private void setRole(Role role){
        this.role = role;
    }

    /**
     * FormDto에서 넘겨받은 값을 엔티티 값으로 Builder한 뒤 반환하는 메서드
     * @param memberFormDto
     * @param passwordEncoder
     */
    public static Member createMember(MemberFormDto memberFormDto,
                                      PasswordEncoder passwordEncoder){

        String password = passwordEncoder.encode(memberFormDto.getPassword());
        Member member = Member.builder()
                .name(memberFormDto.getName())
                .email(memberFormDto.getEmail())
                .address(memberFormDto.getAddress())
                .password(password)
                .build();

        member.setRole(Role.ADMIN);

        return member;
    }

    /**
     * 로그인을 한다
     * 뉴스를 작성한다.(C)
     * 뉴스 리스트에서 내 뉴스가 맨 상단에 위치한다.
     * 뉴스를 삭제하거나, 수정할 수 있다.(UD)
     * 뉴스를 클릭하면 해당 뉴스 페이지로 들어가진다(Read)
     */
}
