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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class EditPage extends AppCompatActivity {
    public static String message;
    EditText editName;
    EditText editIv;
    EditText editComment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page);

        Button saveButton = (Button) findViewById(R.id.save);
        editName = (EditText)findViewById(R.id.edit_name);
        editIv = (EditText)findViewById(R.id.edit_iv);
        editComment = (EditText)findViewById(R.id.edit_comment);

    }

    public void onSaveButtonClicked (View v) {
        Intent i = new Intent();

        SharedPreferences sharedPref = getSharedPreferences("counterinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Date date = new Date();
        editor.putString("name", editName.getText().toString());
        int iv = Integer.parseInt(editIv.getText().toString());
        int cv = iv;
        editor.putInt("iv", iv);
        editor.putInt("cv", cv);
        editor.putString("date",String.valueOf(date));
        editor.putString("comment",editComment.getText().toString());
        editor.commit();
        setResult(RESULT_OK,i);
        finish();
    }
}
