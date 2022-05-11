package com.smoothalgo.hiringQuiz.services;

import com.smoothalgo.hiringQuiz.dto.SessionDTO;
import com.smoothalgo.hiringQuiz.entities.CandidateAnswer;
import com.smoothalgo.hiringQuiz.entities.Session;

import java.util.List;

public interface ISessionService {
    public SessionDTO addSession(SessionDTO sessionDTO);
    public void deleteSession(Long id);
    public SessionDTO findSession(Long id);
    public List<SessionDTO> findAllSession();

}
