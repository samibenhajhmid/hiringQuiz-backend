package com.smoothalgo.hiringQuiz.services.implemtation;

import com.smoothalgo.hiringQuiz.dao.AssessmentRepository;
import com.smoothalgo.hiringQuiz.dao.QuizRepository;
import com.smoothalgo.hiringQuiz.dto.AssessmentDTO;
import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Assessment;
import com.smoothalgo.hiringQuiz.entities.Question;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import com.smoothalgo.hiringQuiz.services.IQuizService;
import com.smoothalgo.hiringQuiz.services.mapper.QuizMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements IQuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    AssessmentRepository assessmentRepository;

    QuizMapper quizMapper = new QuizMapper();
    private final Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);


    @Override
    public QuizDTO saveQuiz(QuizDTO quizDTO) {
        log.debug("Request to save Quiz : {}", quizDTO);
        Quiz quiz = quizMapper.toEntity(quizDTO);
        Date date = new Date();
        quiz.setCreationDate(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        quiz.setAssessment(assessmentRepository.findByTitle(quizDTO.getRelatedAssessment()));
        quiz = quizRepository.save(quiz);
        return quizMapper.toDto(quiz);

    }

    @Override
    public void deleteQuiz(Long id) {
        log.debug("Request to delete Quiz : {}", id);
        quizRepository.deleteById(id);

    }

    @Override
    public Optional<QuizDTO> findQuiz(Long id) {
        return quizRepository.findById(id)
                .map(quizMapper::toDto);


    }


    @Override
    public List<QuizDTO> findAllQuiz() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<QuizDTO> quizzesDTO = new ArrayList<>();

        for (Quiz quiz : quizzes) {
            quizzesDTO.add(quizMapper.toDto(quiz));

        }
        return quizzesDTO;
    }

    @Override
    public Quiz findByTitle(String title) {
        return quizRepository.findByTitle(title);
    }

    @Override
    public List<QuizDTO> findQuizzesByAssessmentCode(String assessmentCode) {
        Assessment assessment = assessmentRepository.findByAssessmentCode(assessmentCode);

        List<QuizDTO> quizzes = new ArrayList<>();
        for (Quiz quiz : quizRepository.findByAssessment(assessment)) {
            quizzes.add(quizMapper.toDto(quiz));
        }

        return quizzes;


    }

    @Override
    public Optional<Quiz> findById(Long id) {

        return quizRepository.findById(id);

    }
}
