package com.example.qqchannels;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.MenuItem;



import com.example.qqchannels.Fragment.ChannelsFragment;
import com.example.qqchannels.Fragment.ContactsFragment;
import com.example.qqchannels.Fragment.NewsFragment;
import com.example.qqchannels.Fragment.TransmitFragment;
import com.example.qqchannels.Fragment.WordFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new NewsFragment());

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_news:
                        loadFragment(new NewsFragment());
                        return true;
                    case R.id.navigation_channels:
                        loadFragment(new ChannelsFragment());

                        return true;
                    case R.id.navigation_world:
                        loadFragment(new WordFragment());
                        return true;
                    case R.id.navigation_contacts:
                        loadFragment(new ContactsFragment());
                        return true;
                    case R.id.navigation_transmit:
                        loadFragment(new TransmitFragment());
                        return true;
                }
                return false;
            }
        });
    }



    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main, fragment);
        fragmentTransaction.commit();
    }
}
