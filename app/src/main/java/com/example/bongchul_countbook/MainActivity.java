/*
 * Copyright (c) Team X, CMPUT301, University of Alberta. All Rights Reserved. You may use, distribute or modify this code under terms and conditions of the Code of Students Behaviour at University of Alberta
 */

package com.example.bongchul_countbook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView no_counters;
    private ListView lv;
    private final ArrayList<Info> items = new ArrayList<Info>();
    private ArrayAdapter<Info> adapter;
    private static final int EDIT_PAGE_RESULT_CODE = 0;
    private static final int SHOW_LIST_RESULT_CODE = 1;
    private int counter = 0;
    Info i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onAddNewButtonClicked(View v){
        Intent i = new Intent(MainActivity.this, EditPage.class);
        startActivityForResult(i, EDIT_PAGE_RESULT_CODE);
    }


    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        lv = (ListView) findViewById(R.id.counters);
        adapter = new ArrayAdapter<Info>(this, R.layout.list_item, items);
        lv.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == EDIT_PAGE_RESULT_CODE) {
            if(resultCode == RESULT_OK) {
                SharedPreferences sharedPref = getSharedPreferences("counterinfo", Context.MODE_PRIVATE);
                String name = sharedPref.getString("name", "");
                int iv = sharedPref.getInt("iv", 0);
                int cv = sharedPref.getInt("cv", 0);
                String comment = sharedPref.getString("comment", "");
                String date = sharedPref.getString("date", "");
                i1 = new Info (name,iv);

                adapter.add(i1);
                counter = lv.getAdapter().getCount();
                no_counters = (TextView)findViewById(R.id.edit_mess);
                no_counters.setText(String.valueOf(counter));
            }
        }

        if(requestCode == SHOW_LIST_RESULT_CODE) {
            if(resultCode == RESULT_OK) {
                SharedPreferences sharedPref = getSharedPreferences("counterinfo", Context.MODE_PRIVATE);
                String name = sharedPref.getString("name", "");
                int iv = sharedPref.getInt("iv", 0);
                int cv = sharedPref.getInt("cv", 0);
                String comment = sharedPref.getString("comment", "");
                String date = sharedPref.getString("date", "");
                Info i2 = new Info(name,iv);
                adapter.remove(i1);
                adapter.add(i2);
                adapter.notifyDataSetChanged();

            }
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent i = new Intent(MainActivity.this, ShowList.class);
                startActivityForResult(i, SHOW_LIST_RESULT_CODE);
            }
        });
    }


}
