package com.webmusic.service.playlist;

import com.webmusic.model.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService implements IPlaylistService{
    @Override
    public Page<Playlist> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Playlist findById(Long id) {
        return null;
    }

    @Override
    public Playlist save(Playlist playlist) {
        return null;
    }

    @Override
    public Playlist delete(Long id) {
        return null;
    }
}
