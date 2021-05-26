package com.webmusic.controller;

import com.webmusic.model.Theme;
import com.webmusic.service.theme.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/themes")
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @GetMapping
    public ResponseEntity<List<Theme>> getAll() {
        return new ResponseEntity<>(themeService.getAll(), HttpStatus.OK);
    }
}
