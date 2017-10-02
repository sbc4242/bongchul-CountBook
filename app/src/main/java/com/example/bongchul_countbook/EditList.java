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
import android.widget.EditText;

import java.util.Date;

public class EditList extends AppCompatActivity {

    EditText editName;
    EditText editIv;
    EditText editCv;
    EditText editComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);
    }

    public void onSaveButtonClicked(View v){

        SharedPreferences sharedPref = getSharedPreferences("counterinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editName = (EditText)findViewById(R.id.textView);
        editIv = (EditText)findViewById(R.id.textView4);
        editCv = (EditText)findViewById(R.id.textView5);
        editComment = (EditText)findViewById(R.id.textView6);

        Date date = new Date();
        editor.putString("name", editName.getText().toString());
        int iv = Integer.parseInt(editIv.getText().toString());
        int cv = Integer.parseInt(editCv.getText().toString());
        editor.putInt("iv", iv);
        editor.putInt("cv", cv);
        editor.putString("date",String.valueOf(date));
        editor.putString("comment",editComment.getText().toString());
        editor.commit();
        Intent i = new Intent();
        setResult(RESULT_OK,i);
        finish();
    }

}
