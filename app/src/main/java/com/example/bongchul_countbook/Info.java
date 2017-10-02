/*
 * Copyright (c) Team X, CMPUT301, University of Alberta. All Rights Reserved. You may use, distribute or modify this code under terms and conditions of the Code of Students Behaviour at University of Alberta
 */

package com.example.bongchul_countbook;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by BongChul on 2017-10-01.
 */

public class Info {
    private String name;
    private Date date;
    private int c_value;
    private int i_value;
    private String comment;

    public Info(String name, int i_value){
        this.name = name;
        this.date = new Date();
        this.i_value = i_value;
    }
    public Info(String name, int c_value, int i_value, String comment){
        this.name = name;
        this.date = new Date();
        this.c_value = c_value;
        this.i_value = i_value;
        this.comment = comment;
    }

    public String toString(){
        return name + " | " + i_value + " | " + date.toString();
    }
}
