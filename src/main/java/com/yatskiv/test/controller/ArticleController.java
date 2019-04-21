package com.yatskiv.test.controller;

import com.yatskiv.test.entity.Article;
import com.yatskiv.test.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${article.url.prefix}")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PutMapping(value = "/articles/{id}")
    public Article replaceArticle(@RequestBody Article article, @PathVariable Long id){
        return articleService.saveOrUpdate(article, id);
    }

}
