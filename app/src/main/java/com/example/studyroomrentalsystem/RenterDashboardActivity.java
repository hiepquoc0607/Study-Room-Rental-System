package com.example.studyroomrentalsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class RenterDashboardActivity extends AppCompatActivity {
    private TextView txtUserName;
    private EditText etSearch;
    private TextView txtMoreRoom;
    private ListView lvRoom;
    private BottomNavigationView bottomNavigationView;

    private void mapping() {
        txtUserName = (TextView) findViewById(R.id.txtUserName);
        etSearch = (EditText) findViewById(R.id.etSearch);
        txtMoreRoom = (TextView) findViewById(R.id.txtMoreRoom);
        lvRoom = (ListView) findViewById(R.id.lvRoom);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
    }

    private void historyPage() {
        Intent intent = new Intent(this, RenterOrderActivity.class);
        startActivity(intent);
        finish();
    }

    private void profilePage() {
        Intent intent = new Intent(this, RenterProfileActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_dashboard);

        mapping();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.dashboard) {
                    return true;
                } else if (item.getItemId() == R.id.order) {
                    historyPage();
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    profilePage();
                    return true;
                }
                return false;
            }
        });
    }
}