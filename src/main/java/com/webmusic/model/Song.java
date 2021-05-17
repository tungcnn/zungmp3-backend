package com.webmusic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lyrics;
    @ManyToOne
    private Singer singer;
    @ManyToOne
    private Album album;
    @ManyToOne
    private Genre genre;
    @ManyToOne
    private Playlist playlist;
}
