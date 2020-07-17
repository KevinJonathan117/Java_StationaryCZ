
package ui;

import beans.CJabatan;
import beans.CPegawai;
import dao.CDaoJabatan;
import dao.CDaoPegawai;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static ui.Login.mycon;


public class Pegawai extends javax.swing.JFrame {

  DefaultComboBoxModel<String> jbtnpeg = new DefaultComboBoxModel<>();
  private DefaultTableModel model_peg = new DefaultTableModel();
  
  String jab;
  
    public Pegawai() {
            
            initComponents();
            fillComboJbtan();
            model_peg.addColumn("ID Pegawai");
            model_peg.addColumn("ID Jabatan");
            model_peg.addColumn("Nama Pegawai");
            model_peg.addColumn("Username");
            //password sbaiknya tdk ada di tabel
            model_peg.addColumn("Status");
            tablePegawai.setModel(model_peg);
            pack();
            clear_screen(); 
            fill_grid(0,"");
            comboBoxJabatan.setModel(jbtnpeg);
            
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        texNamatPegawai = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePegawai = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        labelID = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rbaktif = new javax.swing.JRadioButton();
        rbtidakaktif = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        rbaktif1 = new javax.swing.JRadioButton();
        rbtidakaktif1 = new javax.swing.JRadioButton();
        buttonSearch = new javax.swing.JButton();
        textSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboBoxJabatan = new javax.swing.JComboBox<>();
        textUsername = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        textConfirmPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(77, 82, 87));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nama");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Jabatan");

        texNamatPegawai.setBackground(new java.awt.Color(204, 204, 204));
        texNamatPegawai.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        tablePegawai.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tablePegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablePegawaiMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablePegawai);

        buttonAdd.setBackground(new java.awt.Color(102, 102, 102));
        buttonAdd.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonAdd.setForeground(new java.awt.Color(102, 0, 0));
        buttonAdd.setText("ADD");
        buttonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddMouseClicked(evt);
            }
        });
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonEdit.setBackground(new java.awt.Color(102, 102, 102));
        buttonEdit.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonEdit.setForeground(new java.awt.Color(102, 0, 0));
        buttonEdit.setText("EDIT");
        buttonEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEditMouseClicked(evt);
            }
        });
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonDelete.setBackground(new java.awt.Color(102, 102, 102));
        buttonDelete.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonDelete.setForeground(new java.awt.Color(102, 0, 0));
        buttonDelete.setText("DELETE");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        labelID.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelID.setForeground(new java.awt.Color(255, 255, 255));
        labelID.setText("-");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");

        rbaktif.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rbaktif);
        rbaktif.setForeground(new java.awt.Color(255, 255, 255));
        rbaktif.setText("Aktif");

        rbtidakaktif.setBackground(new java.awt.Color(77, 82, 87));
        buttonGroup1.add(rbtidakaktif);
        rbtidakaktif.setForeground(new java.awt.Color(255, 255, 255));
        rbtidakaktif.setText("Tidak Aktif");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Filter");

        rbaktif1.setBackground(new java.awt.Color(77, 82, 87));
        buttonGroup2.add(rbaktif1);
        rbaktif1.setForeground(new java.awt.Color(255, 255, 255));
        rbaktif1.setText("Aktif");

        rbtidakaktif1.setBackground(new java.awt.Color(77, 82, 87));
        buttonGroup2.add(rbtidakaktif1);
        rbtidakaktif1.setForeground(new java.awt.Color(255, 255, 255));
        rbtidakaktif1.setText("Tidak Aktif");

        buttonSearch.setBackground(new java.awt.Color(102, 102, 102));
        buttonSearch.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonSearch.setForeground(new java.awt.Color(102, 0, 0));
        buttonSearch.setText("Search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        textSearch.setBackground(new java.awt.Color(204, 204, 204));
        textSearch.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Username");

        comboBoxJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxJabatanActionPerformed(evt);
            }
        });

        textUsername.setBackground(new java.awt.Color(204, 204, 204));
        textUsername.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        textUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUsernameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Password");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Confirm Password");

        textPassword.setBackground(new java.awt.Color(204, 204, 204));
        textPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPasswordActionPerformed(evt);
            }
        });

        textConfirmPassword.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(buttonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonDelete))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelID)
                                    .addComponent(texNamatPegawai)
                                    .addComponent(comboBoxJabatan, 0, 221, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(textPassword)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(rbaktif)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rbtidakaktif))
                                            .addComponent(textConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(168, 168, 168)))))
                        .addGap(45, 45, 45)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(69, 69, 69)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtidakaktif1)
                            .addComponent(rbaktif1))
                        .addGap(32, 32, 32)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(labelID)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(texNamatPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rbaktif1)
                                .addGap(10, 10, 10)
                                .addComponent(rbtidakaktif1))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(comboBoxJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(textConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbaktif)
                            .addComponent(rbtidakaktif)
                            .addComponent(jLabel8))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        jPanel1.setBackground(new java.awt.Color(229, 196, 162));

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pegawai");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePegawaiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePegawaiMouseReleased
       int idx = tablePegawai.getSelectedRow();
       if (idx>-1)
       {
            String id = model_peg.getValueAt(idx, 0).toString();
            labelID.setText(id);
            String jabs = model_peg.getValueAt(idx, 1).toString();
            if (jabs == "J3") {
                comboBoxJabatan.setSelectedIndex(0);
            }
            else
            {      
                comboBoxJabatan.setSelectedIndex(1);
            }
            
            
         
            String nama = model_peg.getValueAt(idx, 2).toString();
            texNamatPegawai.setText(nama);       
            String us = model_peg.getValueAt(idx, 3).toString();
            textUsername.setText(us+"");   
            String qry="SELECT * FROM pegawai ";
        ArrayList<CPegawai> allPegawai = CDaoPegawai.getAllPegawai(mycon,qry);
        int pos = -1;
        for (int i = 0; i < allPegawai.size(); i++) {
            if (allPegawai.get(i).getIDPEG().equals(labelID.getText()))
            {
                String a = allPegawai.get(i).getPASSWORD();
                textPassword.setText(a);          
            }
        }
            String aktif = model_peg.getValueAt(idx, 4).toString();

            
            
            if (aktif.equals("AKTIF")){
                rbaktif.setSelected(true);
            }else{
                rbtidakaktif.setSelected(true);
            }
       }
    }//GEN-LAST:event_tablePegawaiMouseReleased

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        String stat = "AKTIF";
        if (rbtidakaktif.isSelected()) stat="TIDAK AKTIF";
        if(textPassword.getText().equals(textConfirmPassword.getText()))
        {
            CPegawai newPeg = new CPegawai("",jab ,texNamatPegawai.getText(),textUsername.getText(),textPassword.getText(),stat);      
            CDaoPegawai.addPegawai(newPeg, mycon);
            fill_grid(0,"");
            clear_screen(); 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "The Password is different");
        }
        
        
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        String stat = "AKTIF";
        if (rbtidakaktif.isSelected() == true ) stat="TIDAK AKTIF";
         if(textPassword.getText().equals(textConfirmPassword.getText()))
        {
        CPegawai newPeg = new CPegawai(labelID.getText(),jab ,texNamatPegawai.getText(),textUsername.getText(),textPassword.getText(), stat);      
        CDaoPegawai.updatePegawai(newPeg, mycon);
        fill_grid(0,"");
         clear_screen(); 
        }
        else
        {
           JOptionPane.showMessageDialog(null, "The Password is different");
        }
        
       
        
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
       CDaoPegawai.deletePegawai(labelID.getText(), mycon);
        fill_grid(0,"");
        labelID.setText("");
        clear_screen(); 
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        String wh = "";
        if (rbtidakaktif1.isSelected()){
            wh += " and status = 'TIDAK AKTIF' ";
        }else{
            wh += " and status = 'AKTIF' ";
        }
        if (!textSearch.getText().equals(""))
        {
            wh+= "and nmpeg like  '%" + textSearch.getText() + "%' ";
        }
    
        fill_grid(1,wh);
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void textUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUsernameActionPerformed
       
    }//GEN-LAST:event_textUsernameActionPerformed

    private void textPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordActionPerformed
        
    }//GEN-LAST:event_textPasswordActionPerformed

    private void buttonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseClicked

    }//GEN-LAST:event_buttonAddMouseClicked

    private void comboBoxJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxJabatanActionPerformed
        String jabat = comboBoxJabatan.getSelectedItem().toString();
        jab = jabat.substring(0, 2);
    }//GEN-LAST:event_comboBoxJabatanActionPerformed

    private void buttonEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEditMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonEditMouseClicked

    
     private void fillComboJbtan() {
        ArrayList<CJabatan> allJbatan = CDaoJabatan.getJabatan(mycon);
        int pos = -1;
        for (int i = 0; i < allJbatan.size(); i++) {
            jbtnpeg.addElement(allJbatan.get(i).getIDJABATAN()+"-"+allJbatan.get(i).getNMJABATAN());
        }
    }
    public void clear_screen(){
        texNamatPegawai.setText(""); textUsername.setText("");
        textPassword.setText(""); textConfirmPassword.setText("");
        comboBoxJabatan.setSelectedIndex(0);
        labelID.setText("-");
        rbaktif.setSelected(true);
        rbaktif1.setSelected(true);
        textSearch.setText("");
        fill_grid(0, "");
    }
    
    public void fill_grid(int mode,String addwhere)
    {
        ArrayList<CPegawai>data=null;
        int jum = model_peg.getRowCount();
        for (int i = 0; i < jum; i++) {
            model_peg.removeRow(0);
        }
        String qry="SELECT * FROM pegawai ";
        if (mode == 0)
        {
            qry="SELECT * FROM pegawai ";
            data = CDaoPegawai.getAllPegawai(mycon,qry);
        }else
        {
            qry= "SELECT * FROM pegawai where idpeg LIKE '%' " + addwhere;
            data = CDaoPegawai.getAllPegawai(mycon,qry);
        }
        for(int i = 0 ; i<data.size(); i++){
            model_peg.addRow(new Object[]{data.get(i).getIDPEG(), data.get(i).getIDJABATAN(),data.get(i).getNMPEG(),data.get(i).getUSERNAME(),
                data.get(i).getSTATUS()});
        }
        tablePegawai.setModel(model_peg);
    }
    
    
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
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pegawai().setVisible(true);
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
    private javax.swing.JComboBox<String> comboBoxJabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelID;
    private javax.swing.JRadioButton rbaktif;
    private javax.swing.JRadioButton rbaktif1;
    private javax.swing.JRadioButton rbtidakaktif;
    private javax.swing.JRadioButton rbtidakaktif1;
    private javax.swing.JTable tablePegawai;
    private javax.swing.JTextField texNamatPegawai;
    private javax.swing.JPasswordField textConfirmPassword;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textSearch;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}
