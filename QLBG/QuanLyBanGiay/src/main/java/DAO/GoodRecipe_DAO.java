/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.GoodRecipe_DTO;
import DTO.Supplier_DTO;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Mai
 */
public class GoodRecipe_DAO {
   Connection con = JDBC.getConnection();
   
   public Vector<GoodRecipe_DTO> getALLpn()
    {
        Vector<GoodRecipe_DTO> pnList = new Vector<>();
        try {
            String sql = "Select * from PhieuNhap";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                GoodRecipe_DTO pn = new GoodRecipe_DTO();
                pn.setMaPN(rs.getInt("MaPN"));
                pn.setMaNCC(rs.getInt("MaNCC"));
                pn.setNgLap(rs.getDate("NgayNhap"));
                pnList.add(pn);
            }
                
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pnList;
    }
   
   public boolean addPN (GoodRecipe_DTO pn)
    {
        try {
            String sql = "Insert into PhieuNhap (MaPN, MaNCC, NgayNhap) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pn.getMaPN());
            ps.setInt(2, pn.getMaNCC());
            ps.setDate(3, pn.getNgLap());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
   
   public int getLastMaPN() {
        String sql = "SELECT MAX(CAST(MaPN AS INT)) AS MaxMaPN FROM PhieuNhap WHERE ISNUMERIC(MaPN) = 1";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("MaxMaPN"); // Lấy số lớn nhất
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Nếu bảng rỗng, trả về 0
    }
    
   public GoodRecipe_DTO findPN(int id)
    {
        GoodRecipe_DTO pn = null;
        try {
            String sql = "Select * from PhieuNhap where MaPN = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                pn = new GoodRecipe_DTO();
                pn.setMaNCC(rs.getInt("MaNCC"));
                pn.setMaPN(rs.getInt("MaPN"));
                pn.setNgLap(rs.getDate("NgayNhap"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pn;
    }
   
}
