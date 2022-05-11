package com.smoothalgo.hiringQuiz.services.mapper;


import com.smoothalgo.hiringQuiz.dto.CandidateAnswerDTO;
import com.smoothalgo.hiringQuiz.entities.*;


public class CandidateAnswerMapper implements EntityMapper<CandidateAnswerDTO, CandidateAnswer> {

    @Override
    public CandidateAnswer toEntity(CandidateAnswerDTO dto) {
        CandidateAnswer candidateAnswer = new CandidateAnswer();
        candidateAnswer.setId(dto.getId());
        candidateAnswer.setDescription(dto.getDescription());

return candidateAnswer;
    }

    @Override
    public CandidateAnswerDTO toDto(CandidateAnswer entity) {
        CandidateAnswerDTO candidateAnswerDTO =new CandidateAnswerDTO();
        candidateAnswerDTO.setId(entity.getId());
        candidateAnswerDTO.setDescription(entity.getDescription());
        candidateAnswerDTO.setRelatedQuestion(entity.getQuestion().getQuestionText());
        candidateAnswerDTO.setRelatedQuiz(entity.getQuiz().getTitle());
        candidateAnswerDTO.setRelatedAssessment(entity.getAssessment().getTitle());
        candidateAnswerDTO.setRelatedUser(entity.getUser().getEmail());
     //   candidateAnswerDTO.setRelatedSessionId(entity.getSession().getId());
        return candidateAnswerDTO;
    }
}
