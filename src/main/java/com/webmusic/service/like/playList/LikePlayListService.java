package com.webmusic.service.like.playList;

import com.webmusic.model.LikePlayList;
import com.webmusic.model.LikeSong;
import com.webmusic.repository.ILikePlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikePlayListService implements ILikePlayListService {

    @Autowired
    private ILikePlayListRepository iLikePlayListRepository;

    @Override
    public List<LikePlayList> checkLike(Long idUser) {
        return iLikePlayListRepository.checkLike(idUser );
    }

    @Override
    public LikePlayList addLike(LikePlayList like) {
        return iLikePlayListRepository.save(like);
    }

    @Override
    public void unLike(LikePlayList likePlayList) {
        iLikePlayListRepository.delete(likePlayList);
    }

    @Override
    public LikePlayList findByPlayListId(Long id) {
        return iLikePlayListRepository.findByPlayListId(id);
    }


}
