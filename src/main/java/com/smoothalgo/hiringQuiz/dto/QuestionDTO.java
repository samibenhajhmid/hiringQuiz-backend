package com.smoothalgo.hiringQuiz.dto;


import com.smoothalgo.hiringQuiz.enumerations.Category;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
public class QuestionDTO {
    @Id
    private Long id;
    @NonNull
    private String questionText;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NonNull
    private Integer questionTime;

    @NonNull
    private Integer questionScore;

    @NonNull
    private String relatedQuiz;
}
