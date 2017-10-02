/*
 * Copyright (c) Team X, CMPUT301, University of Alberta. All Rights Reserved. You may use, distribute or modify this code under terms and conditions of the Code of Students Behaviour at University of Alberta
 */

package com.example.bongchul_countbook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;
import java.util.StringTokenizer;

public class ShowList extends AppCompatActivity {
    TextView tname;
    TextView tiv;
    TextView tcv;
    TextView tcomment;
    TextView tdate;
    private static final int EDIT_LIST_RESULT_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        SharedPreferences sharedPref = getSharedPreferences("counterinfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("name", "");
        int iv = sharedPref.getInt("iv", 0);
        int cv = sharedPref.getInt("cv", 0);
        String comment = sharedPref.getString("comment", "");
        String date = sharedPref.getString("date", "");

        tname = (TextView) findViewById(R.id.textView);
        tname.setText(name);

        tdate = (TextView) findViewById(R.id.textView3);
        tdate.setText(date);

        tiv = (TextView) findViewById(R.id.textView4);
        tiv.setText(String.valueOf(iv));

        tcv = (TextView) findViewById(R.id.textView5);
        tcv.setText(String.valueOf(cv));

        tcomment = (TextView) findViewById(R.id.textView6);
        tcomment.setText(comment);

    }

    public void onEditButtonClicked(View v) {
        Intent i = new Intent(ShowList.this, EditList.class);
        startActivityForResult(i, EDIT_LIST_RESULT_CODE);
    }

    //public void onBackButtonClicked (View v){
    //    Intent i = new Intent(ShowList.this, MainActivity.class);
    //
    //}


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_LIST_RESULT_CODE) {
            if (resultCode == RESULT_OK) {
                SharedPreferences sharedPref = getSharedPreferences("counterinfo", Context.MODE_PRIVATE);

                String name = sharedPref.getString("name", "");
                int iv = sharedPref.getInt("iv", 0);
                int cv = sharedPref.getInt("cv", 0);
                String comment = sharedPref.getString("comment", "");
                String date = sharedPref.getString("date", "");

                tname = (TextView) findViewById(R.id.textView);
                tname.setText(name);

                tdate = (TextView) findViewById(R.id.textView3);
                tdate.setText(date);

                tiv = (TextView) findViewById(R.id.textView4);
                tiv.setText(String.valueOf(iv));

                tcv = (TextView) findViewById(R.id.textView5);
                tcv.setText(String.valueOf(cv));

                tcomment = (TextView) findViewById(R.id.textView6);
                tcomment.setText(comment);
                Intent i = new Intent();
                setResult(RESULT_OK,i);
                finish();

            }
        }
    }
}



