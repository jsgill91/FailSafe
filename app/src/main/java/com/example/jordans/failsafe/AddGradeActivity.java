package com.example.jordans.failsafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Autumn on 12/1/2016.
 */

public class AddGradeActivity extends AppCompatActivity {
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

        /*
            - get all the assignment types currently in the database
            - user selects the assignment type they want to add a grade to
            - get all assignments of that type from the database
                - print the id, name and due date to the screen and have
                    radio buttons for them to select the assignment they want
                    to add a grade to.
            - once they've selected an assignment and hit submit, launch a
                dialog asking for the grade they want to enter.
            - call "add_grade" in the appropriate gradebook and add that grade
         */

        ArrayList<String> types = FS_System.get_types("placeholder");


    }
}

