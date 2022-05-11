package com.smoothalgo.hiringQuiz.services.implemtation;


import com.smoothalgo.hiringQuiz.dao.QuestionRepository;
import com.smoothalgo.hiringQuiz.dao.QuizRepository;
import com.smoothalgo.hiringQuiz.dto.QuestionDTO;
import com.smoothalgo.hiringQuiz.dto.QuizDTO;
import com.smoothalgo.hiringQuiz.entities.Question;
import com.smoothalgo.hiringQuiz.entities.Quiz;
import com.smoothalgo.hiringQuiz.enumerations.Category;
import com.smoothalgo.hiringQuiz.services.IQuestionService;
import com.smoothalgo.hiringQuiz.services.mapper.QuestionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;

    QuestionMapper questionMapper = new QuestionMapper();
    private final Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);

    @Override
    public QuestionDTO saveQuestion(QuestionDTO questionDTO) {
        log.debug("Request to save Question : {}", questionDTO);
        Question question = questionMapper.toEntity(questionDTO);
        question.setQuiz(quizRepository.findByTitle(questionDTO.getRelatedQuiz()));
        question = questionRepository.save(question);
        return (questionMapper.toDto(question));
    }

    @Override
    public void deleteQuestion(Long id) {
        log.debug("Request to delete Question : {}", id);
        questionRepository.deleteById(id);

    }

    @Override
    public void deleteQuestionByCategory(String categoryName) {
        Category category = Enum.valueOf(Category.class, categoryName);
        List<Question> questions = questionRepository.getQuestionByCategory(category);
        if (questions != null && !questions.isEmpty()) {
            questionRepository.deleteAll(questions);
        }


    }


    public Optional<QuestionDTO> findQuestion(Long id) {
        return questionRepository.findById(id).map(questionMapper::toDto);
    }


    @Override
    public List<QuestionDTO> findQuestionByCategory(@RequestParam String categoryName) {
        Category category = Enum.valueOf(Category.class, categoryName);
        List<Question> questions = questionRepository.getQuestionByCategory(category);
        return null;
    }

    @Override
    public List<QuestionDTO> findAllQuestion() {
        List <Question> questions = questionRepository.findAll();
            List <QuestionDTO> questionsDTO = new ArrayList<>();

            for (Question question : questions) {
                questionsDTO.add(questionMapper.toDto(question));

            }
            return questionsDTO;
        }

    @Override
    public List<QuestionDTO> findQuestionsByQuiz(Long quizId)
    {
         Optional <Quiz> quiz = quizRepository.findById(quizId);
        List <Question> questions = questionRepository.findByQuiz(quiz);
        List <QuestionDTO> questionsDTO = new ArrayList<>();
        for (Question question : questions) {
            questionsDTO.add(questionMapper.toDto(question));

        }
        return questionsDTO;
    }


}



