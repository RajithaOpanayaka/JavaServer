package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Student extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("Hello student");
    }
}