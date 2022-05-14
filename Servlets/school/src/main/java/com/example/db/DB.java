package com.example.db;

import com.example.model.student.Student;
import com.example.model.subject.Subject;

public class DB{

    private DB db;

    private DB(){

    }
    public DB getInstance(){
        if(db == null){
            db = new DB();
        }
        return this.db;
    }
}