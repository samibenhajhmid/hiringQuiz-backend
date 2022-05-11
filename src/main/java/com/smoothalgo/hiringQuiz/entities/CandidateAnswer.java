package com.smoothalgo.hiringQuiz.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidateAnswers")
public class CandidateAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String description;


    @OneToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;


    @OneToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}