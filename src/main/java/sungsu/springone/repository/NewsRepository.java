package sungsu.springone.repository;

import org.springframework.stereotype.Repository;
import sungsu.springone.entity.News;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class NewsRepository {

    @PersistenceContext
    EntityManager em;


    public Long save(News news){
        em.persist(news);
        return news.getId();
    }

    public News find(Long id){
        return em.find(News.class, id);
    }
}