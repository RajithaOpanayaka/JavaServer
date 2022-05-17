package com.example.db;

import com.example.model.student.Student;
import com.example.model.subject.Subject;
import java.util.*;

public class LocalDB implements DB{

    private static LocalDB db;
    private Hashtable<String,Student> students;
    private Hashtable<String,Subject> subjects;

    private LocalDB(){
        this.students = new Hashtable<String,Student>();
        this.subjects = new Hashtable<String,Subject>();
    }

    public static LocalDB getInstance(){
        if(db == null){
            db = new LocalDB();
        }
        return db;
    }
    public void addStudent(Student student,String id){
        this.students.put(id,student);
    }
    public void removeStudent(String id){
        this.students.remove(id);
    }
    public Student getStudent(String id){
        return this.students.get(id);
    }
    public void addSubject(Subject subject,String id){
        this.subjects.put(id,subject);
    }
    public void removeSubject(String id){
        this.subjects.remove(id);
    }
    public Subject getSubject(String id){
        return this.subjects.get(id);
    }
}