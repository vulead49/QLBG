/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Storage_DAO;
import DTO.DetailGoodRecipe_DTO;
import DTO.Storage_DTO;
import java.util.Vector;

/**
 *
 * @author Mai
 */
public class Storage_BUS {
    Storage_DAO khodao = new Storage_DAO();
    DetailGoodRecipe_BUS ctpnBUS = new DetailGoodRecipe_BUS();
    
    public Vector<Storage_DTO> getALLkho(){
        return khodao.getALLkho();
    }
    
     public String addGiay(DetailGoodRecipe_DTO giay) {
        // Kiểm tra giày đã tồn tại chưa
        if (ctpnBUS.checkExistGiay(giay.getMaSP())) {
            return "Giày đã tồn tại trong kho!";
        }

        // Thêm giày mới vào kho
        boolean result = khodao.addGiay(giay);
        if (result) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

     
    public void updateKho(DetailGoodRecipe_DTO ctpn) {
        System.out.println("Gọi updateKho() cho sản phẩm: " + ctpn.getMaSP() + " - Số lượng: " + ctpn.getSl());
        khodao.updateKho(ctpn);
    }
     
    public Storage_DTO findSP (int tukhoa){
        return khodao.findSP(tukhoa);
    }
     
    public Vector<Storage_DTO> getFilteredProducts(double minPrice, double maxPrice) {
        return khodao.filterByPrice(minPrice, maxPrice);
    }
     
    public Vector<Storage_DTO> getSortedProducts(boolean ascending) {
        return khodao.sortByPrice(ascending);
    }
}
