package sungsu.springone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sungsu.springone.dto.NewsDto;
import sungsu.springone.dto.NewsListDto;
import sungsu.springone.entity.News;
import sungsu.springone.service.NewsService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/")
    public String home(Model model) {

        List<News> news = newsService.findNewsAll();

        List<NewsListDto> results = news.stream()
                .map(m -> new NewsListDto(m.getId(),m.getTitle(), m.getContent()))
                .collect(Collectors.toList());

        model.addAttribute("results", results);

        return "/home";
    }

    @GetMapping("/news/new")
    public String createForm(Model model) {
        model.addAttribute("newsForm", new NewsForm());
        return "news/createNewsForm";
    }

    @PostMapping("/news/new")
    public String create(@Valid NewsForm newsForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "news/createNewsForm";
        }

        News news = News.builder()
                .title(newsForm.getTitle())
                .content(newsForm.getContent())
                .build();

        newsService.write(news);
        return "redirect:/";
    }

    @GetMapping("/news/{newsId}")
    public String view(@PathVariable("newsId") Long id, Model model){
        News news = newsService.findNews(id);

        NewsDto result = NewsDto.builder()
                .title(news.getTitle())
                .content(news.getContent())
                .build();

        model.addAttribute("result", result);

        return "/news/view";
    }
}
