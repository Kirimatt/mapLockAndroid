package com.kirimatt.maplock.services;

import com.kirimatt.maplock.dtos.AuthenticationRequestDTO;
import com.kirimatt.maplock.dtos.AuthenticationResponseDTO;
import com.kirimatt.maplock.repos.AuthenticationRepository;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthenticationService {

    private static final AuthenticationRepository AUTHENTICATION_REPOSITORY;

    static {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maplock-kirimatt.herokuapp.com/api/v1/auth/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        AUTHENTICATION_REPOSITORY = retrofit.create(AuthenticationRepository.class);
    }

    private AuthenticationService() {
    }

    public static AuthenticationResponseDTO getAuthentication(AuthenticationRequestDTO requestDTO) {
        return AUTHENTICATION_REPOSITORY.getAuthentication(requestDTO)
                .onErrorReturn(e -> new AuthenticationResponseDTO())
                .blockingFirst();
    }
}
