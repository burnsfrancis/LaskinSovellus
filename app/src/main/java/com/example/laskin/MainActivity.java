package com.example.laskin;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed(){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }   else {
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
            j = new Intent(this, Asetukset.class);
            startActivity(j);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent k;

        if (id == R.id.activity_laskin) {
            k = new Intent(this, Laskin.class);
            startActivity(k);
        } else if (id == R.id.activity_funktiolaskin) {
            k = new Intent(this, FunktioLaskin.class);
            startActivity(k);
        } else if (id == R.id.activity_yksikko_pituus) {
            k = new Intent(this, YksikköPituus.class);
            startActivity(k);
        } else if (id == R.id.activity_yksikko_massa) {
            k = new Intent(this, YksikköMassa.class);
            startActivity(k);
        } else if (id == R.id.activity_yksikko_lampotila) {
            k = new Intent(this, YksikköLämpötila.class);
            startActivity(k);
        } else if (id == R.id.activity_yksikko_alue) {
            k = new Intent(this, YksikköAlue.class);
            startActivity(k);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
