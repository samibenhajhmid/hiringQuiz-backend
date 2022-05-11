package com.smoothalgo.hiringQuiz.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smoothalgo.hiringQuiz.enumerations.QuizLevel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor // generate a constructor for fields whit @nonNull
@Table(name = "quizzes")
public class Quiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String description;

    private Boolean isPublished;

    private LocalDate creationDate;

    private LocalDate modificationDate;
    @NonNull
    private QuizLevel level;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "quiz")
    private List<Question> questions ;
   // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   // @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz")
   // private List<Session> sessions;
   @ManyToOne
   @JoinColumn(name = "assessment_id")
   private Assessment assessment;

   // @OneToOne(mappedBy = "quiz")
   // private CandidateAnswer candidateAnswer;
}
