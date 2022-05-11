package com.smoothalgo.hiringQuiz.services;

import com.smoothalgo.hiringQuiz.dto.QuestionDTO;
import com.smoothalgo.hiringQuiz.entities.Question;

import java.util.List;

public interface IQuestionService {
    public QuestionDTO saveQuestion(QuestionDTO questionDTO);
    public void deleteQuestion(Long id);
    public void deleteQuestionByCategory( String categoryName);
    public List<QuestionDTO> findQuestionByCategory(String categoryName);
    public List<QuestionDTO> findAllQuestion();
    public List<QuestionDTO> findQuestionsByQuiz(Long quizId);
}
