package com.example.jordans.failsafe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


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

    public void deleteAll(Gradebook courseList){
        Iterator<String> iterator = Gradebook.iterator();

        while(iterator.hasNext()){
            iterator.next();
            iterator.remove();
            courseList [] = new courseList[10];
        }
    }
    public void deleteClass(Gradebook courseList) {
        Iterator<String> iterator = Gradebook.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();

        }
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


}
