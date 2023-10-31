package com.example.studyroomrentalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studyroomrentalsystem.Model.Request.LoginRequest;
import com.example.studyroomrentalsystem.Model.Response.LoginResponse;
import com.example.studyroomrentalsystem.Repository.AccountRepository;
import com.example.studyroomrentalsystem.Service.Interface.AccountService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    AccountService accountService;
    private TextView txtRegister;
    private Button btnLogin;
    private EditText email, password;

    private void mapping() {
        email = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPassword);
        txtRegister = (TextView) findViewById(R.id.txtRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        accountService = AccountRepository.getAccountService();
    }

    public void checkLogin() {
        String txtEmail = email.getText().toString();
        String txtPassword = password.getText().toString();
        LoginRequest account = new LoginRequest(txtEmail, txtPassword);
        accountService.getTokenAuthen(account).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    String bearerToken = loginResponse.getAccessToken();
                    String emailUser = loginResponse.getEmail();

                    Bundle bundle = new Bundle();
                    bundle.putString("bearerToken", bearerToken);
                    bundle.putString("email", emailUser);
                    Intent intent = new Intent(LoginActivity.this, RenterDashboardActivity.class);
                    intent.putExtra("Data", bundle);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }

    private void registerPage() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    private void landlordSystemPage() {
        Intent intent = new Intent(this, RenterDashboardActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mapping();

        txtRegister.setOnClickListener(v -> registerPage());
        btnLogin.setOnClickListener(v -> checkLogin());
    }
}