package sungsu.springone.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import sungsu.springone.entity.News;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@Rollback(false)
class NewsRepositoryTest {

    @Autowired
    private NewsRepository newsRepository;


    @Test
    void test1() throws Exception{
        //given
        // 사용자가 뉴스 글을 작성하면 그게 DB에 잘 저장됐는지 확인해보고 싶다.
        News news = News.builder()
                .title("뉴스 제목")
                .content("뉴스 내용")
                .build();

        //when
        Long newsId = newsRepository.save(news);
        News findNews = newsRepository.find(newsId);

        //then
        assertEquals(findNews.getId(), news.getId());
        assertEquals("뉴스 제목", news.getTitle());
        assertEquals("뉴스 내용", news.getContent());
        assertEquals(findNews, news); // 영속성 컨텍스트 동일성 보장
    }

}