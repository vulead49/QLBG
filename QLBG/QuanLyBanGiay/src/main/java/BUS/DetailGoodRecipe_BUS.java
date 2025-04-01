/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DetailGoodRecipe_DAO;
import DAO.GoodRecipe_DAO;
import DAO.Storage_DAO;
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
    Storage_DAO khoDao = new Storage_DAO();
    
    public Vector<DetailGoodRecipe_DTO> getALLctpn()
    {
        return ctpnDao.getALLCTpn();
    }
    
    
    public boolean checkExistGiay(int maGiay) {
        return ctpnDao.checkExistGiay(maGiay); // Gọi DAO để kiểm tra DB
    }
    
    public String addCTPN(DetailGoodRecipe_DTO ctpn) {
        boolean result = ctpnDao.addCTPN(ctpn);
        if (result) {
            return "Thêm thành công!";
        } else {
            System.out.println("Lỗi khi thêm CTPN: " + ctpn.getMaSP());
            return "Thêm thất bại";
        }
    }
    
    public boolean delCTPN(int maPN, int maSP, String hang, int size, int soLuong, float giaNhap, String tenSP, String loai) {
        return ctpnDao.deleteCTPN(maPN, maSP, hang, size, soLuong, giaNhap, tenSP, loai);
    }
    
    public GoodRecipe_DTO findPN (int id){
        return ctpnDao.findPN(id);
    } 
}
