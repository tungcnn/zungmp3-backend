package com.webmusic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "song")
public class Song extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private String lyrics;

    @NotBlank(message = "Filename is mandatory")
    private String url;

    private String coverUrl;

    private long views = 0;

    @ManyToMany
    private Collection<Singer> singers;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Theme theme;

    @ManyToOne
    private Country country;

    @JsonIgnore
    @ManyToMany(mappedBy = "songs")
    private Collection<Playlist> playlists;

    @ManyToOne
    private User user;

    @Column(columnDefinition = "boolean default false")
    private boolean checkLike;

    @ManyToMany
    private Collection<Tag> tags;

    private Long LikeTotal = 0L;
}
