package com.webmusic.repository;

import com.webmusic.model.PlaylistComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayCommentRepository extends JpaRepository<PlaylistComment, Long> {
    @Query(value = "SELECT * FROM playlist_comment WHERE playlist_id = ?1 ORDER BY date DESC ", nativeQuery = true)
    List<PlaylistComment> getPlayListCommet(Long id);
}
