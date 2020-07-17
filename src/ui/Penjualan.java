/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import beans.CDetailBarang;
import beans.CDetailBarangPenjualan;
import beans.CDetailJual;
import beans.CMember;
import beans.CPegawai;
import beans.CPenjualan;
import dao.CDaoBarang;
import dao.CDaoMember;
import dao.CDaoPegawai;
import dao.CDaoPenjualan;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static ui.Login.mycon;

/**
 *
 * @author Joshua
 */
public final class Penjualan extends javax.swing.JFrame {
  int total;
  private DefaultTableModel model_penjualan = new DefaultTableModel();
  private DefaultTableModel model_detail = new DefaultTableModel();
  DefaultComboBoxModel<String> combomem = new DefaultComboBoxModel<>();
  DefaultComboBoxModel<String> combopeg = new DefaultComboBoxModel<>();
  public Penjualan() {
         try {
            initComponents();
            //clear_screen_detail();
            this.setLocationRelativeTo(null);
            mycon = new MyConnection().getConnection();
            
            Date ys = new Date();
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            tgl.setText(s.format(ys));
            
             labelIDjual.setText(CDaoPenjualan.getAutoID(mycon));
            
            //Penjualan
            model_penjualan.addColumn("ID Barang");
            model_penjualan.addColumn("No Detail");
            model_penjualan.addColumn("Deskripsi Barang");
            model_penjualan.addColumn("Jumlah Beli");
            model_penjualan.addColumn("Harga Satuan");
            tabelPenjualan.setModel(model_penjualan);
            
            //Detail barang
            model_detail.addColumn("ID Barang");
            model_detail.addColumn("No Detail");
            model_detail.addColumn("Deskripsi");
            model_detail.addColumn("Stok");
            model_detail.addColumn("Harga barang");
            tableDetailBrg.setModel(model_detail);
            
      
            fillkasir();
            fillComboMember();
            pack();
            comboMember.setModel(combomem);
            comboPeg.setModel(combopeg);
           fill_grid_detail(0, "");
            
        } catch (SQLException ex) {
            Logger.getLogger(Pembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
      
        
    public void fill_grid_detail(int mode, String addwhere) {
        ArrayList<CDetailBarangPenjualan> data = null;
        int jum = model_detail.getRowCount();
        for (int i = 0; i < jum; i++) {
            model_detail.removeRow(0);
        }
        String qry;
        if (mode == 0) {
            qry = "SELECT db.nodetail,db.idbarang,db.deskripsi,db.stok,b.hrgjualbarang FROM detailbarang db JOIN barang b ON db.idbarang = b.idbarang WHERE b.status = \"AKTIF\"";
         
            data = CDaoPenjualan.getAllDetailBarang(mycon, qry);
            
        } else {
            qry =  "SELECT db.nodetail,db.idbarang,db.deskripsi,db.stok,b.hrgjualbarang FROM detailbarang db JOIN barang b ON db.idbarang = b.idbarang WHERE b.status = \"AKTIF\" AND db.idbarang LIKE '%' " + addwhere;
            data = CDaoPenjualan.getAllDetailBarang(mycon, qry);
        }
   
        for (int i = 0; i < data.size(); i++) {
            model_detail.addRow(new Object[]{data.get(i).getNODETAIL(), data.get(i).getIDBARANG(), data.get(i).getDESKRIPSI(), data.get(i).getSTOK(),data.get(i).getHARGA()});
        }

        tableDetailBrg.setModel(model_detail);
                    
    }

    public void clear_screen_detail() {  
        lblID.setText("-");
        lblDeskripsi.setText("-");
        lblHarga.setText("-");
        lblStok.setText("-");
        lbldetilbrg.setText("-");
        lblTagihan.setText("-");
        spinjumlah.setValue(0);
        tabelPenjualan.removeAll();
        fill_grid_detail(0,"");
    }

    private void fillkasir()
    {
        String qry = "SELECT * FROM pegawai ";
        ArrayList<CPegawai> allPegawai = CDaoPegawai.getAllPegawai(mycon,qry);
        for (int i = 0; i < allPegawai.size(); i++) {
            combopeg.addElement(allPegawai.get(i).getIDPEG() + "-" + allPegawai.get(i).getNMPEG());
        }
        
       
    }
    
     private void fillComboMember() {
        String qry="SELECT * FROM member ";
        ArrayList<CMember> member = CDaoMember.getAllMember(mycon,qry);
        for (int i = 0; i < member.size(); i++) {
            combomem.addElement(member.get(i).getIDMEMBER()+"-"+member.get(i).getNMMEMBER());
        }
    }
 
         
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buttonCancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDetailBrg = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        textSearch = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        lblDeskripsi = new javax.swing.JLabel();
        lbldetilbrg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPenjualan = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        lblTagihan = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        buttonAdd = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        spinjumlah = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        comboPeg = new javax.swing.JComboBox<>();
        comboMember = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblStok = new javax.swing.JLabel();
        labelIDjual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(103, 174, 156));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Penjualan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1113, 30, 30, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("x");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, 40, -1));

        jPanel2.setBackground(new java.awt.Color(77, 82, 87));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Harga");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Member");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        buttonCancel.setBackground(new java.awt.Color(102, 102, 102));
        buttonCancel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        buttonCancel.setText("CANCEL");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });
        jPanel2.add(buttonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 130, 40));

        tableDetailBrg.setAutoCreateRowSorter(true);
        tableDetailBrg.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tableDetailBrg.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDetailBrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDetailBrgMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tableDetailBrg);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 1140, 210));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Jumlah Barang Dibeli");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        tgl.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        tgl.setText("tgl hari ini : >");
        jPanel2.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, -1, -1));

        lblID.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("-");
        jPanel2.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        textSearch.setBackground(new java.awt.Color(204, 204, 204));
        textSearch.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });
        jPanel2.add(textSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 230, -1));

        buttonSearch.setBackground(new java.awt.Color(102, 102, 102));
        buttonSearch.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        buttonSearch.setForeground(new java.awt.Color(51, 51, 51));
        buttonSearch.setText("Search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, 120, -1));

        lblDeskripsi.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblDeskripsi.setForeground(new java.awt.Color(255, 255, 255));
        lblDeskripsi.setText("-");
        jPanel2.add(lblDeskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 290, -1));

        lbldetilbrg.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbldetilbrg.setForeground(new java.awt.Color(255, 255, 255));
        lbldetilbrg.setText("-");
        jPanel2.add(lbldetilbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, 80, -1));

        tabelPenjualan.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tabelPenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelPenjualan);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 1140, 140));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tagihan   :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 760, -1, -1));

        lblTagihan.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        lblTagihan.setForeground(new java.awt.Color(255, 255, 255));
        lblTagihan.setText("-");
        jPanel2.add(lblTagihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 760, -1, -1));

        lblHarga.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(255, 255, 255));
        lblHarga.setText("-");
        jPanel2.add(lblHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, 50, -1));

        buttonAdd.setBackground(new java.awt.Color(102, 102, 102));
        buttonAdd.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        buttonAdd.setText("ADD ITEM");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });
        jPanel2.add(buttonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 120, 40));

        buttonSimpan.setBackground(new java.awt.Color(102, 102, 102));
        buttonSimpan.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 750, 120, 70));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ID Detail Barang");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, -1, -1));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Deskripsi Barang");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        spinjumlah.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinjumlah.setToolTipText("");
        jPanel2.add(spinjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 100, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Stok");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, -1, -1));

        comboPeg.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        comboPeg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(comboPeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 210, -1));

        comboMember.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        comboMember.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(comboMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 210, -1));

        jLabel14.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nama Pegawai Kasir ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ID Barang");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        lblStok.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblStok.setForeground(new java.awt.Color(255, 255, 255));
        lblStok.setText("-");
        jPanel2.add(lblStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 420, 80, -1));

        labelIDjual.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        labelIDjual.setForeground(new java.awt.Color(255, 255, 255));
        labelIDjual.setText("-");
        jPanel2.add(labelIDjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
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

       
            if (model_penjualan.getRowCount() == 0) {
                total = 0;
                lblTagihan.setText("0");
            }
            else
            {
                
             model_penjualan.removeRow(model_penjualan.getRowCount() - 1);
             tabelPenjualan.setModel(model_penjualan);
             total = 0 ;
             for (int i = 0; i < model_penjualan.getRowCount(); i++) {
              String hitung = model_penjualan.getValueAt(i, 4).toString();
              String jum = model_penjualan.getValueAt(i, 3).toString();
              total +=  Integer.parseInt(hitung) * Integer.parseInt(jum);
              System.out.println(hitung);
              System.out.println(jum);
              System.out.println(total);
            }
            lblTagihan.setText(Integer.toString(total));
            }
        
        
        
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void tableDetailBrgMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDetailBrgMouseReleased
        int idx = tableDetailBrg.getSelectedRow();
        if (idx > -1) {
            String kodedetail = model_detail.getValueAt(idx, 0).toString();
            lblID.setText(kodedetail);
            lbldetilbrg.setText(model_detail.getValueAt(idx, 1).toString());
            lblDeskripsi.setText(model_detail.getValueAt(idx, 2).toString());
            lblStok.setText(model_detail.getValueAt(idx, 3).toString());
            lblHarga.setText(model_detail.getValueAt(idx, 4).toString());
        }
    }//GEN-LAST:event_tableDetailBrgMouseReleased

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        String wh = "";
        if (!textSearch.getText().equals("")) {
            wh += " and deskripsi like '%" + textSearch.getText().toUpperCase() + "%' ";
            
        }
       fill_grid_detail(1, wh);
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
        Boolean a = false;
        for (int i = 0; i < model_penjualan.getRowCount(); i++) {
            String kodedetail = model_penjualan.getValueAt(i, 0).toString();
            int jum = (Integer)model_penjualan.getValueAt(i, 3);
             if (kodedetail == lblID.getText())
             {
                 jum += (Integer)spinjumlah.getValue();
                 model_penjualan.setValueAt(jum, i, 3);
                 a=true;
             }
                     
        }
        
        if (!a) {
              model_penjualan.addRow(new Object[]{lblID.getText(),lbldetilbrg.getText(),lblDeskripsi.getText(),spinjumlah.getValue(),lblHarga.getText()});
        }
        int hitung = Integer.parseInt(lblHarga.getText());
        int jum = (Integer)spinjumlah.getValue();
        total += hitung * jum;
        lblTagihan.setText(Integer.toString(total));
      
        
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        int idx = tabelPenjualan.getRowCount();
        
        //penjualan
        String members = comboMember.getSelectedItem().toString();
        String mem = members.substring(0, 5);
        String pegawai = comboPeg.getSelectedItem().toString();
        String peg = pegawai.substring(0, 5);
       
     if (idx > 0) {
         
         for (int i = 0; i < idx; i++) {
            String kodedetail = String.valueOf(model_penjualan.getValueAt(i, 0));// model_penjualan.getValueAt(i, 0).toString();
            String nodet = String.valueOf(model_penjualan.getValueAt(i, 1));// model_penjualan.getValueAt(i, 1).toString();
            int no = Integer.parseInt(nodet);
            String jumlah = model_penjualan.getValueAt(i, 3).toString();
            int jum = Integer.parseInt(jumlah);
            String harga = model_penjualan.getValueAt(i, 4).toString();
            int har = Integer.parseInt(harga);
            
            
            CPenjualan newjual = new CPenjualan(labelIDjual.getText(),mem,peg,tgl.getText(),0,Integer.parseInt(lblTagihan.getText()));
             try {      
                 CDaoPenjualan.addPenjualan(newjual, mycon);
             } catch (ParseException ex) {
                 Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
             }
            System.out.println("okay");
            
       
               
            CDetailJual newdetjual = new CDetailJual(labelIDjual.getText(),kodedetail,no,jum,har);
            CDaoPenjualan.addDetailPenjualan(newdetjual, mycon);       
  
         }
     
                   
            clear_screen_detail();
        }
       
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox<String> comboMember;
    private javax.swing.JComboBox<String> comboPeg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelIDjual;
    private javax.swing.JLabel lblDeskripsi;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblStok;
    private javax.swing.JLabel lblTagihan;
    private javax.swing.JLabel lbldetilbrg;
    private javax.swing.JSpinner spinjumlah;
    private javax.swing.JTable tabelPenjualan;
    private javax.swing.JTable tableDetailBrg;
    private javax.swing.JTextField textSearch;
    private javax.swing.JLabel tgl;
    // End of variables declaration//GEN-END:variables
}
