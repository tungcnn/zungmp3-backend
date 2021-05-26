package com.webmusic.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

@Data
public class JwtResponse {
    private Long id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> roles;
    private String type="Bearer";
    private String token;

    public JwtResponse(String accessToken, Long id, String fullName,String username, String password, String email, Collection<? extends GrantedAuthority> roles){
        this.token =accessToken;
        this.id=id;
        this.fullName=fullName;
        this.username=username;
        this.password=password;
        this.email=email;
        this.roles=roles;
    }
}
