package com.webmusic.controller;

import com.webmusic.model.Song;
import com.webmusic.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id){
        Optional<Song> song = iSongService.findById(id);
       if (song.isPresent()){
           return new ResponseEntity<>(song.get(), HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
