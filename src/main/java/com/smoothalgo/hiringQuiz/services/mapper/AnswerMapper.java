package com.smoothalgo.hiringQuiz.services.mapper;

import com.smoothalgo.hiringQuiz.dao.QuestionRepository;
import com.smoothalgo.hiringQuiz.dto.AnswerDTO;
import com.smoothalgo.hiringQuiz.entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswerMapper implements EntityMapper<AnswerDTO, Answer>{

    @Autowired
    QuestionRepository questionRepository;
    @Override
    public Answer toEntity(AnswerDTO dto) {
        Answer answer = new Answer();
        answer.setId(dto.getId());
        answer.setDescription(dto.getDescription());
        answer.setIsCorrect(dto.getIsCorrect());
        return answer;
    }

    @Override
    public AnswerDTO toDto(Answer entity) {
       AnswerDTO answerDTO = new AnswerDTO();
       answerDTO.setId(entity.getId());
       answerDTO.setDescription(entity.getDescription());
       answerDTO.setIsCorrect(entity.getIsCorrect());
       answerDTO.setRelatedQuestion(entity.getQuestion().getQuestionText());
       return answerDTO;

    }
}
