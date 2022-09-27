/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Stateful;

/**
 *
 * @author hp
 */
@Stateful
public class Room {

   public String bookRoom(String name, String phone, String type) {
       String msg = "";
       try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost/demo", "root", "root");
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM ROOM WHERE TYPE = ? AND STATUS = 'not_booked'");
        ps.setString(1, type);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
           String r_id = rs.getString(1);
           String charges = rs.getString(5);
           PreparedStatement ps1 = con.prepareStatement("UPDATE ROOM SET STATUS = 'booked', NAME = ?, PHONE = ? WHERE ID = ?");
           ps1.setString(1, name);
           ps1.setString(2, phone);
           ps1.setString(3, r_id);
           
           ps1.executeUpdate();
           msg = "Room Booking Successful, Charges: " + charges;
        }else{
            msg = "No rooms of type " + type + " available";
        }
        
       }catch(ClassNotFoundException | SQLException e){
           e.printStackTrace();
           msg = e.getMessage();
       }
       return msg;
   }
}
