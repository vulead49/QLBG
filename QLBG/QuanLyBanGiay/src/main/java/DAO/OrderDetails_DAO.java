/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.OrderDetails_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Anh
 */
public class OrderDetails_DAO {
    Connection con = JDBC.getConnection();
    
    public Vector<OrderDetails_DTO> getALLctdh()
    {
        Vector<OrderDetails_DTO> ctdhList = new Vector<>();
        try {
            String sql = "Select * from CTDH";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                OrderDetails_DTO ctdh = new OrderDetails_DTO();
                ctdh.setMaCTDH(rs.getInt("MaCTDH"));  // Thêm MaCTDH
                ctdh.setMaDH(rs.getInt("MaDH"));
                ctdh.setMaSP(rs.getInt("MaSP"));
                ctdh.setSoLuong(rs.getInt("SoLuong"));
                ctdh.setGiaBan(rs.getInt("GiaBan"));
                
                ctdhList.add(ctdh);             
            }
                
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ctdhList;
    }
    
    public boolean addCTDH (OrderDetails_DTO ctdh)
    {
        try {
            String sql = "Insert into CTDH (MaDH, MaSP, SoLuong, GiaBan) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);           
            ps.setInt(1, ctdh.getMaDH());
            ps.setInt(2, ctdh.getMaSP());
            ps.setInt(3, ctdh.getSoLuong());
            ps.setDouble(4, ctdh.getGiaBan());           

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    ctdh.setMaCTDH(generatedId); // Lưu MaCTDH mới vào DTO
                    System.out.println("MaCTDH mới: " + generatedId);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
     public int getLastMaDH() {
        String sql = "SELECT MAX(CAST(MaDH AS INT)) AS MaxMaDH FROM CTDH WHERE ISNUMERIC(MaDH) = 1";
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
    // Hàm lấy số lượng tồn kho của sản phẩm từ database
    public int getSoLuongTonKho(int maSP) {
        int soLuongTon = 0;
        try {
            String sql = "SELECT SoLuong FROM Kho WHERE MaSP = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, maSP);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                soLuongTon = rs.getInt("SoLuong"); // Lấy giá trị cột SoLuong
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuongTon;
    }
    public void updateSoLuongTonKho(int maSP, int soLuongMoi) {
        try {
            String sql = "UPDATE Kho SET SoLuong = ? WHERE MaSP = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, soLuongMoi);
            ps.setInt(2, maSP);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int editCTDH (OrderDetails_DTO ctdh)
    {
        try {
            String sql = "UPDATE CTDH SET MaSP = ?, SoLuong = ?, GiaBan = ? WHERE MaCTDH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ctdh.getMaSP());      
            ps.setInt(2, ctdh.getSoLuong());       
            ps.setDouble(3, ctdh.getGiaBan());    
            ps.setInt(4, ctdh.getMaCTDH());
 
            
            int rowUpdate = ps.executeUpdate();
            return rowUpdate > 0 ? 1 : 0;
        } catch (Exception e) {
              e.printStackTrace();  // In ra lỗi chi tiết
        }
        return 0;
    }
    
   // Xóa chi tiết đơn hàng theo MaCTDH
    public boolean deleteCTDH(int maCTDH) {
        try {
            String sql = "DELETE FROM CTDH WHERE MaCTDH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, maCTDH);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Tìm chi tiết đơn hàng theo MaDH
    public List<OrderDetails_DTO> findCTDH(int id) {
        List<OrderDetails_DTO> orderdetails = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CTDH WHERE MaDH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetails_DTO orderdetail = new OrderDetails_DTO();
                orderdetail.setMaCTDH(rs.getInt("MaCTDH")); // Thêm MaCTDH
                orderdetail.setMaDH(rs.getInt("MaDH"));
                orderdetail.setMaSP(rs.getInt("MaSP"));
                orderdetail.setSoLuong(rs.getInt("SoLuong"));
                orderdetail.setGiaBan(rs.getInt("GiaBan"));

                orderdetails.add(orderdetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderdetails;
    }
    
    

}
