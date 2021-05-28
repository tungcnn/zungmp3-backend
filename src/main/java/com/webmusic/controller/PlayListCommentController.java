package com.webmusic.controller;

import com.webmusic.model.PlaylistComment;
import com.webmusic.service.commentplaylist.ICommentPlaylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin("*")
@RequestMapping("playlistcomments")
public class PlayListCommentController {

    ICommentPlaylist commentPlaylist;

    @Autowired
    public PlayListCommentController(ICommentPlaylist commentPlaylist) {
        this.commentPlaylist = commentPlaylist;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PlaylistComment>> getComment(@PathVariable Long id) {
        List<PlaylistComment> list = commentPlaylist.getPlayListCommet(id);
        return new ResponseEntity<>(list, OK);
    }

    @PostMapping
    public ResponseEntity<PlaylistComment> addComment(@RequestBody PlaylistComment playlistComment) {
        PlaylistComment comment = commentPlaylist.save(playlistComment);
        return new ResponseEntity<>(comment, CREATED);
    }
}
