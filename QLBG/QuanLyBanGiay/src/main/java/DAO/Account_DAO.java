/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author tranl
 */
public class Account_DAO {
     Connection con = JDBC.getConnection();
        public Vector<Account_DTO> getALLtk()
    {
        Vector<Account_DTO> tkList = new Vector<>();
        try {
            String sql = "Select * from TaiKhoan";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Account_DTO tk = new Account_DTO();
                tk.setMaTK(rs.getString("MaTK"));
                tk.setMaNV(rs.getString("MaNV"));
                tk.setTenTK(rs.getString("TenTK"));
                tk.setLoaiTK(rs.getString("LoaiTK"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tkList.add(tk);
            }   
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return tkList;
    }
        
        
        
        public boolean addTK (Account_DTO tk)
    {
        try {
            String sql = "Insert into TaiKhoan (MaTK, MaNV, TenTK, LoaiTK, MatKhau) values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tk.getMaTK());
            ps.setString(2, tk.getMaNV());
            ps.setString(3, tk.getTenTK());
            ps.setString(4, tk.getLoaiTK());
            ps.setString(5, tk.getMatKhau());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
     public int getLastMaTK() {
        String sql = "SELECT MAX(CAST(MaTK AS INT)) AS MaxMaTK FROM TaiKhoan WHERE ISNUMERIC(MaTK) = 1";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("MaxMaTK"); // Lấy số lớn nhất
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Nếu bảng rỗng, trả về 0
    }
    public int delTK (String idTK)
    {
        try {
            String sql = "Delete from TaiKhoan where MaTK = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idTK);
            int rowDel = ps.executeUpdate();
            if (rowDel > 0) {
                return 1;
            }
            
        } catch (Exception e) {
        }
        return 0;
    }
    public int editTK (Account_DTO tk)
    {
        try {
            String sql = "Update TaiKhoan set MaNV = ?, TenTK = ?, LoaiTK = ?, MatKhau = ? where MaTK = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tk.getMaNV());
            ps.setString(2, tk.getTenTK());
            ps.setString(3, tk.getLoaiTK());
            ps.setString(4, tk.getMatKhau());
            ps.setString(5, tk.getMaTK());
            int rowUpdate = ps.executeUpdate();
            
            if (rowUpdate > 0) {
                return 1;
            } 
        } catch (Exception e) {
        }
        return 0;
    }
    public Account_DTO findTK(String id)
    {
        Account_DTO tk = null;
        try {
            String sql = "Select *from TaiKhoan where MaTK = ?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                tk = new Account_DTO();
                tk.setMaTK(rs.getString("MaTK"));
                tk.setMaNV(rs.getString("MaNV"));
                tk.setTenTK(rs.getString("TenTK"));
                tk.setLoaiTK(rs.getString("LoaiTK"));
                tk.setMatKhau(rs.getString("MatKhau"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }
}
