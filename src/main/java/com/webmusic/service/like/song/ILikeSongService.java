package com.webmusic.service.like.song;

import com.webmusic.model.LikePlayList;
import com.webmusic.model.LikeSong;

import java.util.List;
import java.util.Optional;

public interface ILikeSongService {
    public List<LikeSong> checkLike(Long idUser);
    LikeSong addLike(LikeSong like);
    void unLike(LikeSong like);
    LikeSong findBySongId(Long id);
}
