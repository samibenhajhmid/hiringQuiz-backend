package com.smoothalgo.hiringQuiz.controllers;

import com.smoothalgo.hiringQuiz.dto.AssessmentDTO;
import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import com.smoothalgo.hiringQuiz.services.IAssessmentService;
import com.smoothalgo.hiringQuiz.services.IQuizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/api")
public class AssessmentController {
    private final Logger log = LoggerFactory.getLogger(QuizController.class);
    @Autowired
    private IAssessmentService iAssessmentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/assessments/create")
    public AssessmentDTO createAssessment(@RequestBody AssessmentDTO assessmentDTO)  throws Exception {
        log.debug("REST request to save Assessment : {}", assessmentDTO);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 15;
        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();

        assessmentDTO.setAssessmentCode(randomString);

        return iAssessmentService.saveAssessment(assessmentDTO);


    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/assessments")
    public List<AssessmentDTO> findAllAssessments() {
        log.debug("REST request to get all quizzes");
        return iAssessmentService.findAllAssessments();

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/assessments/{id}")
    public void deleteAssessment(@PathVariable Long id) {
        iAssessmentService.deleteAssessment(id);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/assessments/update/{id}")
    public AssessmentDTO updateAssessment(@PathVariable Long id,@RequestBody AssessmentDTO assessmentDTO) {
        log.debug("REST request to update Assessment : {}", assessmentDTO);
        assessmentDTO.setId(id);
        return iAssessmentService.saveAssessment(assessmentDTO);

    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/assessments/title/{title}")
    public AssessmentDTO findAssessmentByTitle(@PathVariable String title) {
        log.debug("REST request to get some assessments");
        return iAssessmentService.findAssessmentByTitle(title);

    }
}
