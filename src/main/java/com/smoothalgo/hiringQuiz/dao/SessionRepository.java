package com.smoothalgo.hiringQuiz.dao;

import com.smoothalgo.hiringQuiz.entities.Quiz;
import com.smoothalgo.hiringQuiz.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

}
