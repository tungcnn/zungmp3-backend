package com.webmusic.service.song;

import com.webmusic.model.Song;
import com.webmusic.service.IGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService extends IGeneral<Song> {
    List<Song> getTop15();
    List<Song> getLastestSongs();
    Page<Song> findByNameContains(String name , Pageable pageable);
    Page<Song> getSongByUser(Long id, Pageable pageable);
}
