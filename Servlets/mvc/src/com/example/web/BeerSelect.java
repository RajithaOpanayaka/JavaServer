package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.model.*;

public class BeerSelect extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String c = request.getParameter("color");
        BeerExpert expert = new BeerExpert();
        List brands = expert.getBrands(c);

        // this part handle by JSP
        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
        // out.println("Beer Selection Advice<br>");

        // Iterator itr = brands.iterator();
        // while (itr.hasNext()) {
        // out.print("<br>try: " + itr.next());
        // }
        request.setAttribute("styles", brands);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);

    }
}