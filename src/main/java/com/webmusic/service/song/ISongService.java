package com.webmusic.service.song;

import com.webmusic.model.Song;
import com.webmusic.service.IGeneral;

import java.util.List;

public interface ISongService extends IGeneral<Song> {
    List<Song> getTop15();
    List<Song> getLastestSongs();
}
