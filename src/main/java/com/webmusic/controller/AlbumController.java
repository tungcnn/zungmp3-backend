package com.webmusic.controller;

import com.webmusic.model.Album;
import com.webmusic.service.album.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/albums")
public class AlbumController {
    private IAlbumService albumService;

    @Autowired
    public AlbumController(IAlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Album>> getAllAlbum(Pageable page) {
        Page<Album> getAllAlbum = albumService.getAll(page);
        return new ResponseEntity<>(getAllAlbum, OK);
    }

    @PostMapping("add")
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album addAlbum = albumService.save(album);
        return new ResponseEntity<>(addAlbum, CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Album> editAlbum(@RequestBody Album album) {
        Album editAlbum = albumService.save(album);
        return new ResponseEntity<>(editAlbum, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAlbum(@PathVariable Long id) {
        albumService.delete(id);
        return new ResponseEntity<>(OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Album> getById(@PathVariable Long id) {
        Optional<Album> album = albumService.findById(id);
        return album.map(value -> new ResponseEntity<>(value, OK)).orElseGet(() -> new ResponseEntity<>(NOT_FOUND));
    }
}
