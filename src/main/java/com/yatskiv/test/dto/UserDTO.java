package com.yatskiv.test.dto;

import com.yatskiv.test.entity.Article;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private Integer age;
    private List<ArticleDTO> articles;
}
