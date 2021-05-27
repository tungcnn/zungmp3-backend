package com.webmusic.service.commentplaylist;

import com.webmusic.model.PlaylistComment;
import com.webmusic.service.IGeneral;

import java.util.List;

public interface ICommentPlaylist extends IGeneral<PlaylistComment> {
    List<PlaylistComment> getPlayListCommet(Long id);
}
