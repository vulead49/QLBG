/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.GoodRecipe_DAO;
import DTO.GoodRecipe_DTO;
import java.util.Vector;

/**
 *
 * @author Mai
 */
public class GoodRecipe_BUS {
    GoodRecipe_DAO PndAO = new GoodRecipe_DAO();
    
    public Vector<GoodRecipe_DTO> getALLpn()
    {
        return PndAO.getALLpn();
    }
    
    public String addPN (GoodRecipe_DTO pn)
    {
        if (PndAO.addPN(pn))
        {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }
    
    public int generateMaPN() {
        int lastMaPN = PndAO.getLastMaPN();
    return lastMaPN + 1; // Mã mới là số lớn nhất + 1
    }
    
    public GoodRecipe_DTO findPN (String id)
    {
        return PndAO.findPN(id);
    }
}
