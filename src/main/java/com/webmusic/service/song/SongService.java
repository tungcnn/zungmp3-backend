package com.webmusic.service.song;

import com.webmusic.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{
    @Override
    public Page<Song> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Song findById(Long id) {
        return null;
    }

    @Override
    public Song save(Song song) {
        return null;
    }

    @Override
    public Song delete(Long id) {
        return null;
    }
}
