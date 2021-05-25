package com.webmusic.service.singer;

import com.webmusic.model.Singer;
import com.webmusic.service.IGeneral;

import java.util.List;

public interface ISingerService extends IGeneral<Singer> {
    List<Singer> findByNameContains(String name);
}
