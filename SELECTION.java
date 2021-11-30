/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidsos1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anirudh Pandita
 */
public class SELECTION extends javax.swing.JFrame {

    String test1 = null;
    String audname = null;
    String audid;
    String result = null;
    String pinset = null;
    String audset = null;

    /**
     * /**
     * Creates new form SELECTION
     */
    public SELECTION() {
        initComponents();
        update();
        show_unpincode();
        show_auditor();
        show_rev();
        fillbox();
        show_hos();
        show_med();
        show_food();
        show_plas();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

    }

    public ArrayList<hos> hoslist() {
        ArrayList<hos> hoslist = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
            String query = "SELECT * FROM `pincode`.`hos`";
            myStmt = myConn.prepareStatement(query);
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                hos hi;
                hi = new hos(myRs.getString("HOSPTAL NAME"), myRs.getString("ADDRESS"), myRs.getInt("BEDS"), myRs.getInt("ICU BEDS"), myRs.getInt("VENTILATOR BEDS"), myRs.getInt("TOTAL CASES"), myRs.getInt("ACTIVE CASES"), myRs.getString("REV ID"));
                hoslist.add(hi);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hoslist;
    }

    public void show_hos() {
        ArrayList<hos> list = hoslist();
        DefaultTableModel model = (DefaultTableModel) hostable.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getAddress();
            row[2] = list.get(i).getBeds();
            row[3] = list.get(i).getIcb();
            row[4] = list.get(i).getVb();
            row[5] = list.get(i).getTc();
            row[6] = list.get(i).getAc();
            row[7] = list.get(i).getRid();
            model.addRow(row);
        }
    }

    public ArrayList<med> medlist() {
        ArrayList<med> medlist = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
            String query = "SELECT * FROM `pincode`.`med`";
            myStmt = myConn.prepareStatement(query);
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                med mi;
                mi = new med(myRs.getString("NAME"), myRs.getString("ADDRESS"), myRs.getString("COVID MEDICINE"), myRs.getString("REV ID"));

                medlist.add(mi);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return medlist;
    }

    public void show_med() {
        ArrayList<med> list = medlist();
        DefaultTableModel model = (DefaultTableModel) medtable.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getAddress();
            row[2] = list.get(i).getComed();
            row[3] = list.get(i).getRevid();
            model.addRow(row);
        }
    }
public ArrayList<food> foodlist(){
    ArrayList<food> foodlist = new ArrayList<>();
    Connection myConn=null;
        PreparedStatement myStmt=null;
        ResultSet myRs=null;
        try{
            myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root" , "Kuld1972poon");
            String query="SELECT * FROM `pincode`.`res`";
            myStmt=myConn.prepareStatement(query);
            myRs=myStmt.executeQuery();
            while(myRs.next()){
                food f;
                f = new food(myRs.getString("NAME"),myRs.getString("ADDRESS"),myRs.getString("TAKEAWAY"),myRs.getString("HOME DELIVERY"),myRs.getString("REV ID"));
                foodlist.add(f);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    return foodlist;
}
public void show_food(){
    ArrayList<food> list = foodlist();
    DefaultTableModel model = (DefaultTableModel) foodtable.getModel();
    Object[] row = new Object[5];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getName();
        row[1]=list.get(i).getAddress();
        row[2]=list.get(i).getTake();
        row[3]=list.get(i).getHome();
        row[4]=list.get(i).getRevid();
        model.addRow(row);
    }
}
public ArrayList<plas> plaslist(){
    ArrayList<plas> plaslist= new ArrayList<>();
    Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
            String query = "SELECT * FROM `pincode`.`blood`";
            myStmt = myConn.prepareStatement(query);
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                plas p;
                p = new plas(myRs.getString("NAME"),myRs.getString("COVID NEGATIVE"),myRs.getString("PHONE NO"),myRs.getString("BLOOD TYPE"),myRs.getInt("TIME"));
                plaslist.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return plaslist;
}
public void show_plas(){
    ArrayList<plas> list = plaslist();
    DefaultTableModel model = (DefaultTableModel) platable.getModel();
    Object[] row = new Object[5];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getName();
        row[1]=list.get(i).getNeg();
        row[2]=list.get(i).getTime();
        row[3]=list.get(i).getPhno();
        row[4]=list.get(i).getBtype();
        model.addRow(row);
    }
}
    public ArrayList<reviewer> revlist() {
        ArrayList<reviewer> revlist = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");

            // 2. Prepare statement
            String query = "SELECT * FROM `pincode`.`rev1`";
            myStmt = myConn.prepareStatement(query);

            // 3. Set the parameters
            // 4. Execute SQL query
            myRs = myStmt.executeQuery();
            reviewer r1;
            while (myRs.next()) {
                r1 = new reviewer(myRs.getString("REV NAME"), myRs.getString("REV ID"), myRs.getString("REVPHONE NO"), myRs.getString("AUDITOR"));
                revlist.add(r1);
            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return revlist;
    }

    public void show_rev() {
        ArrayList<reviewer> list = revlist();
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getPhno();
            row[3] = list.get(i).getAudselected();

            model.addRow(row);
        }
    }

    public void fillbox() {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");

            // 2. Prepare statement
            String query = "SELECT * FROM `pincode`.`auditors` WHERE `ACTIVITY STATUS`=1 ";
            myStmt = myConn.prepareStatement(query);

            // 3. Set the parameters
            // 4. Execute SQL query
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                audid = myRs.getString("AUDITOR ID");
                audname = myRs.getString("AUDITOR NAME");
                result = audid + " " + audname;
                auds.addItem(result);
            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    public ArrayList<auditor> auditorlist() {
        ArrayList<auditor> auditorlist = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");

            // 2. Prepare statement
            String query = "SELECT * FROM `pincode`.`auditors`";
            myStmt = myConn.prepareStatement(query);

            // 3. Set the parameters
            // 4. Execute SQL query
            myRs = myStmt.executeQuery();
            auditor a1;
            while (myRs.next()) {
                a1 = new auditor(myRs.getString("AUDITOR ID"), myRs.getString("AUDITOR NAME"), myRs.getString("AUDITOR PHONE NO"), myRs.getString("Pincode issued"), myRs.getString("PINCODE ASSIGNED"), myRs.getInt("ACTIVITY STATUS"));
                auditorlist.add(a1);
            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return auditorlist;
    }

    public void show_auditor() {
        ArrayList<auditor> list = auditorlist();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getAudname();
            row[1] = list.get(i).getAudphno();
            row[2] = list.get(i).getPinass();
            row[3] = list.get(i).getPiniss();
            row[4] = list.get(i).getActivity();
            row[5] = list.get(i).getAudid();
            model.addRow(row);
        }
    }

    public void update() {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");

            // 2. Prepare statement
            String query = "SELECT  COUNT(DISTINCT `PINCODE`) FROM `pincode`.`list(p1)` WHERE `ENABLE/DISABLE`=1";
            myStmt = myConn.prepareStatement(query);

            // 3. Set the parameters
            myRs = myStmt.executeQuery();
            myRs.next();
            int i = myRs.getInt(1);
            serpin.setText("SERVICABLE PINCODE:" + i);

            // 4. Execute SQL query
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    public ArrayList<pincode> pincodelist() {
        ArrayList<pincode> pincodelist = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");

            // 2. Prepare statement
            String query = "SELECT * FROM `pincode`.`list(p1)`" + "WHERE PINCODE = ?" + "AND `ENABLE/DISABLE`=1 ORDER BY PINCODE";
            myStmt = myConn.prepareStatement(query);

            // 3. Set the parameters
            myStmt.setString(1, pincodetext.getText());

            // 4. Execute SQL query
            myRs = myStmt.executeQuery();
            pincode p1;
            while (myRs.next()) {
                p1 = new pincode(myRs.getString("OFFICE NAME"), myRs.getString("PINCODE"), myRs.getInt("ENABLE/DISABLE"));
                pincodelist.add(p1);
            }
            if (pincodelist.isEmpty()) {
                JOptionPane.showMessageDialog(null, "SERVICES NOT PROVIDED FOR THE GIVEN PINCODE");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return pincodelist;
    }

    public void show_pincode() {
        ArrayList<pincode> list = pincodelist();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getOfficename();
            row[1] = list.get(i).getPincode();
            row[2] = list.get(i).getEndn();
            model.addRow(row);
        }
    }

    public ArrayList<unpincode> unpincodelist() {
        ArrayList<unpincode> unpincodelist = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");

            // 2. Prepare statement
            String query = "SELECT DISTINCT PINCODE FROM `pincode`.`list(p1)`" + "WHERE `ENABLE/DISABLE`=0 ORDER BY PINCODE";
            myStmt = myConn.prepareStatement(query);

            // 3. Set the parameters
            //myStmt.setString(1,pincodetext.getText());
            // 4. Execute SQL query
            myRs = myStmt.executeQuery();
            unpincode p1;
            while (myRs.next()) {
                p1 = new unpincode(myRs.getString("PINCODE"));
                unpincodelist.add(p1);
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return unpincodelist;
    }

    public void show_unpincode() {
        ArrayList<unpincode> list = unpincodelist();
        //DefaultTableModel model= (DefaultTableModel) jTable2.getModel();
        Object[] row = new Object[1];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getUnpincode();

            //  model.addRow(row);
        }
        unserpin.setText("UNSERVICABLE PINCODE:" + list.size());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        update1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        revname = new javax.swing.JTextField();
        revphone = new javax.swing.JTextField();
        auds = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        newrevphone = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        newaud = new javax.swing.JTextField();
        newaudphno = new javax.swing.JTextField();
        pinissue = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        auduser = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        upphno = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        audidendis = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pincodetext = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        enpincodetext = new javax.swing.JTextField();
        enable = new javax.swing.JButton();
        disable = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        search = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        serpin = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        unserpin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        newname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        newpin = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        newofficename = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        hostable = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        foodtable = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        medtable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        platable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(70, 84, 128));

        jPanel2.setBackground(new java.awt.Color(70, 84, 128));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PINCODE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(70, 84, 128));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("REVIEWERS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(70, 84, 128));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AUDITORS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(70, 84, 128));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SERVICES");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(70, 84, 128));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PASSWORD CHANGE");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(70, 84, 128));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("LOG-OUT");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 720));

        jPanel5.setBackground(new java.awt.Color(70, 84, 128));

        update1.setText("UPDATE");
        update1.setEnabled(false);
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });

        jButton4.setText("DISABLED");

        jButton2.setText("INSERT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addComponent(update1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jButton2)
                .addGap(104, 104, 104)
                .addComponent(update1)
                .addGap(100, 100, 100)
                .addComponent(jButton4)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("REVIEWER ADDITION");

        jLabel22.setText("REV NAME:");

        jLabel23.setText("REV PHONE NO:");

        jLabel24.setText("UNDER THE AUDITOR:");

        message.setText("PINCODE:");

        auds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                audsActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "REV ID", "REV NAME", "REV PHONE NO", "AUD ASSOCIATED"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel20.setText("NEW REV PHONE NO:");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel22)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(auds, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(201, 201, 201)
                                        .addComponent(message))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addComponent(revname, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(190, 190, 190)
                                                .addComponent(jLabel23))
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addGap(274, 274, 274)
                                                .addComponent(jLabel20)))
                                        .addGap(11, 11, 11)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(newrevphone, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                            .addComponent(revphone)))))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addGap(52, 52, 52)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(revname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(revphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(newrevphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(auds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(message))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab2", jPanel16);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Auditor Name", "Auditor Phone no", "Pincode associated", "Pincode Issued ", "Activity status", "AUD ID"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("AUDITORS ADDITION");

        jLabel16.setText("Auditor Name:");

        jLabel17.setText("Auditor Phone no:");

        jLabel18.setText("Pincode associated:");

        jLabel19.setText("Pincode issued:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", " " }));

        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel26.setText("AUDITOR USERNAME:");

        jButton5.setText("UPDATE");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel27.setText("NEW PHONE NO:");

        upphno.setEnabled(false);

        jPanel19.setBackground(new java.awt.Color(204, 255, 255));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setText("ENABLE/DISABLE");

        jLabel29.setText("ENTER AUD ID:");

        jButton6.setText("ENABLE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("DISABLE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("DIABLED AUDITORS LIST");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(128, 128, 128))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(49, 49, 49))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(audidendis, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(82, 82, 82))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(41, 41, 41)
                .addComponent(jLabel29)
                .addGap(41, 41, 41)
                .addComponent(audidendis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel17)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBox1, 0, 99, Short.MAX_VALUE)
                                            .addComponent(pinissue, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                            .addComponent(newaudphno)
                                            .addComponent(newaud)))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel18)))
                                .addGap(85, 85, 85)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel27)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(auduser, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                            .addComponent(upphno)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(94, 94, 94)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(199, 199, 199)))
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(7, 7, 7))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel15)
                                .addGap(58, 58, 58)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(newaud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel26)
                                    .addComponent(auduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(newaudphno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27)
                                    .addComponent(upphno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(pinissue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(jButton1))
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 77, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("AREA DATA ENTRY");

        jLabel9.setText("ENTER THE AREA PINCODE:");

        jLabel10.setText(" ENTER PINCODE(E/D)");

        enable.setText("ENABLE");
        enable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableActionPerformed(evt);
            }
        });

        disable.setText("DISABLE");
        disable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disableActionPerformed(evt);
            }
        });

        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(70, 84, 128));

        panel.setBackground(new java.awt.Color(70, 84, 128));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelMouseExited(evt);
            }
        });

        serpin.setForeground(new java.awt.Color(255, 255, 255));
        serpin.setText("SERVICABLE PINCODE:");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(serpin, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(serpin)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(70, 84, 128));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
        });

        unserpin.setForeground(new java.awt.Color(255, 255, 255));
        unserpin.setText("UNSERVICABLE PINCODE:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(unserpin)
                .addGap(45, 45, 45))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(unserpin)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OFFICE NAME", "PINCODE", "ENABLE/DISABLE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("INSERT/UPDATE");

        jLabel12.setText("OFFICE NAME:");

        jLabel13.setText("PINCODE:");

        jLabel14.setText("NEW OFFICE NAME:");

        newofficename.setEditable(false);

        insert.setText("INSERT");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(jLabel9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel10)))
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(enpincodetext))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(pincodetext)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(enable, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(disable, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(268, 268, 268))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(245, 245, 245))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newofficename, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newname, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(newpin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123)
                                .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)))
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(pincodetext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh)
                    .addComponent(search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enpincodetext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(enable)
                        .addComponent(disable)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(11, 11, 11)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(newname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(insert)
                    .addComponent(update))
                .addGap(34, 34, 34)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newofficename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(187, Short.MAX_VALUE))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab1", jPanel15);

        hostable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HOSPITAL NAME", "ADDRESS", "BEDS", "ICU BEDS", "VENTILLATOR BEDS", "TOTAL CASES", "ACTIVE CASES", "REV ID"
            }
        ));
        jScrollPane4.setViewportView(hostable);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("HOSPITALS", jPanel14);

        foodtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME OF THE RESTRAURENT", "ADDRESS", "TAKEAWAY", "HOME DELIVERY", "REV ID"
            }
        ));
        jScrollPane5.setViewportView(foodtable);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("FOOD SERVICES", jPanel20);

        medtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PHARMACY NAME", "ADDRESS", "COVID MEDICINE", "REV ID"
            }
        ));
        jScrollPane6.setViewportView(medtable);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("PHARMACY", jPanel21);

        platable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name of the donor", "Covid negative as on", "Time spent as covid positive", "Phone no", "BLOOD TYPE"
            }
        ));
        jScrollPane7.setViewportView(platable);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("PLASMA DONARS", jPanel10);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab4", jPanel18);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, -21, 970, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        jPanel8.setBackground(Color.BLACK);
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        jPanel8.setBackground(new Color(70, 84, 128));
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        int i = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO LOG OUT?", "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        jPanel2.setBackground(Color.BLACK);
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jPanel2.setBackground(new Color(70, 84, 128));
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        jPanel3.setBackground(Color.BLACK);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jPanel3.setBackground(new Color(70, 84, 128));
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        jPanel4.setBackground(Color.BLACK);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        jPanel4.setBackground(new Color(70, 84, 128));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
            String query3 = "UPDATE `pincode`.`list(p1)` SET `OFFICE NAME`=? WHERE `OFFICE NAME`=?";
            myStmt = myConn.prepareStatement(query3);
            myStmt.setString(1, newofficename.getText());
            myStmt.setString(2, newname.getText());
            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "SUCCESFULLy UPDATED!");
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed

        if (newname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "EMPTY FIELDS");

        } else {
            Connection myConn = null;
            PreparedStatement myStmt = null;
            ResultSet myRs = null;

            try {
                // 1. Get a connection to database
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
                String query1 = "SELECT * FROM `pincode`.`list(p1)`" + "WHERE `OFFICE NAME`=?" + "AND PINCODE=?";
                myStmt = myConn.prepareStatement(query1);
                myStmt.setString(1, newname.getText());
                myStmt.setString(2, newpin.getText());
                myRs = myStmt.executeQuery();
                if (myRs.next() == false) {

                    String query = "INSERT INTO `pincode`.`list(p1)`(`OFFICE NAME`,PINCODE,`ENABLE/DISABLE`)VALUES(?,?,0)";
                    myStmt = myConn.prepareStatement(query);
                    myStmt.setString(1, newname.getText());
                    myStmt.setString(2, newpin.getText());
                    myStmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "INSERTED SUCCESFULLY");
                    // jTable2.setModel(new DefaultTableModel(null,new String[]{"OFFICE NAME","PINCODE","ENABLE/DISABLE"}));
                } else {
                    int i = JOptionPane.showConfirmDialog(null, "THE DATA EXISTS DO YOU WISH TO UPDATE IT?", "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (i == JOptionPane.YES_OPTION) {
                        update.setEnabled(true);
                        newofficename.setEditable(true);

                    }
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
    }//GEN-LAST:event_insertActionPerformed

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        jPanel11.setBackground(new Color(70, 84, 128));
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        jPanel11.setBackground(Color.BLACK);
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        unserpinbox frame = new unserpinbox();
        frame.setVisible(true);
    }//GEN-LAST:event_jPanel11MouseClicked

    private void panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseExited
        panel.setBackground(new Color(70, 84, 128));
    }//GEN-LAST:event_panelMouseExited

    private void panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseEntered
        panel.setBackground(Color.BLACK);
    }//GEN-LAST:event_panelMouseEntered

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        serpintable frame = new serpintable();
        frame.setVisible(true);
    }//GEN-LAST:event_panelMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try {
            jTable1.setModel(new DefaultTableModel(null, new String[]{"OFFICE NAME", "PINCODE", "ENABLE/DISABLE"}));
            show_pincode();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        jTable1.setModel(new DefaultTableModel(null, new String[]{"OFFICE NAME", "PINCODE", "ENABLE/DISABLE"}));
        pincodetext.setText(null);
        enpincodetext.setText(null);
        newname.setText(null);
        newofficename.setText(null);
        newpin.setText(null);
        update.setEnabled(false);
        update();
    }//GEN-LAST:event_refreshActionPerformed

    private void disableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disableActionPerformed
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");

            // 2. Prepare statement
            String query = "UPDATE `pincode`.`list(p1)` SET `ENABLE/DISABLE` =0 WHERE PINCODE = ?";
            myStmt = myConn.prepareStatement(query);

            // 3. Set the parameters
            myStmt.setString(1, enpincodetext.getText());

            // 4. Execute SQL query
            myStmt.executeUpdate();

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "DISABLED PINCODE:" + enpincodetext.getText());
        pincodetext.setEditable(true);
        // jTable2.setModel(new DefaultTableModel(null,new String[]{"UNSERVICABLE PINCODE"}));
        show_unpincode();
        //jTable3.setModel(new DefaultTableModel(null,new String[]{"SERVICABLE PINCODE"}));
        // show_serpincode();
        update();
    }//GEN-LAST:event_disableActionPerformed

    private void enableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableActionPerformed
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");

            // 2. Prepare statement
            String query = "UPDATE `pincode`.`list(p1)` SET `ENABLE/DISABLE` =1 WHERE PINCODE = ?";
            myStmt = myConn.prepareStatement(query);

            // 3. Set the parameters
            System.out.println(enpincodetext.getText());
            myStmt.setString(1, enpincodetext.getText());

            // 4. Execute SQL query
            myStmt.executeUpdate();

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "ENABLED PINCODE:" + enpincodetext.getText());
        pincodetext.setEditable(true);
        // jTable2.setModel(new DefaultTableModel(null,new String[]{"UNSERVICABLE PINCODE"}));

        show_unpincode();
        //jTable3.setModel(new DefaultTableModel(null,new String[]{"SERVICABLE PINCODE"}));

        //show_serpincode();
        update();
    }//GEN-LAST:event_enableActionPerformed

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        jPanel6.setBackground(Color.BLACK);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        jPanel6.setBackground(new Color(70, 84, 128));
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        jTabbedPane2.setSelectedIndex(3);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
            String query3 = "UPDATE `pincode`.`auditors` SET  `AUDITOR PHONE NO`=? , `AUDITOR ID`=? WHERE `AUDITOR PHONE NO`=?";
            myStmt = myConn.prepareStatement(query3);
            myStmt.setString(1, upphno.getText());
            String a, ph, pin;
            a = newaud.getText();
            ph = upphno.getText();
            pin = pinissue.getText();
            char b, c;
            b = a.charAt(0);
            c = a.charAt(a.length() - 1);
            String r1, result;
            r1 = new StringBuilder().append(b).append(c).toString();
            result = r1 + ph.substring(6, 10) + pin.substring(1, 6);
            myStmt.setString(2, result);
            myStmt.setString(3, newaudphno.getText());
            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "SUCCESFULLy UPDATED!");
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection myConn = null;
        PreparedStatement myStmt = null;
        PreparedStatement myStmt1 = null;
        ResultSet myRs = null;
        ResultSet myRs1 = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
            String query1 = "SELECT * FROM `pincode`.`auditors`" + "WHERE `AUDITOR NAME`=?" + "AND `AUDITOR PHONE NO`=?";
            String query4 = "SELECT DISTINCT PINCODE FROM `pincode`.`list(p1)` WHERE PINCODE=?" + "AND `ENABLE/DISABLE`=0";
            // 2. Prepare statement

            myStmt = myConn.prepareStatement(query1);
            myStmt1 = myConn.prepareStatement(query4);
            myStmt1.setString(1, pinissue.getText());
            // 3. Set the parameters
            myStmt.setString(1, newaud.getText());
            myStmt.setString(2, newaudphno.getText());
            // 4. Execute SQL query
            myRs1 = myStmt1.executeQuery();
            myRs = myStmt.executeQuery();
            if (myRs1.next() == false) {
                if (myRs.next() == false) {
                    String query2 = "INSERT INTO `pincode`.`auditors`(`AUDITOR ID`,`AUDITOR NAME`,`AUDITOR PHONE NO`,`username`,`PINCODE ASSIGNED`,`Pincode Issued`,`ACTIVITY STATUS`)VALUES(?,?,?,?,?,?,0)";
                    myStmt = myConn.prepareStatement(query2);
                    String a, ph, pin;
                    a = newaud.getText();
                    ph = newaudphno.getText();
                    pin = pinissue.getText();
                    char b, c;
                    b = a.charAt(0);
                    c = a.charAt(a.length() - 1);
                    String r1, result;
                    r1 = new StringBuilder().append(b).append(c).toString();
                    result = r1 + ph.substring(6, 10) + pin.substring(1, 6);
                    myStmt.setString(1, result);
                    myStmt.setString(2, a);
                    myStmt.setString(3, ph);
                    myStmt.setString(4, auduser.getText());
                    myStmt.setString(5, (String) jComboBox1.getSelectedItem());
                    myStmt.setString(6, pinissue.getText());
                    myStmt.executeUpdate();

                } else {
                    int i = JOptionPane.showConfirmDialog(null, "THE DATA EXISTS DO YOU WISH TO UPDATE IT?", "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (i == JOptionPane.YES_OPTION) {
                        jButton5.setEnabled(true);
                        upphno.setEnabled(true);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "ENTERED PINCODE HAS SERVICE UNAVALIBLE");
            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        jTable2.setModel(new DefaultTableModel(null, new String[]{"Auditor Name", "Auditor Phone no", "Pincode associated", "Pincode issued", "ACTIVITY STATUS", "AUD ID"}));
        show_auditor();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
            String query3 = "UPDATE `pincode`.`rev1` SET  `REVPHONE NO`=? , `REV ID`=? WHERE `REVPHONE NO`=?";
            myStmt = myConn.prepareStatement(query3);
            myStmt.setString(1, newrevphone.getText());
            String a, ph, pin;
            a = revname.getText();
            ph = newrevphone.getText();
            pin = pinset;
            char b, c;
            b = a.charAt(0);
            c = a.charAt(a.length() - 1);
            String r1, result;
            r1 = new StringBuilder().append(b).append(c).toString();
            result = r1 + ph.substring(6, 10) + pin.substring(1, 6);
            myStmt.setString(2, result);
            myStmt.setString(3, revphone.getText());
            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "SUCCESFULLy UPDATED!");
        } catch (SQLException exc) {
            exc.printStackTrace();
        }

    }//GEN-LAST:event_update1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");

            // 2. Prepare statement
            String query = "UPDATE `pincode`.`auditors` SET `ACTIVITY STATUS` ='1' " + "WHERE `AUDITOR ID` = ?";
            myStmt = myConn.prepareStatement(query);

            // 3. Set the parameters
            myStmt.setString(1, audidendis.getText());

            // 4. Execute SQL query
            myStmt.executeUpdate();

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        jTable2.setModel(new DefaultTableModel(null, new String[]{"Auditor Name", "Auditor Phone no", "Pincode associated", "Pincode issued", "ACTIVITY STATUS", "AUD ID"}));
        show_auditor();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");

            // 2. Prepare statement
            String query = "UPDATE `pincode`.`auditors` SET `ACTIVITY STATUS` ='0'" + " WHERE `AUDITOR ID` = ?";
            myStmt = myConn.prepareStatement(query);

            // 3. Set the parameters
            myStmt.setString(1, audidendis.getText());

            // 4. Execute SQL query
            myStmt.executeUpdate();

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        jTable2.setModel(new DefaultTableModel(null, new String[]{"Auditor Name", "Auditor Phone no", "Pincode associated", "Pincode issued", "ACTIVITY STATUS", "AUD ID"}));
        show_auditor();
         auds.removeAllItems();
         fillbox();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void audsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_audsActionPerformed
        Object obj = evt.getSource();
        if (obj == auds) {
            String cut = (String) auds.getSelectedItem();
            String r1 = cut.substring(0, 11);
            System.out.println(r1);
            Connection myConn = null;
            PreparedStatement myStmt = null;
            ResultSet myRs = null;
            try {
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
                String query = "SELECT * FROM `pincode`.`auditors`" + "WHERE `AUDITOR ID`=?";
                myStmt = myConn.prepareStatement(query);
                myStmt.setString(1, r1);
                myRs = myStmt.executeQuery();
                if (myRs.next()) {
                    audset = myRs.getString("AUDITOR NAME");
                    pinset = myRs.getString("Pincode issued");
                    message.setText("PINCODE:" + myRs.getString("Pincode issued"));
                }

            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
    }//GEN-LAST:event_audsActionPerformed

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        jPanel7.setBackground(Color.BLACK);
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        jPanel7.setBackground(new Color(70, 84, 128));
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        update frame = new update();
        frame.setVisible(true);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pincode", "root", "Kuld1972poon");
            String query1 = "SELECT * FROM `pincode`.`rev1`" + "WHERE `REV NAME`=?" + "AND `REVPHONE NO`=?";
            myStmt = myConn.prepareStatement(query1);
            myStmt.setString(1, revname.getText());
            myStmt.setString(2, revphone.getText());
            myRs = myStmt.executeQuery();
            if (myRs.next() == false) {

                String query = "INSERT INTO `pincode`.`rev1`(`REV NAME`,`REVPHONE NO`,`AUDITOR`,`PINCODE`,SWICTH,`REV ID`)VALUES(?,?,?,?,0,?)";
                myStmt = myConn.prepareStatement(query);
                myStmt.setString(1, revname.getText());
                myStmt.setString(2, revphone.getText());
                myStmt.setString(3, audset);
                myStmt.setString(4, pinset);
                String a, ph, pin;
                a = revname.getText();
                ph = revphone.getText();
                pin = pinset;
                char b, c;
                b = a.charAt(0);
                c = a.charAt(a.length() - 1);
                String r1, result;
                r1 = new StringBuilder().append(b).append(c).toString();
                result = r1 + ph.substring(6, 10) + pin.substring(1, 6);
                myStmt.setString(5, result);
                myStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "INSERTED SUCCESFULLY");
                jTable3.setModel(new DefaultTableModel(null, new String[]{"REV ID", "REV NAME", "REV PHONE NO", "AUD ASSOCIATED"}));
                show_rev();
            } else {
                int i = JOptionPane.showConfirmDialog(null, "THE DATA EXISTS DO YOU WISH TO UPDATE IT?", "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == JOptionPane.YES_OPTION) {
                    update1.setEnabled(true);

                }
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SELECTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SELECTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SELECTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SELECTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SELECTION().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField audidendis;
    private javax.swing.JComboBox<String> auds;
    private javax.swing.JTextField auduser;
    private javax.swing.JButton disable;
    private javax.swing.JButton enable;
    private javax.swing.JTextField enpincodetext;
    private javax.swing.JTable foodtable;
    private javax.swing.JTable hostable;
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable medtable;
    private javax.swing.JLabel message;
    private javax.swing.JTextField newaud;
    private javax.swing.JTextField newaudphno;
    private javax.swing.JTextField newname;
    private javax.swing.JTextField newofficename;
    private javax.swing.JTextField newpin;
    private javax.swing.JTextField newrevphone;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField pincodetext;
    private javax.swing.JTextField pinissue;
    private javax.swing.JTable platable;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField revname;
    private javax.swing.JTextField revphone;
    private javax.swing.JButton search;
    private javax.swing.JLabel serpin;
    private javax.swing.JLabel unserpin;
    private javax.swing.JButton update;
    private javax.swing.JButton update1;
    private javax.swing.JTextField upphno;
    // End of variables declaration//GEN-END:variables
}
