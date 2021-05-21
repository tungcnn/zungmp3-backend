package com.webmusic.service.album;

import com.webmusic.model.Album;
import com.webmusic.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AlbumService implements IAlbumService {
    private AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Page<Album> getAll(Pageable pageable) {
        return albumRepository.findAll(pageable);
    }

    @Override
    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}
