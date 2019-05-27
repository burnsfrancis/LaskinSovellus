package com.example.laskin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentLaskin()).commit();
            navigationView.setCheckedItem(R.id.nav_laskin);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_laskin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentLaskin()).commit();
                break;
            case R.id.nav_flaskin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentFunktio()).commit();
                break;
            case R.id.nav_alue:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentAlue()).commit();
                break;
            case R.id.nav_pituus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentPituus()).commit();
                break;
            case R.id.nav_massa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentMassa()).commit();
                break;
            case R.id.nav_lampo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentLämpö()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent j;

        if (id == R.id.action_settings) {
            j = new Intent();
            startActivity(j);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
