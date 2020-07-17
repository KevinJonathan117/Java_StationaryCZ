
package ui;

import beans.CBarang;
import beans.CDetailBarang;
import beans.CDetailBeli;
import beans.CPembelian;
import beans.CSupplier;
import dao.CDaoBarang;
import dao.CDaoPembelian;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static ui.Login.mycon;

public class Pembelian extends javax.swing.JFrame {

    private DefaultComboBoxModel model_supplier = new DefaultComboBoxModel();
    private DefaultComboBoxModel model_barang = new DefaultComboBoxModel();
    private DefaultComboBoxModel model_detailbarang = new DefaultComboBoxModel();
    private DefaultTableModel model_detail = new DefaultTableModel();
    int idx=-1;
    public Pembelian() {
        try {
            initComponents();
            clear_screen();
            this.setLocationRelativeTo(null);
            mycon = new MyConnection().getConnection();
            model_detail.addColumn("Nama Barang");
            model_detail.addColumn("Deskripsi");
            model_detail.addColumn("Jumlah");
            model_detail.addColumn("Harga Beli");
            model_detail.addColumn("SubTotal");
            
            isicombo();
            comboBoxSupplier.setModel(model_supplier);
            comboBarang.setModel(model_barang);
            comboDetail.setModel(model_detailbarang);
            tabletran.setModel(model_detail);
            tabletran.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabletran.getColumnModel().getColumn(0).setPreferredWidth(90);
            tabletran.getColumnModel().getColumn(1).setPreferredWidth(300);
            
            pack();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        buttonCancel = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        spinnerJumlah = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        comboBarang = new javax.swing.JComboBox<>();
        comboDetail = new javax.swing.JComboBox<>();
        butDelete = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabletran = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxSupplier = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dtp = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        buttonBuy1 = new javax.swing.JButton();
        butAdd = new javax.swing.JButton();
        butUpdate = new javax.swing.JButton();
        spinnerHarga = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(168, 173, 215));

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pembelian");

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
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 836, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(77, 82, 87));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nama Barang");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        buttonCancel.setBackground(new java.awt.Color(102, 102, 102));
        buttonCancel.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonCancel.setForeground(new java.awt.Color(102, 0, 0));
        buttonCancel.setText("CANCEL");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });
        jPanel5.add(buttonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 130, -1));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Jumlah");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("RP.");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));
        jPanel5.add(spinnerJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 230, -1));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Detail Barang");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        comboBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBarangActionPerformed(evt);
            }
        });
        jPanel5.add(comboBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 152, 230, -1));

        comboDetail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDetailActionPerformed(evt);
            }
        });
        jPanel5.add(comboDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 199, 230, -1));

        butDelete.setBackground(new java.awt.Color(102, 102, 102));
        butDelete.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        butDelete.setForeground(new java.awt.Color(102, 0, 0));
        butDelete.setText("DELETE");
        butDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDeleteActionPerformed(evt);
            }
        });
        jPanel5.add(butDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 260, 130, -1));

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

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 624, 160));

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("No Pembelian");

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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtp, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))))
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

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 410, 130));

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Harga");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        labelTotal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(255, 255, 255));
        labelTotal.setText("0");
        jPanel5.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));

        jLabel27.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("TOTAL");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        buttonBuy1.setBackground(new java.awt.Color(102, 102, 102));
        buttonBuy1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonBuy1.setForeground(new java.awt.Color(102, 0, 0));
        buttonBuy1.setText("BUY");
        buttonBuy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuy1ActionPerformed(evt);
            }
        });
        jPanel5.add(buttonBuy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 130, -1));

        butAdd.setBackground(new java.awt.Color(102, 102, 102));
        butAdd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        butAdd.setForeground(new java.awt.Color(102, 0, 0));
        butAdd.setText("ADD");
        butAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddActionPerformed(evt);
            }
        });
        jPanel5.add(butAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 130, -1));

        butUpdate.setBackground(new java.awt.Color(102, 102, 102));
        butUpdate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        butUpdate.setForeground(new java.awt.Color(102, 0, 0));
        butUpdate.setText("UPDATE");
        butUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUpdateActionPerformed(evt);
            }
        });
        jPanel5.add(butUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 130, -1));
        jPanel5.add(spinnerHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 230, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        CDaoPembelian.clearArray();
        clear_screen();     
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void butDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDeleteActionPerformed
        if (tabletran.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Pilih baris data yang dihapus");
        }else{
            CDaoPembelian.removeRows(tabletran.getSelectedRow());
            settingButton(0);
            fill_grid(0, "");
            clear_screen_detail();
        }
    }//GEN-LAST:event_butDeleteActionPerformed
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
            int harga = Integer.parseInt(model_detail.getValueAt(idx, 3).toString());
            spinnerHarga.setValue(harga); 
            settingButton(1);
       }
    }//GEN-LAST:event_tabletranMouseReleased
    public void clear_screen() {
        isicombo();
        comboBoxSupplier.setSelectedIndex(-1);
        Date date = new Date();
        dtp.setDateFormatString("dd-MMMM-yyyy");
        dtp.setDate(date);
        clear_screen_detail();
        labelID.setText(CDaoPembelian.getAutoID(mycon));
        CDaoPembelian.clearArray();
        fill_grid(0, "");
    }
    public void fill_grid(int mode, String addwhere) {
        ArrayList<CDetailBarang> data = null;
        int jum = model_detail.getRowCount();
        for (int i = 0; i < jum; i++) {
            model_detail.removeRow(0);
        }

        for (int i = 0; i < CDaoPembelian.getDetail().size(); i++) {
            model_detail.addRow(new Object[]{
                CDaoPembelian.getNamaBarang(CDaoPembelian.getDetail().get(i).getIDBRG(),mycon),
                CDaoPembelian.getDescripsiDetailBarang(CDaoPembelian.getDetail().get(i).getIDBRG(), CDaoPembelian.getDetail().get(i).getNODETAIL(),mycon),
                CDaoPembelian.getDetail().get(i).getJUMLAH(),
                CDaoPembelian.getDetail().get(i).getHRGBELI(),
                CDaoPembelian.getDetail().get(i).getSubTotal()});
        }
        labelTotal.setText(CDaoPembelian.hitung_total()+"");
    }


    public void clear_screen_detail() {
        comboBarang.setSelectedIndex(-1);        
        model_detailbarang.removeAllElements();
        spinnerHarga.setValue(0);
        spinnerJumlah.setValue(0);
    }

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

    private void buttonBuy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuy1ActionPerformed
        
        if (comboBoxSupplier.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Supplier tidak boleh dikosongkan");
        } else if (CDaoPembelian.getHitungDetail() == 0) {
            JOptionPane.showMessageDialog(null, "Isi Detail Pembelian dulu");
        } else {
            String[] sup    = comboBoxSupplier.getSelectedItem().toString().split("-");
            //String tg = dtp.getDate().getDate()+"-"+dtp.getDate().getMonth()+"-"+dtp.getDate().getYear();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //dtp.setDateFormatString("yyyy-MM-dd");
            String tg = sdf.format(dtp.getDate());
            CPembelian pem  = new CPembelian(labelID.getText(),Login.KODE_USER, sup[0],tg,Integer.parseInt(labelTotal.getText()));
            CDaoPembelian.simpanPembelian(pem, mycon);
            JOptionPane.showMessageDialog(null, "Data tersimpan dengan nomor pembelian : " + labelID.getText());
            settingButton(0);
            CDaoPembelian.clearArray();
            clear_screen();
            
        }
    }//GEN-LAST:event_buttonBuy1ActionPerformed

    private void butAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddActionPerformed
        if (comboBarang.getSelectedIndex()==-1 ||  comboDetail.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(null, "Pilih barang dulu");
        }else if ((int)spinnerHarga.getValue()<=0) {
            JOptionPane.showMessageDialog(null, "Harga barang tidak boleh <=0 ");
        }else if ((int)spinnerJumlah.getValue()<=0) {
            JOptionPane.showMessageDialog(null, "Jumlah barang tidak boleh <=0 ");
        }else{
            if (spinnerJumlah.getValue().equals("")) {
                JOptionPane.showMessageDialog(null, "Deskripsi tidak boleh dikosongkan");
            } else {
                String[] brg = comboBarang.getSelectedItem().toString().split("-");
                String[] detbrg =comboDetail.getSelectedItem().toString().split("-");
                int pketemu=-1;
                for (int i = 0; i < model_detail.getRowCount(); i++) {
                    if (model_detail.getValueAt(i, 0).toString().equals(brg[1]) &&
                            model_detail.getValueAt(i, 1).toString().equals(detbrg[1])
                       )
                    {
                        pketemu=i;
                    }
                }
                if (pketemu==-1)
                {
                   int total = (int)spinnerJumlah.getValue()*(int)spinnerHarga.getValue();
                   CDetailBeli newdetbrg = new CDetailBeli(labelID.getText(),brg[0],detbrg[0],(int)spinnerJumlah.getValue(),(int)spinnerHarga.getValue());
                   CDaoPembelian.simpanArray(newdetbrg, mycon);
                }else{
                   CDaoPembelian.tambah_jumlah_beli(pketemu,(int)spinnerJumlah.getValue());
                }
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
        } else if ((int)spinnerHarga.getValue()<=0) {
            JOptionPane.showMessageDialog(null, "Harga barang tidak boleh <=0 ");
        }else if ((int)spinnerJumlah.getValue()<=0) {
            JOptionPane.showMessageDialog(null, "Jumlah barang tidak boleh <=0 ");
        }else {
            String stat     = "AKTIF";
            String[] brg    = comboBarang.getSelectedItem().toString().split("-");
            String[] detbrg = comboDetail.getSelectedItem().toString().split("-");
            int jumlah = Integer.parseInt(spinnerJumlah.getValue().toString());
            int harga  = Integer.parseInt(spinnerHarga.getValue().toString());            
            CDetailBeli newdetbeli = new CDetailBeli(labelID.getText(),brg[0],detbrg[0],jumlah,harga);
            CDaoPembelian.updateArray(newdetbeli,idx);
            settingButton(0);
            fill_grid(0, "");
            clear_screen_detail();
        }
    }//GEN-LAST:event_butUpdateActionPerformed

    private void comboDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDetailActionPerformed
        if (comboBarang.getSelectedIndex()>-1 && comboDetail.getSelectedIndex()>-1)
        {
            String[] brg    = comboBarang.getSelectedItem().toString().split("-");
            String[] detbrg = comboDetail.getSelectedItem().toString().split("-");
            int hasil = CDaoPembelian.getHargaBeliAkhir(brg[0], detbrg[0].substring(5), mycon);
            if (hasil==-1){
                spinnerHarga.setValue(0);
            }else{
                spinnerHarga.setValue(hasil);
            }
        }
    }//GEN-LAST:event_comboDetailActionPerformed


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
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAdd;
    private javax.swing.JButton butDelete;
    private javax.swing.JButton butUpdate;
    private javax.swing.JButton buttonBuy1;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JComboBox<String> comboBarang;
    private javax.swing.JComboBox<String> comboBoxSupplier;
    private javax.swing.JComboBox<String> comboDetail;
    private com.toedter.calendar.JDateChooser dtp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JSpinner spinnerHarga;
    private javax.swing.JSpinner spinnerJumlah;
    private javax.swing.JTable tabletran;
    // End of variables declaration//GEN-END:variables
}
