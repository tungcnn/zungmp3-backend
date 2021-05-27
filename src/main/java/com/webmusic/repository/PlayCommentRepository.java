package com.webmusic.repository;

import com.webmusic.model.PlaylistComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayCommentRepository extends JpaRepository<PlaylistComment, Long> {
}
