package com.example.laskin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Yksikönmuuntaja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClick(View v)
    {
        Intent i;
        switch(v.getId())
        {
            case R.id.activity_yksikko_alue:
                i=new Intent(this,YksikköAlue.class);
                startActivity(i);
                break;

            case R.id.activity_yksikko_pituus:
                i=new Intent(this,YksikköPituus.class);
                startActivity(i);
                break;

            case R.id.activity_yksikko_massa:
                i=new Intent(this,YksikköMassa.class);
                startActivity(i);
                break;

            case R.id.activity_yksikko_lampotila:
                i=new Intent(this,YksikköLämpötila.class);
                break;
        }
    }

}
