package com.smoothalgo.hiringQuiz.dto;


import lombok.*;

import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDTO {
    @Id
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private LocalDate expirationDate;
    @NonNull
    private String assessmentCode;
}
