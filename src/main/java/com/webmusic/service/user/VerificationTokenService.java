package com.webmusic.service.user;

import com.webmusic.model.VerificationToken;

public interface VerificationTokenService {
    VerificationToken findByToken(String token);
    void save(VerificationToken token);
}
