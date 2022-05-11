package com.smoothalgo.hiringQuiz.dto;

import lombok.*;

import javax.persistence.Id;
import java.time.LocalDate;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateAnswerDTO {

    @Id
    private Long id;

    @NonNull
    private String description;
    @NonNull
    private String relatedAssessment;
    @NonNull
    private String relatedQuestion;
    @NonNull
    private String relatedQuiz;
    @NonNull
    private String relatedUser;

}