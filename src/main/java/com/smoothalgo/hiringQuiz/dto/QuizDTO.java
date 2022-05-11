package com.smoothalgo.hiringQuiz.dto;


import com.smoothalgo.hiringQuiz.enumerations.QuizLevel;
import lombok.*;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;


public class QuizDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private QuizLevel level;
    private LocalDate creationDate;
    @NonNull
    private String description;

    @NonNull
    private String relatedAssessment;

    public String getRelatedAssessment() {
        return relatedAssessment;
    }

    public void setRelatedAssessment(String relatedAssessment) {
        this.relatedAssessment = relatedAssessment;
    }

    private Boolean isPublished;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public QuizLevel getLevel() {
        return level;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLevel(QuizLevel level) {
        this.level = level;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }

    public QuizDTO(Long id, @NonNull String title, @NonNull QuizLevel level, LocalDate creationDate, @NonNull String description, @NonNull Boolean isPublished, @NonNull String relatedAssessment) {
        this.id = id;
        this.title = title;
        this.level = level;
        this.creationDate = creationDate;
        this.description = description;
        this.isPublished = isPublished;
        this.relatedAssessment = relatedAssessment;
    }

    public QuizDTO() {

    }
}

