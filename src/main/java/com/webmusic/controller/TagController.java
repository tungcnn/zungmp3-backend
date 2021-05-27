package com.webmusic.controller;

import com.webmusic.model.Tag;
import com.webmusic.service.tag.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private ITagService tagService;

    @GetMapping
    public ResponseEntity<Iterable<Tag>> getAll() {
        return new ResponseEntity<>(tagService.getAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Tag> addTag(@RequestBody Tag tag) {
        return new ResponseEntity<>(tagService.save(tag), HttpStatus.OK);
    }
}
