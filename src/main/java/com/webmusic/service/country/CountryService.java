package com.webmusic.service.country;

import com.webmusic.model.Country;
import com.webmusic.repository.CountryRepository;
import com.webmusic.service.genre.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }
}
