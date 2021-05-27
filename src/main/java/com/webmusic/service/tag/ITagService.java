package com.webmusic.service.tag;

import com.webmusic.model.Tag;

import java.util.Optional;

public interface ITagService {
    Iterable<Tag> getAll();
    Optional<Tag> findById(Long id);
    Tag save(Tag t);
    void delete(Long id);
}
