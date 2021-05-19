package com.webmusic.service.playlist;

import com.webmusic.model.Playlist;
import com.webmusic.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService implements IPlaylistService{

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Page<Playlist> getAll(Pageable pageable) {
        return playlistRepository.findAll(pageable);
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }
}
