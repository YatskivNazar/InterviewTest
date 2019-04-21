package com.yatskiv.test.service.impl;

import com.yatskiv.test.entity.Article;
import com.yatskiv.test.repository.ArticleRepository;
import com.yatskiv.test.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Article saveOrUpdate(Article newArticle, Long id) {

        return articleRepository.findById(id)
                .map(article -> {
                    article.setColor(newArticle.getColor());
                    article.setText(newArticle.getText());
                    return articleRepository.save(article);
                }).orElseGet(() -> {
                    newArticle.setId(id);
                    return articleRepository.save(newArticle);
                });
    }

    @Override
    public Optional<Article> getById(Long id) {
        return articleRepository.findById(id);
    }
}
