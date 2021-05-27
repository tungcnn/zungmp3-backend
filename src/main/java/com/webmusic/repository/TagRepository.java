package com.webmusic.repository;

import com.webmusic.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
