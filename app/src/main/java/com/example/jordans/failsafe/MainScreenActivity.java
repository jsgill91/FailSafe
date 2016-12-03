package com.example.jordans.failsafe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Autumn on 10/14/2016.
 */
public class MainScreenActivity extends AppCompatActivity {
    public FailSafe FS_System = new FailSafe();
    int classCount;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_activity);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences
                (getApplicationContext());
        final SharedPreferences.Editor editor = prefs.edit();


        classCount = prefs.getInt("classCount", 0);



        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            FS_System = (FailSafe) bundle.getSerializable("FailSafe_System");
        }
        final Button addBtn = (Button) findViewById(R.id.addClassBtn);

        final Button classButton1 = (Button) findViewById(R.id.classButton1);
        final Button classButton2 = (Button) findViewById(R.id.classButton2);
        final Button classButton3 = (Button) findViewById(R.id.classButton3);
        final Button classButton4 = (Button) findViewById(R.id.classButton4);
        final Button classButton5 = (Button) findViewById(R.id.classButton5);
        final Button classButton6 = (Button) findViewById(R.id.classButton6);
        final Button classButton7 = (Button) findViewById(R.id.classButton7);
        final Button classButton8 = (Button) findViewById(R.id.classButton8);
        final Button classButton9 = (Button) findViewById(R.id.classButton9);

        //classButton1. = "com.example.jordans.failsafe";



        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                classCount++;
                editor.putInt("classCount",classCount);
                editor.commit();

                Intent nextScreen = new Intent(v.getContext(), AddClassActivity.class);
                //passing the serializable object
                nextScreen.putExtra("FailSafe_System", FS_System);
                startActivity(nextScreen);



            }
        });


        int i = 0;
        while (i < classCount && classCount < 10) {
            switch (i) {
                case 0:
                    classButton1.setVisibility(View.VISIBLE);
                    //editor.putString("BtnText", prefs.getString("courseName", "Course"));
                    String bText = prefs.getString("courseName", "DEFAULT");
                    classButton1.setText(bText);

                    setBtnTxt(classButton1);
                    classButton1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(MainScreenActivity.this, ClassPage1.class);
                            startActivity(intent);
                        }
                    });

                    break;

                case 1:
                    classButton2.setVisibility(View.VISIBLE);
                    String bText2 = prefs.getString("courseName2", "DEFAULT");
                    classButton1.setText(bText2);
                    classButton1.setText(bText2);
                    classButton2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(MainScreenActivity.this, ClassPage2.class);
                            startActivity(intent);
                        }
                    });

                    break;
                case 2:
                    classButton3.setVisibility(View.VISIBLE);
                    setBtnTxt(classButton3);
                    classButton3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(MainScreenActivity.this, ClassPage3.class);
                            startActivity(intent);
                        }
                    });
                    break;
                case 3:
                    classButton4.setVisibility(View.VISIBLE);
                    setBtnTxt(classButton4);
                    classButton4.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(MainScreenActivity.this, ClassPage4.class);
                            startActivity(intent);
                        }
                    });
                    break;
                case 4:
                    classButton5.setVisibility(View.VISIBLE);
                    setBtnTxt(classButton5);
                    classButton5.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(MainScreenActivity.this, ClassPage5.class);
                            startActivity(intent);
                        }
                    });
                    break;
                case 5:
                    classButton6.setVisibility(View.VISIBLE);
                    setBtnTxt(classButton6);
                    classButton6.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(MainScreenActivity.this, ClassPage6.class);
                            startActivity(intent);
                        }
                    });
                    break;
                case 6:
                    classButton7.setVisibility(View.VISIBLE);
                    setBtnTxt(classButton7);
                    classButton7.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(MainScreenActivity.this, ClassPage7.class);
                            startActivity(intent);
                        }
                    });
                    break;
                case 7:
                    classButton8.setVisibility(View.VISIBLE);
                    setBtnTxt(classButton8);
                    classButton8.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(MainScreenActivity.this, ClassPage8.class);
                            startActivity(intent);
                        }
                    });
                    break;
                case 8:
                    classButton9.setVisibility(View.VISIBLE);
                    setBtnTxt(classButton9);
                    classButton9.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(MainScreenActivity.this, ClassPage9.class);
                            startActivity(intent);
                        }
                    });
                    addBtn.setClickable(false);
                    //toast to delete classes instead?
                    break;
            }
            i++;



            editor.putInt("classCount",classCount);
            editor.commit();
        }

    }

    private void setBtnTxt(Button classBtn) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences
                (getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        if (classBtn.getText().equals("Button")) {
            String btnTxt = prefs.getString("courseName", "Course");
            classBtn.setText(btnTxt);
        }
    }

}
