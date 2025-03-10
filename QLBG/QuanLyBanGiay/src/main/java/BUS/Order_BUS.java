/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Supplier_DAO;
import DTO.Supplier_DTO;
import java.util.Vector;


public class Order_BUS {
    Supplier_DAO nccDAO = new Supplier_DAO();
    
    public Vector<Supplier_DTO> getALLncc()
    {
        return nccDAO.getALLncc();
    }
    
    public String addNCC(Supplier_DTO ncc) {

        // Gửi xuống DAO để thêm vào DB
        if (nccDAO.addNCC(ncc)) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại! SDT phải điền số nguyên";
    }
    
    public int generateMaNCC() {
        int lastMaNCC = nccDAO.getLastMaNCC();
    return lastMaNCC + 1; // Mã mới là số lớn nhất + 1
}

    
    
    
    public String updateNCC (Supplier_DTO ncc)
    {
        if (nccDAO.editNCC(ncc) == 1)
        {
            return "Cập nhật thành công";
        }
        return "Cập nhật thất bại";
    }
    
    
    
    public String deleteNCC (String id)
    {
        if (nccDAO.delNCC(id) == 1)
        {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    public Supplier_DTO findbyID(String id){
        return nccDAO.findNCC(id);
    }
    
}
