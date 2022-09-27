/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ejb.Stateful;

/**
 *
 * @author hp
 */
@Stateful
public class Report {

    public void addMarks(String name, String sub1, String sub2, String sub3){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost/demo", "root", "root");
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO REPORT VALUES (?,?,?,?)");
            ps.setString(1, name); ps.setString(2, sub1);
            ps.setString(3, sub2); ps.setString(4, sub3);
            
            ps.executeUpdate();
            
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
