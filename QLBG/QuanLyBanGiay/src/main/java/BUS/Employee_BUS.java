/*
 *Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Employee_DAO;
import DAO.Hierarchy_DAO;
import DTO.Employee_DTO;
import GUI.MyDialog;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;


public class Employee_BUS {
    Employee_DAO nvDAO = new Employee_DAO();
    Hierarchy_DAO hie = new Hierarchy_DAO();
    
    public Vector<Employee_DTO> getALLnv()
    {
        return nvDAO.getALLnv();
    }
    
    public String addNV(Employee_DTO nv) {

        // Gửi xuống DAO để thêm vào DB
         if (!nv.getSDT().matches("\\d{1,20}")) { // Cho phép số tối đa 20 chữ số
        return "Thêm thất bại! SDT phải là số.";
    }

    // Gửi xuống DAO để thêm vào DB
    if (nvDAO.addNV(nv)) {
        return "Thêm thành công!";
    }
    return "Thêm thất bại!";
    }
    
    public int generateMaNV() {
        int lastMaNCC = nvDAO.getLastMaNV();
    return lastMaNCC + 1; // Mã mới là số lớn nhất + 1
}

    
    
    
    public String updateNV (Employee_DTO nv)
    {
        if (nvDAO.editNV(nv) == 1)
        {
            return "Cập nhật thành công";
        }
        return "Cập nhật thất bại";
    }
    
    
    
    public String deleteNV (int id)
    {
        if (nvDAO.delNV(id) == 1)
        {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    public Employee_DTO findbyID(int id){
        return nvDAO.findNV(id);
    }
    
    public String getTenNVByMaNV(int maNV) throws SQLException {
        Employee_DTO emp = nvDAO.getEmployeeByMaNV(maNV);
        return (emp != null) ? emp.getHoTen() : null;
    }
    
    public int getMaCapBacbyID(int manv) throws SQLException {
        int id = nvDAO.getMaCapBacByID(manv);
        if (id>0) {
            return id;
        } else {
            new MyDialog("Không tìm thấy!", MyDialog.ERROR_DIALOG);
            return 0;
        }
    }
    
    public String getTenCapBac(int id) {
        return hie.getTenCapBac(id);
    }
    
    public boolean editNVV (int id, String ten, Date ngay,String gioitinh,String sdt){
        if (nvDAO.editNVV(id, ten, ngay, gioitinh, sdt)) {
             new MyDialog("Sửa thông tin nhân viên thành công!", MyDialog.SUCCESS_DIALOG);
             return true;
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
}
