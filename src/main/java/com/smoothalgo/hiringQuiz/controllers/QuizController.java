package com.smoothalgo.hiringQuiz.controllers;


import com.smoothalgo.hiringQuiz.controllers.util.PaginationUtil;
import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import com.smoothalgo.hiringQuiz.services.IQuizService;
import org.apache.tomcat.util.http.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.net.URI;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;


@RestController
@RequestMapping("/api")
public class QuizController {
    private final Logger log = LoggerFactory.getLogger(QuizController.class);
    @Autowired
    private IQuizService iQuizService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/quizzes/create")
    public QuizDTO createQuiz(@RequestBody QuizDTO quizDTO) throws Exception {
        log.debug("REST request to save Quiz : {}", quizDTO);
        return iQuizService.saveQuiz(quizDTO);


    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/quizzes")
    public List<QuizDTO> findAllQuiz() {
        log.debug("REST request to get all quizzes");
        return iQuizService.findAllQuiz();

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/quizzes/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        iQuizService.deleteQuiz(id);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/quizzes/update/{id}")
    public QuizDTO updateQuiz(@PathVariable Long id, @RequestBody QuizDTO quizDTO) {
        log.debug("REST request to update Quiz : {}", quizDTO);
        quizDTO.setId(id);
        return iQuizService.saveQuiz(quizDTO);

    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/quizzes/title/{title}")
    public Quiz findByTitle(@PathVariable String title) {
        log.debug("REST request to get all quizzes");
        return iQuizService.findByTitle(title);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/quizzes/assessment/{assessmentCode}")
    public List<QuizDTO> findQuizzesByAssessmentCode(@PathVariable String assessmentCode) {
        log.debug("REST request to get quizzes by assessment code");
        return iQuizService.findQuizzesByAssessmentCode(assessmentCode);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/quizzes/{id}")
    public Quiz findById(@PathVariable Long id) throws Exception {
        log.debug("REST request to get one quiz by ID");
        if (iQuizService.findById(id).isPresent()) {
            return iQuizService.findById(id).get();
        } else throw new Exception("quiz with is :" + id + "not found");


    }
}
