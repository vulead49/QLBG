/*
 *Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Employee_DAO;
import DTO.Employee_DTO;
import java.util.Vector;


public class Employee_BUS {
    Employee_DAO nvDAO = new Employee_DAO();
    
    public Vector<Employee_DAO> getALLnv()
    {
        return nvDAO.getALLnv();
    }
    
    public String addNCC(Employee_DTO nv) {

        // Gửi xuống DAO để thêm vào DB
        if (nvDAO.addNV(nv)) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại! SDT phải điền số nguyên";
    }
    
    public int generateMaNV() {
        int lastMaNCC = nvDAO.getLastMaNV();
    return lastMaNCC + 1; // Mã mới là số lớn nhất + 1
}

    
    
    
    public String updateNCC (Employee_DTO nv)
    {
        if (nvDAO.editNV(nv) == 1)
        {
            return "Cập nhật thành công";
        }
        return "Cập nhật thất bại";
    }
    
    
    
    public String deleteNV (String id)
    {
        if (nvDAO.delNV(id) == 1)
        {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    public Employee_DTO findbyID(String id){
        return nvDAO.findNV(id);
    }
    
}
