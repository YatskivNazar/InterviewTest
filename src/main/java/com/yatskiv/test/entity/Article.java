package com.yatskiv.test.entity;

import com.yatskiv.test.util.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String text;

    @Column(length = 50, columnDefinition = "varchar(50)")
    @Enumerated(EnumType.STRING)
    private Color color;

    public Article() {
    }

    public Article(String text, Color color) {
        this.text = text;
        this.color = color;
    }
}
