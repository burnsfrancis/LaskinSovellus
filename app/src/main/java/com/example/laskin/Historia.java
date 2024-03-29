package com.example.laskin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class Historia extends AppCompatActivity {

    private ListView lv;
    private DBHelper dbHelper;
    private ArrayAdapter<String> adapter;
    private String calcName="";
    private String []EmptyList={"Tyhjä"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv= findViewById(R.id.listView);
        dbHelper=new DBHelper(this);
        calcName=getIntent().getStringExtra("calcName");
        ArrayList<String> list = dbHelper.showHistory(calcName);
        if(!list.isEmpty())
            adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, list);
        else
            adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,EmptyList);
        lv.setAdapter(adapter);
    }

    public void onClick(View v)
    {
        dbHelper.deleteRecords(calcName);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,EmptyList);
        lv.setAdapter(adapter);
    }
}