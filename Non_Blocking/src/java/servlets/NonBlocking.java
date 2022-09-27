/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class NonBlocking extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<h1>FileReader</h1>"); 
        String filename="/WEB-INF/data.txt"; 
        ServletContext ctx =getServletContext(); 
        InputStream in = ctx.getResourceAsStream(filename);
        
        String path = "http://" + request.getServerName()+ 
        ":" +request.getServerPort() 
        + request.getContextPath() +"/ReadNonBlocking"; 
        
        URL url = new URL(path); 
        HttpURLConnection conn=(HttpURLConnection)url.openConnection(); 
        conn.setChunkedStreamingMode(2); 
        conn.setDoOutput(true); 
        conn.connect();
        
        if(in != null) 
        {
            InputStreamReader inr = new InputStreamReader(in); 
            BufferedReader br = new BufferedReader(inr); 
            String text=""; 
            System.out.println("Reading started...."); 
            BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(conn.getOutputStream())
            );
            
            while(((text=br.readLine())!=null)){
                out.print(text+"<br>");
                try{
                    Thread.sleep(100); 
                    out.flush();
                }catch(InterruptedException ex){}
            }
            bw.flush(); 
            bw.close(); 
        }
 
    }
}
