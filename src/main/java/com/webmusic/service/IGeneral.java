package com.webmusic.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneral<T> {
    Page<T> getAll(Pageable pageable);
    T findById(Long id);
    T save(T t);
    T delete(Long id);
}
