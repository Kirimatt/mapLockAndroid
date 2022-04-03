package com.kirimatt.maplock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kirimatt.maplock.dtos.AuthenticationRequestDTO;
import com.kirimatt.maplock.dtos.AuthenticationResponseDTO;
import com.kirimatt.maplock.services.AuthenticationService;

public class MainActivity extends AppCompatActivity {

    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSignIn = findViewById(R.id.buttonSignIn);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        progressBar = findViewById(R.id.progressBar);

        buttonSignIn.setOnClickListener(a -> signIn());
    }

    public void signIn() {
        if (editTextEmail.getText().length() != 0 && editTextPassword.getText().length() != 0) {
            new Thread(() -> {
                runOnUiThread(() -> progressBar.setVisibility(View.VISIBLE));

                AuthenticationRequestDTO requestDTO = new AuthenticationRequestDTO(
                        editTextEmail.getText().toString(),
                        editTextPassword.getText().toString()
                );

                AuthenticationResponseDTO responseDTO = AuthenticationService.getAuthentication(requestDTO);
                runOnUiThread(() ->
                        Toast.makeText(getApplicationContext(), responseDTO.toString(), Toast.LENGTH_LONG).show());

                runOnUiThread(() -> progressBar.setVisibility(View.INVISIBLE));
            }).start();
        }
    }
}