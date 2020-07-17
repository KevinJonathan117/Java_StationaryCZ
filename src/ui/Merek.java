
package ui;

import beans.CKategori;
import javax.swing.JFrame;
import beans.CMerek;
import dao.CDaoKategori;
import dao.CDaoMerek;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static ui.Login.mycon;

public class Merek extends javax.swing.JFrame {

    private DefaultTableModel model_merek = new DefaultTableModel();

    public Merek() {
        initComponents();
        try {
            this.setLocationRelativeTo(null);
            mycon = new MyConnection().getConnection();
            model_merek.addColumn("ID Merek");
            model_merek.addColumn("Nama");
            model_merek.addColumn("Status");
            table1.setModel(model_merek);
            pack();
            fill_grid(0,"");
            settingButton(0);
            pack();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void fill_grid(int mode,String addwhere)
    {
        ArrayList<CMerek>data=null;
        int jum = model_merek.getRowCount();
        for (int i = 0; i < jum; i++) {
            model_merek.removeRow(0);
        }
        String qry="SELECT * FROM merek ";
        if (mode==0)
        {
            qry="SELECT * FROM merek ";
            data = CDaoMerek.getAllMerek(mycon,qry);
        }else{
            qry="SELECT * FROM merek where idmerek LIKE '%' " + addwhere;
            data = CDaoMerek.getAllMerek(mycon,qry);
        }
        for(int i = 0 ; i<data.size(); i++){
            model_merek.addRow(new Object[]{data.get(i).getIDMEREK(), data.get(i).getNMMEREK(),
                data.get(i).getSTATUS()});
        }
        table1.setModel(model_merek);
    }
    public void clear_screen()
    {
        labelID.setText("-");
        textNamaMerek.setText("");
        rbaktif.setSelected(true);
        rbaktif1.setSelected(true);
        rbtidakaktif1.setSelected(false);
        textSearch.setText("");
        fill_grid(0, "");
    }
    public void settingButton(int mode)
    {
        if (mode==0){
            buttonAdd.setEnabled(true);
            buttonEdit.setEnabled(false); 
            buttonDelete.setEnabled(false);
            clear_screen(); 
        }else{
            buttonAdd.setEnabled(false);
            buttonEdit.setEnabled(true); 
            buttonDelete.setEnabled(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        textNamaMerek = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        rbaktif1 = new javax.swing.JRadioButton();
        rbtidakaktif1 = new javax.swing.JRadioButton();
        textSearch = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        rbaktif = new javax.swing.JRadioButton();
        rbtidakaktif = new javax.swing.JRadioButton();
        labelID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(215, 145, 181));

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Merek");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("x");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(77, 82, 87));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Merek");

        textNamaMerek.setBackground(new java.awt.Color(204, 204, 204));
        textNamaMerek.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        table1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        buttonAdd.setBackground(new java.awt.Color(102, 102, 102));
        buttonAdd.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonAdd.setForeground(new java.awt.Color(102, 0, 0));
        buttonAdd.setText("ADD");
        buttonAdd.setToolTipText("");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonEdit.setBackground(new java.awt.Color(102, 102, 102));
        buttonEdit.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonEdit.setForeground(new java.awt.Color(102, 0, 0));
        buttonEdit.setText("EDIT");
        buttonEdit.setToolTipText("");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonDelete.setBackground(new java.awt.Color(102, 102, 102));
        buttonDelete.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonDelete.setForeground(new java.awt.Color(102, 0, 0));
        buttonDelete.setText("DELETE");
        buttonDelete.setToolTipText("");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Filter");

        buttonGroup2.add(rbaktif1);
        rbaktif1.setText("Aktif");

        buttonGroup2.add(rbtidakaktif1);
        rbtidakaktif1.setText("Tidak Aktif");

        textSearch.setBackground(new java.awt.Color(204, 204, 204));
        textSearch.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        buttonSearch.setBackground(new java.awt.Color(102, 102, 102));
        buttonSearch.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonSearch.setForeground(new java.awt.Color(102, 0, 0));
        buttonSearch.setText("Search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");

        buttonGroup1.add(rbaktif);
        rbaktif.setText("Aktif");

        buttonGroup1.add(rbtidakaktif);
        rbtidakaktif.setText("Tidak Aktif");

        labelID.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelID.setForeground(new java.awt.Color(255, 255, 255));
        labelID.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(buttonDelete))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbaktif)
                                .addGap(50, 50, 50)
                                .addComponent(rbtidakaktif))
                            .addComponent(textNamaMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelID))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel9)
                        .addGap(68, 68, 68)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtidakaktif1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbaktif1)
                                .addGap(67, 67, 67)
                                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbaktif1)
                                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addComponent(rbtidakaktif1))
                            .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addComponent(labelID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textNamaMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbaktif)
                            .addComponent(rbtidakaktif)
                            .addComponent(jLabel8))
                        .addGap(119, 119, 119)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        String wh = "";
        if (rbtidakaktif1.isSelected()){
            wh+=" and status='TIDAK AKTIF' ";
        }else{
            wh+=" and status='AKTIF' ";
        }
        if (!textSearch.getText().equals(""))
        {
            wh+=" and NMMEReK like '%" + textSearch.getText() + "%' ";
        }
        fill_grid(1,wh);
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        String stat = "AKTIF";
        if (rbtidakaktif.isSelected()) stat="TIDAK AKTIF";
        CMerek newmerk = new CMerek("",textNamaMerek.getText(),stat);      
        CDaoMerek.addMerek(newmerk, mycon);
        settingButton(0);
        fill_grid(0,"");
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        String stat = "AKTIF";
        if (rbtidakaktif.isSelected()) stat="TIDAK AKTIF";
        CMerek newmerek = new CMerek(labelID.getText(),textNamaMerek.getText(),stat);      
        CDaoMerek.updateMerek(newmerek, mycon);
        settingButton(0);
        fill_grid(0,"");
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        CDaoMerek.deleteMerek(labelID.getText(), mycon);
        settingButton(0);
        fill_grid(0,"");
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void table1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseReleased
        int idx = table1.getSelectedRow();
       if (idx>-1)
       {
            String id = model_merek.getValueAt(idx, 0).toString();
            labelID.setText(id);
            String nama = model_merek.getValueAt(idx, 1).toString();
            textNamaMerek.setText(nama);       
            String aktif = model_merek.getValueAt(idx, 2).toString();
            if (aktif.equals("AKTIF")){
                rbaktif.setSelected(true);
            }else{
                rbtidakaktif.setSelected(true);
            }
            settingButton(1);
       }
    }//GEN-LAST:event_table1MouseReleased


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
            java.util.logging.Logger.getLogger(Merek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Merek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Merek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Merek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Merek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelID;
    private javax.swing.JRadioButton rbaktif;
    private javax.swing.JRadioButton rbaktif1;
    private javax.swing.JRadioButton rbtidakaktif;
    private javax.swing.JRadioButton rbtidakaktif1;
    private javax.swing.JTable table1;
    private javax.swing.JTextField textNamaMerek;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
