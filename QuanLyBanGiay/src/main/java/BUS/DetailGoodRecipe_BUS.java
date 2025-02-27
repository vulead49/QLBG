/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DetailGoodRecipe_DAO;
import DAO.GoodRecipe_DAO;
import DTO.DetailGoodRecipe_DTO;
import DTO.GoodRecipe_DTO;
import java.util.Vector;

/**
 *
 * @author Mai
 */
public class DetailGoodRecipe_BUS {
    DetailGoodRecipe_DAO ctpnDao  = new DetailGoodRecipe_DAO();
    
    public Vector<DetailGoodRecipe_DTO> getALLpn()
    {
        return ctpnDao.getALLCTpn();
    }
}
