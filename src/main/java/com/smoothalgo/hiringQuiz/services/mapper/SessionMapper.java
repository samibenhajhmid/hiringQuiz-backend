package com.smoothalgo.hiringQuiz.services.mapper;

import com.smoothalgo.hiringQuiz.dto.SessionDTO;

import com.smoothalgo.hiringQuiz.entities.Session;


public class SessionMapper implements EntityMapper<SessionDTO, Session> {

    @Override
    public Session toEntity(SessionDTO dto) {
        Session session = new Session();
        session.setId(dto.getId());
        session.setCreationDate(dto.getCreationDate());
        session.setPassedTime(dto.getPassedTime());
        session.setSessionNote(dto.getSessionNote());
        return session;
    }

    @Override
    public SessionDTO toDto(Session entity) {
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setId(entity.getId());
        sessionDTO.setCreationDate(entity.getCreationDate());
        sessionDTO.setPassedTime(entity.getPassedTime());
        sessionDTO.setSessionNote(entity.getSessionNote());
        sessionDTO.setRelatedUser(entity.getUser().getEmail());
        sessionDTO.setRelatedQuiz(entity.getQuiz().getTitle());
        sessionDTO.setRelatedAssessment(entity.getAssessment().getTitle());
        return sessionDTO;
    }
}
