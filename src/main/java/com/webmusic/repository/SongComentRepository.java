package com.webmusic.repository;

import com.webmusic.model.SongComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongComentRepository extends JpaRepository<SongComment, Long> {
    @Query(value = "SELECT * FROM song_comment where song_id = ?1 order by date desc", nativeQuery = true)
    Page<SongComment> getSongComment(Long id, Pageable page);
}
