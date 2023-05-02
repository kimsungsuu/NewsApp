package sungsu.springone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sungsu.springone.request.NewsCreate;
import sungsu.springone.service.NewsService;


@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news/new")
    public String createForm(Model model){
        model.addAttribute("newsForm", new NewsForm());
        return "/news/createForm";
    }

}
