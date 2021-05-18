package com.webmusic.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneral<T> {
    Page<T> getAll(Pageable pageable);

    Optional<T> findById(Long id);

    T save(T t);

    void delete(Long id);
}
