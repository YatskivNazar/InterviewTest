package com.yatskiv.test.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Article> articles;

    public User() {
    }

    public User(String name, Integer age, List<Article> articles) {
        this.name = name;
        this.age = age;
        this.articles = articles;
    }
}
