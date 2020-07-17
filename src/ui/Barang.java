package ui;

import beans.CBarang;
import beans.CDetailBarang;
import beans.CKategori;
import beans.CMerek;
import dao.CDaoBarang;
import dao.CDaoKategori;
import dao.CDaoMerek;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static ui.Login.mycon; //utk mycon agar bs connect

public class Barang extends javax.swing.JFrame {

    private DefaultTableModel model_barang = new DefaultTableModel();
    private DefaultTableModel model_detail = new DefaultTableModel();
    private DefaultComboBoxModel model_kategori = new DefaultComboBoxModel();
    private DefaultComboBoxModel model_merek = new DefaultComboBoxModel();

    public Barang() {
        initComponents();
        try {
            this.setLocationRelativeTo(null);
            mycon = new MyConnection().getConnection();
            model_barang.addColumn("ID Barang");
            model_barang.addColumn("Kategori");
            model_barang.addColumn("Merek");
            model_barang.addColumn("Nama Barang");
            model_barang.addColumn("Harga Barang");
            model_barang.addColumn("Stok");
            model_barang.addColumn("Aktif");
            model_barang.addColumn("File Gambar");
            tableBrg.setModel(model_barang);
            model_detail.addColumn("No Detail");
            model_detail.addColumn("ID Barang");
            model_detail.addColumn("Deskripsi");
            model_detail.addColumn("Stok Detail");
            tableDetailBrg.setModel(model_detail);

            isicombo();
            comboKat.setModel(model_kategori);
            comboMerek.setModel(model_merek);
            pack();
            fill_grid(0, "");
            pack();
            clear_screen();
            btnAddDetail.setEnabled(true);
            btnUpdateDetail.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void isicombo() {
        model_kategori.removeAllElements();
        model_merek.removeAllElements();
        ArrayList<CKategori> listkat = CDaoKategori.getAllKategori(mycon, "select * from kategori where status='AKTIF'");
        ArrayList<CMerek> listmerek = CDaoMerek.getAllMerek(mycon, "select * from merek where status='AKTIF'");
        for (int i = 0; i < listkat.size(); i++) {
            model_kategori.addElement(listkat.get(i).getIDKATEGORI() + "-" + listkat.get(i).getNMKATEGORI());
        }
        for (int i = 0; i < listmerek.size(); i++) {
            model_merek.addElement(listmerek.get(i).getIDMEREK() + "-" + listmerek.get(i).getNMMEREK());
        }
    }

    public void fill_grid(int mode, String addwhere) {
        ArrayList<CBarang> data = null;
        int jum = model_barang.getRowCount();
        for (int i = 0; i < jum; i++) {
            model_barang.removeRow(0);
        }
        String qry = "SELECT * FROM barang ";
        if (mode == 0) {
            qry = "SELECT * FROM barang ";
            data = CDaoBarang.getAllBarang(mycon, qry);
        } else {
            qry = "SELECT * FROM barang where idbarang LIKE '%' " + addwhere;
            data = CDaoBarang.getAllBarang(mycon, qry);
        }
        for (int i = 0; i < data.size(); i++) {
            String tempkat = CDaoKategori.getKategoriById(data.get(i).getIDKATEGORI(), mycon).getNMKATEGORI();
            String tempmerek = CDaoMerek.getMerekById(data.get(i).getIDMEREK(), mycon).getNMMEREK();
            model_barang.addRow(new Object[]{data.get(i).getIDBARANG(), tempkat, tempmerek, data.get(i).getNMBARANG(), data.get(i).getHRGJUALBARANG(), data.get(i).getSTOK(),
                data.get(i).getNMGAMBAR(), data.get(i).getSTATUS()});
        }
        tableBrg.setModel(model_barang);
    }

    public void fill_grid_detail(int mode, String addwhere) {
        ArrayList<CDetailBarang> data = null;
        int jum = model_detail.getRowCount();
        for (int i = 0; i < jum; i++) {
            model_detail.removeRow(0);
        }
        String qry = "SELECT * FROM detailbarang ";
        if (mode == 0) {
            qry = "SELECT * FROM detailbarang ";
            data = CDaoBarang.getAllDetailBarang(mycon, qry);
        } else {
            qry = "SELECT * FROM detailbarang where idbarang LIKE '%' " + addwhere;
            data = CDaoBarang.getAllDetailBarang(mycon, qry);
        }
        for (int i = 0; i < data.size(); i++) {
            model_detail.addRow(new Object[]{data.get(i).getNODETAIL(), data.get(i).getIDBARANG(), data.get(i).getDESKRIPSI(), data.get(i).getSTOK()});
        }
        tableDetailBrg.setModel(model_detail);
                    
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(labelGambar.getWidth(), labelGambar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBrg = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textNamaBrg = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        spinnerStokBrg = new javax.swing.JSpinner();
        spinnerHrgBrg = new javax.swing.JSpinner();
        btnPicture = new javax.swing.JButton();
        labelGambar = new javax.swing.JLabel();
        labelPicName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDetailBrg = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        textDescripsi = new javax.swing.JTextField();
        btnAddDetail = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelKodeBarangDetail = new javax.swing.JLabel();
        labelIDDetail = new javax.swing.JLabel();
        btnUpdateDetail = new javax.swing.JButton();
        textSearch = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboKat = new javax.swing.JComboBox<>();
        comboMerek = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        rbaktif = new javax.swing.JRadioButton();
        rbtidakaktif = new javax.swing.JRadioButton();
        rbaktif1 = new javax.swing.JRadioButton();
        rbtidakaktif1 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelStokDetail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("barang"); // NOI18N
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(167, 107, 107));

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Barang");

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
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(837, 837, 837)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(77, 82, 87));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableBrg.setAutoCreateRowSorter(true);
        tableBrg.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tableBrg.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableBrgMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableBrg);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 109, 605, 116));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Merek");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 95, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Harga");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 163, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Stok");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 199, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gambar");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 242, -1, -1));

        textNamaBrg.setBackground(new java.awt.Color(204, 204, 204));
        textNamaBrg.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPanel2.add(textNamaBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 132, 230, -1));

        buttonAdd.setBackground(new java.awt.Color(102, 102, 102));
        buttonAdd.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonAdd.setForeground(new java.awt.Color(102, 0, 0));
        buttonAdd.setText("ADD");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });
        jPanel2.add(buttonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 386, -1, 55));

        buttonEdit.setBackground(new java.awt.Color(102, 102, 102));
        buttonEdit.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonEdit.setForeground(new java.awt.Color(102, 0, 0));
        buttonEdit.setText("EDIT");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });
        jPanel2.add(buttonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 386, 98, 55));

        buttonDelete.setBackground(new java.awt.Color(102, 102, 102));
        buttonDelete.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonDelete.setForeground(new java.awt.Color(102, 0, 0));
        buttonDelete.setText("DELETE");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 386, -1, 55));
        jPanel2.add(spinnerStokBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 204, 70, -1));
        jPanel2.add(spinnerHrgBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 168, 105, -1));

        btnPicture.setBackground(new java.awt.Color(102, 102, 102));
        btnPicture.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnPicture.setForeground(new java.awt.Color(102, 0, 0));
        btnPicture.setText("Picture");
        btnPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPictureActionPerformed(evt);
            }
        });
        jPanel2.add(btnPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 244, -1, 23));

        labelGambar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelGambar.setForeground(new java.awt.Color(255, 255, 255));
        labelGambar.setText("Gambar");
        jPanel2.add(labelGambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 273, 96, 55));

        labelPicName.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelPicName.setForeground(new java.awt.Color(255, 255, 255));
        labelPicName.setText("-");
        jPanel2.add(labelPicName, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 242, 143, -1));

        tableDetailBrg.setAutoCreateRowSorter(true);
        tableDetailBrg.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 402, 605, 115));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kode Barang");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 287, -1, -1));

        textDescripsi.setBackground(new java.awt.Color(204, 204, 204));
        textDescripsi.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPanel2.add(textDescripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 323, 320, -1));

        btnAddDetail.setBackground(new java.awt.Color(102, 102, 102));
        btnAddDetail.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnAddDetail.setForeground(new java.awt.Color(102, 0, 0));
        btnAddDetail.setText("Add Detail");
        btnAddDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDetailActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 367, -1, 23));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Deskripsi Barang");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 322, -1, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Kode Detail");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 243, -1, -1));

        labelKodeBarangDetail.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelKodeBarangDetail.setForeground(new java.awt.Color(255, 255, 255));
        labelKodeBarangDetail.setText("-");
        jPanel2.add(labelKodeBarangDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 287, -1, -1));

        labelIDDetail.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelIDDetail.setForeground(new java.awt.Color(255, 255, 255));
        labelIDDetail.setText("-");
        jPanel2.add(labelIDDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 243, -1, -1));

        btnUpdateDetail.setBackground(new java.awt.Color(102, 102, 102));
        btnUpdateDetail.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnUpdateDetail.setForeground(new java.awt.Color(102, 0, 0));
        btnUpdateDetail.setText("Update Detail");
        btnUpdateDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDetailActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdateDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 367, -1, 23));

        textSearch.setBackground(new java.awt.Color(204, 204, 204));
        textSearch.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPanel2.add(textSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 43, 147, -1));

        buttonSearch.setBackground(new java.awt.Color(102, 102, 102));
        buttonSearch.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        buttonSearch.setForeground(new java.awt.Color(102, 0, 0));
        buttonSearch.setText("Search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 32, 120, -1));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Filter");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 39, -1, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nama Barang");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 131, -1, -1));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Kategori");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 59, -1, -1));

        comboKat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(comboKat, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 64, 230, -1));

        comboMerek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(comboMerek, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 100, 230, -1));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Status");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 322, -1, -1));

        buttonGroup1.add(rbaktif);
        rbaktif.setText("Aktif");
        jPanel2.add(rbaktif, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 326, -1, -1));

        buttonGroup1.add(rbtidakaktif);
        rbtidakaktif.setText("Tidak Aktif");
        jPanel2.add(rbtidakaktif, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 326, -1, -1));

        buttonGroup2.add(rbaktif1);
        rbaktif1.setText("Aktif");
        rbaktif1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbaktif1ActionPerformed(evt);
            }
        });
        jPanel2.add(rbaktif1, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 32, -1, -1));

        buttonGroup2.add(rbtidakaktif1);
        rbtidakaktif1.setText("Tidak Aktif");
        jPanel2.add(rbtidakaktif1, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 65, -1, -1));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ID Barang");
        jLabel15.setToolTipText("");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 24, -1, -1));

        labelID.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelID.setForeground(new java.awt.Color(255, 255, 255));
        labelID.setText("-");
        labelID.setToolTipText("");
        jPanel2.add(labelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 24, -1, -1));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Stok Barang");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, -1, -1));

        labelStokDetail.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        labelStokDetail.setForeground(new java.awt.Color(255, 255, 255));
        labelStokDetail.setText("0");
        jPanel2.add(labelStokDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPictureActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            labelGambar.setIcon(ResizeImage(path));
            labelPicName.setText(selectedFile.getName().toString());
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Select");
        }
    }//GEN-LAST:event_btnPictureActionPerformed

    public void clear_screen() {
        isicombo();
        comboKat.setSelectedIndex(-1);
        comboMerek.setSelectedIndex(-1);
        textNamaBrg.setText("");
        spinnerHrgBrg.setValue(0);
        spinnerStokBrg.setValue(0);
        spinnerStokBrg.setEnabled(false);
        rbaktif.setSelected(true);
        rbaktif1.setSelected(true);
        rbtidakaktif1.setSelected(false);
        textSearch.setText("");
        labelGambar.setText("Gambar");
        labelGambar.setIcon(null);
        labelPicName.setText("-");

        fill_grid(0, "");
    }

    public void clear_screen_detail() {
        labelIDDetail.setText("-");
        labelKodeBarangDetail.setText("-");
        textDescripsi.setText("-");
    }

    public void settingButton(int mode) {
        if (mode == 0) {
            buttonAdd.setEnabled(true);
            buttonEdit.setEnabled(false);
            buttonDelete.setEnabled(false);
            clear_screen();
        } else {
            buttonAdd.setEnabled(false);
            buttonEdit.setEnabled(true);
            buttonDelete.setEnabled(true);
        }
    }
    private void btnAddDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDetailActionPerformed
        if (textDescripsi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Deskripsi tidak boleh dikosongkan");
        } else {
            CDetailBarang newdetbrg = new CDetailBarang("", labelID.getText(), textDescripsi.getText(), Integer.parseInt(labelStokDetail.getText()));
            CDaoBarang.addDetailBarang(newdetbrg, mycon);
            settingButton(0);
            fill_grid(0, "");
            clear_screen_detail();
        }
    }//GEN-LAST:event_btnAddDetailActionPerformed

    private void btnUpdateDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDetailActionPerformed
        if (textDescripsi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama barang tidak boleh dikosongkan");
        }  else {
            CDetailBarang newdetbrg = new CDetailBarang(labelIDDetail.getText(), labelID.getText(), textDescripsi.getText(), Integer.parseInt(labelStokDetail.getText()));
            CDaoBarang.UpdateDetailBarang(newdetbrg, mycon);
            btnAddDetail.setEnabled(true);
            btnUpdateDetail.setEnabled(false);
            fill_grid(0, "");
            clear_screen_detail();
        }
    }//GEN-LAST:event_btnUpdateDetailActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        String wh = "";
        if (rbtidakaktif1.isSelected()) {
            wh += " and status='TIDAK AKTIF' ";
        } else {
            wh += " and status='AKTIF' ";
        }
        if (!textSearch.getText().equals("")) {
            wh += " and upper(nmbarang) like '%" + textSearch.getText().toUpperCase() + "%' ";
        }
        fill_grid(1, wh);
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        if (textNamaBrg.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh dikosongkan");
        } else if (comboKat.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Kategori tidak boleh dikosongkan");
        } else if (comboMerek.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Merek tidak boleh dikosongkan");
        } else if ((int) spinnerHrgBrg.getValue() <= 0) {
            JOptionPane.showMessageDialog(null, "Harga tidak valid");
        } else {
            String stat = "AKTIF";
            //if (rbtidakaktif.isSelected()) stat="TIDAK AKTIF";
            String spMerek[] = comboMerek.getSelectedItem().toString().split("-");
            String spKategori[] = comboKat.getSelectedItem().toString().split("-");
            CBarang newbrg = new CBarang("", spKategori[0], spMerek[0], textNamaBrg.getText(),
                    labelPicName.getText(), (int) spinnerHrgBrg.getValue(), 0, stat);
            CDaoBarang.addBarang(newbrg, mycon);
            settingButton(0);
            fill_grid(0, "");
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        if (textNamaBrg.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh dikosongkan");
        } else if (comboKat.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Kategori tidak boleh dikosongkan");
        } else if (comboMerek.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Merek tidak boleh dikosongkan");
        } else if ((int) spinnerHrgBrg.getValue() <= 0) {
            JOptionPane.showMessageDialog(null, "Harga tidak valid");
        } else {
            String stat = "AKTIF";
            String spMerek[] = comboMerek.getSelectedItem().toString().split("-");
            String spKategori[] = comboKat.getSelectedItem().toString().split("-");
            CBarang newbrg = new CBarang(labelID.getText(), spKategori[0], spMerek[0], textNamaBrg.getText(),
                    labelPicName.getText(), (int) spinnerHrgBrg.getValue(), 0, stat);
            CDaoBarang.updateBarang(newbrg, mycon);
            settingButton(0);
            fill_grid(0, "");
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        CDaoBarang.deleteBarang(labelID.getText(), mycon);
        settingButton(0);
        fill_grid(0, "");
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private int getIndexMerek(String nm) {
        int temp = -1;
        for (int i = 0; i < model_merek.getSize(); i++) {
            String[] tt = model_merek.getElementAt(i).toString().split("-");
            if (tt[1].equalsIgnoreCase(nm)) {
                temp = i;
            }
        }
        return temp;
    }

    private int getIndexKategori(String nm) {
        int temp = -1;
        for (int i = 0; i < model_kategori.getSize(); i++) {
            String[] tt = model_kategori.getElementAt(i).toString().split("-");
            if (tt[1].equalsIgnoreCase(nm)) {
                temp = i;
            }
        }
        return temp;
    }
    private void tableBrgMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBrgMouseReleased
        int idx = tableBrg.getSelectedRow();
        if (idx > -1) {
            String id = model_barang.getValueAt(idx, 0).toString();
            labelID.setText(id);
            String kat = model_barang.getValueAt(idx, 1).toString();
            comboKat.setSelectedIndex(getIndexKategori(kat));
            String merek = model_barang.getValueAt(idx, 2).toString();
            comboMerek.setSelectedIndex(getIndexMerek(merek));
            String nama = model_barang.getValueAt(idx, 3).toString();
            textNamaBrg.setText(nama);
            spinnerHrgBrg.setValue(Integer.parseInt(model_barang.getValueAt(idx, 4).toString()));
            spinnerStokBrg.setValue(Integer.parseInt(model_barang.getValueAt(idx, 5).toString()));
            labelPicName.setText(model_barang.getValueAt(idx, 6).toString());
            String path = System.getProperty("user.dir");
            labelGambar.setIcon(ResizeImage(path + "\\gambar\\" + labelPicName.getText()));
            String aktif = model_barang.getValueAt(idx, 7).toString();
            if (aktif.equals("AKTIF")) {
                rbaktif.setSelected(true);
            } else {
                rbtidakaktif.setSelected(true);
            }
            settingButton(1);
            isidetail(id);
        }
    }//GEN-LAST:event_tableBrgMouseReleased

    private void tableDetailBrgMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDetailBrgMouseReleased
        int idx = tableDetailBrg.getSelectedRow();
        if (idx > -1) {
            String nomordetail = model_detail.getValueAt(idx, 0).toString();
            labelIDDetail.setText(nomordetail);
            String kodedetail = model_detail.getValueAt(idx, 1).toString();
            labelKodeBarangDetail.setText(kodedetail);
            textDescripsi.setText(model_detail.getValueAt(idx, 2).toString());
            labelStokDetail.setText(model_detail.getValueAt(idx, 3).toString());
            btnAddDetail.setEnabled(false);
            btnUpdateDetail.setEnabled(true);
        }
    }//GEN-LAST:event_tableDetailBrgMouseReleased

    private void rbaktif1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbaktif1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbaktif1ActionPerformed

    public void isidetail(String idid) {
        fill_grid_detail(1, " and upper(idbarang) ='" + idid + "'");
    }

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
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDetail;
    private javax.swing.JButton btnPicture;
    private javax.swing.JButton btnUpdateDetail;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JComboBox<String> comboKat;
    private javax.swing.JComboBox<String> comboMerek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelGambar;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelIDDetail;
    private javax.swing.JLabel labelKodeBarangDetail;
    private javax.swing.JLabel labelPicName;
    private javax.swing.JLabel labelStokDetail;
    private javax.swing.JRadioButton rbaktif;
    private javax.swing.JRadioButton rbaktif1;
    private javax.swing.JRadioButton rbtidakaktif;
    private javax.swing.JRadioButton rbtidakaktif1;
    private javax.swing.JSpinner spinnerHrgBrg;
    private javax.swing.JSpinner spinnerStokBrg;
    private javax.swing.JTable tableBrg;
    private javax.swing.JTable tableDetailBrg;
    private javax.swing.JTextField textDescripsi;
    private javax.swing.JTextField textNamaBrg;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

}
