/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidsos1;

import static covidsos1.revportal.d;
import static covidsos1.revportal.lo;
import static covidsos1.revportal.n;
import static covidsos1.revportal.p;
import static covidsos1.revportal.rid;
import static covidsos1.revportal.t;
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
public class oopsin {
   void transfer(String id,String idto, String phno){
       System.out.println(id+" "+idto+" "+phno);
       Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        try{
            myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root" , "Kuld1972poon");
            String query="UPDATE `pincode`.`callreport` SET `REV ID` =? "+"WHERE `REV ID`=?"+"AND `PHONE NO`=?";
            myStmt=myConn.prepareStatement(query);
            myStmt.setString(1,idto);
            myStmt.setString(2,id);
            myStmt.setString(3,phno);
            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "TRANSFER CONFIRMED");
        }catch (SQLException exc) {
			exc.printStackTrace();
		}
   }  
}

