package com.smoothalgo.hiringQuiz.dao;

import com.smoothalgo.hiringQuiz.entities.Answer;
import com.smoothalgo.hiringQuiz.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> getAnswersByQuestion(Question question) ;
    Optional<Answer> findById(Long id);
}
