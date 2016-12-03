package com.example.jordans.failsafe;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


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
public class Gradebook  implements Serializable{

    private String courseName;
    private String courseID;

    private ArrayList<String> assgList;
    private ArrayList<String[]> gradeList;
    private ArrayList<Double> weightList;
    private ArrayList<Integer> dropList;

    public Gradebook(){}

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

    /*
        Okay, the way the addAssignments CURRENTLY works is an com.example.autumn.failsafe.Assignment object
        is still created in FailSafe and stored in the Calendar. Before exiting
        the activity, however, the information is stored here.

        A note: Assignments still need to be given numbers to uniquely identify
        them in the database since i can't figure out how to make a superkey
     */

    //method modified so that a user enters an assignment at the same time they enter the grade;
    // can be change later. For now, instead of getting rid of the unnecessary columns, "" is passed in for their values
    //essentially combines add_assignment and add_grade
    public void add_grade(String name, String type, double grade){
        String[] tuple = {name,type,String.valueOf(grade)};
        gradeList.add(tuple);
    }

    public void set_weightList(ArrayList<Double> weights) {
        weightList = weights;
    }

    public void set_drop(ArrayList<Integer> drops) {
        dropList = drops;
    }

    public ArrayList<String[]> get_grades(){
        //what should this return?
        //an arraylist
        return gradeList;
    }


    public double calculate_average(){

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

        //gradeList = name, type, grade <-- drop lowest
        double final_grade = 0;
        int ptr = 0;
        String currentType;
        ArrayList<Double> grades = new ArrayList<>();
        while(ptr <= assgList.size()){
            currentType = assgList.get(ptr);
            for(int i = 1; i < gradeList.size(); i++){
                if(gradeList.get(i)[2].equals(currentType)){
                    grades.add(Double.valueOf(gradeList.get(i)[2]));
                }
            }
            Collections.sort(grades);
            int stop = grades.size() - dropList.get(ptr);
            double type_grade = 0;

            //less than stop
            for(int j = 0; j < stop; j++){
                type_grade += grades.get(j);
            }
            final_grade += (type_grade/(grades.size() - dropList.get(ptr))) * weightList.get(ptr);
            ptr++;
        }

        return final_grade;

    }



}
