package com.smoothalgo.hiringQuiz.services.implemtation;

import com.smoothalgo.hiringQuiz.dao.ConfirmationTokenRepository;
import com.smoothalgo.hiringQuiz.entities.ConfirmationToken;
import com.smoothalgo.hiringQuiz.services.IConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService implements IConfirmationTokenService {

    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;
    @Override
    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    @Override
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    @Override
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
