package com.webmusic.service.playlist;

import com.webmusic.model.Playlist;
import com.webmusic.service.IGeneral;

import java.util.List;

public interface IPlaylistService extends IGeneral<Playlist> {
    List<Playlist> findPlaylistByUserId(Long id);
    List<Playlist> findByNameContains(String name);
    List<Playlist> top15Like();
    List<Playlist> top15Views();
    List<Playlist> getLatestPlayList();
}
