package com.webmusic.controller;

import com.webmusic.model.Playlist;
import com.webmusic.model.Song;
import com.webmusic.service.playlist.IPlaylistService;
import com.webmusic.service.song.ISongService;
import com.webmusic.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private IPlaylistService playlistService;
    @Autowired
    private ISongService iSongService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Playlist>> listPlayList(Pageable pageable){
        Page<Playlist> playlists = playlistService.getAll(pageable);
        List<Playlist> listPlaylists = playlists.getContent();
        return new ResponseEntity<>(listPlaylists, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Playlist> createPlayList(@Valid @RequestBody Playlist playlist , BindingResult bindingResult , @PathVariable Long id){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if (userService.findById(id).isPresent()){
            playlist.setUser(userService.findById(id).get());
            return new ResponseEntity<>(playlistService.save(playlist),HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayList(@PathVariable Long id){
        playlistService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/{id_song}")
    public ResponseEntity<Song> addSongToPlayList(@PathVariable("id") Long id , @PathVariable("id_song") Long id_song){
        List<Song> songs = playlistService.findById(id).get().getSongs();
        for (Song song:songs) {
            if (song.getId()==id_song){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
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
    public ResponseEntity<Playlist> editPlayList(@Valid @RequestBody Playlist playlist , @PathVariable Long id ,BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
       Playlist editPlayList = playlistService.findById(id).get();
        if (playlistService.findById(id).isPresent()){
            playlist.setId(editPlayList.getId());
            playlist.setUser(editPlayList.getUser());
            playlist.setSongs(editPlayList.getSongs());
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
    @GetMapping("userPlayList/{id}")
    public ResponseEntity<List<Playlist>> getAllPlayListByUserId(@PathVariable Long id){
        System.out.println(id);
        return new ResponseEntity<>(playlistService.findPlaylistByUserId(id),HttpStatus.OK);
    }
    @DeleteMapping("deleteSong/{id}/{id_PlayList}")
    public ResponseEntity<Void> DeleteSong(@PathVariable("id") Long id , @PathVariable("id_PlayList") Long playList_id){
        Optional<Playlist> playlist = playlistService.findById(playList_id);
        if (playlist.isPresent()){
            playlist.get().getSongs().removeIf(song -> song.getId().equals(id));
            playlistService.save(playlist.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/top15views")
    public ResponseEntity<List<Playlist>> getTop15Views(){
        return new ResponseEntity<>(playlistService.top15Views(),HttpStatus.OK);
    }

    @GetMapping("/top15likes")
    public ResponseEntity<List<Playlist>> getTop15Likes(){
        return new ResponseEntity<>(playlistService.top15Like(),HttpStatus.OK);
    }
}
