package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.example.model.subject.Subject;
import com.example.db.LocalDB;
public class SubjectController extends HttpServlet{

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
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        Subject subject = new Subject(name,id);
        db.addSubject(subject, id);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("Successfully added");
    }
}