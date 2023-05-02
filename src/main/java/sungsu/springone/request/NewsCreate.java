package sungsu.springone.request;


import lombok.Builder;

public class NewsCreate {
    private String title;

    private String content;

    public NewsCreate() {
    }

    @Builder
    public NewsCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle(){
       return title;
    }

    public String getContent() {
        return content;
    }
}
