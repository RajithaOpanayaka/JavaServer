package com.example.db;

import com.example.model.student.Student;
import com.example.model.subject.Subject;

public class LocalDB implements DB{

    private static LocalDB db;
    private Student student;
    private Subject subject;

    private LocalDB(){}

    public static LocalDB getInstance(){
        if(db == null){
            db = new LocalDB();
        }
        return db;
    }
    public void addStudent(Student student){
    }
    public void removeStudent(int id){
    }
    public Student getStudent(int id){
        return this.student;
    }
    public void addSubject(Subject subject){
    }
    public void removeSubject(int id){
    }
    public Subject getSubject(int id){
        return this.subject;
    }
}