package com.webmusic.repository;

import com.webmusic.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
     Page<Song> findByNameContains(String name , Pageable pageable);
}
