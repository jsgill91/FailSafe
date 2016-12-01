package com.example.jordans.failsafe;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class ClassPage1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_page1);

        Intent intent = getIntent();
    }

}
