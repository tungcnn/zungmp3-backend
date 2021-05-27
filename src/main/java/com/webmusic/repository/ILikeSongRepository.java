package com.webmusic.repository;

import com.webmusic.model.LikePlayList;
import com.webmusic.model.LikeSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ILikeSongRepository extends JpaRepository< LikeSong,Long > {
    @Query(value = "select * from like_song where user_id = ?1 ",nativeQuery = true)
    List<LikeSong> checkLike(Long idUser);
    @Query(value = "select * from like_song where song_id = ?1 and user_id = ?2",nativeQuery = true)
    LikeSong findBySongId(Long id , Long idUser);
}
