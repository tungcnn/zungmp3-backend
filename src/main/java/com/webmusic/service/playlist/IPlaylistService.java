package com.webmusic.service.playlist;

import com.webmusic.model.Playlist;
import com.webmusic.service.IGeneral;

import java.util.List;

public interface IPlaylistService extends IGeneral<Playlist> {
    List<Playlist> findPlaylistByUserId(Long id);
}
