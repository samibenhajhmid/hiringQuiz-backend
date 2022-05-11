package com.smoothalgo.hiringQuiz.services;

import com.smoothalgo.hiringQuiz.entities.ConfirmationToken;

import java.util.Optional;

public interface IConfirmationTokenService {

    public void saveConfirmationToken(ConfirmationToken token);
    public Optional<ConfirmationToken> getToken(String token);
    public int setConfirmedAt(String token);
}
