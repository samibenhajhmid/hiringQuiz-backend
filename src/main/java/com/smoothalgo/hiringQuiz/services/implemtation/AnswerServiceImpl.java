package com.smoothalgo.hiringQuiz.services.implemtation;


import com.smoothalgo.hiringQuiz.dao.AnswerRepository;
import com.smoothalgo.hiringQuiz.dao.QuestionRepository;
import com.smoothalgo.hiringQuiz.dto.AnswerDTO;
import com.smoothalgo.hiringQuiz.entities.Answer;
import com.smoothalgo.hiringQuiz.entities.Question;
import com.smoothalgo.hiringQuiz.services.IAnswerService;
import com.smoothalgo.hiringQuiz.services.mapper.AnswerMapper;
import com.smoothalgo.hiringQuiz.services.mapper.QuestionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    QuestionRepository questionRepository;

    AnswerMapper answerMapper = new AnswerMapper();

    private final Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);

    @Override
    public AnswerDTO saveAnswer(AnswerDTO answerDTO) {
        log.debug("Request to save Answer : {}", answerDTO);
        Answer answer = answerMapper.toEntity(answerDTO);
       answer.setQuestion(questionRepository.findByQuestionText(answerDTO.getRelatedQuestion()));
        //answer.setQuiz(quizRepository.findByTitle(questionDTO.getRelatedQuiz()));
       answer = answerRepository.save(answer);
        return (answerMapper.toDto(answer));

    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);

    }

    @Override
    public AnswerDTO findAnswer(Long id) {
       Answer answer =  answerRepository.findById(id).get();
        return answerMapper.toDto(answer);
    }

    @Override
    public List<AnswerDTO> findAnswersByQuestion(Long questionId) {
        Question question = questionRepository.getById(questionId);
        List<AnswerDTO> answersDTO = new ArrayList<>();
        for(Answer answer : answerRepository.getAnswersByQuestion(question)){
            answersDTO.add(answerMapper.toDto(answer));
        }
       return answersDTO;
    }

    @Override
    public List<AnswerDTO> findAll(){
        List<AnswerDTO> answersDTO = new ArrayList<>();
        for (Answer answer : answerRepository.findAll()){
            answersDTO.add(answerMapper.toDto(answer));
        }
        return answersDTO;
    }
}
