package com.smoothalgo.hiringQuiz.services.mapper;

import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Quiz;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class QuizMapper implements EntityMapper<QuizDTO, Quiz>{

    @Override
    public Quiz toEntity(QuizDTO dto) {
        Date date = new Date();
        Quiz quiz = new Quiz();
        quiz.setId(dto.getId());
        quiz.setTitle(dto.getTitle());
        quiz.setDescription(dto.getDescription());
        quiz.setCreationDate(dto.getCreationDate());
        quiz.setModificationDate(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        quiz.setLevel(dto.getLevel());
        quiz.setIsPublished(dto.getIsPublished());
        return quiz;
    }

    @Override
    public QuizDTO toDto(Quiz entity) {
        QuizDTO quizDTO = new QuizDTO();
        quizDTO.setId(entity.getId());
        quizDTO.setTitle(entity.getTitle());
        quizDTO.setDescription(entity.getDescription());
        quizDTO.setCreationDate(entity.getCreationDate());
        quizDTO.setLevel(entity.getLevel());
        quizDTO.setIsPublished(entity.getIsPublished());
        quizDTO.setRelatedAssessment(entity.getAssessment().getTitle());
        return quizDTO;
    }

}
