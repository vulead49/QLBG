/*
 *Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Order_DAO;
import DAO.Supplier_DAO;
import DTO.Order_DTO;
import DTO.Supplier_DTO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Order_BUS {
    Order_DAO dhDAO = new Order_DAO();
    
    public Vector<Order_DTO> getALLdh()
    {
        return dhDAO.getALLdh();
    }
    
    public String addDH(Order_DTO dh) {

        // Gửi xuống DAO để thêm vào DB
        if (dhDAO.addDH(dh)) {
            return "Tạo đơn hàng thành công!";
        }
        return "Thêm thất bại!";
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
    
    public String editDHbyCTDH (int id, float s) {
        if (dhDAO.editTotalDH(id, s) == 1){
            return "Cập nhật thành công";
        } 
         return "Cập nhật thất bại";
    }
    
    public List<Order_DTO> findOrdersWithNonCashPayment() {
        return dhDAO.findOrdersWithNonCashPayment();
    }    
    
    public void loadOrderDataToTable(JTable table) {
        // Xóa dữ liệu cũ
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // Lấy dữ liệu từ DAO và thêm vào bảng
        
        List<Order_DTO> orders = dhDAO.getALLdh();
        for (Order_DTO order : orders) {
            String formattedPrice;
                if ( order.getThanhTien() >= 1000000) {
                    formattedPrice = String.format("%,.2fTr",  order.getThanhTien() / 1000000.0); // VD: 4000000 -> 4000K
                } else {
                    formattedPrice = String.format("%,.0f",  order.getThanhTien()); // Số nhỏ thì giữ nguyên
                }
            Object[] rowData = {
                order.getMaHD(),
                order.getTenKH(),
                order.getNgayLap(),
                formattedPrice,
                order.getTrangThai()
            };
            model.addRow(rowData);
        }
    }
    
    public List<Order_DTO> findOrdersByDate(Date from, Date to) {
        return dhDAO.findOrdersByDate(from, to);
}
}
