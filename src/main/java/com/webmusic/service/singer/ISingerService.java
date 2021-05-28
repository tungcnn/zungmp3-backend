package com.webmusic.service.singer;

import com.webmusic.model.Singer;
import com.webmusic.service.IGeneral;

import java.util.List;
import java.util.Optional;

public interface ISingerService {
    List<Singer> findByNameContains(String name);
    Iterable<Singer> getAll();
    Optional<Singer> findById(Long id);
    Singer save(Singer singer);
    void delete(Long id);
}
