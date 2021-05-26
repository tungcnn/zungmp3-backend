package com.webmusic.service.theme;

import com.webmusic.model.Theme;
import com.webmusic.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService implements IThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public List<Theme> getAll() {
        return themeRepository.findAll();
    }
}
