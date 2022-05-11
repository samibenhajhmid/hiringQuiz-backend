package com.smoothalgo.hiringQuiz.services;

import com.smoothalgo.hiringQuiz.dto.CandidateAnswerDTO;
import com.smoothalgo.hiringQuiz.entities.Answer;
import com.smoothalgo.hiringQuiz.entities.CandidateAnswer;

import java.util.List;

public interface ICandidateAnswerService {
    public CandidateAnswerDTO addCandidateAnswer(CandidateAnswerDTO candidateAnswerDTO);
    public void deleteCandidateAnswer(Long id);
    public CandidateAnswerDTO findCandidateAnswer(Long id);
    public List<CandidateAnswerDTO> findAllCandidateAnswer();
    public CandidateAnswerDTO updateCandidateAnswer(Long id, CandidateAnswerDTO candidateAnswerDTO);
}
