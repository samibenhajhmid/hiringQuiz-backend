package com.smoothalgo.hiringQuiz.services;

import com.smoothalgo.hiringQuiz.dto.AnswerDTO;
import com.smoothalgo.hiringQuiz.entities.Answer;

import java.util.List;

public interface IAnswerService {
    public AnswerDTO saveAnswer(AnswerDTO answerDTO);
    public void deleteAnswer(Long id);
    public AnswerDTO findAnswer(Long id);
    public List<AnswerDTO> findAnswersByQuestion(Long questionId);
    public List<AnswerDTO> findAll();
}
