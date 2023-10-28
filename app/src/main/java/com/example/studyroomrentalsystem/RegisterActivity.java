package com.example.studyroomrentalsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.studyroomrentalsystem.fragment.Register01Fragment;
import com.example.studyroomrentalsystem.fragment.Register02Fragment;

public class RegisterActivity extends AppCompatActivity {
    private Button btnRegister;
    private TextView txtLogin;
    private int clickCount = 0;

    private void mapping() {
        btnRegister = (Button) findViewById(R.id.btnRegister);
        txtLogin = (TextView) findViewById(R.id.txtLogin);
    }

    private void loginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mapping();

        replaceFragment(new Register01Fragment());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount = clickCount+1;
                switch (clickCount) {
                    case 1:
                        replaceFragment(new Register02Fragment());
                        btnRegister.setText("Register");
                        break;
                    case 2:
                        loginPage();
                        break;
                }
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPage();
            }
        });
    }
}