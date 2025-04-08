/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Order_DTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Order_DAO {
    Connection con = JDBC.getConnection();
    
    public Vector<Order_DTO> getALLdh()
    {
        Vector<Order_DTO> dhList = new Vector<>();
        try {
            String sql = "Select * from DonHang";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Order_DTO nv = new Order_DTO();
                nv.setMaDH(rs.getString("MaDH"));
                nv.setTenKH(rs.getString("TenKH"));
                nv.setNgayLap(rs.getDate("NgayLap"));
                nv.setThanhTien(rs.getFloat("ThanhTien"));
                nv.setTrangThai(rs.getBoolean("TrangThai"));
                dhList.add(nv);

                
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
            ps.setDate(3, dh.getNgayLap());
            ps.setFloat(4, dh.getThanhTien());           
            ps.setBoolean(5, dh.getTrangThai());

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
            String sql = "Update DonHang set TenKH = ?, NgayLap = ?, ThanhTien = ?, TrangThai = ? where MaDH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dh.getTenKH());      // TenKH
            ps.setDate(2, dh.getNgayLap());       // NgayLap
            ps.setFloat(3, dh.getThanhTien());    // ThanhTien
            ps.setBoolean(4, dh.getTrangThai());  // PhuongThuc
            ps.setString(5, dh.getMaHD());   
            
            int rowUpdate = ps.executeUpdate();
            
            if (rowUpdate > 0) {
                return 1;
            } 
        } catch (Exception e) {
              e.printStackTrace();  // In ra lỗi chi tiết
        }
        return 0;
    }
    
    public int editTotalDH(int madh, float thanhtien){
        try {
            String sql = "Update DonHang set ThanhTien = ? where MaDH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, thanhtien);  
            ps.setInt(2, madh); 
            int rowUpdate = ps.executeUpdate();
            
            if (rowUpdate > 0) {
                return 1;
            } 
        } catch (Exception e) {
              e.printStackTrace();  // In ra lỗi chi tiết
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
            String sql = "Select * from DonHang where MaDH = ?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                sp = new Order_DTO();
                sp.setMaDH(rs.getString("MaDH"));
                sp.setTenKH(rs.getString("TenKH"));
                sp.setNgayLap(rs.getDate("NgayLap"));
                sp.setThanhTien(rs.getFloat("ThanhTien"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
         
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }  
    
    public List<Order_DTO> findOrdersWithNonCashPayment() {
        List<Order_DTO> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DonHang WHERE TrangThai = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order_DTO order = new Order_DTO();
                order.setMaDH(rs.getString("MaDH"));
                order.setTenKH(rs.getString("TenKH"));
                order.setNgayLap(rs.getDate("NgayLap"));
                order.setThanhTien(rs.getFloat("ThanhTien"));
                order.setTrangThai(rs.getBoolean("TrangThai"));
                orders.add(order);
            }
        } catch (Exception e) {
            }   
        return orders;
    }
    
    public List<Order_DTO> findOrdersByDate(Date fromDate, Date toDate) {
        List<Order_DTO> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DonHang WHERE NgayLap BETWEEN ? AND ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, fromDate);
            ps.setDate(2, toDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order_DTO order = new Order_DTO();
                order.setMaDH(rs.getString("MaDH"));
                order.setTenKH(rs.getString("TenKH"));
                order.setNgayLap(rs.getDate("NgayLap"));
                order.setThanhTien(rs.getFloat("ThanhTien"));
                order.setTrangThai(rs.getBoolean("TrangThai"));
                orders.add(order);
            }
        } catch (Exception e) {
        }
        return orders;
    }

}

