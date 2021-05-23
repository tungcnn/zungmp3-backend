package com.webmusic.repository;

import com.webmusic.model.Song;
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

    Page<Song> findByNameContains(String name , Pageable pageable);

    @Query(value = "select * from song where user_id = ?1", nativeQuery = true)
    Page<Song> getSongByUser(Long id, Pageable pageable);
}
