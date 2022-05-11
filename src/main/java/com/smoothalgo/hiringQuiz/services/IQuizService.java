package com.smoothalgo.hiringQuiz.services;

import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IQuizService {

    public QuizDTO saveQuiz(QuizDTO quizDto);

    public void deleteQuiz(Long id);

    public Optional<QuizDTO> findQuiz(Long id);


    public List<QuizDTO> findAllQuiz();

 public Quiz findByTitle(String title);

   List <QuizDTO> findQuizzesByAssessmentCode(String assessmentCode);

    Optional <Quiz> findById(Long id);
}

