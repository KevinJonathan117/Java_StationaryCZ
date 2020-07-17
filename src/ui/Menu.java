
package ui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Menu extends javax.swing.JFrame {

    Supplier FormSupplier;
    Kategori FormKategori;
    Merek FormMerek;
    Member FormMember;
    Barang FormBarang;
    Penjualan FormPenjualan;
    TopUp FormTopUp;
    Pembelian FormPembelian;
    Retur FormRetur;
    Jabatan FormJabatan;
    Pegawai FormPegawai;
    Statistics FormStatistics;
    TerimaRetur FormTerimaRetur;
    public Menu() {
        initComponents();
         this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        buttonSupplier = new javax.swing.JButton();
        buttonBarang = new javax.swing.JButton();
        buttonPembelian = new javax.swing.JButton();
        buttonPenjualan = new javax.swing.JButton();
        buttonTopUp = new javax.swing.JButton();
        buttonRetur = new javax.swing.JButton();
        buttonKategori = new javax.swing.JButton();
        buttonMerek = new javax.swing.JButton();
        buttonMember = new javax.swing.JButton();
        buttonJabatan = new javax.swing.JButton();
        buttonPegawai = new javax.swing.JButton();
        buttonStatistics = new javax.swing.JButton();
        buttonTerimaRetur = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("menu"); // NOI18N
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(208, 180, 202));

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menu");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(77, 82, 87));

        buttonSupplier.setBackground(new java.awt.Color(102, 102, 102));
        buttonSupplier.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonSupplier.setForeground(new java.awt.Color(102, 0, 0));
        buttonSupplier.setText("Supplier");
        buttonSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupplierActionPerformed(evt);
            }
        });

        buttonBarang.setBackground(new java.awt.Color(102, 102, 102));
        buttonBarang.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonBarang.setForeground(new java.awt.Color(102, 0, 0));
        buttonBarang.setText("Barang");
        buttonBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarangActionPerformed(evt);
            }
        });

        buttonPembelian.setBackground(new java.awt.Color(102, 102, 102));
        buttonPembelian.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonPembelian.setForeground(new java.awt.Color(102, 0, 0));
        buttonPembelian.setText("Pembelian");
        buttonPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPembelianActionPerformed(evt);
            }
        });

        buttonPenjualan.setBackground(new java.awt.Color(102, 102, 102));
        buttonPenjualan.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonPenjualan.setForeground(new java.awt.Color(102, 0, 0));
        buttonPenjualan.setText("Penjualan");
        buttonPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPenjualanMouseClicked(evt);
            }
        });

        buttonTopUp.setBackground(new java.awt.Color(102, 102, 102));
        buttonTopUp.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonTopUp.setForeground(new java.awt.Color(102, 0, 0));
        buttonTopUp.setText("TOP-UP");
        buttonTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTopUpActionPerformed(evt);
            }
        });

        buttonRetur.setBackground(new java.awt.Color(102, 102, 102));
        buttonRetur.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonRetur.setForeground(new java.awt.Color(102, 0, 0));
        buttonRetur.setText("Retur");
        buttonRetur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonReturMouseClicked(evt);
            }
        });
        buttonRetur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturActionPerformed(evt);
            }
        });

        buttonKategori.setBackground(new java.awt.Color(102, 102, 102));
        buttonKategori.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonKategori.setForeground(new java.awt.Color(102, 0, 0));
        buttonKategori.setText("Kategori");
        buttonKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKategoriActionPerformed(evt);
            }
        });

        buttonMerek.setBackground(new java.awt.Color(102, 102, 102));
        buttonMerek.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonMerek.setForeground(new java.awt.Color(102, 0, 0));
        buttonMerek.setText("Merek");
        buttonMerek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMerekActionPerformed(evt);
            }
        });

        buttonMember.setBackground(new java.awt.Color(102, 102, 102));
        buttonMember.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonMember.setForeground(new java.awt.Color(102, 0, 0));
        buttonMember.setText("Member");
        buttonMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMemberActionPerformed(evt);
            }
        });

        buttonJabatan.setBackground(new java.awt.Color(102, 102, 102));
        buttonJabatan.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonJabatan.setForeground(new java.awt.Color(102, 0, 0));
        buttonJabatan.setText("Jabatan");
        buttonJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJabatanActionPerformed(evt);
            }
        });

        buttonPegawai.setBackground(new java.awt.Color(102, 102, 102));
        buttonPegawai.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonPegawai.setForeground(new java.awt.Color(102, 0, 0));
        buttonPegawai.setText("Pegawai");
        buttonPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPegawaiMouseClicked(evt);
            }
        });
        buttonPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPegawaiActionPerformed(evt);
            }
        });

        buttonStatistics.setBackground(new java.awt.Color(102, 102, 102));
        buttonStatistics.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonStatistics.setForeground(new java.awt.Color(102, 0, 0));
        buttonStatistics.setText("Statistics");
        buttonStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonStatisticsMouseClicked(evt);
            }
        });
        buttonStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStatisticsActionPerformed(evt);
            }
        });

        buttonTerimaRetur.setBackground(new java.awt.Color(102, 102, 102));
        buttonTerimaRetur.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonTerimaRetur.setForeground(new java.awt.Color(102, 0, 0));
        buttonTerimaRetur.setText("Terima Retur");
        buttonTerimaRetur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTerimaReturMouseClicked(evt);
            }
        });
        buttonTerimaRetur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTerimaReturActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMember, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonRetur, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonJabatan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonPegawai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonTerimaRetur, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonStatistics, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTopUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonJabatan)
                                .addGap(88, 88, 88)
                                .addComponent(buttonPembelian))
                            .addComponent(buttonTopUp)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(buttonStatistics)
                                .addGap(21, 21, 21)
                                .addComponent(buttonTerimaRetur)))
                        .addGap(29, 29, 29)
                        .addComponent(buttonPenjualan)
                        .addGap(27, 27, 27)
                        .addComponent(buttonRetur))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonMerek)
                        .addGap(26, 26, 26)
                        .addComponent(buttonKategori)
                        .addGap(21, 21, 21)
                        .addComponent(buttonBarang)
                        .addGap(29, 29, 29)
                        .addComponent(buttonSupplier)
                        .addGap(27, 27, 27)
                        .addComponent(buttonMember))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(buttonPegawai)))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void buttonSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupplierActionPerformed
        FormSupplier = new Supplier();
        FormSupplier.setVisible(true);
    }//GEN-LAST:event_buttonSupplierActionPerformed

    private void buttonMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMemberActionPerformed
        FormMember = new Member();
        FormMember.setVisible(true);
    }//GEN-LAST:event_buttonMemberActionPerformed

    private void buttonKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKategoriActionPerformed
        FormKategori = new Kategori();
        FormKategori.setVisible(true);
    }//GEN-LAST:event_buttonKategoriActionPerformed

    private void buttonMerekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMerekActionPerformed
        FormMerek = new Merek();
        FormMerek.setVisible(true);
    }//GEN-LAST:event_buttonMerekActionPerformed

    private void buttonBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarangActionPerformed
        FormBarang = new Barang();
        FormBarang.setVisible(true);
    }//GEN-LAST:event_buttonBarangActionPerformed

    private void buttonPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPembelianActionPerformed
        FormPembelian = new Pembelian();
        FormPembelian.setVisible(true);
    }//GEN-LAST:event_buttonPembelianActionPerformed

    private void buttonTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTopUpActionPerformed
    
        try {
            FormTopUp = new TopUp();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FormTopUp.setVisible(true);
    }//GEN-LAST:event_buttonTopUpActionPerformed

    private void buttonReturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonReturActionPerformed

    private void buttonJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJabatanActionPerformed
        FormJabatan  = new Jabatan();
        FormJabatan.setVisible(true);
    }//GEN-LAST:event_buttonJabatanActionPerformed

    private void buttonPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPenjualanMouseClicked
        // TODO add your handling code here:
         FormPenjualan = new Penjualan();
         FormPenjualan.setVisible(true);
    }//GEN-LAST:event_buttonPenjualanMouseClicked

    private void buttonReturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonReturMouseClicked
        // TODO add your handling code here:
        FormRetur = new Retur();
        FormRetur.setVisible(true);
    }//GEN-LAST:event_buttonReturMouseClicked

    private void buttonPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPegawaiActionPerformed
        
    }//GEN-LAST:event_buttonPegawaiActionPerformed

    private void buttonPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPegawaiMouseClicked
        FormPegawai = new Pegawai();
        FormPegawai.setVisible(true);
    }//GEN-LAST:event_buttonPegawaiMouseClicked

    private void buttonStatisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStatisticsMouseClicked
        FormStatistics = new Statistics();
        FormStatistics.setVisible(true);
    }//GEN-LAST:event_buttonStatisticsMouseClicked

    private void buttonStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStatisticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonStatisticsActionPerformed

    private void buttonTerimaReturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTerimaReturMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTerimaReturMouseClicked

    private void buttonTerimaReturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTerimaReturActionPerformed
        FormTerimaRetur = new TerimaRetur();
        FormTerimaRetur.setVisible(true);
    }//GEN-LAST:event_buttonTerimaReturActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBarang;
    private javax.swing.JButton buttonJabatan;
    private javax.swing.JButton buttonKategori;
    private javax.swing.JButton buttonMember;
    private javax.swing.JButton buttonMerek;
    private javax.swing.JButton buttonPegawai;
    private javax.swing.JButton buttonPembelian;
    private javax.swing.JButton buttonPenjualan;
    private javax.swing.JButton buttonRetur;
    private javax.swing.JButton buttonStatistics;
    private javax.swing.JButton buttonSupplier;
    private javax.swing.JButton buttonTerimaRetur;
    private javax.swing.JButton buttonTopUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
