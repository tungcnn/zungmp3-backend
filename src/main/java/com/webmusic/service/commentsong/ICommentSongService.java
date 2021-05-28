package com.webmusic.service.commentsong;

import com.webmusic.model.SongComment;
import com.webmusic.service.IGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommentSongService extends IGeneral<SongComment> {
    Page<SongComment> getAllComment(Long id, Pageable pageable);
}
