/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.OrderDetails_DAO;
import DTO.OrderDetails_DTO;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anh
 */
public class OrderDetails_BUS {
    OrderDetails_DAO ctdhDAO = new OrderDetails_DAO();
    
    public Vector<OrderDetails_DTO> getALLctdh()
    {
        return ctdhDAO.getALLctdh();
    }
    
    public String addCTDH(OrderDetails_DTO ctdh) {

        // Gửi xuống DAO để thêm vào DB
        if (ctdhDAO.addCTDH(ctdh)) {
            return "Tạo đơn hàng thành công!";
        }
        return "Thêm thất bại!";
    }
    
    public int generateMaCTDH() {
        int lastMaCTDH = ctdhDAO.getLastMaDH();
    return lastMaCTDH + 1; // Mã mới là số lớn nhất + 1
}

     public int getSoLuongTonKho(int maSP) {
        return ctdhDAO.getSoLuongTonKho(maSP);
    }

    public void updateSoLuongTonKho(int maSP, int soLuongMoi) {
        ctdhDAO.updateSoLuongTonKho(maSP, soLuongMoi);
    }
    
    
    public String updateDH (OrderDetails_DTO dh)
    {
        if (ctdhDAO.editCTDH(dh) == 1)
        {
            return "Cập nhật thành công";
        }
        return "Cập nhật thất bại";
    }
    
    
    
    public void deleteCTDH(int maCTDH) {
    boolean deleted = ctdhDAO.deleteCTDH(maCTDH);
    if (deleted) {
       // System.out.println("Đã xóa chi tiết đơn hàng: MaDH = " + maDH + ", MaSP = " + maSP);
    } else {
    //    System.out.println("Lỗi: Không tìm thấy chi tiết đơn hàng để xóa.");
    }
}

    public List<OrderDetails_DTO> findbyID(int id){
        return ctdhDAO.findCTDH(id);
    }
    
    public void loadOrderDetailDataToTable(JTable table, int id) {
        // Xóa dữ liệu cũ
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // Lấy dữ liệu từ DAO và thêm vào bảng
        
        List<OrderDetails_DTO> OrderDetails = ctdhDAO.findCTDH(id); // Lấy danh sách lịch làm việc
        for (OrderDetails_DTO dh : OrderDetails) {
            Object[] rowData = {
                dh.getMaCTDH(),
                dh.getMaDH(),
                dh.getMaSP(),
                dh.getSoLuong(),
                dh.getGiaBan()
            };
            model.addRow(rowData);
        }
    }
    
}

