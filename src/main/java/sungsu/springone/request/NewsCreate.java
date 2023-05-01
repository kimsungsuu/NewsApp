package sungsu.springone.request;


public class NewsCreate {

    private String title;
    private String image;

    public NewsCreate() {
    }

    public NewsCreate(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
       return title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
