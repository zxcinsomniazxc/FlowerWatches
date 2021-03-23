package com.example.flowerwatches;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {

    TextView btnSignUp;
    EditText edUsername, edEmail, edPassword, edCpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        btnSignUp = findViewById(R.id.btnSignUpQ);
        edUsername = findViewById(R.id.edUsernameQ);
        edEmail = findViewById(R.id.edEmailQ);
        edPassword = findViewById(R.id.edPasswordQ);
        edCpassword = findViewById(R.id.edCpasswordQ);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edEmail.getText().toString()) || TextUtils.isEmpty(edUsername.getText().toString()) || TextUtils.isEmpty(edPassword.getText().toString()) || TextUtils.isEmpty(edCpassword.getText().toString())) {
                    String message = "All inputs required ...";
                    Toast.makeText(Registration.this, message, Toast.LENGTH_LONG).show();
                }else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setEmail(edEmail.getText().toString());
                    registerRequest.setPassword(edPassword.getText().toString());
                    registerRequest.setUsername(edUsername.getText().toString());
                    registerUser(registerRequest);
                }
            }
        });
    }

    public void registerUser (RegisterRequest registerRequest){
        Call<RegisterResponse> registerResponseCall = ApiClient.getService().registerUsers(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()){
                    String message = "Successful ...";
                    Toast.makeText(Registration.this, message, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Registration.this, Autorisation.class));
                    finish();
                }else{
                    String message = "An error occurred please try again later ...";
                    Toast.makeText(Registration.this, message, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(Registration.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }
}
