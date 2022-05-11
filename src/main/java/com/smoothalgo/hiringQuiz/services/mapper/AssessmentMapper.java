package com.smoothalgo.hiringQuiz.services.mapper;

import com.smoothalgo.hiringQuiz.dto.AssessmentDTO;
import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Assessment;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZoneId;
import java.util.Date;

public class AssessmentMapper implements EntityMapper<AssessmentDTO, Assessment> {

    @Override
    public Assessment toEntity(AssessmentDTO dto) {
        Assessment assessment = new Assessment();
        assessment.setId(dto.getId());
        assessment.setTitle(dto.getTitle());
        assessment.setExpirationDate(dto.getExpirationDate());
        assessment.setAssessmentCode(dto.getAssessmentCode());
        return assessment;
    }

    @Override
    public AssessmentDTO toDto(Assessment entity) {
        AssessmentDTO assessmentDTO = new AssessmentDTO();
        assessmentDTO.setId(entity.getId());
        assessmentDTO.setTitle(entity.getTitle());
        assessmentDTO.setExpirationDate(entity.getExpirationDate());
        assessmentDTO.setAssessmentCode(entity.getAssessmentCode());
        return assessmentDTO;
    }
}
