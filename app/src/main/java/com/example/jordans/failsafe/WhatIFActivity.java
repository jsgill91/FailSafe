package com.example.jordans.failsafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Autumn on 11/7/2016.
 */

public class WhatIfActivity extends AppCompatActivity {
    public FailSafe FS_System = new FailSafe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_if_activity);
        getSupportActionBar().hide();


        //check if there IS a serializable object to overwrite FS_System with

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            FS_System = (FailSafe) bundle.getSerializable("FailSafe_System");
        }

        final TextView assg1 = (TextView) findViewById(R.id.wi_assg1);
        final TextView assg2 = (TextView) findViewById(R.id.wi_assg1);
        final TextView assg3 = (TextView) findViewById(R.id.wi_assg1);
        final TextView assg4 = (TextView) findViewById(R.id.wi_assg1);
        TextView[] titles = {assg1,assg2,assg3,assg4};

        final EditText newGrade1 = (EditText) findViewById(R.id.assg1_new_grade);
        final EditText newGrade2 = (EditText) findViewById(R.id.assg2_new_grade);
        final EditText newGrade3 = (EditText) findViewById(R.id.assg3_new_grade);
        final EditText newGrade4 = (EditText) findViewById(R.id.assg4_new_grade);

        final Button addGrade1 = (Button) findViewById(R.id.a1_add_grade);
        final Button addGrade2 = (Button) findViewById(R.id.a2_add_grade);
        final Button addGrade3 = (Button) findViewById(R.id.a3_add_grade);
        final Button addGrade4 = (Button) findViewById(R.id.a4_add_grade);

        final CheckBox assg1_grade1 = (CheckBox) findViewById(R.id.wi_grade1_1); final CheckBox assg1_grade2 = (CheckBox) findViewById(R.id.wi_grade1_2);
        final CheckBox assg1_grade3 = (CheckBox) findViewById(R.id.wi_grade1_3); final CheckBox assg1_grade4 = (CheckBox) findViewById(R.id.wi_grade1_4);
        final CheckBox assg1_grade5 = (CheckBox) findViewById(R.id.wi_grade1_5); final CheckBox assg1_grade6 = (CheckBox) findViewById(R.id.wi_grade1_6);
        final CheckBox assg1_grade7 = (CheckBox) findViewById(R.id.wi_grade1_7); final CheckBox assg1_grade8 = (CheckBox) findViewById(R.id.wi_grade1_8);
        final CheckBox assg1_grade9 = (CheckBox) findViewById(R.id.wi_grade1_9); final CheckBox assg1_grade10 = (CheckBox) findViewById(R.id.wi_grade1_10);
        final CheckBox[] assg1_checkboxes = {assg1_grade1,assg1_grade2,assg1_grade3,assg1_grade4,assg1_grade5,assg1_grade6,assg1_grade7,assg1_grade8,assg1_grade9,assg1_grade10};

        final CheckBox assg2_grade1 = (CheckBox) findViewById(R.id.wi_grade2_1); final CheckBox assg2_grade2 = (CheckBox) findViewById(R.id.wi_grade2_2);
        final CheckBox assg2_grade3 = (CheckBox) findViewById(R.id.wi_grade2_3); final CheckBox assg2_grade4 = (CheckBox) findViewById(R.id.wi_grade2_4);
        final CheckBox assg2_grade5 = (CheckBox) findViewById(R.id.wi_grade2_5); final CheckBox assg2_grade6 = (CheckBox) findViewById(R.id.wi_grade2_6);
        final CheckBox assg2_grade7 = (CheckBox) findViewById(R.id.wi_grade2_7); final CheckBox assg2_grade8 = (CheckBox) findViewById(R.id.wi_grade2_8);
        final CheckBox assg2_grade9 = (CheckBox) findViewById(R.id.wi_grade2_9); final CheckBox assg2_grade10 = (CheckBox) findViewById(R.id.wi_grade2_10);
        CheckBox[] assg2_checkboxes = {assg2_grade1,assg2_grade2,assg2_grade3,assg2_grade4,assg2_grade5,assg2_grade6,assg2_grade7,assg2_grade8,assg2_grade9,assg2_grade10};

        final CheckBox assg3_grade1 = (CheckBox) findViewById(R.id.wi_grade3_1); final CheckBox assg3_grade2 = (CheckBox) findViewById(R.id.wi_grade3_2);
        final CheckBox assg3_grade3 = (CheckBox) findViewById(R.id.wi_grade3_3); final CheckBox assg3_grade4 = (CheckBox) findViewById(R.id.wi_grade3_4);
        final CheckBox assg3_grade5 = (CheckBox) findViewById(R.id.wi_grade3_5); final CheckBox assg3_grade6 = (CheckBox) findViewById(R.id.wi_grade3_6);
        final CheckBox assg3_grade7 = (CheckBox) findViewById(R.id.wi_grade3_7); final CheckBox assg3_grade8 = (CheckBox) findViewById(R.id.wi_grade3_8);
        final CheckBox assg3_grade9 = (CheckBox) findViewById(R.id.wi_grade3_9); final CheckBox assg3_grade10 = (CheckBox) findViewById(R.id.wi_grade3_10);
        CheckBox[] assg3_checkboxes = {assg3_grade1,assg3_grade2,assg3_grade3,assg3_grade4,assg3_grade5,assg3_grade6,assg3_grade7,assg3_grade8,assg3_grade9,assg3_grade10};

        final CheckBox assg4_grade1 = (CheckBox) findViewById(R.id.wi_grade4_1); final CheckBox assg4_grade2 = (CheckBox) findViewById(R.id.wi_grade4_2);
        final CheckBox assg4_grade3 = (CheckBox) findViewById(R.id.wi_grade4_3); final CheckBox assg4_grade4 = (CheckBox) findViewById(R.id.wi_grade4_4);
        final CheckBox assg4_grade5 = (CheckBox) findViewById(R.id.wi_grade4_5); final CheckBox assg4_grade6 = (CheckBox) findViewById(R.id.wi_grade4_6);
        final CheckBox assg4_grade7 = (CheckBox) findViewById(R.id.wi_grade4_7); final CheckBox assg4_grade8 = (CheckBox) findViewById(R.id.wi_grade4_8);
        final CheckBox assg4_grade9 = (CheckBox) findViewById(R.id.wi_grade4_9); final CheckBox assg4_grade10 = (CheckBox) findViewById(R.id.wi_grade4_10);
        CheckBox[] assg4_checkboxes = {assg4_grade1,assg4_grade2,assg4_grade3,assg4_grade4,assg4_grade5,assg4_grade6,assg4_grade7,assg4_grade8,assg4_grade9,assg4_grade10};

        /*
            What If needs
                - pull the grades from the database
                - populate and set visibility of the checkboxes
                - add a grade to the appropriate list when it's typed into the box
                - calculate the temporary grade
                - displayed in a dialogue box
         */
        //need a way to get the classname; figure out what it means by static method
        ArrayList<String> gradeInfo = FS_System.get_assignments();
        ArrayList<String> typeList = new ArrayList<>();
        CheckBox[][] checkboxes = new CheckBox[10][4];
        int type = 0;
        int grade = 1;
        int boxSetPtr = -1;
        int boxPtr = 0;
        while(grade <= gradeInfo.size()){
            if(!(typeList.contains(gradeInfo.get(type)))){
                boxPtr = 0;
                typeList.add(gradeInfo.get(type));
                boxSetPtr++;
                titles[boxSetPtr].setText(gradeInfo.get(type));
                //eventually need to check that adding the grade doesn't run off the edge of the checkbox array
                checkboxes[boxPtr][boxSetPtr].setText(gradeInfo.get(grade));
                boxPtr++;
                type+=2;
                grade+=2;
            }
            else{
                checkboxes[boxPtr][boxSetPtr].setText(gradeInfo.get(type));
                boxPtr++;
                type+=2;
                grade+=2;
            }
        }

        addGrade1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(newGrade1.getText().equals("")){
                    Toast.makeText(v.getContext(), "Must input a value", Toast.LENGTH_LONG).show();
                }
                else{
                    int i = 0;
                    while(assg1_checkboxes[i].getText().toString().contains("Grade")){
                        i++;
                    }
                    assg1_checkboxes[i].setText(newGrade1.getText().toString());
                    newGrade1.setText("");
                }
            }
        });
    }
}
