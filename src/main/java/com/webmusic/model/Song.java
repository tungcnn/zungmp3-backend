package com.webmusic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lyrics;
    private String filename;
    @ManyToMany
    private Collection<Singer> singers;
    @ManyToOne
    private Album album;
    @ManyToMany
    private Collection<Genre> genres;
    @JsonIgnore
    @ManyToMany(mappedBy = "songs")
    private Collection<Playlist> playlists;
//    @OneToOne
//    private User user;
}
