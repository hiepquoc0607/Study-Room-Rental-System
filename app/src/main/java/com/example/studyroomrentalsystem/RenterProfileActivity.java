package com.example.studyroomrentalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class RenterProfileActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    private void mapping() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
    }

    private void historyPage() {
        Intent intent = new Intent(this, RenterOrderActivity.class);
        startActivity(intent);
        finish();
    }

    private void dashboardPage() {
        Intent intent = new Intent(this, RenterDashboardActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_process);

        mapping();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.dashboard) {
                    dashboardPage();
                    return true;
                } else if (item.getItemId() == R.id.order) {
                    historyPage();
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    return true;
                }
                return false;
            }
        });
    }
}