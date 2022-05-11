package com.smoothalgo.hiringQuiz.controllers;


import com.smoothalgo.hiringQuiz.dto.CreateQuestionRequest;
import com.smoothalgo.hiringQuiz.dto.QuestionDTO;
import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Question;
import com.smoothalgo.hiringQuiz.services.IQuestionService;
import com.smoothalgo.hiringQuiz.services.IQuizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {
    private final Logger log = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    private IQuestionService iQuestionService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/questions/create")
    public QuestionDTO createQuestion(@RequestBody QuestionDTO questionDTO) throws Exception {
        log.debug("REST request to save Question : {}", questionDTO);
        return iQuestionService.saveQuestion(questionDTO);


    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/questions")
    public List<QuestionDTO> findAllQuestions() {
        log.debug("REST request to get all questions");
        return iQuestionService.findAllQuestion();

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        iQuestionService.deleteQuestion(id);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/questions/update/{id}")
    public QuestionDTO updateQuestion(@PathVariable Long id,@RequestBody QuestionDTO questionDTO) {
        log.debug("REST request to update Question : {}", questionDTO);
        questionDTO.setId(id);
        return iQuestionService.saveQuestion(questionDTO);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/questions/quiz/{id}")
    public List <QuestionDTO> findQuestionByQuiz(@PathVariable Long id) {
        log.debug("REST request to find Question by Quiz : {}");
        return iQuestionService.findQuestionsByQuiz(id);

    }

}
