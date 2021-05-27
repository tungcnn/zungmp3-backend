package com.webmusic.service.commentsong;

import com.webmusic.model.SongComment;
import com.webmusic.repository.SongComentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongCommentService implements ICommentSongService {

    SongComentRepository songComentRepository;

    @Autowired
    public SongCommentService(SongComentRepository songComentRepository) {
        this.songComentRepository = songComentRepository;
    }

    @Override
    public Page<SongComment> getAll(Pageable pageable) {
        return songComentRepository.findAll(pageable);
    }

    @Override
    public Optional<SongComment> findById(Long id) {
        return songComentRepository.findById(id);
    }

    @Override
    public SongComment save(SongComment songComment) {
        return songComentRepository.save(songComment);
    }

    @Override
    public void delete(Long id) {
        songComentRepository.deleteById(id);
    }

    @Override
    public Page<SongComment> getAllComment(Long id, Pageable pageable) {
        return songComentRepository.getSongComment(id, pageable);
    }
}
