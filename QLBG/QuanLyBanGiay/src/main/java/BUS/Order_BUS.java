/*
 *Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Order_DAO;
import DTO.Order_DTO;
import java.util.Vector;


public class Order_BUS {
    Order_DAO odDAO = new Order_DAO();
    
    public Vector<Order_DTO> getALLnod()
    {
        return odDAO.getALLod();
    }
    
    public String addDH(Order_DTO dh) {

        // Gửi xuống DAO để thêm vào DB
        if (odDAO.addDH(dh)) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại! SDT phải điền số nguyên";
    }
    
    public int generateMaDH() {
        int lastMaDH = odDAO.getLastMaDH();
    return lastMaDH + 1; // Mã mới là số lớn nhất + 1
}

    
    
    
}
