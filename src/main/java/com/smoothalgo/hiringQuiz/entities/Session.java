package com.smoothalgo.hiringQuiz.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor // generate a constructor for fields whit @nonNull
@Table(name = "Sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private LocalDate creationDate;

    @NonNull
    private Integer passedTime;
    @NonNull
    private Integer sessionNote;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

   // @OneToOne(mappedBy = "session")
   // private CandidateAnswer candidateAnswer;

}
