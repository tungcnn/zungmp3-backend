package com.webmusic.controller;

import com.webmusic.model.LikePlayList;
import com.webmusic.model.Playlist;
import com.webmusic.model.User;
import com.webmusic.service.like.playList.ILikePlayListService;
import com.webmusic.service.like.playList.LikePlayListService;
import com.webmusic.service.playlist.IPlaylistService;
import com.webmusic.service.playlist.PlaylistService;
import com.webmusic.service.user.IUserService;
import com.webmusic.service.user.UserService;
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
            LikePlayList like = new LikePlayList();
            like.setPlaylist(playlist.get());
            like.setUser(user.get());
            return new ResponseEntity<>(likePlayListService.addLike(like), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id_playList}")
    public ResponseEntity<Void> remove(@PathVariable Long id_playList) {
        LikePlayList likePlayList = likePlayListService.findByPlayListId(id_playList);
        likePlayListService.unLike(likePlayList);
        System.out.println(likePlayList);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
