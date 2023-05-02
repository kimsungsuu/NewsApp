package sungsu.springone.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import sungsu.springone.entity.News;
import sungsu.springone.repository.NewsRepository;
import sungsu.springone.request.NewsCreate;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class NewsServiceTest {

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsRepository newsRepository;

    @Test
    @DisplayName("회원 저장, 조회, 전체 조회 테스트")
//    @Rollback(value = false)
    void test1() throws Exception{
        //given
        News news = News.builder()
                .title("제목")
                .content("내용")
                .build();

        News news2 = News.builder()
                .title("제목2")
                .content("내용2")
                .build();

        //when
        newsService.write(news);
        newsService.write(news2);

        List<News> allNews = newsService.findNewsAll();

        News findNews = newsService.findNews(2L);

        //then
        assertEquals(2, newsRepository.count());
        assertEquals(2, allNews.size());
        assertEquals(2, findNews.getId());
        assertEquals("제목2", allNews.get(1).getTitle());
        assertEquals("내용2", findNews.getContent());
        assertEquals("제목", newsRepository.find(news.getId()).getTitle());
    }
}