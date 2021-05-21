package com.webmusic.controller;

import com.webmusic.model.Playlist;
import com.webmusic.model.Song;
import com.webmusic.service.playlist.IPlaylistService;
import com.webmusic.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private IPlaylistService playlistService;
    @Autowired
    private ISongService iSongService;

    @GetMapping
    public ResponseEntity<List<Playlist>> listPlayList(Pageable pageable){
        Page<Playlist> playlists = playlistService.getAll(pageable);
        List<Playlist> listPlaylists = playlists.getContent();
        return new ResponseEntity<>(listPlaylists, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlayList(@RequestBody Playlist playlist){
        return new ResponseEntity<>(playlistService.save(playlist),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayList(@PathVariable Long id){
        playlistService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/{id_song}")
    public ResponseEntity<Song> addSongToPlayList(@PathVariable("id") Long id , @PathVariable("id_song") Long id_song){
        if (iSongService.findById(id_song).isPresent()){
            Song song = iSongService.findById(id_song).get();
            Playlist playlist = playlistService.findById(id).get();
            playlist.getSongs().add(song);
            playlistService.save(playlist);
            return new ResponseEntity<>(song,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> editPlayList(@RequestBody Playlist playlist , @PathVariable Long id){
       Playlist editPlayList = playlistService.findById(id).get();
        if (playlistService.findById(id).isPresent()){
            playlist.setId(editPlayList.getId());
            playlistService.save(playlist);
            return new ResponseEntity<>(playlist,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlayListById(@PathVariable Long id){
        if (playlistService.findById(id).isPresent()) {
            return new ResponseEntity<>(playlistService.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
