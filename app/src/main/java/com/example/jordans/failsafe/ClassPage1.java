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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_page1);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences
                (getApplicationContext());
        final SharedPreferences.Editor editor = prefs.edit();

        Intent intent = getIntent();
        setTitle(prefs.getString("course Name", "Course"));

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(prefs.getString("assignName", "DEFAULT"));
        Button addAssignment = (Button) findViewById(R.id.addAssign);
        addAssignment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ClassPage1.this, AddGradeActivity.class);
                startActivity(intent);
            }
        });
    }

}
