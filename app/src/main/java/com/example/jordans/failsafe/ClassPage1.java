package com.example.jordans.failsafe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ClassPage1 extends Activity {
    public FailSafe FS_System = new FailSafe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_page1);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences
                (getApplicationContext());
        final SharedPreferences.Editor editor = prefs.edit();

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            FS_System = (FailSafe) bundle.getSerializable("FailSafe_System");
        }

        setTitle(prefs.getString("courseName", "Course"));

        final TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(prefs.getString("assignName", "DEFAULT"));
        final TextView grade_title = (TextView) findViewById((R.id.grade_header));
        final TextView grade_display = (TextView) findViewById((R.id.grade_display));
        //addAssignment = addGrade
        final Button addAssignment = (Button) findViewById(R.id.addAssign);
        final Button calcGradeBtn = (Button) findViewById(R.id.calcGrade);

        addAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(v.getContext(), AddGradeActivity.class);
                nextScreen.putExtra("FailSafe_System", FS_System);
                startActivity(nextScreen);
            }
        });

        calcGradeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double grade = FS_System.calculate_average(prefs.getString("courseName", "Course"));
                grade_title.setVisibility(View.VISIBLE);
                grade_display.setVisibility(View.VISIBLE);
                grade_display.setText(String.valueOf(grade));
            }
        });

    }

}
