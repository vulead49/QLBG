/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DetailGoodRecipe_DTO;
import DTO.GoodRecipe_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DetailGoodRecipe_DAO {
    Connection con = JDBC.getConnection();
   
   public Vector<DetailGoodRecipe_DTO> getALLCTpn()
    {
        Vector<DetailGoodRecipe_DTO> ctpnList = new Vector<>();
        try {
            String sql = "Select * from CTPhieuNhap";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                DetailGoodRecipe_DTO ctpn = new DetailGoodRecipe_DTO();
                ctpn.setMaPN(rs.getString("MaPN"));
                ctpn.setMaSP(rs.getString("MaSP"));
                ctpn.setSl(rs.getInt("SoLuong"));
                ctpn.setHang(rs.getString("Hang"));
                ctpn.setSize(rs.getInt("Size"));
                ctpn.setGiaNhap(rs.getFloat("GiaNhap"));
                ctpnList.add(ctpn);
            }               
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ctpnList;
    }
   
}
