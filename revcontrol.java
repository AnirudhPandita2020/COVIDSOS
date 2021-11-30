/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidsos1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Anirudh Pandita
 */
public class revcontrol extends oopsin{
    public static String idto,phone;
    public void setup(String id,String ph){
        idto=id;
        phone=ph;
    }
    void check(String id){
         Connection myConn = null;
           
            PreparedStatement myStmt = null;
          
            ResultSet myRs = null;
           
            try {
                // 1. Get a connection to database
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
                String query = "SELECT SWICTH FROM `pincode`.`rev1`" + "WHERE `REV ID`=?";
                myStmt = myConn.prepareStatement(query);
               myStmt.setString(1,id);
               myRs=myStmt.executeQuery();
               myRs.next();
               int j=myRs.getInt("SWICTH");
               if(j==0){
                   JOptionPane.showMessageDialog(null,"NOT ALLOWED BY THE REVIEWER ITSELF");
               }
               else{
                 revcontrol ob = new revcontrol();
                 ob.transfer(id,idto,phone);
               }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
    }
}
