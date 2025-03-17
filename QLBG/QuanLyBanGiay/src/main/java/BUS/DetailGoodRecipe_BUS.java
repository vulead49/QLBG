/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DetailGoodRecipe_DAO;
import DAO.GoodRecipe_DAO;
import DTO.DetailGoodRecipe_DTO;
import DTO.GoodRecipe_DTO;
import DTO.Supplier_DTO;
import java.util.Vector;

/**
 *
 * @author Mai
 */
public class DetailGoodRecipe_BUS {
    DetailGoodRecipe_DAO ctpnDao  = new DetailGoodRecipe_DAO();
    
    public Vector<DetailGoodRecipe_DTO> getALLctpn()
    {
        return ctpnDao.getALLCTpn();
    }
    
    
    public boolean checkExistGiay(String maGiay) {
    return ctpnDao.checkExistGiay(maGiay); // Gọi DAO để kiểm tra DB
}
    
    public String addCTPN(DetailGoodRecipe_DTO ctpn) {

        // Gửi xuống DAO để thêm vào DB
        if (ctpnDao.addCTPN(ctpn)) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại! SDT phải điền số nguyên";
    }
    
    
    
    public String updateCTPN (DetailGoodRecipe_DTO ctpn)
    {
        if (ctpnDao.editCTPN(ctpn) == 1)
        {
            return "Cập nhật thành công";
        }
        return "Cập nhật thất bại";
    }
    
    
    
    public String deleteCTPN(String maPN, String maSP, String hang, int size, int soLuong, float giaNhap, String tenSP, String phanLoai) {
        if (maPN.isEmpty() || maSP.isEmpty()) {
            return "Mã phiếu nhập và mã giày không được để trống!";
        }

        boolean isDeleted = ctpnDao.deleteCTPN(maPN, maSP, hang, size, soLuong, giaNhap, tenSP, phanLoai);
        if (isDeleted) {
            return "Xóa thành công chi tiết phiếu nhập!";
        } else {
            return "Xóa thất bại! Không tìm thấy bản ghi phù hợp.";
        }
    }
    

    public GoodRecipe_DTO findPN (String id)
    {
        return ctpnDao.findPN(id);
    }
    
    
}
