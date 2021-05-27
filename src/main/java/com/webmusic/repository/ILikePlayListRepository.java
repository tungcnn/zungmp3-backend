package com.webmusic.repository;

import com.webmusic.model.LikePlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ILikePlayListRepository extends JpaRepository<LikePlayList , Long> {
    @Query(value = "select * from like_play_list where like_play_list.user_id = ?1 ",nativeQuery = true)
    List<LikePlayList> checkLike(Long idUser);
    @Query(value = "select * from like_play_list where playlist_id = ?1",nativeQuery = true)
    LikePlayList findByPlayListId(Long id);
}
