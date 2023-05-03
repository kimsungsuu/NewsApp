package sungsu.springone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsListDto {

    private Long id;
    private String title;

    private String content;

    public NewsListDto() {
    }

    public NewsListDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
