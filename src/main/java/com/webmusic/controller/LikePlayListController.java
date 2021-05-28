package com.webmusic.controller;

import com.webmusic.model.LikePlayList;
import com.webmusic.model.Playlist;
import com.webmusic.model.User;
import com.webmusic.service.like.playList.ILikePlayListService;
import com.webmusic.service.playlist.IPlaylistService;
import com.webmusic.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("LikePlayList")
public class LikePlayListController {
    @Autowired
    private ILikePlayListService likePlayListService;
    @Autowired
    private IPlaylistService playlistService;
    @Autowired
    private IUserService userService;

    @GetMapping("/{id_user}")
    public ResponseEntity<?> checkLike(@PathVariable("id_user") Long idUser) {
        List<LikePlayList> likes = likePlayListService.checkLike(idUser);
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @PostMapping("/{idUser}")
    public ResponseEntity<LikePlayList> addLike(@RequestBody Long id_PlayList, @PathVariable("idUser") Long id) {
        Optional<Playlist> playlist = playlistService.findById(id_PlayList);
        Optional<User> user = userService.findById(id);
        if (playlist.isPresent() && user.isPresent()) {
            playlist.get().setLikeTotalPlayList(playlist.get().getLikeTotalPlayList()+1);
            playlistService.save(playlist.get());
            LikePlayList like = new LikePlayList();
            like.setPlaylist(playlist.get());
            like.setUser(user.get());
            return new ResponseEntity<>(likePlayListService.addLike(like), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id_playList}/{idUser}")
    public ResponseEntity<Void> remove(@PathVariable("id_playList") Long id_playList , @PathVariable("idUser") Long idUser) {
        Optional<Playlist> playlist = playlistService.findById(id_playList);
        if (playlist.isPresent()) {
            LikePlayList likePlayList = likePlayListService.findByPlayListId(id_playList , idUser);
            likePlayListService.unLike(likePlayList);
            playlist.get().setLikeTotalPlayList(playlist.get().getLikeTotalPlayList()-1);
            playlistService.save(playlist.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
