package com.webmusic.controller;

import com.webmusic.model.Album;
import com.webmusic.service.album.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
    public ResponseEntity<List<Album>> getAllAlbum(Pageable page) {
        Page<Album> getAllAlbum = albumService.getAll(page);
        List<Album> albums = getAllAlbum.getContent();
        return new ResponseEntity<>(albums, OK);
    }

    @PostMapping("add")
    public ResponseEntity<Album> addAlbum(@Valid @RequestBody Album album) {
        Album addAlbum = albumService.save(album);
        return new ResponseEntity<>(addAlbum, CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Album> editAlbum(@Valid @RequestBody Album album) {
        Album editAlbum = albumService.save(album);
        return new ResponseEntity<>(editAlbum, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAlbum(@PathVariable Long id) {
        if (id == null){
            return new ResponseEntity<>(NOT_FOUND);
        }
        albumService.delete(id);
        return new ResponseEntity<>(OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Album> getById(@PathVariable Long id) {
        Optional<Album> album = albumService.findById(id);
        return album.map(value -> new ResponseEntity<>(value, OK)).orElseGet(() -> new ResponseEntity<>(NOT_FOUND));
    }
}
