/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.DayOff_BUS;
import BUS.Employee_BUS;
import BUS.Payroll_BUS;
import BUS.Schedule_BUS;
import DAO.Hierarchy_DAO;
import DTO.Employee_DTO;
import DTO.Hierarchy_DTO;
import DTO.Schedule_DTO;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mai
 */
public class Schedule extends javax.swing.JFrame {
    Schedule_BUS scheduleBUS = new Schedule_BUS();
    Employee_BUS emp = new Employee_BUS();
    Payroll_BUS pay =new Payroll_BUS();
    Hierarchy_DAO hie = new Hierarchy_DAO();
    DayOff_BUS day = new DayOff_BUS();
    /**
     * Creates new form Schedule
     */
    public Schedule() {
        initComponents();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSchedule = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        Accept = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ID = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DateStart = new javax.swing.JTextField();
        DateEnd = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        Exit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Tennv = new javax.swing.JTextField();
        Reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 179, 113));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 516));

        jTableSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MaNV", "TenNV", "Ngay", "GioBatDau", "GioKetThuc", "DuyetCong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableScheduleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSchedule);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Lịch Làm");

        add.setText("Thêm");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        Edit.setText("Sửa");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Delete.setText("Xóa");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Search.setText("Xem");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Accept.setText("Duyệt công");
        Accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Ngày: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Mã nhân viên: ");

        ID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Thời gian từ: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Đến:");

        Exit.setText("Thoát");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tên nhân viên: ");

        Reset.setText("Làm mới");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tennv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Accept)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Exit)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(add)
                                .addComponent(Delete)
                                .addComponent(Edit)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Reset)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(DateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Accept)
                    .addComponent(jLabel7)
                    .addComponent(Tennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Search))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add)
                            .addComponent(Reset))
                        .addGap(18, 18, 18)
                        .addComponent(Edit)
                        .addGap(18, 18, 18)
                        .addComponent(Delete)
                        .addGap(18, 18, 18)
                        .addComponent(Exit)
                        .addGap(0, 79, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        Staff st = new Staff();
        st.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void jTableScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableScheduleMouseClicked
        // TODO add your handling code here:
        xuLyClickTblSchedule();
    }//GEN-LAST:event_jTableScheduleMouseClicked

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
        if (ID.getSelectedItem() != null) {
            int manv = Integer.parseInt(ID.getSelectedItem().toString());
                String tenNv = scheduleBUS.getTenNV(manv);
                DateStart.setText("");
                DateEnd.setText("");
                
                Tennv.setText(tenNv);
        }   
    }//GEN-LAST:event_IDActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            // TODO add your handling code here:
            xuLyThemLichLam();
        } catch (SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        int row = jTableSchedule.getSelectedRow();
        if (row == -1) {
            new MyDialog("Vui lòng chọn một lịch làm!", MyDialog.ERROR_DIALOG);
            return;
        }
        String ma =jTableSchedule.getValueAt(row,0).toString();
        int id = Integer.parseInt(ma);
        try {
            scheduleBUS.deleteSchedule(id);
        } catch (SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadData();
    }//GEN-LAST:event_DeleteActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        try {
            // TODO add your handling code here:
            xuLySuaLichLam();
        } catch (SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadData();
    }//GEN-LAST:event_EditActionPerformed

    private void AcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            xulyDuyetCong();
        } catch (SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AcceptActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        try {
            // TODO add your handling code here:
            loadDataByDate();
        } catch (SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_ResetActionPerformed

    private void loadData(){
        loadComboBoxData();
        try {
            scheduleBUS.getAllSchedules();
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        scheduleBUS.loadScheduleDataToTable(jTableSchedule);
        Tennv.setEditable(false);
    }
    
    private void loadDataByDate() throws SQLException{       
        
        if (jDateChooser2.getDate() == null) {
            new MyDialog("Vui lòng chọn ngày!", MyDialog.ERROR_DIALOG);
                return;
        }
        Date selectedDate = new Date(jDateChooser2.getDate().getTime());  
        scheduleBUS.loadScheduleDataToTableByDate(jTableSchedule,selectedDate);
    }
    private void xuLyClickTblSchedule(){
            int row = jTableSchedule.getSelectedRow();
            if(row > -1){
                String ma =jTableSchedule.getValueAt(row,0)+"";
                String maNV =jTableSchedule.getValueAt(row,1).toString();
                String tenNV =jTableSchedule.getValueAt(row,2)+"";
                String ngay =jTableSchedule.getValueAt(row,3).toString()+"";
                String giobd =jTableSchedule.getValueAt(row,4)+"";
                String giokt =jTableSchedule.getValueAt(row,5)+"";
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = dateFormat.parse(ngay); // Chuyển đổi chuỗi thành Date
                    jDateChooser1.setDate(date); // Đặt giá trị vào JDateChooser
                } catch (ParseException e) {
                    e.printStackTrace(); // Xử lý ngoại lệ nếu có lỗi trong việc chuyển đổi
                }
                Tennv.setText(tenNV);
                ID.setSelectedItem(maNV);
                DateStart.setText(giobd);
                DateEnd.setText(giokt);
            }
    }
    private void loadComboBoxData() {
        ActionListener[] listeners = ID.getActionListeners();
        for (ActionListener listener : listeners) {
            ID.removeActionListener(listener);
        }
        ID.removeAllItems();
        List<Employee_DTO> nhanVienList = emp.getALLnv();
        for (Employee_DTO nv : nhanVienList) {
            ID.addItem(String.valueOf(nv.getMaNV()));
        }
        for (ActionListener listener : listeners) {
            ID.addActionListener(listener);
        }
    }
    
    private void xuLyThemLichLam() throws SQLException{
        int id=  Integer.parseInt(ID.getSelectedItem().toString());
        java.sql.Date sqlDate = new java.sql.Date(jDateChooser1.getDate().getTime());
        if (day.isKeyExists(id, sqlDate)) {
            return;
        }        
        scheduleBUS.addSchedule(
                ID.getSelectedItem().toString(),
                jDateChooser1.getDate(),
                DateStart.getText(),
                DateEnd.getText()
                );
        loadData();
    }
    
   private void xuLySuaLichLam() throws SQLException{
       int row = jTableSchedule.getSelectedRow();
       // Kiểm tra nếu không có hàng nào được chọn
        if (row == -1) {
            new MyDialog("Vui lòng chọn một lịch làm!", MyDialog.ERROR_DIALOG);
            return;
        }
       String ma =jTableSchedule.getValueAt(row,0).toString();
       Boolean duyet = (Boolean) jTableSchedule.getValueAt(row,6);
       int stt= Integer.parseInt(ma);
        scheduleBUS.updateSchedule(
                stt,
                ID.getSelectedItem().toString(),
                jDateChooser1.getDate(),
                DateStart.getText(),
                DateEnd.getText(),
                duyet
                );
        loadData();
    }
     private void xulyDuyetCong()throws SQLException{
        int row = jTableSchedule.getSelectedRow();
        if (row == -1) {
            new MyDialog("Vui lòng chọn một lịch làm!", MyDialog.ERROR_DIALOG);
            return;
        }
        Boolean duyet = (Boolean) jTableSchedule.getValueAt(row,6);
        if (duyet == true) {
            new MyDialog("Lịch làm đã được duyệt!", MyDialog.ERROR_DIALOG);
            return;
        }
        String ma =jTableSchedule.getValueAt(row,0).toString();
        int stt= Integer.parseInt(ma);
        scheduleBUS.check(stt);
        generatePayroll();
        loadData();
     }
     private void generatePayroll() throws SQLException {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(jDateChooser1.getDate());
            int month = calendar.get(Calendar.MONTH) + 1; // Tháng trong Java bắt đầu từ 0
            int year = calendar.get(Calendar.YEAR);
            int employeeId =Integer.parseInt(ID.getSelectedItem().toString()) ;
            if (pay.checkPayrollExists(employeeId, month, year)) {
                updatePayrollBySchedule(employeeId, month, year);
                return ;
            }
            // Giả sử bạn có danh sách schedule và hierarchy
            List<Schedule_DTO> scheduleList = scheduleBUS.fetchScheduleForEmployee(employeeId, month, year);
            if (scheduleList==null) return;
            List<Hierarchy_DTO> hierarchyList = hie.fetchHierarchyData();
            if (hierarchyList==null) return;
            // Tính toán bảng lương
            pay.calculateSalaryBasedOnRank(scheduleList, hierarchyList, employeeId, month, year);
        } catch (NumberFormatException ex) {
            new MyDialog("Vui lòng nhập tháng và năm hợp lệ!", MyDialog.ERROR_DIALOG);
        } 
//        catch (SQLException ex) {
//            new MyDialog("Lỗi cơ sở dữ liệu!", MyDialog.ERROR_DIALOG);
//        }
    }
     
     private void updatePayrollBySchedule(int employeeId,int month,int year) throws SQLException{
         try {
            // Giả sử bạn có danh sách schedule và hierarchy
            List<Schedule_DTO> scheduleList = scheduleBUS.fetchScheduleForEmployee(employeeId, month, year);
            if (scheduleList==null) return;
            List<Hierarchy_DTO> hierarchyList = hie.fetchHierarchyData();
            if (hierarchyList==null) return;
            // Tính toán bảng lương
            pay.updatePayrollBySchedule(scheduleList, hierarchyList, employeeId, month, year);
        } catch (NumberFormatException ex) {
            new MyDialog("Vui lòng nhập tháng và năm hợp lệ!", MyDialog.ERROR_DIALOG);
        } 
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
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accept;
    private javax.swing.JTextField DateEnd;
    private javax.swing.JTextField DateStart;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Exit;
    private javax.swing.JComboBox<String> ID;
    private javax.swing.JButton Reset;
    private javax.swing.JButton Search;
    private javax.swing.JTextField Tennv;
    private javax.swing.JButton add;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSchedule;
    // End of variables declaration//GEN-END:variables
}
