
package dress.rent;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import cus.registartion.MENU;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class DressRentForm extends javax.swing.JFrame {
    Connection conn= null;
    PreparedStatement pst= null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    PreparedStatement pst1;
    PreparedStatement pst2;
    
    public DressRentForm() {
        initComponents();
        conn= DBconnect.connect();
        tableload();
        fillcombo2();
        fillcombo();
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }
    
     public void fillcombo(){
        
        String sql="select Dres_id from dress_reg";
        
        try {
            pst1=conn.prepareStatement(sql);
            
            rs=pst1.executeQuery();
            while(rs.next()){
                DREdres_idbox.addItem(rs.getString("Dres_id"));
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DressRentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fillcombo2(){
        
       
        String sql1="select Id from cus_reg";
        try {
            
            pst2=conn.prepareStatement(sql1);
            rs1=pst2.executeQuery();
            
            while(rs1.next()){
                
                DREcus_idbox.addItem(rs1.getString("Id"));
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(DressRentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public void tableload(){
        try {
            String sql = "SELECT DREdres_id AS Dress_Id,DREcus_id AS Cust_Id,DREcus_name AS Customer,DRE_fee AS Fee ,DRE_date AS Date,DREdue_date AS Due_date FROM dress_rent";
            pst = conn.prepareStatement(sql);
            rs= pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
  
    
    public void clear(){
        DREdres_idbox.setSelectedItem("");
        DREcus_idbox.setSelectedItem("");
        DREcus_namebox.setText("");
        DRE_feebox.setText("");
        DRE_datecal.setDateFormatString("");
        DREdue_datecal.setDateFormatString("");
        insertbtn.setEnabled(true);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DREcus_namebox = new javax.swing.JTextField();
        DRE_datecal = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        DRE_feebox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        DREdue_datecal = new com.toedter.calendar.JDateChooser();
        insertbtn = new javax.swing.JButton();
        clearbtn1 = new javax.swing.JButton();
        DREdres_idbox = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        DREcus_idbox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addContainerGap(386, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 440));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("DRESS RENT DETAILS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(303, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 770, 50));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Dress Id");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Customer Id");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Customer Name");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Dress Fee");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Date of Rent");

        jLabel7.setText("Due Date");

        DRE_datecal.setDateFormatString("yyyy-M-dd");

        jDateChooser2.setDateFormatString("yyyy-mm-dd");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Due Date");

        DREdue_datecal.setDateFormatString("yyyy-M-dd");

        insertbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        insertbtn.setText("INSERT");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });

        clearbtn1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        clearbtn1.setText("CLEAR");
        clearbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn1ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        DREcus_idbox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                DREcus_idboxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(insertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 32, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(65, 65, 65)
                                .addComponent(jButton2)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DREcus_namebox)
                            .addComponent(DRE_feebox)
                            .addComponent(DRE_datecal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(DREdue_datecal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DREdres_idbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DREcus_idbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DREdres_idbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DREcus_idbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(DREcus_namebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DRE_feebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DRE_datecal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DREdue_datecal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearbtn1)
                    .addComponent(insertbtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(314, 314, 314)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 310, 370));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 460, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
       String dress_id = DREdres_idbox.getSelectedItem().toString();
       String cust_id = DREcus_idbox.getSelectedItem().toString();
       String cust_name= DREcus_namebox.getText();
       String fee = DRE_feebox.getText();
       
       SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
       String date = Date_Format.format(DRE_datecal.getDate());
        
       SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
       String due = Date_Format1.format(DREdue_datecal.getDate());
       
        try {
            String sql = "INSERT INTO dress_rent(DREdres_id,DREcus_id,DREcus_name,DRE_fee,DRE_date,DREdue_date)VALUES('"+dress_id+"','"+cust_id+"','"+cust_name+"','"+fee+"','"+date+"','"+due+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserted!");
            
             pst1 = conn.prepareStatement("update dress_reg set Dres_available = 'No' where Dres_id = ?");
             pst1.setString(1, dress_id);
             pst1.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
   tableload();
    }//GEN-LAST:event_insertbtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
       // tabledata();
       
        try {
          DefaultTableModel df = (DefaultTableModel)table1.getModel();
          int selectedIndex = table1.getSelectedRow();
          
          DREdres_idbox.setSelectedItem(df.getValueAt(selectedIndex, 0).toString());
          DREcus_idbox.setSelectedItem(df.getValueAt(selectedIndex, 1).toString());
          DREcus_namebox.setText(df.getValueAt(selectedIndex, 2).toString());
          DRE_feebox.setText(df.getValueAt(selectedIndex, 3).toString());
          Date date;
          date = new SimpleDateFormat("yyyy-MM-dd").parse((String)df.getValueAt(selectedIndex, 4));  
          DRE_datecal.setDate(date);
          Date due;
          due = new SimpleDateFormat("yyyy-MM-dd").parse((String)df.getValueAt(selectedIndex, 5));
          DREdue_datecal.setDate(due);
         
          insertbtn.setEnabled(false);
          jButton2.setEnabled(true);
          jButton3.setEnabled(true);
        } catch (ParseException ex) {
            Logger.getLogger(DressRentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
       //tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void clearbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn1ActionPerformed
       clear();
    }//GEN-LAST:event_clearbtn1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MENU me=new MENU();
        this.hide();
        me.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       String dress_id = DREdres_idbox.getSelectedItem().toString();
       String cust_id = DREcus_idbox.getSelectedItem().toString();
       String cust_name= DREcus_namebox.getText();
       String fee = DRE_feebox.getText();
       SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
       String date = Date_Format.format(DRE_datecal.getDate()); 
       SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
       String due = Date_Format1.format(DREdue_datecal.getDate());
       
        try {
            //DREcus_id=?,DREcus_name=?,DRE_fee=?,DRE_date=?,DREdue_date=? 
            String sql = "update dress_rent set DREcus_id=? , DRE_fee=? , DRE_date=? , DREdue_date=?  where DREdres_id=? and DREcus_name=?";
            pst = conn.prepareStatement(sql);
           
            pst.setString(2, cust_id);
            pst.setString(1, cust_name);
            pst.setString(3, fee);
            pst.setString(4, date);
            pst.setString(5, due);
            pst.setString(6, dress_id);
            pst.setString(7, fee);
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Insert Sucessfully!");
            tableload();
            
            DREcus_idbox.requestFocus();
            fillcombo();
            insertbtn.setEnabled(true);
            conn.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
          
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       String dress_id = DREdres_idbox.getSelectedItem().toString();
       String cust_id = DREcus_idbox.getSelectedItem().toString();
       String cust_name= DREcus_namebox.getText();
       String fee = DRE_feebox.getText();
       SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
       String date = Date_Format.format(DRE_datecal.getDate()); 
       SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
       String due = Date_Format1.format(DREdue_datecal.getDate());
       
        try {
            String sql = "delete from dress_rent where DREdres_id=? and DREcus_id=? and DREcus_name=? and DRE_fee=? and DRE_date=? and DREdue_date=? ";
            pst = conn.prepareStatement(sql);
           
            pst.setString(2, cust_id);
            pst.setString(3, cust_name);
            pst.setString(4, fee);
            pst.setString(5, date);
            pst.setString(6, due);
            pst.setString(1, dress_id);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data delete Sucessfully!");
            tableload();
            
            DREcus_idbox.requestFocus();
            fillcombo();
            insertbtn.setEnabled(true);
            conn.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void DREcus_idboxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_DREcus_idboxPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String item=(String)DREcus_idbox.getSelectedItem();
        String sql="select Cus_name from cus_reg where Id=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,item);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String name=rs.getString("Cus_name");
                DREcus_namebox.setText(name);
            }
        }
        catch(Exception e){
        }
        
    }//GEN-LAST:event_DREcus_idboxPopupMenuWillBecomeInvisible

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        DREcus_namebox.setEditable(false);
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(DressRentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DressRentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DressRentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DressRentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DressRentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DRE_datecal;
    private javax.swing.JTextField DRE_feebox;
    private javax.swing.JComboBox<String> DREcus_idbox;
    private javax.swing.JTextField DREcus_namebox;
    private javax.swing.JComboBox<String> DREdres_idbox;
    private com.toedter.calendar.JDateChooser DREdue_datecal;
    private javax.swing.JButton clearbtn1;
    private javax.swing.JButton insertbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
