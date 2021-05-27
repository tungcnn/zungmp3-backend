package com.webmusic.service.like.song;

import com.webmusic.model.LikeSong;
import com.webmusic.repository.ILikeSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LikeSongService implements ILikeSongService {
    @Autowired
    private ILikeSongRepository iLikeSongRepository;

    @Override
    public List<LikeSong> checkLike(Long idUser) {
        return iLikeSongRepository.checkLike(idUser);
    }

    @Override
    public LikeSong addLike(LikeSong like) {
        return iLikeSongRepository.save(like);
    }

    @Override
    public void unLike(LikeSong likeSong) {
        iLikeSongRepository.delete(likeSong);
    }

    @Override
    public LikeSong findBySongId(Long id , Long idUser) {
        return iLikeSongRepository.findBySongId(id , idUser);
    }
}
