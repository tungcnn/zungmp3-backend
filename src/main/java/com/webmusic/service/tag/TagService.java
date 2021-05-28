package com.webmusic.service.tag;

import com.webmusic.model.Tag;
import com.webmusic.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService implements ITagService{
    @Autowired
    private TagRepository tagRepository;

    @Override
    public Iterable<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag save(Tag t) {
        return tagRepository.save(t);
    }

    @Override
    public void delete(Long id) {
        tagRepository.deleteById(id);
    }
}
