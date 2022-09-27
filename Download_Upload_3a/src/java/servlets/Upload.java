/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author hp
 */
@MultipartConfig
@WebServlet(name = "Upload", urlPatterns = {"/Upload"})
public class Upload extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String path = req.getParameter("dest");
        Part filePart = req.getPart("myfile");
        String filename = filePart.getSubmittedFileName();
        
        OutputStream os = new FileOutputStream(new File(path + "/" + filename));
        InputStream is = filePart.getInputStream();
        int read;
        
        while((read = is.read()) != -1){
               os.write(read);
        }
        out.println("File Uploaded Successfully");
        
        is.close();
        os.close();
    }


}
