package com.example.db;

import com.example.model.student.Student;
import com.example.model.subject.Subject;

public interface DB{
    public abstract void addStudent(Student student);
    public abstract void removeStudent(int id);
    public abstract Student getStudent(int id);
    public abstract void addSubject(Subject subject);
    public abstract void removeSubject(int id);
    public abstract Subject getSubject(int id);
}