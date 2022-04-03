package com.kirimatt.maplock.dtos;

import androidx.annotation.NonNull;

/**
 * Класс сущность для авторизации
 *
 * @author azamat
 */
public class AuthenticationRequestDTO {
    private String email;
    private String password;

    public AuthenticationRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthenticationRequestDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    @Override
    public String toString() {
        return "AuthenticationRequestDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
