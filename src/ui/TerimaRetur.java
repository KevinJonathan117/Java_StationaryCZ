
package ui;

import beans.CDetailBarang;
import beans.CDetailRetur;
import beans.CReturBeli;
import dao.CDaoReturBeli;
import dao.CDaoSupplier;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static ui.Login.mycon;

public class TerimaRetur extends javax.swing.JFrame {

    private DefaultComboBoxModel model_retur = new DefaultComboBoxModel();
    private DefaultTableModel model_detail = new DefaultTableModel();
    private ArrayList<String> kodebarang=new ArrayList<String>();
    private ArrayList<String> kodedetail=new ArrayList<String>();
    int idx=-1;
    public TerimaRetur() {
       try {
            initComponents();
            clear_screen();
            this.setLocationRelativeTo(null);
            mycon = new MyConnection().getConnection();
            model_detail.addColumn("Nama Barang");
            model_detail.addColumn("Deskripsi");
            model_detail.addColumn("Jumlah");
            
            isicombo();
            comboBoxRetur.setModel(model_retur);
            tabletran.setModel(model_detail);
            pack();
        } catch (SQLException ex) {
            Logger.getLogger(Pembelian.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
     public void clear_screen() {
        isicombo();
        comboBoxRetur.setSelectedIndex(-1);
        Date date = new Date();
        dtp.setDateFormatString("dd-MMMM-yyyy");
        dtp.setDate(date);
        kodebarang.clear();
        kodedetail.clear();
        fill_grid(0, "");
    }
    public void isicombo() {
        model_retur.removeAllElements();
        ArrayList<CReturBeli> listretur = CDaoReturBeli.getAllRetur(mycon, "select * from returpembelian where tgldapatbarang is null");
        
        for (int i = 0; i < listretur.size(); i++) {
            model_retur.addElement(listretur.get(i).getNORETUR()+ "-" + CDaoSupplier.getNamaSupplier(listretur.get(i).getIDSUPPLIER(), mycon));
        }
        
    }
    public void fill_grid(int mode, String addwhere) {
        ArrayList<CDetailBarang> data = null;
        int jum = model_detail.getRowCount();
        for (int i = 0; i < jum; i++) {
            model_detail.removeRow(0);
        }

        for (int i = 0; i < CDaoReturBeli.getDetail().size(); i++) {
            model_detail.addRow(new Object[]{
                CDaoReturBeli.getNamaBarang(CDaoReturBeli.getDetail().get(i).getIDBARANG(),mycon),
                CDaoReturBeli.getDescripsiDetailBarang(CDaoReturBeli.getDetail().get(i).getIDBARANG(), CDaoReturBeli.getDetail().get(i).getNODETAIL(),mycon),
                CDaoReturBeli.getDetail().get(i).getJUMLAHRETUR()});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelSupplier = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxRetur = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dtp = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        labelTglRetur = new javax.swing.JLabel();
        buttonRETUR = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabletran = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(142, 179, 142));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Terima Retur");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 21, 310, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1039, 21, 21, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("x");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1078, 21, 26, -1));

        jPanel5.setBackground(new java.awt.Color(77, 82, 87));

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("No Retur Beli");

        labelSupplier.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelSupplier.setText("-");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("Supplier");

        comboBoxRetur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxRetur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxReturActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("Tanggal Kembali");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("Tanggal Retur");

        labelTglRetur.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelTglRetur.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dtp, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTglRetur, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxRetur, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxRetur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelSupplier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTglRetur, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(dtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        buttonRETUR.setBackground(new java.awt.Color(102, 102, 102));
        buttonRETUR.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonRETUR.setForeground(new java.awt.Color(102, 0, 0));
        buttonRETUR.setText("TERIMA KEMBALIAN RETUR");
        buttonRETUR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRETURActionPerformed(evt);
            }
        });

        buttonCancel.setBackground(new java.awt.Color(102, 102, 102));
        buttonCancel.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonCancel.setForeground(new java.awt.Color(102, 0, 0));
        buttonCancel.setText("CANCEL");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        tabletran.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tabletran.setModel(new javax.swing.table.DefaultTableModel(
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
        tabletran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabletranMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tabletran);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(buttonRETUR, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(408, 408, 408))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCancel)
                            .addComponent(buttonRETUR))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1120, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void buttonRETURActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRETURActionPerformed

        if (comboBoxRetur.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Supplier tidak boleh dikosongkan");
        } else if (model_detail.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Isi Detail Pembelian dulu");
        } else {
            String[] dtret    = comboBoxRetur.getSelectedItem().toString().split("-");
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tg = sdf.format(dtp.getDate());
            CDaoReturBeli.updateTglDapatRetur(dtret[0],tg, mycon);
            for (int i = 0; i < model_detail.getRowCount(); i++) {
               //menambah setiap detail yan gdikembalikan 
                CDaoReturBeli.updateStokBarangTerimaRetur(Integer.parseInt(model_detail.getValueAt(i,2).toString()),
                        kodedetail.get(i),kodebarang.get(i), mycon);
            }
            JOptionPane.showMessageDialog(null, "Penyelesaian Retur " + dtret[0] + " selesai dilakukan");
            clear_screen();
            labelSupplier.setText("-");
            labelTglRetur.setText("-");
        }
    }//GEN-LAST:event_buttonRETURActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        CDaoReturBeli.clearArray();
        clear_screen();
        labelSupplier.setText("-");
        labelTglRetur.setText("-");
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void tabletranMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletranMouseReleased

    }//GEN-LAST:event_tabletranMouseReleased

    private void comboBoxReturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxReturActionPerformed
        if (comboBoxRetur.getSelectedIndex()>-1)
        {
            String[] dpt = comboBoxRetur.getSelectedItem().toString().split("-");
            labelSupplier.setText(CDaoSupplier.getIdSupplier(dpt[1], mycon)+"/"+dpt[1]);
            labelTglRetur.setText(CDaoReturBeli.getTglRetur(dpt[0],mycon));
            isidetailreturbeli();
        }
        
    }//GEN-LAST:event_comboBoxReturActionPerformed

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
            java.util.logging.Logger.getLogger(TerimaRetur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TerimaRetur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TerimaRetur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TerimaRetur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TerimaRetur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonRETUR;
    private javax.swing.JComboBox<String> comboBoxRetur;
    private com.toedter.calendar.JDateChooser dtp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelSupplier;
    private javax.swing.JLabel labelTglRetur;
    private javax.swing.JTable tabletran;
    // End of variables declaration//GEN-END:variables

    private void isidetailreturbeli() {
        ArrayList<CDetailRetur> data = null;
        int jum = model_detail.getRowCount();
        for (int i = 0; i < jum; i++) {
            model_detail.removeRow(0);
        }
        String[] dpt = comboBoxRetur.getSelectedItem().toString().split("-");
        kodebarang.clear();
        kodedetail.clear();
        data=CDaoReturBeli.getAllDetailRetur(mycon, "select * from detail_retur where noretur='" + dpt[0] + "'");
        for (int i = 0; i < data.size(); i++) {
            kodebarang.add(data.get(i).getIDBARANG());
            kodedetail.add(data.get(i).getNODETAIL());
            model_detail.addRow(new Object[]{
                CDaoReturBeli.getNamaBarang(data.get(i).getIDBARANG(),mycon),
                CDaoReturBeli.getDescripsiDetailBarang(data.get(i).getIDBARANG(),data.get(i).getIDBARANG()+ data.get(i).getNODETAIL(),mycon),
                data.get(i).getJUMLAHRETUR()});
        }
    }
}
