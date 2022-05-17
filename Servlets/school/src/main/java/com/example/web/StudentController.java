package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.example.db.LocalDB;
import com.example.model.student.Student;
public class StudentController extends HttpServlet{

    private LocalDB db;

    public void init(){
        this.db = LocalDB.getInstance();
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String id = request.getParameter("id");
        Student student = db.getStudent(id);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        if(student == null){
            out.println("Not found");
            return;
        }

        out.println("Student: name "+student.getName());
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        db.addStudent(new Student(name,id), id);

        response.setContentType("text/html");
        PrintWriter out =  response.getWriter();
        out.println("Successfully added "+ name);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String id = request.getParameter("id");

        Student student = db.getStudent(id);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(student == null){
            out.println("Not found");
            return;
        }
        db.removeStudent(id);
        out.println("Successfully removed.");
    }
}