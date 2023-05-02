package sungsu.springone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungsu.springone.entity.News;
import sungsu.springone.repository.NewsRepository;
import sungsu.springone.request.NewsCreate;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    // 뉴스 글 저장
    @Transactional(readOnly = false)
    public void write(News news){
        newsRepository.save(news);
    }

    // 뉴스 글 전체 조회
    public List<News> findNewsAll(){
        List<News> result = newsRepository.findAll();

        return result;
    }

    // 뉴스 한건 조회
    public News findNews(Long newsId){
        return newsRepository.find(newsId);
    }

}
