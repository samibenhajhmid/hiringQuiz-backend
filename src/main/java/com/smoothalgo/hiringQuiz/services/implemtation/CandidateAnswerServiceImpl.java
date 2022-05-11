package com.smoothalgo.hiringQuiz.services.implemtation;


import com.smoothalgo.hiringQuiz.dao.*;
import com.smoothalgo.hiringQuiz.dto.CandidateAnswerDTO;
import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.CandidateAnswer;
import com.smoothalgo.hiringQuiz.entities.Question;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import com.smoothalgo.hiringQuiz.entities.Session;
import com.smoothalgo.hiringQuiz.services.ICandidateAnswerService;
import com.smoothalgo.hiringQuiz.services.mapper.CandidateAnswerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CandidateAnswerServiceImpl implements ICandidateAnswerService {
    @Autowired
    CandidateAnswerRepository candidateAnswerRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    AssessmentRepository assessmentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionRepository sessionRepository;
    private final Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);

    CandidateAnswerMapper candidateAnswerMapper = new CandidateAnswerMapper();

    @Override
    public CandidateAnswerDTO addCandidateAnswer(CandidateAnswerDTO candidateAnswerDTO) {
        log.debug("Request to save CandidateAnswer : {}", candidateAnswerDTO);

        CandidateAnswer candidateAnswer = candidateAnswerMapper.toEntity(candidateAnswerDTO);

        candidateAnswer.setQuestion(questionRepository.findByQuestionText(candidateAnswerDTO.getRelatedQuestion()));
        candidateAnswer.setQuiz(quizRepository.findByTitle(candidateAnswerDTO.getRelatedQuiz()));
        candidateAnswer.setAssessment(assessmentRepository.findByTitle(candidateAnswerDTO.getRelatedAssessment()));
        candidateAnswer.setUser(userRepository.findByEmail(candidateAnswerDTO.getRelatedUser()).get());
       // candidateAnswer.setSession(sessionRepository.findById(candidateAnswerDTO.getRelatedSessionId()).get());
        candidateAnswer = candidateAnswerRepository.save(candidateAnswer);
        return (candidateAnswerMapper.toDto(candidateAnswer));

    }

    @Override
    public void deleteCandidateAnswer(Long id) {
        candidateAnswerRepository.deleteById(id);
    }

    @Override
    public CandidateAnswerDTO findCandidateAnswer(Long id) {
        CandidateAnswer candidateAnswer = candidateAnswerRepository.findById(id).get();
        return candidateAnswerMapper.toDto(candidateAnswer);
    }

    @Override
    public List<CandidateAnswerDTO> findAllCandidateAnswer() {
        List<CandidateAnswer> candidateAnswers = candidateAnswerRepository.findAll();
        List<CandidateAnswerDTO> candidateAnswerDTOS = new ArrayList<>();
        for (CandidateAnswer candidateAnswer : candidateAnswers) {
            candidateAnswerDTOS.add(candidateAnswerMapper.toDto(candidateAnswer));

        }
        return candidateAnswerDTOS;
    }

    @Override
    public CandidateAnswerDTO updateCandidateAnswer(Long id, CandidateAnswerDTO candidateAnswerDTO) {
        return null;
    }
}
