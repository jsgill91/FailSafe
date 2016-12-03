package com.example.jordans.failsafe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Autumn on 10/18/2016.
 *
 * 11/5 - For some reason when you click to add a new assignment type the first time,
 *          assg2 overlays assg1.
 *      - Need to set the weight and drop to text not hint, just in case the user
 *          decides not to enter anything in the fields because a 0 is "already"
 *          there.
 */
public class AddClassActivity extends FragmentActivity {
    public FailSafe FS_System;
    private int assgCount = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_class_activity2);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences
                (getApplicationContext());
        final SharedPreferences.Editor editor = prefs.edit();

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            FS_System = (FailSafe) bundle.getSerializable("FailSafe_System");
        }

        final EditText cNameField = (EditText) findViewById(R.id.cName);
        final EditText cIdField = (EditText) findViewById(R.id.cID);

        final EditText assg1_name = (EditText) findViewById(R.id.assg1_name);
        final EditText assg1_weight = (EditText) findViewById(R.id.assg1_weight_box);
        final EditText assg1_drop = (EditText) findViewById(R.id.assg1_drop_box);
        final TextView sym1 = (TextView) findViewById(R.id.symbol1);

        final EditText assg2_name = (EditText) findViewById(R.id.assg2_name);
        final EditText assg2_weight = (EditText) findViewById(R.id.assg2_weight_box);
        final EditText assg2_drop = (EditText) findViewById(R.id.assg2_drop_box);
        final TextView sym2 = (TextView) findViewById(R.id.symbol2);

        final EditText assg3_name = (EditText) findViewById(R.id.assg3_name);
        final EditText assg3_weight = (EditText) findViewById(R.id.assg3_weight_box);
        final EditText assg3_drop = (EditText) findViewById(R.id.assg3_drop_box);
        final TextView sym3 = (TextView) findViewById(R.id.symbol3);

        final EditText assg4_name = (EditText) findViewById(R.id.assg4_name);
        final EditText assg4_weight = (EditText) findViewById(R.id.assg4_weight_box);
        final EditText assg4_drop = (EditText) findViewById(R.id.assg4_drop_box);
        final TextView sym4 = (TextView) findViewById(R.id.symbol4);

        final EditText assg5_name = (EditText) findViewById(R.id.assg5_name);
        final EditText assg5_weight = (EditText) findViewById(R.id.assg5_weight_box);
        final EditText assg5_drop = (EditText) findViewById(R.id.assg5_drop_box);
        final TextView sym5 = (TextView) findViewById(R.id.symbol5);

        final EditText assg6_name = (EditText) findViewById(R.id.assg6_name);
        final EditText assg6_weight = (EditText) findViewById(R.id.assg6_weight_box);
        final EditText assg6_drop = (EditText) findViewById(R.id.assg6_drop_box);
        final TextView sym6 = (TextView) findViewById(R.id.symbol6);

        final EditText assg7_name = (EditText) findViewById(R.id.assg7_name);
        final EditText assg7_weight = (EditText) findViewById(R.id.assg7_weight_box);
        final EditText assg7_drop = (EditText) findViewById(R.id.assg7_drop_box);
        final TextView sym7 = (TextView) findViewById(R.id.symbol7);

        final EditText assg8_name = (EditText) findViewById(R.id.assg8_name);
        final EditText assg8_weight = (EditText) findViewById(R.id.assg8_weight_box);
        final EditText assg8_drop = (EditText) findViewById(R.id.assg8_drop_box);
        final TextView sym8 = (TextView) findViewById(R.id.symbol8);

        final EditText assg9_name = (EditText) findViewById(R.id.assg9_name);
        final EditText assg9_weight = (EditText) findViewById(R.id.assg9_weight_box);
        final EditText assg9_drop = (EditText) findViewById(R.id.assg9_drop_box);
        final TextView sym9 = (TextView) findViewById(R.id.symbol9);

        final EditText assg10_name = (EditText) findViewById(R.id.assg10_name);
        final EditText assg10_weight = (EditText) findViewById(R.id.assg10_weight_box);
        final EditText assg10_drop = (EditText) findViewById(R.id.assg10_drop_box);
        final TextView sym10 = (TextView) findViewById(R.id.symbol10);

        final Gradebook newClass = new Gradebook();


        final Button submitButton = (Button) findViewById(R.id.classSubmitBtn);
        final Button newTypeButton = (Button) findViewById(R.id.newAssignmentType);

        final ArrayList<Double> weights = new ArrayList<>();
        final ArrayList<Integer> drops = new ArrayList<>();

        newTypeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (assgCount){
                    case 1:
                        //enable assg 2
                        assg2_name.setVisibility(View.VISIBLE);
                        assg2_weight.setVisibility(View.VISIBLE);
                        sym2.setVisibility(View.VISIBLE);
                        assg2_drop.setVisibility(View.VISIBLE);
                        assgCount++;
                        break;
                    case 2:
                        //enable assg 3
                        assg3_name.setVisibility(View.VISIBLE);
                        assg3_weight.setVisibility(View.VISIBLE);
                        sym3.setVisibility(View.VISIBLE);
                        assg3_drop.setVisibility(View.VISIBLE);
                        assgCount++;
                        break;
                    case 3:
                        //enable assg 4
                        assg4_name.setVisibility(View.VISIBLE);
                        assg4_weight.setVisibility(View.VISIBLE);
                        sym4.setVisibility(View.VISIBLE);
                        assg4_drop.setVisibility(View.VISIBLE);
                        assgCount++;
                        break;
                    case 4:
                        //enable assg 5
                        assg5_name.setVisibility(View.VISIBLE);
                        assg5_weight.setVisibility(View.VISIBLE);
                        sym5.setVisibility(View.VISIBLE);
                        assg5_drop.setVisibility(View.VISIBLE);
                        assgCount++;
                        break;
                    case 5:
                        //enable assg 6
                        assg6_name.setVisibility(View.VISIBLE);
                        assg6_weight.setVisibility(View.VISIBLE);
                        sym6.setVisibility(View.VISIBLE);
                        assg6_drop.setVisibility(View.VISIBLE);
                        assgCount++;
                        break;
                    case 6:
                        //enable assg 7
                        assg7_name.setVisibility(View.VISIBLE);
                        assg7_weight.setVisibility(View.VISIBLE);
                        sym7.setVisibility(View.VISIBLE);
                        assg7_drop.setVisibility(View.VISIBLE);
                        assgCount++;
                        break;
                    case 7:
                        //enable assg 8
                        assg8_name.setVisibility(View.VISIBLE);
                        assg8_weight.setVisibility(View.VISIBLE);
                        sym8.setVisibility(View.VISIBLE);
                        assg8_drop.setVisibility(View.VISIBLE);
                        assgCount++;
                        break;
                    case 8:
                        //enable assg 9
                        assg9_name.setVisibility(View.VISIBLE);
                        assg9_weight.setVisibility(View.VISIBLE);
                        sym9.setVisibility(View.VISIBLE);
                        assg9_drop.setVisibility(View.VISIBLE);
                        assgCount++;
                        break;
                    case 9:
                        //enable assg 10
                        assg10_name.setVisibility(View.VISIBLE);
                        assg10_weight.setVisibility(View.VISIBLE);
                        sym10.setVisibility(View.VISIBLE);
                        assg10_drop.setVisibility(View.VISIBLE);
                        assgCount++;
                        newTypeButton.setClickable(false);
                        break;

                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //Gradebook newClass = new Gradebook(context);
                ArrayList<String> classList = new ArrayList<>();
                String nameString;
                String weightString;
                String dropString;
                double weight;
                int count = 1;

                newClass.setCourseName(cNameField.getText().toString());
                newClass.setCourseID(cIdField.getText().toString());

                editor.putString("courseName", cNameField.getText().toString());
                editor.commit();
                editor.putString("courseId", cIdField.getText().toString());
                editor.commit();



                while(count <= assgCount){
                    switch (count){
                        case 1:
                            nameString = assg1_name.getText().toString();
                            weightString = assg1_weight.getText().toString();
                            dropString = assg1_drop.getText().toString();
                            if(!(weightString.equals(""))){
                                weight = Double.valueOf(weightString)/100.0;
                            }
                            else{
                                weight = 0;
                            }
                            if(dropString.equals("")){
                                dropString = "0";
                            }

                            weights.add(weight);
                            drops.add(Integer.valueOf(dropString));

                            classList.add(nameString);
                            count++;
                            break;
                        case 2:
                            nameString = assg2_name.getText().toString();
                            weightString = assg2_weight.getText().toString();
                            dropString = assg2_drop.getText().toString();
                            if(!(weightString.equals(""))){
                                weight = Double.valueOf(weightString)/100.0;
                            }
                            else{
                                weight = 0;
                            }
                            if(dropString.equals("")){
                                dropString = "0";
                            }

                            weights.add(weight);
                            drops.add(Integer.valueOf(dropString));
                            classList.add(nameString);
                            count++;
                            break;
                        case 3:
                            nameString = assg3_name.getText().toString();
                            weightString = assg3_weight.getText().toString();
                            dropString = assg3_drop.getText().toString();
                            if(!(weightString.equals(""))){
                                weight = Double.valueOf(weightString)/100.0;
                            }
                            else{
                                weight = 0;
                            }
                            if(dropString.equals("")){
                                dropString = "0";
                            }

                            weights.add(weight);
                            drops.add(Integer.valueOf(dropString));
                            classList.add(nameString);
                            count++;
                            break;
                        case 4:
                            nameString = assg4_name.getText().toString();
                            weightString = assg4_weight.getText().toString();
                            dropString = assg4_drop.getText().toString();
                            if(!(weightString.equals(""))){
                                weight = Double.valueOf(weightString)/100.0;
                            }
                            else{
                                weight = 0;
                            }
                            if(dropString.equals("")){
                                dropString = "0";
                            }

                            weights.add(weight);
                            drops.add(Integer.valueOf(dropString));
                            classList.add(nameString);
                            count++;
                            break;
                        case 5:
                            nameString = assg5_name.getText().toString();
                            weightString = assg5_weight.getText().toString();
                            dropString = assg5_drop.getText().toString();
                            if(!(weightString.equals(""))){
                                weight = Double.valueOf(weightString)/100.0;
                            }
                            else{
                                weight = 0;
                            }
                            if(dropString.equals("")){
                                dropString = "0";
                            }

                            weights.add(weight);
                            drops.add(Integer.valueOf(dropString));
                            classList.add(nameString);
                            count++;
                            break;
                        case 6:
                            nameString = assg6_name.getText().toString();
                            weightString = assg6_weight.getText().toString();
                            dropString = assg6_drop.getText().toString();
                            if(!(weightString.equals(""))){
                                weight = Double.valueOf(weightString)/100.0;
                            }
                            else{
                                weight = 0;
                            }
                            if(dropString.equals("")){
                                dropString = "0";
                            }

                            weights.add(weight);
                            drops.add(Integer.valueOf(dropString));
                            classList.add(nameString);
                            count++;
                            break;
                        case 7:
                            nameString = assg7_name.getText().toString();
                            weightString = assg7_weight.getText().toString();
                            dropString = assg7_drop.getText().toString();
                            if(!(weightString.equals(""))){
                                weight = Double.valueOf(weightString)/100.0;
                            }
                            else{
                                weight = 0;
                            }
                            if(dropString.equals("")){
                                dropString = "0";
                            }

                            weights.add(weight);
                            drops.add(Integer.valueOf(dropString));
                            classList.add(nameString);
                            count++;
                            break;
                        case 8:
                            nameString = assg8_name.getText().toString();
                            weightString = assg8_weight.getText().toString();
                            dropString = assg8_drop.getText().toString();
                            if(!(weightString.equals(""))){
                                weight = Double.valueOf(weightString)/100.0;
                            }
                            else{
                                weight = 0;
                            }
                            if(dropString.equals("")){
                                dropString = "0";
                            }

                            weights.add(weight);
                            drops.add(Integer.valueOf(dropString));
                            classList.add(nameString);
                            count++;
                            break;
                        case 9:
                            nameString = assg9_name.getText().toString();
                            weightString = assg9_weight.getText().toString();
                            dropString = assg9_drop.getText().toString();
                            if(!(weightString.equals(""))){
                                weight = Double.valueOf(weightString)/100.0;
                            }
                            else{
                                weight = 0;
                            }
                            if(dropString.equals("")){
                                dropString = "0";
                            }

                            weights.add(weight);
                            drops.add(Integer.valueOf(dropString));
                            classList.add(nameString);
                            count++;
                            break;
                        case 10:
                            nameString = assg10_name.getText().toString();
                            weightString = assg10_weight.getText().toString();
                            dropString = assg10_drop.getText().toString();
                            if(!(weightString.equals(""))){
                                weight = Double.valueOf(weightString)/100.0;
                            }
                            else{
                                weight = 0;
                            }
                            if(dropString.equals("")){
                                dropString = "0";
                            }

                            weights.add(weight);
                            drops.add(Integer.valueOf(dropString));
                            classList.add(nameString);
                            count++;
                            break;
                    }
                }
                newClass.setAssignmentList(classList);
                FS_System.add_class(newClass); // something about this is making the system crash
                //doesn't need to return to the home screen; needs to go to the class's home screen
                Intent nextScreen = new Intent(v.getContext(), MainScreenActivity.class);
                //passing the serializable object
                nextScreen.putExtra("FailSafe_System", FS_System);
                // final String btnText = cNameField.getText().toString();
                nextScreen.putExtra("com.example.jordans.failsafe", cNameField.getText().toString());
                //MainScreenActivity.visFlag = true;
                startActivity(nextScreen);
                //write methods to add buttons to class page to represent

            }
        });
    }
}