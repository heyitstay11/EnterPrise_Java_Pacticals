/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(name = "Download", urlPatterns = {"/Download"})
public class Download extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("application/octet-stream");
        PrintWriter out = res.getWriter();
        
        ServletContext ctx = getServletContext();
        InputStream is = ctx.getResourceAsStream("/WEB-INF/EJ.pdf");
        
        res.setHeader("Content-Disposition", "attachment;fileName=\"EJ.pdf\"");
        
        int i;
        while((i = is.read()) != -1){
            out.write(i);
        }
        
        is.close();
        out.close();
    }


}
