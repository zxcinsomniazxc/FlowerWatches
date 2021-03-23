package com.example.flowerwatches;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Autorisation extends AppCompatActivity {

    TextView btnLogin;
    EditText edUsername, edPassword;
    TextView noAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autorisation);

        btnLogin = findViewById(R.id.btnLogin);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        noAccount = findViewById(R.id.noAccount);

        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Autorisation.this, Registration.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }

        });
    }
    public void loginUser(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(edUsername.getText().toString());
        loginRequest.setPassword(edPassword.getText().toString());
        Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    String message = Integer.toString(loginResponse.getToken());
                    Toast.makeText(Autorisation.this, message ,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Autorisation.this, MainActivity.class));
                    finish();
                }else{
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(Autorisation.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}