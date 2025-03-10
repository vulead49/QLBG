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
    
    
    
    public String deleteCTPN (String id)
    {
        if (ctpnDao.delCTPN(id) == 1)
        {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    public GoodRecipe_DTO findPN (String id)
    {
        return ctpnDao.findPN(id);
    }
    
    
}
