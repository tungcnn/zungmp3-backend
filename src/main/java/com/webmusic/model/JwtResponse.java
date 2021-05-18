package com.webmusic.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;

import java.util.Collection;

public class JwtResponse {
    private Long id;
    private String token;
    private String type="Bearer";
    private String username;
    private String name;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String accessToken, Long id, String username, String name, Collection<? extends GrantedAuthority> roles){
        this.token =accessToken;
        this.username=username;
        this.roles=roles;
        this.name=name;
        this.id=id;
    }

    public JwtResponse(Long id, String token, String type, String username, String name, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.token = token;
        this.type = type;
        this.username = username;
        this.name = name;
        this.roles = roles;
    }
}
