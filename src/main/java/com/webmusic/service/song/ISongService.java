package com.webmusic.service.song;

import com.webmusic.model.Song;
import com.webmusic.service.IGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService extends IGeneral<Song> {
    Page<Song> findByNameContains(String name , Pageable pageable);
}
