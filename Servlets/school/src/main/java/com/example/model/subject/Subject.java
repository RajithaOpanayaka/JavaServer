package com.example.model.subject;

import java.util.*;
public class Subject{
    private String name;
    private String id;
    private ArrayList<String> students;

    public Subject(String name,String id){
        this.name = name;
        this.id = id;
        this.students = new ArrayList<String>();
    }

    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public void addStudent(String id){
        this.students.add(id);
    }
    public void removeStudent(String id){
        this.students.remove(id);
    }
    public ArrayList getStudents(){
        return this.students;
    }
}