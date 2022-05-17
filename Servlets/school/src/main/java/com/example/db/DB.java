package com.example.db;

import com.example.model.student.Student;
import com.example.model.subject.Subject;

public interface DB{
    public abstract void addStudent(Student student,String id);
    public abstract void removeStudent(String id);
    public abstract Student getStudent(String id);
    public abstract void addSubject(Subject subject,String id);
    public abstract void removeSubject(String id);
    public abstract Subject getSubject(String id);
}