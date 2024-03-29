package sungsu.springone.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberFormDto {

    @NotEmpty(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    private String email;

    @NotEmpty(message = "패스워드는 필수 입력 값입니다.")
    private String password;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;

}
