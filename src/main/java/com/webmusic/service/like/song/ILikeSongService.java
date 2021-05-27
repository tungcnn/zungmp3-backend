package com.webmusic.service.like.song;


import com.webmusic.model.LikeSong;

import java.util.List;


public interface ILikeSongService {
    public List<LikeSong> checkLike(Long idUser);
    LikeSong addLike(LikeSong like);
    void unLike(LikeSong like);
    LikeSong findBySongId(Long id , Long idUser);

}
