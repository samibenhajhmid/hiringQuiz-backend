package com.smoothalgo.hiringQuiz.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor // generate a constructor for fields whit @nonNull
@Table(name = "assessments")
public class Assessment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String assessmentCode;
    @NonNull
    private LocalDate expirationDate;

  //  @OneToOne(mappedBy = "assessment")
   // private CandidateAnswer candidateAnswer;

}
