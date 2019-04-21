package com.yatskiv.test.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yatskiv.test.util.Color;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
    private String text;
    private Color color;
}
