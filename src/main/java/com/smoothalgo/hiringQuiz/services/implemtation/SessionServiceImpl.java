package com.smoothalgo.hiringQuiz.services.implemtation;

import com.smoothalgo.hiringQuiz.dao.AssessmentRepository;
import com.smoothalgo.hiringQuiz.dao.QuizRepository;
import com.smoothalgo.hiringQuiz.dao.SessionRepository;
import com.smoothalgo.hiringQuiz.dao.UserRepository;
import com.smoothalgo.hiringQuiz.dto.QuestionDTO;
import com.smoothalgo.hiringQuiz.dto.SessionDTO;
import com.smoothalgo.hiringQuiz.entities.Question;
import com.smoothalgo.hiringQuiz.entities.Session;
import com.smoothalgo.hiringQuiz.entities.User;
import com.smoothalgo.hiringQuiz.services.ISessionService;
import com.smoothalgo.hiringQuiz.services.mapper.SessionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService {

    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AssessmentRepository assessmentRepository;
    @Autowired
    QuizRepository quizRepository;

    SessionMapper sessionMapper = new SessionMapper();
    private final Logger log = LoggerFactory.getLogger(SessionServiceImpl.class);

    @Override
    public SessionDTO addSession(SessionDTO sessionDTO) {
        log.debug("Request to save Session : {}", sessionDTO);
        int sessionNote = 0;
        List <Question> sessionsQuestions = quizRepository.findByTitle(sessionDTO.getRelatedQuiz()).getQuestions();
        for (Question question: sessionsQuestions){

            sessionNote=sessionNote+ question.getQuestionScore();
        }
        Session session = sessionMapper.toEntity(sessionDTO);
        session.setPassedTime(sessionDTO.getPassedTime());
        session.setSessionNote(session.getSessionNote());
        session.setQuiz(quizRepository.findByTitle(sessionDTO.getRelatedQuiz()));
        session.setUser(userRepository.findByEmail(sessionDTO.getRelatedUser()).get());
        session.setAssessment(assessmentRepository.findByTitle(sessionDTO.getRelatedAssessment()));
        session.setSessionNote(sessionNote);
        return (sessionMapper.toDto(sessionRepository.save(session)));
    }

    @Override
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);

    }

    @Override
    public SessionDTO findSession(Long id) {
        Session session = (Session) sessionRepository.findById(id).get();

        return sessionMapper.toDto(session);
    }

    @Override
    public List<SessionDTO> findAllSession() {
        List <Session> sessions = sessionRepository.findAll();
        List <SessionDTO> sessionDTOS = new ArrayList<>();

        for (Session session : sessions) {

            sessionDTOS.add(sessionMapper.toDto(session));

        }
        return sessionDTOS;
    }


}
