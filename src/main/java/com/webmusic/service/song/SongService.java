package com.webmusic.service.song;

import com.webmusic.model.Song;
import com.webmusic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SongService implements ISongService {
    private SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Page<Song> getAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public List<Song> getTop15() {
        return songRepository.getTop15();
    }

    @Override
    public List<Song> getLastestSongs() {
       return songRepository.getLatestSong();
    }
    public Page<Song> findByNameContains(String name, Pageable pageable) {
        return this.songRepository.findByNameContains(name , pageable);
    }
}
