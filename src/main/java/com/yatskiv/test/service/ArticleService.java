package com.yatskiv.test.service;

import com.yatskiv.test.entity.Article;

import java.util.Optional;

public interface ArticleService {
    Article saveOrUpdate(Article newArticle, Long id);
    Optional<Article> getById(Long id);
}
