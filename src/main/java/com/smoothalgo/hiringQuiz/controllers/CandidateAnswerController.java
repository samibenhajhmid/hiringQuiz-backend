package com.smoothalgo.hiringQuiz.controllers;

import com.smoothalgo.hiringQuiz.dao.QuizRepository;
import com.smoothalgo.hiringQuiz.dto.CandidateAnswerDTO;
import com.smoothalgo.hiringQuiz.services.ICandidateAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CandidateAnswerController {
    @Autowired
    ICandidateAnswerService iCandidateAnswerService;
    @Autowired
    QuizRepository quizRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/candidatesAnswers")
    public List<CandidateAnswerDTO> findAllCandidateAnswers() {
        return iCandidateAnswerService.findAllCandidateAnswer();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/candidatesAnswers/create")
    public CandidateAnswerDTO addCandidateAnswer(@RequestBody CandidateAnswerDTO candidateAnswerDTO) {

        return iCandidateAnswerService.addCandidateAnswer(candidateAnswerDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/candidatesAnswers/{id}")
    public void deleteCandidateAnswer(@PathVariable Long id){
        iCandidateAnswerService.deleteCandidateAnswer(id);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/candidatesAnswers/update/{id}")
    public CandidateAnswerDTO updateCandidateAnswer(@PathVariable Long id, @RequestBody CandidateAnswerDTO candidateAnswerDTO) {
        return iCandidateAnswerService.updateCandidateAnswer(id,candidateAnswerDTO);
    }


}



