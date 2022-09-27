/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Report;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class Entry extends HttpServlet {
    @EJB Report obj;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String name = req.getParameter("name");
        String sub1 = req.getParameter("sub1");
        String sub2 = req.getParameter("sub2");
        String sub3 = req.getParameter("sub3");
        
        obj.addMarks(name, sub1, sub2, sub3);
        
        out.println("Marks Added Successfully");
        
    }


}
