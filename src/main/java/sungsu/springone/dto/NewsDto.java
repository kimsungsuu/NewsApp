package sungsu.springone.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsDto {

    private String title;

    private String content;

    public NewsDto() {
    }

    @Builder
    public NewsDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
