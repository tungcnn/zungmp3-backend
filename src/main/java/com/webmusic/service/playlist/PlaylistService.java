package com.webmusic.service.playlist;

import com.webmusic.model.Playlist;
import com.webmusic.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<Playlist> findPlaylistByUserId(Long id) {
        return playlistRepository.findPlaylistByUserId(id);
    }

    @Override
    public List<Playlist> findByNameContains(String name) {
        return playlistRepository.findByNameContains(name);
    }

    @Override
    public List<Playlist> top15Like() {
        return playlistRepository.top15Like();
    }

    @Override
    public List<Playlist> top15Views() {
        return playlistRepository.top15Views();
    }
}
