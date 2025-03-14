/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Order_DTO;
import GUI.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Vector;


public class Order_DAO {
    Connection con = JDBC.getConnection();
    
    public Vector<Order_DAO> getALLod()
    {
        Vector<Order_DAO> dhList = new Vector<>();
        try {
            String sql = "Select * from DonHang";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Order_DTO nv = new Order_DTO();
                nv.setMaDH(rs.getString("MaDH"));
                nv.setTenKH(rs.getString("TenKH"));
                nv.setNgayLap(rs.getString("NgayLap"));
                nv.setThanhTien(rs.getFloat("ThanhTien"));
                nv.setTrangThai(rs.getString("TrangThai"));

                
            }
                
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return dhList;
    }
    
    public boolean addDH (Order_DTO dh)
    {
        try {
            String sql = "Insert into DonHang (MaDH, TenKH, NgayLap, ThanhTien, TrangThai) values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dh.getMaHD());
            ps.setString(2, dh.getTenKH());
            ps.setString(3, dh.getNgayLap());
            ps.setFloat(4, dh.getThanhTien());           
            ps.setString(5, dh.getTrangThai());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
     public int getLastMaDH() {
        String sql = "SELECT MAX(CAST(MaDH AS INT)) AS MaxMaDH FROM DonHang WHERE ISNUMERIC(MaDH) = 1";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("MaxMaDH"); // Lấy số lớn nhất
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Nếu bảng rỗng, trả về 0
    }
    
    public int editDH (Order_DTO dh)
    {
        try {
            String sql = "Update DonHang set MaDH = ?, TenKH = ?, NgayLap = ?, ThanhTien = ?, TrangThai = ? where MaDH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dh.getMaHD());
            ps.setString(2, dh.getTenKH());
            ps.setString(3, dh.getNgayLap());
            ps.setFloat(4, dh.getThanhTien());           
            ps.setString(5, dh.getTrangThai());
          
            int rowUpdate = ps.executeUpdate();
            
            if (rowUpdate > 0) {
                return 1;
            } 
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int delDH (String idDH)
    {
        try {
            String sql = "Delete from DonHang where MaDH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idDH);
            int rowDel = ps.executeUpdate();
            if (rowDel > 0) {
                return 1;
            }
            
        } catch (Exception e) {
        }
        return 0;
    }
    
    public Order_DTO findDH(String id)
    {
        Order_DTO sp = null;
        try {
            String sql = "Select *from DonHang where MaDH = ?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                sp = new Order_DTO();
                sp.setMaDH(rs.getString("MaDH"));
                sp.setTenKH(rs.getString("TenKH"));
                sp.setNgayLap(rs.getString("NgayLap"));
                sp.setThanhTien(rs.getFloat("ThanhTien"));
                sp.setTrangThai(rs.getString("TrangThai"));
         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }
    
    
}
