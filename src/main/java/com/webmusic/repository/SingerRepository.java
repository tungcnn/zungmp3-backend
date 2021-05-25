package com.webmusic.repository;

import com.webmusic.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingerRepository extends JpaRepository<Singer, Long> {
    List<Singer> findByNameContains(String name);
}
