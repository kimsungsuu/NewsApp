package sungsu.springone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sungsu.springone.request.NewsCreate;


@Controller
public class NewsController {

    @GetMapping("/")
    public String hello(Model model){

        NewsCreate newsData = new NewsCreate();

        newsData.setTitle("콩순이에 대해서..");
        newsData.setImage("kongsoonpicture.jpg");

        model.addAttribute("newsData", newsData);

        return "news_main";
    }

    @GetMapping("/param-test")
    public String paramTest(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }
}
