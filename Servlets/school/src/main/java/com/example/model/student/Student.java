package com.example.model.student;

import java.util.*;
public class Student{
    private String name;
    private String id;
    private ArrayList<String> subjects;

    public Student(String name,String id){
        this.name = name;
        this.id = id;
        this.subjects = new ArrayList<String>();
    }
    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public void addSubject(String id){
        this.subjects.add(id);
    }
    public void removeSubject(String id){
        this.subjects.remove(id);
    }
    public ArrayList getSubjects(){
        return this.subjects;
    }
}