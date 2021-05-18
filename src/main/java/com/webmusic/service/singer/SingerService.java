package com.webmusic.service.singer;

import com.webmusic.model.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingerService implements ISingerService{
    @Override
    public Page<Singer> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Singer> findById(Long id) {
        return null;
    }

    @Override
    public Singer save(Singer singer) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
