package com.webmusic.service.user;

import com.webmusic.model.User;
import com.webmusic.service.IGeneral;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneral<User> , UserDetailsService {
    Optional<User> findByUsername(String username);
}
