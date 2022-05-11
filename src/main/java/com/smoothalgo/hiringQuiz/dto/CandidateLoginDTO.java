package com.smoothalgo.hiringQuiz.dto;

import lombok.*;

import javax.persistence.Id;


public class CandidateLoginDTO {
    @Id
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String assessmentCode;

    public CandidateLoginDTO(Long id, @NonNull String email, @NonNull String password, @NonNull String assessmentCode) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.assessmentCode = assessmentCode;
    }

    public CandidateLoginDTO() {

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAssessmentCode() {
        return assessmentCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAssessmentCode(String assessmentCode) {
        this.assessmentCode = assessmentCode;
    }
}
