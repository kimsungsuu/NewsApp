package sungsu.springone.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class NewsForm {

    @NotEmpty(message = "제목을 입력해주세요")
    private String title;

    private String content;

}
