package com.webmusic.controller;

import com.webmusic.model.SongComment;
import com.webmusic.service.commentsong.ICommentSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class SongCommentController {

    ICommentSongService commentSongService;

    @Autowired
    public SongCommentController(ICommentSongService commentSongService) {
        this.commentSongService = commentSongService;
    }

    @PostMapping
    public ResponseEntity<SongComment> addComment(@RequestBody SongComment songComment) {
        SongComment newComment = commentSongService.save(songComment);
        return new ResponseEntity<>(newComment, CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<SongComment>> getComment(@PathVariable("id") Long id, Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(), 1000);
        Page<SongComment> getAll = commentSongService.getAllComment(id, page);
        List<SongComment> comments = getAll.getContent();
        return new ResponseEntity<>(comments,OK);   
    }
}
