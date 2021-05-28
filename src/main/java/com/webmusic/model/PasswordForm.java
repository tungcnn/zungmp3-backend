package com.webmusic.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PasswordForm {
    private Long id;

    @NotBlank
    @Size(min=6,max=64)
    private String username;

    @NotBlank
    @Size(min=6,max = 128)
    private String currentPassword;

    @NotBlank
    @Size(min=6,max=128)
    private String newPassword;

    public PasswordForm() {
    }

    public PasswordForm(Long id, @NotBlank @Size(min=6,max = 64) String username, @NotBlank @Size(min=6,max = 128) String currentPassword,@NotBlank @Size(min=6,max = 128) String newPassword) {
        this.id = id;
        this.username = username;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }
}
