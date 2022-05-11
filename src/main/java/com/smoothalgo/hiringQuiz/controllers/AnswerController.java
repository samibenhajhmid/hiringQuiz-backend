package com.smoothalgo.hiringQuiz.controllers;


import com.smoothalgo.hiringQuiz.dto.AnswerDTO;
import com.smoothalgo.hiringQuiz.entities.Answer;
import com.smoothalgo.hiringQuiz.services.IAnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AnswerController {
    @Autowired
    private IAnswerService iAnswerService;

    private final Logger log = LoggerFactory.getLogger(QuizController.class);
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/answers")
    public List<AnswerDTO> findAllAnswers() {
        log.debug("REST request to get all answers");
        return iAnswerService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/answers/create")
    public AnswerDTO createAnswer(@RequestBody AnswerDTO answerDTO) {
        log.debug("REST request to create Answer : {}", answerDTO);
        return iAnswerService.saveAnswer(answerDTO);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/answers/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        iAnswerService.deleteAnswer(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/answers/question/{questionId}")
    public List<AnswerDTO> findAnswersByQuestion(@PathVariable Long questionId) {
        return iAnswerService.findAnswersByQuestion(questionId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/answers/update/{id}")
    public AnswerDTO updateAnswer(@PathVariable Long id, @RequestBody AnswerDTO answerDTO) {
        log.debug("REST request to update Answer : {}", answerDTO);
        answerDTO.setId(id);
        return iAnswerService.saveAnswer(answerDTO);
    }

}

