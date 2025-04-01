/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Account_DAO;
import DAO.Authority_DAO;
import DTO.Account_DTO;
import DTO.Authority_DTO;
import GUI.MyDialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anh
 */
public class Account_BUS {
    Account_DAO accountDAO = new Account_DAO();
    public void docListAccount() throws SQLException  {
        List<Account_DTO> listAccount = accountDAO.getAllAccountsWithRole();
    }

    // Lấy danh sách tài khoản
    public List<Account_DTO> getAllAccounts() throws SQLException {
        return accountDAO.getAllAccounts();
    }
    
    public List<Account_DTO> getAllAccountsWithRole() throws SQLException {
        return accountDAO.getAllAccountsWithRole();  
    }
    public Account_DTO getAccountByMaNV(int manv) throws SQLException {
        return accountDAO.getAccountByMaNV(manv);
    }
  
    public void loadAccountDataToTable(JTable table) {
    try {
        List<Account_DTO> accounts = getAllAccountsWithRole();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        for (Account_DTO acc : accounts) {
            model.addRow(new Object[]{
                acc.getTaiKhoanID(),
                acc.getIDNV(),
                acc.getTenNV(),
                acc.getTenDangNhap(),
                acc.getTenQuyen(),
                acc.getMatKhau()
            });
        }
    } catch (SQLException e) {
    }
}

    // Thêm tài khoản với kiểm tra dữ liệu
    public boolean addAccount(JComboBox MaNV, String tenTK, String MK, String loaiTK) throws SQLException {
        int maNV = Integer.parseInt(MaNV.getSelectedItem().toString());
        if (tenTK.trim().equals("")) {
            new MyDialog("Tên tài khoản không được để rỗng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (MK.trim().equals("")) {
            new MyDialog("Mật khẩu không được để rỗng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (loaiTK.trim().equals("")) {
            new MyDialog("Loại tài khoản không được để rỗng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (accountDAO.getAccountByMaNV(maNV)!=null){
            new MyDialog("Nhân viên đã có tài khoản!", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        Account_DTO acc = new Account_DTO();
            acc.setTaiKhoanID(generateAccountID());
            acc.setIDNV(maNV);
            acc.setTenDangNhap(tenTK);
            acc.setMatKhau(MK);
            acc.setMaQuyen(getMaQuyenByTenQuyen(loaiTK));
            if (accountDAO.addAccount(acc)) {
                new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
    }

    // Cập nhật tài khoản
    public boolean updateAccount(JComboBox MaNV, String tenTK, String MK, String loaiTK) throws SQLException {
        int maNV = Integer.parseInt(MaNV.getSelectedItem().toString());
        if (tenTK.trim().equals("")) {
            new MyDialog("Tên tài khoản không được để rỗng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (MK.trim().equals("")) {
            new MyDialog("Mật khẩu không được để rỗng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (loaiTK.trim().equals("")) {
            new MyDialog("Loại tài khoản không được để rỗng!", MyDialog.ERROR_DIALOG);
            return false;
        }
        int idtk=accountDAO.getIDTKbyIDNV(maNV);
        if (idtk==0) {
            new MyDialog("Không tìm thấy mã tài khoản!", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        Account_DTO acc = new Account_DTO();
            acc.setTaiKhoanID(idtk);
            acc.setIDNV(maNV);
            acc.setTenDangNhap(tenTK);
            acc.setMatKhau(MK);
            acc.setMaQuyen(getMaQuyenByTenQuyen(loaiTK));
            
            if (accountDAO.updateAccount(acc)) {
                new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
    }


    // Xóa tài khoản
    public boolean deleteAccount(int taiKhoanID) throws SQLException {
        if  (accountDAO.deleteAccount(taiKhoanID)){
            new MyDialog("Xóa thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
        } else {
            new MyDialog("Xóa thất bại!", MyDialog.ERROR_DIALOG);
                return false;
        }
    }
    
    public int generateAccountID() {
        return accountDAO.generateAccountID();
    }

    public int getMaQuyenByTenQuyen(String tenQuyen) throws SQLException {
        Authority_DAO authorityDAO = new Authority_DAO();
        List<Authority_DTO> authorities = authorityDAO.getAllAuthorities();
        for (Authority_DTO auth : authorities) {
            if (auth.getTenQuyen().equalsIgnoreCase(tenQuyen)) {
                return auth.getMaQuyen();
            }
        }
        throw new SQLException("❌ Không tìm thấy quyền: " + tenQuyen);
    }
    public Account_DTO login(String tenTK, String matKhau) throws SQLException {
        Account_DTO acc = accountDAO.getAccountByUsernameAndPassword(tenTK, matKhau);
        if (acc != null) {
            return acc;
        } else {
            return null;
        }
    }
    
    public int getIDTKbyIDNV(int id){
        int idtk=accountDAO.getIDTKbyIDNV(id);
        if (idtk==0) {
            new MyDialog("Không tìm thấy tk!", MyDialog.ERROR_DIALOG);
        }
        return idtk;
    }
    
    public Account_DTO authenticate(String username, String password){
        return accountDAO.authenticate(username, password);
    }
    
    public boolean updateAccountPass(int id, String mk) throws SQLException{
        if (mk==null){
            new MyDialog("Mật khẩu không được để trống!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (mk.length()>20) {
            new MyDialog("Mật khẩu vượt quá 20 kí tự!", MyDialog.ERROR_DIALOG);
            return false;
        }
        return accountDAO.updateAccountPass(id, mk);
    }
}

