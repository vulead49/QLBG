/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Supplier_DTO;
import GUI.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class Supplier_DAO {
    Connection con = JDBC.getConnection();
    
    public Vector<Supplier_DTO> getALLncc()
    {
        Vector<Supplier_DTO> nccList = new Vector<>();
        try {
            String sql = "Select * from NhaCungCap";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Supplier_DTO ncc = new Supplier_DTO();
                ncc.setMaNCC(rs.getString("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setSDT(rs.getString("SDT"));
                nccList.add(ncc);
            }
                
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return nccList;
    }
    
    public boolean addNCC (Supplier_DTO ncc)
    {
        try {
            String sql = "Insert into NhaCungCap (MaNCC, TenNCC, DiaChi, SDT) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getMaNCC());
            ps.setString(2, ncc.getTenNCC());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, ncc.getSDT());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
     public int getLastMaNCC() {
        String sql = "SELECT MAX(CAST(MaNCC AS INT)) AS MaxMaNCC FROM NhaCungCap WHERE ISNUMERIC(MaNCC) = 1";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("MaxMaNCC"); // Lấy số lớn nhất
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Nếu bảng rỗng, trả về 0
    }
    
    public int editNCC (Supplier_DTO ncc)
    {
        try {
            String sql = "Update NhaCungCap set TenNCC = ?, DiaChi = ?, SDT = ? where MaNCC = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getDiaChi());
            ps.setString(3, ncc.getSDT());
            ps.setString(4, ncc.getMaNCC());
            int rowUpdate = ps.executeUpdate();
            
            if (rowUpdate > 0) {
                return 1;
            } 
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int delNCC (String idNCC)
    {
        try {
            String sql = "Delete from NhaCungCap where MaNCC = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idNCC);
            int rowDel = ps.executeUpdate();
            if (rowDel > 0) {
                return 1;
            }
            
        } catch (Exception e) {
        }
        return 0;
    }
    
    public Supplier_DTO findNCC(String id)
    {
        Supplier_DTO sp = null;
        try {
            String sql = "Select *from NhaCungCap where MaNCC = ?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                sp = new Supplier_DTO();
                sp.setMaNCC(rs.getString("MaNCC"));
                sp.setTenNCC(rs.getString("TenNCC"));
                sp.setDiaChi(rs.getString("DiaChi"));
                sp.setSDT(rs.getString("SDT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }
    
    
}
