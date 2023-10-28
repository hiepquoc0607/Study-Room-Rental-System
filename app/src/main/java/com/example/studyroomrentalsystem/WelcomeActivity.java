package com.example.studyroomrentalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.studyroomrentalsystem.fragment.Introduction01Fragment;
import com.example.studyroomrentalsystem.fragment.Introduction02Fragment;
import com.example.studyroomrentalsystem.fragment.Introduction03Fragment;

public class WelcomeActivity extends AppCompatActivity {
    private Button btnNext;
    private int clickCount = 0;

    private void mapping() {
        btnNext = (Button) findViewById(R.id.btnNext);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private void loginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mapping();

        replaceFragment(new Introduction01Fragment());

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount = clickCount + 1;
                switch (clickCount) {
                    case 1:
                        replaceFragment(new Introduction02Fragment());
                        break;
                    case 2:
                        replaceFragment(new Introduction03Fragment());
                        break;
                    case 3:
                        loginPage();
                        break;
                }
            }
        });
    }
}