package com.webmusic.service.playlist;

import com.webmusic.model.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService implements IPlaylistService{
    @Override
    public Page<Playlist> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return null;
    }

    @Override
    public Playlist save(Playlist playlist) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
