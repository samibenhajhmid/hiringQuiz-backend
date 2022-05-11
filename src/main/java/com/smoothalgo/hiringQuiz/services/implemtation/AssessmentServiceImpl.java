package com.smoothalgo.hiringQuiz.services.implemtation;

import com.smoothalgo.hiringQuiz.dao.AssessmentRepository;
import com.smoothalgo.hiringQuiz.dao.QuizRepository;
import com.smoothalgo.hiringQuiz.dto.AssessmentDTO;
import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Assessment;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import com.smoothalgo.hiringQuiz.services.IAssessmentService;
import com.smoothalgo.hiringQuiz.services.mapper.AssessmentMapper;
import com.smoothalgo.hiringQuiz.services.mapper.QuizMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssessmentServiceImpl implements IAssessmentService {

    @Autowired
    AssessmentRepository assessmentRepository;
    AssessmentMapper assessmentMapper = new AssessmentMapper();
    private final Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);

    @Override
    public AssessmentDTO saveAssessment(AssessmentDTO assessmentDTO) {
        log.debug("Request to save Assessment : {}", assessmentDTO);
        Assessment assessment = assessmentMapper.toEntity(assessmentDTO);
        assessment = assessmentRepository.save(assessment);

        return assessmentMapper.toDto(assessment);
    }

    @Override
    public void deleteAssessment(Long id) {
        log.debug("Request to delete Assessment : {}", id);
        assessmentRepository.deleteById(id);
    }

    @Override
    public Optional<AssessmentDTO> findAssessment(Long id) {
        return assessmentRepository.findById(id)
                .map(assessmentMapper::toDto);
    }

    @Override
    public List<AssessmentDTO> findAllAssessments() {
        List<Assessment> assessments = assessmentRepository.findAll();
        List<AssessmentDTO> assessmentsDTO = new ArrayList<>();

        for (Assessment assessment : assessments) {
            assessmentsDTO.add(assessmentMapper.toDto(assessment));

        }
        return assessmentsDTO;
    }

    @Override
    public AssessmentDTO findAssessmentByTitle(String title) {
        Assessment assessment = assessmentRepository.findByTitle(title);
        return assessmentMapper.toDto(assessment);
    }

    @Override
    public Assessment findByAssessmentCode(String assessmentCode) {
        Assessment assessment = assessmentRepository.findByAssessmentCode(assessmentCode);
        return assessment;
    }

}
