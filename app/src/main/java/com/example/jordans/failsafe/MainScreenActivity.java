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
    static boolean visFlag = false;
    //put sharedprefences thing here for visFlag
//    private Button[] classButtons = new Button[8];



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
                    String btnTxt = prefs.getString("courseName", "Course");
                    classButton1.setText(btnTxt);
                    classButton1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(MainScreenActivity.this, ClassPage1.class);
                            startActivity(intent);
                        }
                    });
                    //classCount++;
                    break;
                case 1:
                    classButton2.setVisibility(View.VISIBLE);
                    //classCount++;
                    break;
                case 2:
                    classButton3.setVisibility(View.VISIBLE);
                    //classCount++;
                    break;
                case 3:
                    classButton4.setVisibility(View.VISIBLE);
                    //classCount++;
                    break;
                case 4:
                    classButton5.setVisibility(View.VISIBLE);
                    //classCount++;
                    break;
                case 5:
                    classButton6.setVisibility(View.VISIBLE);
                    //classCount++;
                    break;
                case 6:
                    classButton7.setVisibility(View.VISIBLE);
                    //classCount++;
                    break;
                case 7:
                    classButton8.setVisibility(View.VISIBLE);
                 //   classCount++;
                    break;
                case 8:
                    classButton9.setVisibility(View.VISIBLE);
                 //   classCount++;
                    addBtn.setClickable(false);
                    //toast to delete classes instead?
                    break;
            }
            i++;

            editor.putInt("classCount",classCount);
            editor.commit();
        }


    }

//    public boolean setVisible(Button classBtn) {
//       // visFlag = true;
//        classBtn.setVisibility(View.VISIBLE);
//        return true;
//    }
//
//    private void setInvisible(Button classBtn) {
//        visFlag = false;
//        classBtn.setVisibility(View.GONE);
//    }

}
