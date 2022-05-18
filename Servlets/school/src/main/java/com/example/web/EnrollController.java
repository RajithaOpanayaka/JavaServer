package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import com.example.model.subject.Subject;
import com.example.model.student.Student;
import com.example.db.LocalDB;

public class EnrollController extends HttpServlet{

    private LocalDB db;

    public void init(){
        this.db = LocalDB.getInstance();
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

        String id = request.getParameter("id");
        Subject subject = db.getSubject(id);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        if(subject == null){
            out.println("Not found.");
            return;
        }
        out.println("Subject: "+subject.getName());
        ArrayList<String> students = subject.getStudents();
        for(int i=0;i< students.size();i++){
            out.println("Student id: "+students.get(i));
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String subjectId = request.getParameter("subject");
        String studentId = request.getParameter("student");

        Subject subject = db.getSubject(subjectId);
        Student student  = db.getStudent(studentId);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        if(subject == null || student == null){
            out.println("Invalid inputs.");
            return;
        }
        student.addSubject(subjectId);
        subject.addStudent(studentId);
        out.println("Successfully enrolled");
    }
}