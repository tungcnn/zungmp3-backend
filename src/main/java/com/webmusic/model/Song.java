package com.webmusic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private String lyrics;

    private String url;

    private String coverUrl;

    private long views = 0;

    @ManyToMany
    private Collection<Singer> singers;

    @ManyToOne
    private Album album;

    @ManyToMany
    private List<Genre> genres;

    @ManyToOne
    private Theme theme;

    @ManyToOne
    private Country country;

    @JsonIgnore
    @ManyToMany(mappedBy = "songs")
    private Collection<Playlist> playlists;
}
