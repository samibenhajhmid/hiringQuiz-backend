package com.smoothalgo.hiringQuiz.dao;

import com.smoothalgo.hiringQuiz.dto.AssessmentDTO;
import com.smoothalgo.hiringQuiz.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    Assessment findByTitle(String title);

    Assessment findByAssessmentCode(String assessmentCode);
}
