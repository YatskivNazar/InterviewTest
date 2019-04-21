package com.yatskiv.test;

import com.yatskiv.test.entity.Article;
import com.yatskiv.test.repository.ArticleRepository;
import com.yatskiv.test.service.ArticleService;
import com.yatskiv.test.util.Color;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void givenArticleRepository_whenSaveAndRetrieveEntity_thenOk(){
        Article article = articleService
                .saveOrUpdate(new Article("text", Color.BLUE), 1L);

        Optional<Article> foundArticle = articleService
                 .getById(article.getId());

        Assert.assertNotNull(foundArticle.get());
        Assert.assertEquals(article.getText(), foundArticle.get().getText());

    }
}
