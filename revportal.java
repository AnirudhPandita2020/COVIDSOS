/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidsos1;

import static covidsos1.audportal.i;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Anirudh Pandita
 */
public class revportal extends javax.swing.JFrame {
public static String rid=null;
public static String n,p;
public static int lo=0;
public static String d,t;
    /**
     * Creates new form revportal
     */
    public revportal() {
        initComponents();
        clock();
      
    }
     
    
    public void clock(){
        Thread clock = new Thread()
        {
            public void run(){
                try {
                    while(true){
                     Calendar cal = new GregorianCalendar();
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int month=cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int sec=cal.get(Calendar.SECOND);
        int min=cal.get(Calendar.MINUTE);
        int hour= cal.get(Calendar.HOUR);
        
        time.setText("TIME:"+hour+":"+min+":"+sec+" "+day+"/"+month+"/"+year);
                    sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(revportal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }
        };
        clock.start();
       
    }
    
    public void setup(String id){
        rid=id;
        Connection myConn = null;
        
		PreparedStatement myStmt = null;
                PreparedStatement myStmt1=null;
		ResultSet myRs = null;
                ResultSet myRs1=null;
                
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root" , "Kuld1972poon");
			 String query = "SELECT * FROM `pincode`.`rev1`"+"WHERE `REV ID`=?";
                         myStmt=myConn.prepareStatement(query);
                         myStmt.setString(1,id);
                         myRs=myStmt.executeQuery();
                         myRs.next();
                         aud.setText("AUDITOR:"+myRs.getString("REV NAME"));
                         audid.setText("AUDITOR ID:"+myRs.getString("REV ID"));
                          String query2="SELECT  COUNT(`REV ID`)  FROM `pincode`.`callreport`"+"WHERE `REV ID`=?";
                           myStmt1=myConn.prepareStatement(query2);
                                  myStmt1.setString(1,id);
                                  myRs1=myStmt1.executeQuery();
                                  myRs1.next();
                                  int i=myRs1.getInt(1);
                                  tc.setText("TOTAL CALLS:"+i);
                                  String query3="SELECT  COUNT(`REV ID`)  FROM `pincode`.`callreport`"+"WHERE `REV ID`=?"+"AND `COMPLETED`=0";
                                   myStmt1=myConn.prepareStatement(query3);
                                  myStmt1.setString(1,id);
                                  myRs1=myStmt1.executeQuery();
                                  myRs1.next();
                                  int j=myRs1.getInt(1);
                                  pc.setText("PENDING CALLS:"+j);
                                  String query4="SELECT  COUNT(`REV ID`)  FROM `pincode`.`callreport`"+"WHERE `REV ID`=?"+"AND `COMPLETED`=1";
                                   myStmt1=myConn.prepareStatement(query4);
                                  myStmt1.setString(1,id);
                                  myRs1=myStmt1.executeQuery();
                                  myRs1.next();
                                  int k=myRs1.getInt(1);
                                  cc.setText("COMPLETED CALLS:"+k);
    }catch (SQLException exc) {
			exc.printStackTrace();
		}
    }
    public static void gettime(){
        Calendar cal = new GregorianCalendar();
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int month=cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int sec=cal.get(Calendar.SECOND);
        int min=cal.get(Calendar.MINUTE);
        int hour= cal.get(Calendar.HOUR);
         String time = hour+":"+min+":"+sec;
         String date =day+"/"+month+"/"+year;
         d=date;
         t=time;
    }
    public void loginaccess() {
        
       gettime();
        if (lo == 0) {
            Connection myConn = null;
            Connection myConn1 = null;
            PreparedStatement myStmt = null;
            PreparedStatement myStmt1 = null;
            ResultSet myRs = null;
            ResultSet myRs1 = null;
            try {
                // 1. Get a connection to database
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
                String query = "SELECT * FROM `pincode`.`attendance`" + "WHERE `REV ID`=?";
                myStmt = myConn.prepareStatement(query);
                myStmt.setString(1, rid);
                myRs = myStmt.executeQuery();
               
                    myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
                    String query1 = "INSERT INTO `pincode`.`attendance`(`REV ID`,`LOGIN TIME`,`LOGOUT TIME`,`DATE`) VALUES(?,?,'no yet',?)";
                    myStmt1 = myConn1.prepareStatement(query1);
                    myStmt1.setString(1, rid);
                    myStmt1.setString(2, t);
                    myStmt1.setString(3, d);
                    myStmt1.executeUpdate();
                   lo++;
                

            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        else{
             Connection myConn = null;
            Connection myConn1 = null;
            PreparedStatement myStmt = null;
            PreparedStatement myStmt1 = null;
            ResultSet myRs = null;
            ResultSet myRs1 = null;
            try {
                // 1. Get a connection to database
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
                String query = "SELECT * FROM `pincode`.`attendance`" + "WHERE `REV ID`=?";
                myStmt = myConn.prepareStatement(query);
                myStmt.setString(1, rid);
                myRs = myStmt.executeQuery();
                if (myRs.next() == true) {
                    
                    myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
                    String query1 = "UPDATE `pincode`.`attendance` SET `LOGOUT TIME` = ?"+" WHERE `REV ID`=?";
                    myStmt1 = myConn1.prepareStatement(query1);
                    myStmt1.setString(1,t );
                    myStmt1.setString(2, rid);
                    myStmt1.executeUpdate();
                    lo--;

                }

            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
    }
    
        
        
    
    public ArrayList<call> calllist(){
        ArrayList<call> calllist = new ArrayList<>();
        Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        try{
            myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root" , "Kuld1972poon");
            String query="SELECT * FROM `pincode`.`callreport`";
            myStmt=myConn.prepareStatement(query);
            myRs=myStmt.executeQuery();
            call c1;
            while(myRs.next()){
                c1=new call(myRs.getString("NAME"),myRs.getString("PHONE NO"),myRs.getString("HOSPITAL"),myRs.getString("PHARMACY"),myRs.getString("PLASMA"),myRs.getString("FOOD"),myRs.getString("REV ID"),myRs.getInt("COMPLETED"));
                calllist.add(c1);
            }
        }catch (SQLException exc) {
			exc.printStackTrace();
		}
        return calllist;
    }
public void show_cc(){
    ArrayList<call> list = calllist();
    DefaultTableModel model =(DefaultTableModel) calltable.getModel();
    Object [] row = new Object[6];
    for(int i=0;i<list.size();i++){
        if(list.get(i).getComp()==1&&list.get(i).getId().equals(rid)){
        row[0]=list.get(i).getName();
        row[1]=list.get(i).getPhno();
        row[2]=list.get(i).getHos();
        row[3]=list.get(i).getMed();
        row[4]=list.get(i).getPlas();
        row[5]=list.get(i).getFood();
       model.addRow(row);
    }
    }
}
public void show_pc(){
    ArrayList<call> list = calllist();
    DefaultTableModel model =(DefaultTableModel) calltable.getModel();
    Object [] row = new Object[6];
    for(int i=0;i<list.size();i++){
        if(list.get(i).getComp()==0&&list.get(i).getId().equals(rid)){
        row[0]=list.get(i).getName();
        row[1]=list.get(i).getPhno();
        row[2]=list.get(i).getHos();
        row[3]=list.get(i).getMed();
        row[4]=list.get(i).getPlas();
        row[5]=list.get(i).getFood();
       model.addRow(row);
    }
    }
}
public void show_tc(){
    ArrayList<call> list = calllist();
    DefaultTableModel model =(DefaultTableModel) calltable.getModel();
    Object [] row = new Object[6];
    for(int i=0;i<list.size();i++){
        if(list.get(i).getId().equals(rid)){
        row[0]=list.get(i).getName();
        row[1]=list.get(i).getPhno();
        row[2]=list.get(i).getHos();
        row[3]=list.get(i).getMed();
        row[4]=list.get(i).getPlas();
        row[5]=list.get(i).getFood();
       model.addRow(row);
    }
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        aud = new javax.swing.JLabel();
        audid = new javax.swing.JLabel();
        cc = new javax.swing.JLabel();
        pc = new javax.swing.JLabel();
        tc = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        calltable = new javax.swing.JTable();
        cname = new javax.swing.JLabel();
        cphno = new javax.swing.JLabel();
        chosp = new javax.swing.JLabel();
        cfood = new javax.swing.JLabel();
        cplasma = new javax.swing.JLabel();
        cmed = new javax.swing.JLabel();
        sercall = new javax.swing.JButton();
        ccall = new javax.swing.JButton();
        rctt = new javax.swing.JButton();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(22, 29, 69));

        aud.setForeground(new java.awt.Color(255, 255, 255));
        aud.setText("AUDITOR:");

        audid.setForeground(new java.awt.Color(255, 255, 255));
        audid.setText("AUDITOR ID:");

        cc.setForeground(new java.awt.Color(255, 255, 255));
        cc.setText("COMPLETED CALLS:");
        cc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ccMouseClicked(evt);
            }
        });

        pc.setForeground(new java.awt.Color(255, 255, 255));
        pc.setText("PENDING CALLS:");
        pc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pcMouseClicked(evt);
            }
        });

        tc.setForeground(new java.awt.Color(255, 255, 255));
        tc.setText("TOTAL CALLS:");
        tc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tcMouseClicked(evt);
            }
        });

        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("TIME:");

        jButton4.setText("LOGOUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time)
                    .addComponent(tc)
                    .addComponent(pc)
                    .addComponent(cc)
                    .addComponent(audid)
                    .addComponent(aud))
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(aud)
                .addGap(33, 33, 33)
                .addComponent(audid)
                .addGap(47, 47, 47)
                .addComponent(cc)
                .addGap(34, 34, 34)
                .addComponent(pc)
                .addGap(30, 30, 30)
                .addComponent(tc)
                .addGap(41, 41, 41)
                .addComponent(time)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        calltable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "PHONE NO", "HOSPITAL", "MEDICINE", "PLASMA", "FOOD"
            }
        ));
        calltable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calltableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(calltable);

        cname.setText("Name:");

        cphno.setText("Phone no:");

        chosp.setText("Hospital Required:");

        cfood.setText("FOOD:");

        cplasma.setText("PLASMA:");

        cmed.setText("MEDICINE:");

        sercall.setText("SERVICE THE CALL");
        sercall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sercallActionPerformed(evt);
            }
        });

        ccall.setText("CLOSE CALL");
        ccall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccallActionPerformed(evt);
            }
        });

        rctt.setText("REQUEST CALL TRANSFER");
        rctt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcttActionPerformed(evt);
            }
        });

        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(chosp)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cphno)
                            .addComponent(cname)
                            .addComponent(cplasma)
                            .addComponent(cfood)
                            .addComponent(cmed))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ccall, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rctt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sercall, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(refresh, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cname)
                    .addComponent(sercall))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cphno)
                        .addGap(18, 18, 18)
                        .addComponent(chosp)
                        .addGap(13, 13, 13)
                        .addComponent(cfood)
                        .addGap(11, 11, 11)
                        .addComponent(cplasma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmed))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(rctt)
                        .addGap(18, 18, 18)
                        .addComponent(ccall)
                        .addGap(18, 18, 18)
                        .addComponent(refresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ccMouseClicked
       calltable.setModel(new DefaultTableModel(null,new String[]{"NAME","PHONE NO","HOSPITAL","MEDICINE","PLASMA","FOOD"}));
       cname.setText("NAME:");
       cphno.setText("Phone no:");
       chosp.setText("Hospital Required:");
       cfood.setText("FOOD:");
       cplasma.setText("PLASMA:");
       cmed.setText("MEDICINE:");
		show_cc();
    }//GEN-LAST:event_ccMouseClicked

    private void pcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcMouseClicked
      calltable.setModel(new DefaultTableModel(null,new String[]{"NAME","PHONE NO","HOSPITAL","MEDICINE","PLASMA","FOOD"}));
      cname.setText("NAME:");
       cphno.setText("Phone no:");
       chosp.setText("Hospital Required:");
       cfood.setText("FOOD:");
       cplasma.setText("PLASMA:");
       cmed.setText("MEDICINE:");
      show_pc();
    }//GEN-LAST:event_pcMouseClicked

    private void tcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tcMouseClicked
        calltable.setModel(new DefaultTableModel(null,new String[]{"NAME","PHONE NO","HOSPITAL","MEDICINE","PLASMA","FOOD"}));
        cname.setText("NAME:");
       cphno.setText("Phone no:");
       chosp.setText("Hospital Required:");
       cfood.setText("FOOD:");
       cplasma.setText("PLASMA:");
       cmed.setText("MEDICINE:");
        show_tc();
    }//GEN-LAST:event_tcMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
           calltable.setModel(new DefaultTableModel(null,new String[]{"NAME","PHONE NO","HOSPITAL","MEDICINE","PLASMA","FOOD"}));
           cname.setText("NAME:");
       cphno.setText("Phone no:");
       chosp.setText("Hospital Required:");
       cfood.setText("FOOD:");
       cplasma.setText("PLASMA:");
       cmed.setText("MEDICINE:");
    }//GEN-LAST:event_refreshActionPerformed

    private void calltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calltableMouseClicked
       int i=calltable.getSelectedRow();
       TableModel model = calltable.getModel();
       cname.setText("NAME:"+model.getValueAt(i,0).toString());
       cphno.setText("Phone no:"+model.getValueAt(i,1).toString());
       chosp.setText("Hospital Required:"+model.getValueAt(i,2).toString());
       cfood.setText("FOOD:"+model.getValueAt(i,3).toString());
       cplasma.setText("Plasma:"+model.getValueAt(i,4).toString());
       cmed.setText("MEDICINE:"+model.getValueAt(i,5).toString());
       n=model.getValueAt(i,0).toString();
       p=model.getValueAt(i,1).toString();
    }//GEN-LAST:event_calltableMouseClicked

    private void sercallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sercallActionPerformed
      ser frame = new ser();
      frame.setVisible(true);
      frame.fillbox1(rid);
      frame.fillbox2(rid);
      frame.fillbox3(rid);
      frame.fillbox4();
      frame.setup(n,p);
    }//GEN-LAST:event_sercallActionPerformed

    private void rcttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcttActionPerformed
        rct frame =new rct();
        frame.setup1(rid);
        frame.setup2(p);
        frame.setVisible(true);
    }//GEN-LAST:event_rcttActionPerformed

    private void ccallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccallActionPerformed
      Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        try{
            myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root" , "Kuld1972poon");
            String query="UPDATE `pincode`.`callreport` SET `COMPLETED` = 1 "+"WHERE `NAME` =?"+"AND `PHONE NO`=?";
            myStmt=myConn.prepareStatement(query);
            myStmt.setString(1,n);
            myStmt.setString(2,p);
            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"CALL CLOSED SUCCESSFULLY");
        }catch (SQLException exc) {
			exc.printStackTrace();
		}
        audportal ob = new audportal();
        ob.show_call();
    }//GEN-LAST:event_ccallActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       loginaccess();
       int i= JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANNA LOG OUT?","CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(i==JOptionPane.YES_OPTION){
       
        Loginportal frame = new Loginportal();
        frame.setVisible(true);
         setVisible(false);
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(revportal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(revportal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(revportal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(revportal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new revportal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aud;
    private javax.swing.JLabel audid;
    private javax.swing.JTable calltable;
    private javax.swing.JLabel cc;
    private javax.swing.JButton ccall;
    private javax.swing.JLabel cfood;
    private javax.swing.JLabel chosp;
    private javax.swing.JLabel cmed;
    private javax.swing.JLabel cname;
    private javax.swing.JLabel cphno;
    private javax.swing.JLabel cplasma;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pc;
    private javax.swing.JButton rctt;
    private javax.swing.JButton refresh;
    private javax.swing.JButton sercall;
    private javax.swing.JLabel tc;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
