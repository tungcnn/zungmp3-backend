package com.webmusic.service.like.playList;

import com.webmusic.model.LikePlayList;


import java.util.List;
import java.util.Optional;

public interface ILikePlayListService {
    List<LikePlayList> checkLike(Long idUser);
    LikePlayList addLike(LikePlayList like);
    void unLike(LikePlayList like);
    LikePlayList findByPlayListId(Long id);
}
