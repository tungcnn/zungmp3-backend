package com.webmusic.repository;

import com.webmusic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    User findByEmail(@NotBlank @Email @Size(max=64) String email);

}
