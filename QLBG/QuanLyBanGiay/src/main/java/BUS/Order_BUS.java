/*
 *Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Order_DAO;
import DTO.Order_DTO;
import java.util.Vector;


public class Order_BUS {
    Order_DAO dhDAO = new Order_DAO();
    
    public Vector<Order_DTO> getALLdh()
    {
        return dhDAO.getALLdh();
    }
    
    public String addDH(Order_DTO dh) {

        // Gửi xuống DAO để thêm vào DB
        if (dhDAO.addDH(dh)) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại! SDT phải điền số nguyên";
    }
    
    public int generateMaDH() {
        int lastMaNCC = dhDAO.getLastMaDH();
    return lastMaNCC + 1; // Mã mới là số lớn nhất + 1
}

    
    
    
    public String updateDH (Order_DTO dh)
    {
        if (dhDAO.editDH(dh) == 1)
        {
            return "Cập nhật thành công";
        }
        return "Cập nhật thất bại";
    }
    
    
    
    public String deleteDH (String id)
    {
        if (dhDAO.delDH(id) == 1)
        {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    public Order_DTO findbyID(String id){
        return dhDAO.findDH(id);
    }
    
}
