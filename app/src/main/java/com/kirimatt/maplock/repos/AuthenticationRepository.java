package com.kirimatt.maplock.repos;

import com.kirimatt.maplock.dtos.AuthenticationRequestDTO;
import com.kirimatt.maplock.dtos.AuthenticationResponseDTO;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticationRepository {
    @POST("login")
    Observable<AuthenticationResponseDTO> getAuthentication(@Body AuthenticationRequestDTO requestDTO);
}
