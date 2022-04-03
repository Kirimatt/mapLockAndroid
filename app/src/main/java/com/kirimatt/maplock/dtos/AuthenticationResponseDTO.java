package com.kirimatt.maplock.dtos;

import androidx.annotation.NonNull;

/**
 * Класс сущность для авторизации
 *
 * @author azamat
 */
public class AuthenticationResponseDTO {
    private String email;
    private String token;

    public AuthenticationResponseDTO(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public AuthenticationResponseDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @NonNull
    @Override
    public String toString() {
        return "AuthenticationResponseDTO{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
