package com.example.jordans.failsafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        final EditText name = (EditText) findViewById(R.id.assg_name);
        final EditText type = (EditText) findViewById(R.id.type_input);
        final EditText grade = (EditText) findViewById(R.id.assg_grade);
        final TextView typeView = (TextView) findViewById(R.id.type_list);
        final Button submitBtn = (Button) findViewById(R.id.newGradeBtn);

        final ArrayList<String> types = FS_System.get_types("placeholder");

        String typeList = "(available assignment types: ";
        for(int i = 0; i <= types.size(); i++){
            if(i == 0){
                typeList += types.get(i);
            }
            else{
                typeList += ", " + types.get(i);
            }
        }
        typeList += ")";

        //allow the user to see their type options
        typeView.setText(typeList);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("") || name.getText().toString().equals(" Enter Name")){
                    Toast.makeText(v.getContext(), "Must input an assignment name", Toast.LENGTH_LONG).show();
                }
                else if(type.getText().toString().equals("") || type.getText().toString().equals(" Enter Name") || !(types.contains(type.getText().toString()))){
                    Toast.makeText(v.getContext(), "Must input a valid assignment type", Toast.LENGTH_LONG).show();
                }
                else if(grade.getText().toString().equals("")){
                    Toast.makeText(v.getContext(), "Must input an assignment grade", Toast.LENGTH_LONG).show();
                }
                else{
                    FS_System.add_grade("placeholder_classname", name.getText().toString(), type.getText().toString(), Double.valueOf(grade.getText().toString()));
                }

                //pass control back to whatever class
            }
        });




    }
}

