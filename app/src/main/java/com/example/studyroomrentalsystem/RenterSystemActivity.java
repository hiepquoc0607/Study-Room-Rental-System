package com.example.studyroomrentalsystem;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.studyroomrentalsystem.fragment.DashboardFragment;
import com.example.studyroomrentalsystem.fragment.FavoriteFragment;
import com.example.studyroomrentalsystem.fragment.HistoryFragment;
import com.example.studyroomrentalsystem.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class RenterSystemActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    private void mapping() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
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
        setContentView(R.layout.activity_renter_system);

        mapping();

        replaceFragment(new DashboardFragment());

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.dashboard) {
                    replaceFragment(new DashboardFragment());
                    return true;
                } else if (item.getItemId() == R.id.favorite) {
                    replaceFragment(new FavoriteFragment());
                    return true;
                } else if (item.getItemId() == R.id.historyOrder) {
                    replaceFragment(new HistoryFragment());
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    replaceFragment(new ProfileFragment());
                    return true;
                }
                return false;
            }
        });
    }
}