package com.example.studyroomrentalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RegisterActivity extends AppCompatActivity {
    ArrayAdapter<String> genderAdapter;
    ArrayAdapter<String> roleAdapter;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhone;
    private EditText etDob;
    private Button btnRegister;
    private TextView txtLogin;
    private AutoCompleteTextView txtAutoGender;
    private AutoCompleteTextView txtAutoRole;
    private String[] gender = {"Male", "Female", "Order"};
    private String[] role = {"Renter", "Landlord"};
    private String genderSelected = "";
    private String roleSelected = "";

    private void mapping() {
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etDob = (EditText) findViewById(R.id.etDob);
        txtAutoGender = (AutoCompleteTextView) findViewById(R.id.txtAutoGender);
        txtAutoRole = (AutoCompleteTextView) findViewById(R.id.txtAutoRole);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        txtLogin = (TextView) findViewById(R.id.txtLogin);

        genderAdapter = new ArrayAdapter<String>(this, R.layout.drop_down_item_layout, gender);
        txtAutoGender.setAdapter(genderAdapter);

        roleAdapter = new ArrayAdapter<String>(this, R.layout.drop_down_item_layout, role);
        txtAutoRole.setAdapter(roleAdapter);
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

        txtAutoGender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                genderSelected = parent.getItemAtPosition(position).toString();
            }
        });

        txtAutoRole.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                roleSelected = parent.getItemAtPosition(position).toString();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPage();
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