package com.webmusic.service.user;

import com.webmusic.model.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {
    @Autowired
    VerificationTokenService verificationTokenService;

    @Override
    public VerificationToken findByToken(String token) {
        return verificationTokenService.findByToken(token);
    }

    @Override
    public void save(VerificationToken token) {
        verificationTokenService.save(token);
    }
}
