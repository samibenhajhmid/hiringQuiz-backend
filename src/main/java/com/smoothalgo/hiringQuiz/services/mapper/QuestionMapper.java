package com.smoothalgo.hiringQuiz.services.mapper;

import com.smoothalgo.hiringQuiz.dao.QuizRepository;
import com.smoothalgo.hiringQuiz.dto.QuestionDTO;
import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Question;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionMapper implements EntityMapper<QuestionDTO, Question> {

    @Override
    public Question toEntity(QuestionDTO dto) {

        Question question = new Question();
        question.setId(dto.getId());
        question.setQuestionText(dto.getQuestionText());
        question.setCategory(dto.getCategory());
        question.setQuestionTime(dto.getQuestionTime());
        question.setQuestionScore(dto.getQuestionScore());
        return question;

    }

    @Override
    public QuestionDTO toDto(Question entity) {
       QuestionDTO questionDTO = new QuestionDTO();
       questionDTO.setId(entity.getId());
       questionDTO.setQuestionText(entity.getQuestionText());
       questionDTO.setCategory(entity.getCategory());
       questionDTO.setQuestionScore(entity.getQuestionScore());
       questionDTO.setQuestionTime(entity.getQuestionTime());
       questionDTO.setRelatedQuiz(entity.getQuiz().getTitle());
       return questionDTO;
    }

}
