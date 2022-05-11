package com.smoothalgo.hiringQuiz.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Id;


public class AnswerDTO {
    @Id
    private Long id;
    @NonNull
    private String description;
    @NonNull
    private Boolean isCorrect;
    @NonNull
    private String relatedQuestion;

    public AnswerDTO(Long id, @NonNull String description, @NonNull Boolean isCorrect, @NonNull String relatedQuestion) {
        this.id = id;
        this.description = description;
        this.isCorrect = isCorrect;
        this.relatedQuestion = relatedQuestion;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public String getRelatedQuestion() {
        return relatedQuestion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsCorrect(Boolean Iscorrect) {
        isCorrect = Iscorrect;
    }

    public void setRelatedQuestion(String relatedQuestion) {
        this.relatedQuestion = relatedQuestion;
    }

    public AnswerDTO() {

    }
}
