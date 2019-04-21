package com.yatskiv.test.converter;

import com.yatskiv.test.dto.ArticleDTO;
import com.yatskiv.test.dto.UserDTO;
import com.yatskiv.test.entity.Article;
import com.yatskiv.test.entity.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserEntityToDTOConverter {
    public static List<UserDTO> convertUsersToDTO(List<User> users){
        return users.stream()
                .map(UserEntityToDTOConverter::convertUserToDTO)
                .collect(Collectors.toList());
    }

    public static Set<UserDTO> convertUsersToDTO(Set<User> users){
        return users.stream()
                .map(UserEntityToDTOConverter::convertUserToDTO)
                .collect(Collectors.toSet());
    }

    public static UserDTO convertUserToDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .age(user.getAge())
                .name(user.getName())
                .articles(convertArticlesToDTO(user.getArticles()))
                .build();
    }

    public static ArticleDTO convertArticleToDTO(Article article){
        return ArticleDTO.builder()
                .color(article.getColor())
                .text(article.getText())
                .build();
    }

    public static List<ArticleDTO> convertArticlesToDTO(List<Article> articles){
        return articles.stream()
                .map(UserEntityToDTOConverter::convertArticleToDTO)
                .collect(Collectors.toList());
    }
}
