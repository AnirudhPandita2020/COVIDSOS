/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidsos1;

import static covidsos1.ser.n;
import static covidsos1.ser.p;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anirudh Pandita
 */
public class workingwindow extends javax.swing.JFrame {
public static String x=null;
    /**
     * Creates new form workingwindow
     */
    public workingwindow() {
        initComponents();
    }
    public ArrayList<serend> serendlist(){
        ArrayList<serend> serendlist=  new ArrayList<>();
        Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        try{
             String name=serper.getSelectedItem().toString();
             System.out.println(name);
              myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root" , "Kuld1972poon");
              String query="SELECT `C NAME` FROM `pincode`.`sercall`"+"WHERE `NAME`=?";
              myStmt=myConn.prepareStatement(query);
              myStmt.setString(1,name);
              myRs=myStmt.executeQuery();
              while(myRs.next()){
                  serend s1;
                  s1= new serend(myRs.getString("C NAME"));
                  serendlist.add(s1);
              }
             
             
            }catch (SQLException exc) {
			exc.printStackTrace();
		}
        return serendlist;
    }
    public void fillbox5(){
        ArrayList<serend> list = serendlist();
        for(int i=0;i<list.size();i++){
            cbox.addItem(list.get(i).getCname());
        }
    }
public void fillbox1(){
    SELECTION ob = new SELECTION();
    ArrayList<hos> list = ob.hoslist();
    for(int i=0;i<list.size();i++){
         
          serper.addItem(list.get(i).getName());
    
}}
public void fillbox2(){
    SELECTION ob = new SELECTION();
    ArrayList<food> list = ob.foodlist();
     for(int i=0;i<list.size();i++){
        
       serper.addItem(list.get(i).getName());
    
}}
public void fillbox3(){
    SELECTION ob = new SELECTION();
    ArrayList<med> list = ob.medlist();
     for(int i=0;i<list.size();i++){
        
          serper.addItem(list.get(i).getName()); 
    }
}
public void fillbox4(){
    SELECTION ob = new SELECTION();
    ArrayList<plas> list = ob.plaslist();
     for(int i=0;i<list.size();i++){
         serper.addItem(list.get(i).getName());
       
    }
    
}
public void fun1(){
    Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        try{
             
              myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root" , "Kuld1972poon");
              String query ="UPDATE `pincode`.`callreport` SET `HOSPITAL` = ? "+"WHERE `NAME` =?";
              myStmt=myConn.prepareStatement(query);
             myStmt.setString(1,ar1.getText());
             myStmt.setString(2,x);
             myStmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"FEEDBACK SUCESS");
            }catch (SQLException exc) {
			exc.printStackTrace();
		}
}
public void fun2(){
     Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        try{
             
              myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root" , "Kuld1972poon");
              String query ="UPDATE `pincode`.`callreport` SET `FOOD` = ? "+"WHERE `NAME` =?";
              myStmt=myConn.prepareStatement(query);
             myStmt.setString(1,ar1.getText());
             myStmt.setString(2,x);
             myStmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"FEEDBACK SUCESS");
            }catch (SQLException exc) {
			exc.printStackTrace();
		}
}
public void fun3(){
     Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        try{
             
              myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root" , "Kuld1972poon");
              String query ="UPDATE `pincode`.`callreport` SET `PLASMA` = ? "+"WHERE `NAME` =?";
              myStmt=myConn.prepareStatement(query);
             myStmt.setString(1,ar1.getText());
             myStmt.setString(2,x);
             myStmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"FEEDBACK SUCESS");
            }catch (SQLException exc) {
			exc.printStackTrace();
		}
}
public void fun4(){
     Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        try{
             
              myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root" , "Kuld1972poon");
              String query ="UPDATE `pincode`.`callreport` SET `PHARMACY` = ? "+"WHERE `NAME` =?";
              myStmt=myConn.prepareStatement(query);
             myStmt.setString(1,ar1.getText());
             myStmt.setString(2,x);
             myStmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"FEEDBACK SUCESS");
            }catch (SQLException exc) {
			exc.printStackTrace();
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

        sertype = new javax.swing.JComboBox<>();
        cbox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ar1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        serper = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOSPITAL", "FOOD", "PLASMA", "MEDICINE", " " }));
        sertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sertypeActionPerformed(evt);
            }
        });

        cbox.setEnabled(false);
        cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxActionPerformed(evt);
            }
        });

        jLabel1.setText("SERVICE TYPE");

        jLabel2.setText("CILENT NAME");

        ar1.setColumns(20);
        ar1.setRows(5);
        jScrollPane1.setViewportView(ar1);

        jLabel3.setText("MESSAGE");

        jButton1.setText("FEEDBACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("SERVICE PROVIDER NAME");

        serper.setEnabled(false);
        serper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serperActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(serper, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sertype, javax.swing.GroupLayout.Alignment.TRAILING, 0, 155, Short.MAX_VALUE)
                    .addComponent(cbox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(serper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(86, 86, 86))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      String a=sertype.getSelectedItem().toString();
      if(a=="HOSPITAL"){
          fun1();
      }
      if(a=="FOOD"){
          fun2();
      }
      if(a=="PLASMA"){
          fun3();
      }
      if(a=="MEDICINE"){
          fun4();
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sertypeActionPerformed
       String type = (String) sertype.getSelectedItem();
       if(type.equals("HOSPITAL")){
           serper.removeAllItems();
           fillbox1();
           serper.setEnabled(true);
       }
       if(type.equals("FOOD")){
           serper.removeAllItems();
           fillbox2();
            serper.setEnabled(true);
       }
       if(type.equals("PLASMA"))
       {
           serper.removeAllItems();
           fillbox4();
            serper.setEnabled(true);
       }
       if(type.equals("MEDICINE")){
           serper.removeAllItems();
           fillbox3();
            serper.setEnabled(true);
       }
    }//GEN-LAST:event_sertypeActionPerformed

    private void cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxActionPerformed
        x=cbox.getSelectedItem().toString();
        System.out.println(x);
    }//GEN-LAST:event_cboxActionPerformed

    private void serperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serperActionPerformed
         cbox.removeAllItems();
        fillbox5();
           cbox.setEnabled(true);
    }//GEN-LAST:event_serperActionPerformed

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
            java.util.logging.Logger.getLogger(workingwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(workingwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(workingwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(workingwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new workingwindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ar1;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> serper;
    private javax.swing.JComboBox<String> sertype;
    // End of variables declaration//GEN-END:variables
}
