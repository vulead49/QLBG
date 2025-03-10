/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DetailGoodRecipe_DTO;
import DTO.GoodRecipe_DTO;
import DTO.Supplier_DTO;
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
   
    public boolean addCTPN (DetailGoodRecipe_DTO ctpn)
    {
        try {
            String sql = "Insert into CTPhieuNhap (MaPN, MaSP, SoLuong, Hang, Size, GiaNhap) values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ctpn.getMaPN());
            ps.setString(2, ctpn.getMaSP() );
            ps.setInt(3, ctpn.getSl());
            ps.setString(4, ctpn.getHang());
            ps.setInt(5, ctpn.getSize());
            ps.setFloat(6, ctpn.getGiaNhap());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
//    public GoodRecipe_DTO findPN(String id)
//    {
//        GoodRecipe_DTO pn = null;
//        try {
//            String sql = "Select *from PhieuNhap where MaPN = ?";
//            PreparedStatement ps = con.prepareCall(sql);
//            ps.setString(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next())
//            {
//                pn = new GoodRecipe_DTO();
//                pn.setMaNCC(rs.getString("MaNCC"));
//                pn.setMaPN(rs.getString("MaPN"));
//                pn.setNgLap(rs.getDate("NgayNhap"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return pn;
//    }
    
    public int editCTPN (DetailGoodRecipe_DTO ctpn)
    {
        try {
            String sql = "Update CTPhieuNhap set MaSP = ?, SoLuong = ?, Hang = ?, Size = ?, GiaNhap = ? where MaPN= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ctpn.getMaPN());
            ps.setString(2, ctpn.getMaSP() );
            ps.setInt(3, ctpn.getSl());
            ps.setString(4, ctpn.getHang());
            ps.setInt(5, ctpn.getSize());
            ps.setFloat(6, ctpn.getGiaNhap());
            int rowUpdate = ps.executeUpdate();
            
            if (rowUpdate > 0) {
                return 1;
            } 
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int delCTPN (String idSP)
    {
        try {
            String sql = "Delete from NhaCungCap where MaPN = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, idSP);
            int rowDel = ps.executeUpdate();
            if (rowDel > 0) {
                return 1;
            }
            
        } catch (Exception e) {
        }
        return 0;
    }
    
    public GoodRecipe_DTO findPN(String id)
    {
        GoodRecipe_DTO pn = null;
        try {
            String sql = "Select *from PhieuNhap where MaPN = ?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                pn = new GoodRecipe_DTO();
                pn.setMaNCC(rs.getString("MaNCC"));
                pn.setMaPN(rs.getString("MaPN"));
                pn.setNgLap(rs.getDate("NgayNhap"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pn;
    }
    
    
   
   
}
