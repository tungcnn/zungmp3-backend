package com.webmusic.repository;

import com.webmusic.model.Song;
import com.webmusic.model.SongComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query(value = "select * from song order by views desc limit 15", nativeQuery = true)
    List<Song> getTop15();

    @Query(value = "select * from song where (DATEDIFF(CURDATE(), release_date)) < 14 order by release_date desc ", nativeQuery = true)
    List<Song> getLatestSong();

    Page<Song> findByNameContains(String name, Pageable pageable);

    @Query(value = "select * from song where user_id = ?1", nativeQuery = true)
    Page<Song> getSongByUser(Long id, Pageable pageable);


    @Query(value = "select s.name, s.id,s.cover_url,s.lyrics,s.url,s.views from song s " +
            "join song_singers sg on s.id = sg.songs_id where sg.singers_id = ?1 ", nativeQuery = true)
    Page<Object> getSongById(Long id, Pageable pageable);

}
