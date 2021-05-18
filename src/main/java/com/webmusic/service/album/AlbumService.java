package com.webmusic.service.album;

import com.webmusic.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService implements IAlbumService{
    @Override
    public Page<Album> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Album> findById(Long id) {
        return null;
    }

    @Override
    public Album save(Album album) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
