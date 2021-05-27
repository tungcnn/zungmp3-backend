package com.webmusic.service.commentplaylist;

import com.webmusic.model.PlaylistComment;
import com.webmusic.repository.PlayCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentPlaylist implements ICommentPlaylist {
    PlayCommentRepository playCommentRepository;

    @Autowired
    public CommentPlaylist(PlayCommentRepository playCommentRepository) {
        this.playCommentRepository = playCommentRepository;
    }

    @Override
    public Page<PlaylistComment> getAll(Pageable pageable) {
        return playCommentRepository.findAll(pageable);
    }

    @Override
    public Optional<PlaylistComment> findById(Long id) {
        return playCommentRepository.findById(id);
    }

    @Override
    public PlaylistComment save(PlaylistComment playlistComment) {
        return playCommentRepository.save(playlistComment);
    }

    @Override
    public void delete(Long id) {
        playCommentRepository.deleteById(id);
    }
}
