package com.smoothalgo.hiringQuiz.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smoothalgo.hiringQuiz.enumerations.Category;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor // generate a constructor for fields whit @nonNull
@Table(name = "Questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Answer> answers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

   // @OneToOne(mappedBy = "question")
   // private CandidateAnswer candidateAnswer;

}
