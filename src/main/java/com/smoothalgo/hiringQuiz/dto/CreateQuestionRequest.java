package com.smoothalgo.hiringQuiz.dto;

import com.smoothalgo.hiringQuiz.entities.Question;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateQuestionRequest {
    private Question question;
    private String title;
}
