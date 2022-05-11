package com.smoothalgo.hiringQuiz.dao;

import com.smoothalgo.hiringQuiz.entities.Question;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import com.smoothalgo.hiringQuiz.enumerations.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> getQuestionsByQuiz(Quiz quiz);
    List<Question> getQuestionByCategory(Category category);
    void deleteQuestionByCategory(Category category);
    Optional<Question> findById(Long id);
    Question findQuestionById(Long id);

    Question findByQuestionText(String questionText);
    List <Question> findByQuiz(Optional<Quiz> quiz);
}
