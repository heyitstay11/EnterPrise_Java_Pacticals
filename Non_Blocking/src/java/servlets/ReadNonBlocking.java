/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import java.io.IOException; 
import javax.servlet.AsyncContext; 
import javax.servlet.ServletException; 
import javax.servlet.ServletInputStream; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 


@WebServlet (name = "ReadNonBlocking", urlPatterns = 
{"/ReadNonBlocking"},asyncSupported = true ) 
public class ReadNonBlocking extends HttpServlet { 
    @Override 
     protected void service(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException { 
        response.setContentType("text/html"); 
        AsyncContext ac = request.startAsync(); 
        ServletInputStream in=request.getInputStream(); 
        in.setReadListener(new ReadingListener(in,ac)); 
     } 

}
