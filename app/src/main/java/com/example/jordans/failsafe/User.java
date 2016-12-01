package com.example.jordans.failsafe;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Autumn on 9/14/2016.
 */
public class User implements Serializable{
    private String username;
    private String password;
    private String university;
    //redo all the stuff involving classes to reflect this change
    private Gradebook[] courseList = new Gradebook[10];
    private int num_courses = 0;

    User(){}

    User(String uName, String pWord){
        this.username = uName;
        this.password = pWord;
    }


    public void set_username(String usrnm){
        this.username = usrnm;
    }

    public void set_password(String pswd){
        this.password = pswd;
    }

    public void set_university(String univ){
        university = univ;
    }


    public String get_username(){
        return username;
    }

    public String get_password(){
        return password;
    }

    public void add_class(Gradebook newClass){
        courseList[num_courses] = newClass;
        num_courses++;
    }
    public void delete_class(String class_name){
        int i = 0;
        while(i <= num_courses && !(courseList[i].getCourseName().equals(class_name))){
            i++;
        }
        for(int j = 0; j < num_courses; j++){
            courseList[i] = courseList[j];
            i++;
        }
        num_courses--;
    }
    public void delete_All(String class_name){
        courseList = new Gradebook[10];
    }

    public double calculate_average(String class_name){
        int i = 0;
        while(i <= num_courses && !(courseList[i].getCourseName().equals(class_name))){
            i++;
        }

        return courseList[i].calculate_average();
    }

    public ArrayList<String> get_assignments(String class_name){
        int i = 0;
        while(i <= num_courses && !(courseList[i].getCourseName().equals(class_name))){
            i++;
        }
        return courseList[i].get_assignments();
    }

    public void add_grade(String class_name, String name, String assg_type, double grade){
        int i = 0;
        while(i <= num_courses && !(courseList[i].getCourseName().equals(class_name))){
            i++;
        }
        courseList[i].add_grade(name,assg_type,grade);
    }

    public ArrayList<String> get_types(String class_name){
        int i = 0;
        while(i <= num_courses && !(courseList[i].getCourseName().equals(class_name))){
            i++;
        }
        return courseList[i].get_types();
    }

}
//