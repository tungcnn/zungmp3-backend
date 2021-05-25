package com.webmusic.controller;

import com.webmusic.model.Song;
import com.webmusic.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    private ISongService songService;

    @Autowired
    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping("/{id}") // FindById Song
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        Optional<Song> song = songService.findById(id);
        if (song.isPresent()) {
            return new ResponseEntity<>(song.get(), OK);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Song>> getAll(Pageable page) {
        Page<Song> getAllSong = songService.getAll(page);
        List<Song> songs = getAllSong.getContent();
        return new ResponseEntity<>(songs, OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Song> addSong(@Valid @RequestBody Song song) {
        Song newSong = songService.save(song);
        return new ResponseEntity<>(newSong, CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Song> editSong(@Valid @RequestBody Song song) {
        Song editSong = songService.save(song);
        return new ResponseEntity<>(editSong, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        songService.delete(id);
        return new ResponseEntity<>(OK);
    }
    @GetMapping("/top15")
    public ResponseEntity<List<Song>> getTop15() {
        return new ResponseEntity<>(songService.getTop15(), OK);
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Song>> getLatest() {
        return new ResponseEntity<>(songService.getLastestSongs(), OK);
    }
    @PostMapping("/search")
    public ResponseEntity<Page<Song>> findByName(@RequestBody Song song , Pageable pageable){
        if (song.getName()!= null || song.getName().equals("")) {
            Page<Song> songs = songService.findByNameContains(song.getName(), pageable);
            List<Song> songList = songs.getContent();
            return new ResponseEntity(songList, HttpStatus.OK);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }
}
