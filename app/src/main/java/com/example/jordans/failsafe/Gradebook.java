package com.example.jordans.failsafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Autumn on 9/8/2016.
 *
 * 10/19: Gradebook is now Course + Gradebook
 * 11/4: I was working on making gradebook handle the flexible now present in AddClassActivity
 *          Before I closed android most recently, I created a new db table for the weights. Need
 *          to find a way to indicated a foreign key when the table is created and find out if I
 *          can specify that the fields are double, int, etc. Don't forget, when adding the stuff
 *          to Gradebook to add the assignment types to the assgList so that Jordan can pull it
 *          for her Spinner. [DISREGARD]
 * 11/5:    - calculate grade also probably needs to be updated with the new flexibility
 *          - need to write "what_if"
 * 11/6:    - updated calculate_grade and calculate_assignment_grade
 *          - work on what_if next
 *          - still need to test this. Like, soon.
 */
public class Gradebook extends SQLiteOpenHelper implements Serializable{

    private String courseName;
    private String courseID;

    private ArrayList<String> assgList;
    private int idGenerator;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Schedule"; //database name
    //Table 1
    private static final String TABLE_ASSIGNMENTS = "Assignments";
    //Table 1 column names
    private static final String ASSG_ID = "ID";
    private static final String ASSG_NAME = "Name";
    private static final String ASSG_DUE_DATE = "Due Date";
    private static final String ASSG_TYPE = "Type";
    private static final String ASSG_DESCRIPTION = "Description";
    private static final String ASSG_GRADE = "Grade";

    //Table 2
    //subbed "Toss" for all occurrences of "Drop" bc doing so made it stop giving me errors! :)
    //for some reason it didn't matter that I didn't change the "Drop" in the variable names...
    private static final String TABLE_ASSIGNMENT_DROPS = "Tossed_Assignments";
    //Table 2 column names
    private static final String DROP_ASSG_TYPE = "Assg_Type";
    private static final String DROP_NUMBER = "Toss_Number";

    //Table 3
    private static final String TABLE_ASSIGNMENT_WEIGHTS = "Assignment_Weights";
    //Table 2 column names
    private static final String WEIGHT_ASSG_TYPE = "Assg_Type";
    private static final String WEIGHT = "Weight";

    public Gradebook(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void setCourseName(String name){
        courseName = name;
    }

    public void setCourseID(String id){
        courseID = id;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getCourseID(){
        return courseID;
    }

    /* these two methods could possibly be rewritten as queries to the database later*/
    public void setAssignmentList(ArrayList<String> list){
        assgList = list;
    }

    public ArrayList<String> getAssignmentList(){
        return assgList;
    }


    /*------ DATABASE METHODS ------*/
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_ASSIGNMENTS_TABLE = "CREATE TABLE " + TABLE_ASSIGNMENTS + "(" + ASSG_ID +
                " INTEGER PRIMARY KEY," + ASSG_NAME + " TEXT NOT NULL," + ASSG_DUE_DATE + " TEXT NOT NULL," + ASSG_TYPE + " TEXT NOT NULL," +
                ASSG_DESCRIPTION + " TEXT NOT NULL," + ASSG_GRADE + " DOUBLE NOT NULL)";
        String CREATE_DROPS_TABLE = "CREATE TABLE " + TABLE_ASSIGNMENT_DROPS + "(" + DROP_ASSG_TYPE +
                " TEXT PRIMARY KEY," + DROP_NUMBER + " INTEGER NOT NULL)";
        String CREATE_WEIGHTS_TABLE = "CREATE TABLE " + TABLE_ASSIGNMENT_WEIGHTS + "(" + WEIGHT_ASSG_TYPE +
                " TEXT PRIMARY KEY," + WEIGHT + " DOUBLE NOT NULL)";
        db.execSQL(CREATE_ASSIGNMENTS_TABLE);
        db.execSQL(CREATE_DROPS_TABLE);
        db.execSQL(CREATE_WEIGHTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASSIGNMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASSIGNMENT_DROPS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASSIGNMENT_WEIGHTS);
        onCreate(db);
    }
    /*
        Okay, the way the addAssignments CURRENTLY works is an com.example.autumn.failsafe.Assignment object
        is still created in FailSafe and stored in the Calendar. Before exiting
        the activity, however, the information is stored here.

        A note: Assignments still need to be given numbers to uniquely identify
        them in the database since i can't figure out how to make a superkey
     */
    public void add_assignment(String name, String due_date, String type, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ASSG_ID, idGenerator);
        values.put(ASSG_NAME, name);
        values.put(ASSG_DUE_DATE, due_date);
        values.put(ASSG_TYPE, type);
        values.put(ASSG_DESCRIPTION, description);

        db.insert(TABLE_ASSIGNMENTS, null, values);
        db.close();
        idGenerator++;
    }

    public int add_grade(int id, String name, String due_date, String type, String description, int grade){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ASSG_ID, id);
        values.put(ASSG_NAME, name);
        values.put(ASSG_DUE_DATE, due_date);
        values.put(ASSG_TYPE, type);
        values.put(ASSG_DESCRIPTION, description);
        values.put(String.valueOf(ASSG_GRADE), grade);

        return db.update(TABLE_ASSIGNMENTS, values, ASSG_ID + " = ?",
                new String[]{String.valueOf(id)});

    }

    public ArrayList<String> get_types(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> types = new ArrayList<>();
        String myQuery;
        myQuery = "SELECT Assg_Type, FROM TABLE_ASSIGNMENT_WEIGHTS";

        Cursor cursor = db.rawQuery(myQuery,null);
        while(cursor.moveToNext()){
            types.add(cursor.getString(cursor.getColumnIndex("Assg_Type")));
        }
        return types;

    }

    public void set_weight(String assignment, double weight) {
        /*
            Adds weights to the Weight table
         */

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(WEIGHT_ASSG_TYPE, assignment);
        values.put(WEIGHT, weight);


        db.insert(TABLE_ASSIGNMENT_WEIGHTS, null, values);
        db.close();
    }

    public void set_drop(String assignment, int drop_num) {
        //need to check if the assignment is already in this table and replace
        //the values if so
        //adds number of dropped assignments to the Tossed table

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DROP_ASSG_TYPE, assignment);
        values.put(DROP_NUMBER, drop_num);


        db.insert(TABLE_ASSIGNMENT_DROPS, null, values);
        db.close();
    }

    public ArrayList<String> get_assignments(){
        //what should this return?
        //an arraylist
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> assignments = new ArrayList<String>();
        String myQuery;

        myQuery = "SELECT Name, Type, Grade, FROM TABLE_ASSIGNMENTS " +
                "ORDER BY Type";

        Cursor cursor = db.rawQuery(myQuery,null);
        if(cursor != null){
            while(cursor.moveToNext()){
                //assignments.add(cursor.getString(cursor.getColumnIndex("Name")));
                assignments.add(cursor.getString(cursor.getColumnIndex("Type")));
                assignments.add(String.valueOf(cursor.getDouble(cursor.getColumnIndex("Grade"))));
            }
        }
        cursor.close();
        return assignments;
    }

    public double calculate_assignment_average(String assignment){
        SQLiteDatabase db = this.getReadableDatabase();

        String myQuery;

        myQuery = "SELECT Type, AVG(CAST(Grade AS DOUBLE)) AS Average FROM TABLE_ASSIGNMENTS " +
                "ORDER BY Grade DESC LIMIT COUNT(Type)-(Select " + "drop_num FROM TABLE_ASSIGNMENT_DROPS " +
                "WHERE assg_type = " + assignment + ")";

        Cursor cursor = db.rawQuery(myQuery,null);
        double avg = cursor.getDouble(cursor.getColumnIndex("Toss_Number"));

        cursor.close();
        return avg;
    }

    public double calculate_average(){
        SQLiteDatabase db = this.getReadableDatabase();

        String myQuery;
        String myQuery2;
        /*
            Okay, right now, this function (cough, should):
                1) Query the Assignment table and produce an average for each assignment type
                    (after removing the lowest number of assignments according to what's in the
                    Tossed table)
                2) Query the Weight table using the assignment type returned by the first query
                    to get the weight associated with that assignment
                3) Multiply the Grade returned by the first query by the weight return by the
                    second and adds it to total_average
                4) Once all the assignment types have been added to total_average, return
                    total_average

             Figure out how to run this using query() instead of rawQuery()

             The question is, if the nested query returns an empty value (the assignment is not in
             the drops table and therefore has no assignments to be dropped), will the query cause
             an error or will it just subtract zero and keep moving?
        */

        myQuery = "SELECT Type, AVG(CAST(Grade AS DOUBLE)) AS Average FROM TABLE_ASSIGNMENTS " + 
                "ORDER BY Grade DESC LIMIT COUNT(Type)-(Select " + "drop_num FROM TABLE_ASSIGNMENT_DROPS " +
                "WHERE assg_type = Type)";

        Cursor cursor = db.rawQuery(myQuery,null);
        double avg;
        double total_average = 0;
        if(cursor != null){
            while(cursor.moveToNext()){
                myQuery2 = "Select Weight FROM TABLE_ASSIGNMENT_WEIGHTS WHERE Assg_Type = " + cursor.getString(cursor.getColumnIndex("Type"));
                Cursor cursor2 = db.rawQuery(myQuery2,null);

                avg = cursor.getDouble(cursor.getColumnIndex("Average")) * cursor2.getDouble((cursor2.getColumnIndex("Weight")));
                total_average += avg;

                cursor2.close();
            }
        }

        cursor.close();
        return total_average;
    }

    public double what_if(){

        double average = 0;
        /*
            Could write this to "temporarily" add Assignment objects to the database
            (just DON'T FORGET TO DELETE THEM WHEN FINISHED!) then run calculate_full_grade
            over the modified database.
        */

        /*
            - print out list of assignment types (and grades?)
            - next to each assignment type, have an "Add Grade" button
            -

         */

        return average;
    }


}
