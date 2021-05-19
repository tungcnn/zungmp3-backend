package com.webmusic.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(String fullName, String email, String username, String password, Set<Role> roles) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
