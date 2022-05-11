package com.smoothalgo.hiringQuiz.dao;

import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Assessment;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import com.smoothalgo.hiringQuiz.enumerations.QuizLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findQuizByLevel(QuizLevel level) ;
     Optional<Quiz> findById(Long id);
     Quiz findQuizByTitle(String title);


   public Quiz findByTitle(String title);
   List <Quiz> findByAssessment(Assessment assessment);

}
