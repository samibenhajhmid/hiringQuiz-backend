package com.smoothalgo.hiringQuiz.services;



import com.smoothalgo.hiringQuiz.dto.AssessmentDTO;
import com.smoothalgo.hiringQuiz.entities.Assessment;

import java.util.List;
import java.util.Optional;

public interface IAssessmentService {

    public AssessmentDTO saveAssessment(AssessmentDTO assessmentDTO);

    public void deleteAssessment(Long id);

    public Optional<AssessmentDTO> findAssessment(Long id);


    public List<AssessmentDTO> findAllAssessments();

    public AssessmentDTO findAssessmentByTitle(String title);
    public Assessment findByAssessmentCode(String assessmentCode);
}
