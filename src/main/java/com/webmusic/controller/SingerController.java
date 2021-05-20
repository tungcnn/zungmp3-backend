package com.webmusic.controller;

import com.webmusic.model.Singer;
import com.webmusic.service.singer.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/singers")
public class SingerController {
    private ISingerService singerService;

    @Autowired
    public SingerController(ISingerService singerService) {
        this.singerService = singerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Singer>> getAllSinger(Pageable page) {
        Page<Singer> getAll = singerService.getAll(page);
        List<Singer> singers = getAll.getContent();
        return new ResponseEntity<>(singers, OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Singer> addSinger(@Valid @RequestBody Singer singer) {
        Singer addSinger = singerService.save(singer);
        return new ResponseEntity<>(addSinger, CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Singer> editSinger(@Valid @RequestBody Singer singer) {
        Singer editSinger = singerService.save(singer);
        return new ResponseEntity<>(editSinger, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSinger(@PathVariable Long id) {
        if (id == null){
            return new ResponseEntity<>(NOT_FOUND);
        }
        singerService.delete(id);
        return new ResponseEntity<>(OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Singer> findById(@PathVariable Long id) {
        Optional<Singer> singer = singerService.findById(id);
        return singer.map(value -> new ResponseEntity<>(value, OK)).orElseGet(() -> new ResponseEntity<>(NOT_FOUND));
    }
}
