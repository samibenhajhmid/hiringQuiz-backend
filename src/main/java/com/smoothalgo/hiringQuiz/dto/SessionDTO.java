package com.smoothalgo.hiringQuiz.dto;


import com.smoothalgo.hiringQuiz.entities.Assessment;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import com.smoothalgo.hiringQuiz.entities.User;
import lombok.*;

import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {
    @Id
    private Long id;
    private LocalDate creationDate;
    @NonNull
    private String relatedUser;
    @NonNull
    private String relatedQuiz;
    @NonNull
    private String relatedAssessment;
    @NonNull
    private Integer passedTime;

    @NonNull
    private Integer sessionNote;
}
