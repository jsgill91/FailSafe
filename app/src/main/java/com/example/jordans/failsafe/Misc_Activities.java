package com.example.jordans.failsafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Autumn on 11/11/2016.
 *
 * An activity class created to hold my parts of the project that belong
 * on my other group members' app screens.
 *
 * - Calculate Grade (check)
 * - What If
 */

public class Misc_Activities extends AppCompatActivity{
    public FailSafe FS_System;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.misc_layout_activity);
        getSupportActionBar().hide();


        //check if there IS a serializable object to overwrite FS_System with

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            FS_System = (FailSafe) bundle.getSerializable("FailSafe_System");
        }

        // Calculate Average Start

        final Button calcBtn = (Button) findViewById(R.id.calc_button);
        final Button wiBtn = (Button) findViewById(R.id.whatIf_button);
        final Button addGradeBtn = (Button) findViewById(R.id.addGrade_button);

        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /*
                    courseName goes here. Or the functions can easily
                    be rewritten to take an integer for direct indexing
                 */
                String class_name = "";
                double avg = FS_System.calculate_average(class_name);

                launchDialogue(class_name,String.valueOf(avg));
            }
        });

        // Calculate Average End

        // What If Start
        wiBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextScreen = new Intent(v.getContext(), WhatIfActivity.class);
                nextScreen.putExtra("FailSafe_System", FS_System);
                startActivity(nextScreen);
            }
        });
        //What If End

        //Add Grade Start
//        addGradeBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent nextScreen = new Intent(v.getContext(), AddGradeActivity.class);
//                nextScreen.putExtra("FailSafe_System", FS_System);
//                startActivity(nextScreen);
//            }
//        });
        //Add Grade End

    }

    public void launchDialogue(String title, String grade){
        AlertDialog.Builder grade_window = new AlertDialog.Builder(this);

        grade_window.setMessage("Current average: " + grade)
                .setTitle(title)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog dialog = grade_window.create();
        dialog.show();
    }
}
