package com.smoothalgo.hiringQuiz.dao;

import com.smoothalgo.hiringQuiz.entities.Assessment;
import com.smoothalgo.hiringQuiz.entities.CandidateAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateAnswerRepository extends JpaRepository<CandidateAnswer, Long> {
    CandidateAnswer findByAssessment(Assessment assessment);
}
