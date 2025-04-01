/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.DetailGoodRecipe_BUS;
import BUS.GoodRecipe_BUS;
import BUS.Storage_BUS;
import BUS.Supplier_BUS;
import DTO.DetailGoodRecipe_DTO;
import DTO.GoodRecipe_DTO;
import DTO.Supplier_DTO;
import java.sql.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mai
 */
public class GoodRecipe extends javax.swing.JFrame {

        Supplier_BUS nccBUS = new Supplier_BUS();
        GoodRecipe_BUS pnBUS = new GoodRecipe_BUS();
        DetailGoodRecipe_BUS ctpnBUS = new DetailGoodRecipe_BUS();
        Storage_BUS khoBUS = new Storage_BUS();

    public GoodRecipe() {
        initComponents();
        cboxIDNCC();
        cboxIDPN();
        loadListPN();
        loadListCTPN();
    }

    private void cboxIDNCC()
    {
        Vector<Supplier_DTO> nccList = nccBUS.getALLncc();
        for (Supplier_DTO ncc : nccList)
        {
           cbNCC.addItem(ncc.getMaNCC());
        }
    }
    
    
     private void cboxIDPN()
    {
        Vector<GoodRecipe_DTO> pnList = pnBUS.getALLpn();
        for (GoodRecipe_DTO pn : pnList)
        {
           cbFindPN.addItem(String.valueOf(pn.getMaPN()));
           cbPN.addItem(String.valueOf(pn.getMaPN()));
           cbFindIDpn.addItem(String.valueOf(pn.getMaPN()));

        }
    }
     
//     private void cboxIDgiay()
//    {
//        Vector<GoodRecipe_DTO> pnList = pnBUS.getALLpn();
//        for (GoodRecipe_DTO pn : pnList)
//        {
//           cbFindPN.addItem(pn.getMaPN());
//           cbPN.addItem(pn.getMaPN());
//        }
//    }
     
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cbNCC = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        btnADD = new javax.swing.JButton();
        cbFindPN = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtIDgiay = new javax.swing.JTextField();
        btnAddCTPN = new javax.swing.JButton();
        cbFindIDpn = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        cbPN = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnDEL = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        btnRefCT = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cbLoai = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbHang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1020, 754));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(203, 161, 106));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(510, 754));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Phiếu nhập");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MaPN", "MaNCC", "NgayNhap"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Chọn nhà cung cấp");

        cbNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id ncc", " " }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Chọn ngày nhập");

        btnADD.setText("Tạo phiếu nhập");
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });

        cbFindPN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id pn", " " }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("ID phiếu nhập");

        txtID.setEnabled(false);

        jButton4.setText("Xem NCC");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnFind.setText("Tìm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jButton8.setText("Thoat");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(txtID)
                            .addComponent(cbNCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(54, 54, 54)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFindPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnADD)
                    .addComponent(cbFindPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(btnFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(btnRefresh))
                .addGap(85, 85, 85))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, -1));

        jPanel2.setBackground(new java.awt.Color(213, 192, 165));
        jPanel2.setPreferredSize(new java.awt.Dimension(510, 754));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Chi tiết phiếu nhập");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaPN", "MaSP", "SoLuong", "Hang", "Size", "GiaNhap", "TenSP", "PhanLoai"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("ID giày");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Số lượng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Gía nhập");

        txtIDgiay.setEditable(false);
        txtIDgiay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDgiayFocusLost(evt);
            }
        });

        btnAddCTPN.setText("Thêm");
        btnAddCTPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCTPNActionPerformed(evt);
            }
        });

        cbFindIDpn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id ", " " }));
        cbFindIDpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFindIDpnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("ID phiếu nhập");

        jButton7.setText("In phiếu");

        cbPN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MaPN" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Hang");

        btnDEL.setText("Xóa");
        btnDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Size");

        btnRefCT.setText("Refresh");
        btnRefCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefCTActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Tên sản phẩm");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Phân loại");

        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", " " }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Chọn mã PN");

        cbHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adidas", "Nike", "Puma", "Reebok", " " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtIDgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel8)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAddCTPN)
                                .addGap(196, 196, 196)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbFindIDpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(btnDEL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefCT))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtIDgiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCTPN)
                    .addComponent(cbFindIDpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefCT)
                    .addComponent(btnDEL)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 0, 580, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Supplier ncc = new Supplier();
        ncc.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        main main = new main();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        try {
        // Kiểm tra ngày có được chọn không
        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Hãy chọn ngày!");
            return;
        }

        // Kiểm tra và lấy giá trị idNCC từ combobox
        Object selectedNCC = cbNCC.getSelectedItem();
        if (selectedNCC == null || selectedNCC.toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp!");
            return;
        }
        int idNCC = Integer.parseInt(selectedNCC.toString());

        // Tạo đối tượng GoodRecipe_DTO
        GoodRecipe_DTO pn = new GoodRecipe_DTO();

        // Tạo mã PN mới
        int newMaPN = generateMaPN();
        pn.setMaPN(newMaPN);

        // Gán MaNCC vào DTO
        pn.setMaNCC(idNCC);

        // Chuyển đổi java.util.Date sang java.sql.Date
        java.util.Date utilDate = txtDate.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        pn.setNgLap(sqlDate);

        // Gọi phương thức thêm vào CSDL
        String result = pnBUS.addPN(pn);
        JOptionPane.showMessageDialog(this, result);

        // Load lại danh sách sau khi thêm
        loadListPN();
        cboxIDPN();
        
    } catch (Exception e) {
        e.printStackTrace(); // Log lỗi ra console để dễ debug
        JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnADDActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String selectedMaPN = cbFindPN.getSelectedItem().toString();
        if(selectedMaPN != null){
            searchPN(selectedMaPN);
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadListPN();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRefCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefCTActionPerformed
        loadListCTPN();
    }//GEN-LAST:event_btnRefCTActionPerformed

    private void btnAddCTPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCTPNActionPerformed
        try {
        // Kiểm tra ô nhập có bị trống không
        if (txtGiaNhap.getText().trim().isEmpty() || 
            txtIDgiay.getText().trim().isEmpty() ||
            txtSL.getText().trim().isEmpty() ||
            txtSize.getText().trim().isEmpty() ||
            txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!");
            return;
        }

        // Kiểm tra giá trị số hợp lệ
        float giaNhap;
        int soLuong, size;
        try {
            giaNhap = Float.parseFloat(txtGiaNhap.getText().trim());
            soLuong = Integer.parseInt(txtSL.getText().trim());
            size = Integer.parseInt(txtSize.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá nhập, số lượng và size phải là số hợp lệ!");
            return;
        }

        int maGiay = Integer.parseInt(txtIDgiay.getText());
        String hang = (String) cbHang.getSelectedItem();
        String loai = (String) cbLoai.getSelectedItem();
        int maPN = Integer.parseInt(cbPN.getSelectedItem().toString());

        if (hang == null || loai == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đủ thông tin từ combobox!");
            return;
        }

        // Kiểm tra giày đã tồn tại chưa
        boolean giayDaTonTai = ctpnBUS.checkExistGiay(maGiay);

        // Nếu giày chưa có, thêm mới vào bảng GIAY
        if (!giayDaTonTai) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Mã giày chưa có trong hệ thống. Bạn có muốn thêm mới không?", 
                "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            DetailGoodRecipe_DTO giay = new DetailGoodRecipe_DTO();
            giay.setMaSP(maGiay);
            giay.setTenSP(txtName.getText().trim());
            giay.setHang(hang);
            giay.setGiaNhap(giaNhap);
            giay.setSize(size);
            giay.setLoai(loai);

            String resultGiay = khoBUS.addGiay(giay);
            JOptionPane.showMessageDialog(this, resultGiay);

            if (!resultGiay.equals("Thêm thành công!")) {
                return;
            }
        }

        // Thêm vào CTPN
        DetailGoodRecipe_DTO ctpn = new DetailGoodRecipe_DTO();
        ctpn.setGiaNhap(giaNhap);
        ctpn.setHang(hang);
        ctpn.setMaSP(maGiay);
        ctpn.setSl(soLuong);
        ctpn.setSize(size);
        ctpn.setTenSP(txtName.getText().trim());
        ctpn.setLoai(loai);
        ctpn.setMaPN(maPN);

        String result = ctpnBUS.addCTPN(ctpn);
        JOptionPane.showMessageDialog(this, result);

        // Nếu thêm thành công, cập nhật kho
        if (result.equals("Thêm thành công!")) {
            khoBUS.updateKho(ctpn);
        }

        // Cập nhật danh sách
        loadListCTPN();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi thêm sản phẩm: " + e.getMessage());
    }
    }//GEN-LAST:event_btnAddCTPNActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int selectedRow = jTable2.getSelectedRow();
         if (selectedRow != -1) {
        // Lấy dữ liệu từ các cột trong hàng được chọn
        int idpn = Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString()); // Lấy MSSV từ cột thứ 1
        int idsp = Integer.parseInt(jTable2.getValueAt(selectedRow, 1).toString()); // Lấy tên từ cột thứ 2
        String sl = jTable2.getValueAt(selectedRow, 2).toString(); // Lấy điểm từ cột thứ 3
        String hang = jTable2.getValueAt(selectedRow, 3).toString(); // Lấy điểm từ cột thứ 3
        String size = jTable2.getValueAt(selectedRow, 4).toString(); // Lấy điểm từ cột thứ 3
        String gia = jTable2.getValueAt(selectedRow, 5).toString(); // Lấy điểm từ cột thứ 3
        String ten = jTable2.getValueAt(selectedRow, 6).toString(); // Lấy điểm từ cột thứ 3
        String loai = jTable2.getValueAt(selectedRow, 7).toString(); // Lấy điểm từ cột thứ 3
        cbPN.setSelectedItem(idpn);
        cbHang.setSelectedItem(hang);
        cbLoai.setSelectedItem(loai);
        

        // Hiển thị thông tin vào các JTextField
       
        txtGiaNhap.setText(gia);
        txtIDgiay.setText(String.valueOf(idsp));
        txtSize.setText(size);
        txtSL.setText(sl);
        txtName.setText(ten);
        
         }
    }//GEN-LAST:event_jTable2MouseClicked

    private void cbFindIDpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFindIDpnActionPerformed
        int selectedMaPN = Integer.parseInt(cbFindIDpn.getSelectedItem().toString()); 
        loadListByMaPN(selectedMaPN);    }//GEN-LAST:event_cbFindIDpnActionPerformed

    private void btnDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa!");
        return;
    }

    int maPN = Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString());
    int maSP = Integer.parseInt(jTable2.getValueAt(selectedRow, 1).toString());
    int soLuong = Integer.parseInt(jTable2.getValueAt(selectedRow, 2).toString());
    String hang = jTable2.getValueAt(selectedRow, 3).toString();
    int size = Integer.parseInt(jTable2.getValueAt(selectedRow, 4).toString());
    float giaNhap = Float.parseFloat(jTable2.getValueAt(selectedRow, 5).toString());
    String tenSP = jTable2.getValueAt(selectedRow, 6).toString();
    String loai = jTable2.getValueAt(selectedRow, 7).toString();

    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        if (ctpnBUS.delCTPN(maPN, maSP, hang, size, soLuong, giaNhap, tenSP, loai)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            loadListCTPN();// Hàm reload lại bảng
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
        }
    }
    }//GEN-LAST:event_btnDELActionPerformed

    private void txtIDgiayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDgiayFocusLost
        // TODO add your handling code here:
        String idSP = txtIDgiay.getText().trim();
    
    if (!idSP.isEmpty()) {
        if (ctpnBUS.checkExistGiay(Integer.parseInt(idSP))) {
            // Nếu sản phẩm đã có trong kho -> Chỉ cho phép nhập số lượng
            cbHang.setEnabled(false);
            txtGiaNhap.setEnabled(false);
            txtSize.setEnabled(false);
            txtName.setEnabled(false);
            cbLoai.setEnabled(false);

            txtSL.setEnabled(true); // Chỉ cho nhập số lượng
        } else {
            // Nếu sản phẩm chưa có trong kho -> Cho nhập tất cả thông tin
            cbHang.setEnabled(true);
            txtGiaNhap.setEnabled(true);
            txtSize.setEnabled(true);
            txtName.setEnabled(true);
            cbLoai.setEnabled(true);

            txtSL.setEnabled(true); // Nhập số lượng bình thường
        }
    }
    }//GEN-LAST:event_txtIDgiayFocusLost

    private int generateMaPN() {
        return pnBUS.generateMaPN();
    }
     
    private void searchPN(String mapn){
        int Mapn = Integer.parseInt(mapn);
        GoodRecipe_DTO pn = pnBUS.findPN(Mapn);
        if (pn !=null){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("MaNCC");
            model.addColumn("MaPN");
            model.addColumn("NgayNhap");
            model.addRow(new Object[]{pn.getMaPN(), pn.getMaNCC(), pn.getNgLap()});
            jTable1.setModel(model);
            
            txtID.setText(String.valueOf(pn.getMaPN()));
            txtDate.setDate(pn.getNgLap());
        }else{
            JOptionPane.showMessageDialog(this, "khong tim thay nha cung cap");
        }
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
            java.util.logging.Logger.getLogger(GoodRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GoodRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GoodRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GoodRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoodRecipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnAddCTPN;
    private javax.swing.JButton btnDEL;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnRefCT;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cbFindIDpn;
    private javax.swing.JComboBox<String> cbFindPN;
    private javax.swing.JComboBox<String> cbHang;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JComboBox<String> cbNCC;
    private javax.swing.JComboBox<String> cbPN;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDgiay;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables

    private void loadListPN() {
        Vector<GoodRecipe_DTO> pnList = new Vector<GoodRecipe_DTO>();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("MaPN");
        model.addColumn("MaNCC");
        model.addColumn("NgayNhap");
        
        pnList = pnBUS.getALLpn();
        for (int i = 0; i < pnList.size(); i++)
        {
            GoodRecipe_DTO pn = new GoodRecipe_DTO();
            pn = pnList.get(i);
            int idPN = pn.getMaPN();
            int idNCC = pn.getMaNCC();
            Date ngNhap = pn.getNgLap();
            Object[] row = {idPN, idNCC, ngNhap};
            model.addRow(row);
        }
        jTable1.setModel(model);
    }
    
    private void loadListCTPN() {
        Vector<DetailGoodRecipe_DTO> CtpnList = new Vector<DetailGoodRecipe_DTO>();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("MaPN");
        model.addColumn("MaSP");
        model.addColumn("SoLuong");        
        model.addColumn("Hang");
        model.addColumn("Size");
        model.addColumn("GiaNhap");
        model.addColumn("TenSP");
        model.addColumn("PhanLoai");

        
        CtpnList = ctpnBUS.getALLctpn();
        for (int i = 0; i < CtpnList.size(); i++)
        {
            //DetailGoodRecipe_DTO ctpn = new DetailGoodRecipe_DTO();
            DetailGoodRecipe_DTO ctpn = CtpnList.get(i);
            int idPN = ctpn.getMaPN();
            int idSP = ctpn.getMaSP();
            int sl = ctpn.getSl();
            String hang = ctpn.getHang();
            int size = ctpn.getSize();
            float gia = ctpn.getGiaNhap();
            String ten = ctpn.getTenSP();
            String loai = ctpn.getLoai();
            Object[] row = {idPN, idSP, sl, hang, size, gia, ten, loai};
            model.addRow(row);
        }
        jTable2.setModel(model);
    }
    
    private void loadListByMaPN(int selectedMaPN) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("MaPN");
        model.addColumn("MaSP");
        model.addColumn("SoLuong");
        model.addColumn("Hang");
        model.addColumn("Size");
        model.addColumn("GiaNhap");
        model.addColumn("TenSP");
        model.addColumn("PhanLoai");

        // Lấy danh sách chi tiết phiếu nhập từ database
        Vector<DetailGoodRecipe_DTO> CtpnList = ctpnBUS.getALLctpn(); 

        for (DetailGoodRecipe_DTO ctpn : CtpnList) {
            if (ctpn.getMaPN()==selectedMaPN) { // Lọc theo MaPN
                Object[] row = {
                    ctpn.getMaPN(), 
                    ctpn.getMaSP(), 
                    ctpn.getSl(), 
                    ctpn.getHang(), 
                    ctpn.getSize(), 
                    ctpn.getGiaNhap(), 
                    ctpn.getTenSP(), 
                    ctpn.getLoai()
                };
                model.addRow(row);
            }
        }

        jTable2.setModel(model); // Cập nhật bảng với dữ liệu mới
    }
    
}
