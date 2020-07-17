
package ui;

import beans.CBarang;
import beans.CDetailBarang;
import beans.CDetailRetur;
import beans.CReturBeli;
import beans.CSupplier;
import dao.CDaoBarang;
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

public class Retur extends javax.swing.JFrame {

    private DefaultComboBoxModel model_supplier = new DefaultComboBoxModel();
    private DefaultComboBoxModel model_barang = new DefaultComboBoxModel();
    private DefaultComboBoxModel model_detailbarang = new DefaultComboBoxModel();
    private DefaultTableModel model_detail = new DefaultTableModel();
    int idx=-1;
    
    public Retur() {
        try {
            initComponents();
            clear_screen();
            this.setLocationRelativeTo(null);
            mycon = new MyConnection().getConnection();
            model_detail.addColumn("Nama Barang");
            model_detail.addColumn("Deskripsi");
            model_detail.addColumn("Jumlah");
            isicombo();
            comboBoxSupplier.setModel(model_supplier);
            comboBarang.setModel(model_barang);
            comboDetail.setModel(model_detailbarang);
            tabletran.setModel(model_detail);
            pack();
        } catch (SQLException ex) {
            Logger.getLogger(Pembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void clear_screen_detail() {
        comboBarang.setSelectedIndex(-1);        
        model_detailbarang.removeAllElements();
        spinnerJumlah.setValue(0);
    }
     public void clear_screen() {
        isicombo();
        comboBoxSupplier.setSelectedIndex(-1);
        Date date = new Date();
        dtp.setDateFormatString("dd-MMMM-yyyy");
        dtp.setDate(date);
        clear_screen_detail();
        labelID.setText(CDaoReturBeli.getAutoID(mycon));
        CDaoReturBeli.clearArray();
        fill_grid(0, "");
    }
    public void isicombo() {
        model_supplier.removeAllElements();
        model_barang.removeAllElements();
        
        ArrayList<CSupplier> listsupplier = CDaoSupplier.getAllSupplier(mycon, "select * from supplier where status='AKTIF'");
        ArrayList<CBarang> listbarang = CDaoBarang.getAllBarang(mycon, "select * from barang where status='AKTIF'");
        for (int i = 0; i < listsupplier.size(); i++) {
            model_supplier.addElement(listsupplier.get(i).getIDSUPPLIER()+ "-" + listsupplier.get(i).getNMSUPPLIER());
        }
        for (int i = 0; i < listbarang.size(); i++) {
            model_barang.addElement(listbarang.get(i).getIDBARANG()+ "-" + listbarang.get(i).getNMBARANG());
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
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxSupplier = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dtp = new com.toedter.calendar.JDateChooser();
        comboBarang = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        comboDetail = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        spinnerJumlah = new javax.swing.JSpinner();
        buttonRETUR = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabletran = new javax.swing.JTable();
        butAdd = new javax.swing.JButton();
        butUpdate = new javax.swing.JButton();
        butDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(142, 179, 142));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Retur");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 21, -1, -1));

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

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nama Barang");

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("No Retur Beli");

        labelID.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelID.setText("-");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("Supplier");

        comboBoxSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("Tanggal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelID, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(comboBoxSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtp, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(dtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        comboBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBarangActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Detail Barang");

        comboDetail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Jumlah");

        buttonRETUR.setBackground(new java.awt.Color(102, 102, 102));
        buttonRETUR.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonRETUR.setForeground(new java.awt.Color(102, 0, 0));
        buttonRETUR.setText("RETUR");
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

        butAdd.setBackground(new java.awt.Color(102, 102, 102));
        butAdd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        butAdd.setForeground(new java.awt.Color(102, 0, 0));
        butAdd.setText("ADD");
        butAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddActionPerformed(evt);
            }
        });

        butUpdate.setBackground(new java.awt.Color(102, 102, 102));
        butUpdate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        butUpdate.setForeground(new java.awt.Color(102, 0, 0));
        butUpdate.setText("UPDATE");
        butUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUpdateActionPerformed(evt);
            }
        });

        butDelete.setBackground(new java.awt.Color(102, 102, 102));
        butDelete.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        butDelete.setForeground(new java.awt.Color(102, 0, 0));
        butDelete.setText("DELETE");
        butDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23)
                                .addComponent(jLabel21)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(buttonRETUR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(butAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(butUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(butDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(408, 408, 408))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(comboBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(comboDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(spinnerJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonRETUR))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butAdd)
                    .addComponent(butUpdate)
                    .addComponent(butDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
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

    private void comboBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBarangActionPerformed
        if (comboBarang.getSelectedIndex()>-1)
        {
            model_detailbarang.removeAllElements();
            String[] text = comboBarang.getSelectedItem().toString().split("-");
            ArrayList<CDetailBarang> listdetailbarang = CDaoBarang.getAllDetailBarang(mycon, "select * from detailbarang where idbarang='" + text[0] + "'");
            for (int i = 0; i < listdetailbarang.size(); i++) {
                model_detailbarang.addElement(listdetailbarang.get(i).getIDBARANG()+listdetailbarang.get(i).getNODETAIL()+
                    "-" + listdetailbarang.get(i).getDESKRIPSI());
            }
        }
    }//GEN-LAST:event_comboBarangActionPerformed

    private void buttonRETURActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRETURActionPerformed

        if (comboBoxSupplier.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Supplier tidak boleh dikosongkan");
        } else if (CDaoReturBeli.getHitungDetail() == 0) {
            JOptionPane.showMessageDialog(null, "Isi Detail Pembelian dulu");
        } else {
            String[] sup    = comboBoxSupplier.getSelectedItem().toString().split("-");
            //String tg = dtp.getDate().getDate()+"-"+dtp.getDate().getMonth()+"-"+dtp.getDate().getYear();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //dtp.setDateFormatString("yyyy-MM-dd");
            String tg = sdf.format(dtp.getDate());
            CReturBeli ret  = new CReturBeli(labelID.getText(),sup[0],tg,"");
            CDaoReturBeli.simpanReturPembelian(ret, mycon);
            JOptionPane.showMessageDialog(null, "Data tersimpan dengan nomor retur pembelian : " + labelID.getText());
            settingButton(0);
            CDaoReturBeli.clearArray();
            clear_screen();

        }
    }//GEN-LAST:event_buttonRETURActionPerformed
    public void settingButton(int mode) {
        if (mode == 0) {
            butAdd.setEnabled(true);
            butUpdate.setEnabled(false);
            butDelete.setEnabled(false);
        } else {
            butAdd.setEnabled(false);
            butUpdate.setEnabled(true);
            butDelete.setEnabled(true);
        }
    }
    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        CDaoReturBeli.clearArray();
        clear_screen();
    }//GEN-LAST:event_buttonCancelActionPerformed
    private int getIndexBarang(String nm) {
        int temp = -1;
        for (int i = 0; i < model_barang.getSize(); i++) {
            String[] tt = model_barang.getElementAt(i).toString().split("-");
            if (tt[1].equalsIgnoreCase(nm) || tt[0].equalsIgnoreCase(nm)) {
                temp = i;
            }
        }
        return temp;
    }
    private int getIndexDetailBarang(String nm) {
        int temp = -1;
        for (int i = 0; i < model_detailbarang.getSize(); i++) {
            String[] tt = model_detailbarang.getElementAt(i).toString().split("-");
            if (tt[1].equalsIgnoreCase(nm) || tt[0].equalsIgnoreCase(nm) ) {
                temp = i;
            }
        }
        return temp;
    }
    private void tabletranMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletranMouseReleased
        idx = tabletran.getSelectedRow();
        if (idx>-1)
        {
            String nama = model_detail.getValueAt(idx, 0).toString();
            comboBarang.setSelectedIndex(getIndexBarang(nama));
            String namadetail = model_detail.getValueAt(idx, 1).toString();
            comboDetail.setSelectedIndex(getIndexDetailBarang(namadetail));
            int jum = Integer.parseInt(model_detail.getValueAt(idx, 2).toString());
            spinnerJumlah.setValue(jum);
            settingButton(1);
        }
    }//GEN-LAST:event_tabletranMouseReleased

    private void butAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddActionPerformed
        if (comboBarang.getSelectedIndex()==-1 ||  comboDetail.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(null, "Pilih barang dulu");
        }else if ((int)spinnerJumlah.getValue()<=0) {
            JOptionPane.showMessageDialog(null, "Jumlah barang tidak boleh <=0 ");
        }else{
            if (spinnerJumlah.getValue().equals("")) {
                JOptionPane.showMessageDialog(null, "Deskripsi tidak boleh dikosongkan");
            } else {
                String[] brg = comboBarang.getSelectedItem().toString().split("-");
                String[] detbrg =comboDetail.getSelectedItem().toString().split("-");
                CDetailRetur newdetretbrg = new CDetailRetur(labelID.getText(),brg[0],detbrg[0],(int)spinnerJumlah.getValue());
                CDaoReturBeli.simpanArray(newdetretbrg, mycon);
                settingButton(0);
                fill_grid(0, "");
                clear_screen_detail();
            }
        }
    }//GEN-LAST:event_butAddActionPerformed

    private void butUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUpdateActionPerformed
        if (comboBarang.getSelectedIndex()==-1) {
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh dikosongkan");
        } else if (comboDetail.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Detail Barang tidak boleh dikosongkan");
        }else if ((int)spinnerJumlah.getValue()<=0) {
            JOptionPane.showMessageDialog(null, "Jumlah barang tidak boleh <=0 ");
        }else {
            String stat     = "AKTIF";
            String[] brg    = comboBarang.getSelectedItem().toString().split("-");
            String[] detbrg = comboDetail.getSelectedItem().toString().split("-");
            int jumlah = Integer.parseInt(spinnerJumlah.getValue().toString());
            CDetailRetur newdetretbeli = new CDetailRetur(labelID.getText(),brg[0],detbrg[0],jumlah);
            CDaoReturBeli.updateArray(newdetretbeli,idx);
            settingButton(0);
            fill_grid(0, "");
            clear_screen_detail();
        }
    }//GEN-LAST:event_butUpdateActionPerformed

    private void butDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDeleteActionPerformed
        if (tabletran.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Pilih baris data yang dihapus");
        }else{
            CDaoReturBeli.removeRows(tabletran.getSelectedRow());
            settingButton(0);
            fill_grid(0, "");
            clear_screen_detail();
        }
    }//GEN-LAST:event_butDeleteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Retur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Retur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Retur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Retur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Retur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAdd;
    private javax.swing.JButton butDelete;
    private javax.swing.JButton butUpdate;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonRETUR;
    private javax.swing.JComboBox<String> comboBarang;
    private javax.swing.JComboBox<String> comboBoxSupplier;
    private javax.swing.JComboBox<String> comboDetail;
    private com.toedter.calendar.JDateChooser dtp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelID;
    private javax.swing.JSpinner spinnerJumlah;
    private javax.swing.JTable tabletran;
    // End of variables declaration//GEN-END:variables
}
