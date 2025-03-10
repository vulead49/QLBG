/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Employee_DTO;
import GUI.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Vector;


public class Employee_DAO {
    Connection con = JDBC.getConnection();
    
    public Vector<Employee_DAO> getALLnv()
    {
        Vector<Employee_DAO> nccList = new Vector<>();
        try {
            String sql = "Select * from NhanVien";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Employee_DTO nv = new Employee_DTO();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setCapBac(rs.getBoolean("MaCapBac"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setNgaySinh(rs.getString("NgaySinh"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setSDT(rs.getString("SDT"));

                
            }
                
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return nccList;
    }
    
    public boolean addNV (Employee_DTO nv)
    {
        try {
            String sql = "Insert into NhaCungCap (MaNCC, TenNCC, DiaChi, SDT) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setBoolean(2, nv.getCapBac());
            ps.setString(3, nv.getHoTen());
            ps.setString(4, nv.getNgaySinh());           
            ps.setBoolean(5, nv.getGioiTinh());
            ps.setString(6, nv.getSDT());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
     public int getLastMaNV() {
        String sql = "SELECT MAX(CAST(MaNV AS INT)) AS MaxMaNV FROM NhanVien WHERE ISNUMERIC(MaNV) = 1";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("MaxMaNV"); // Lấy số lớn nhất
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Nếu bảng rỗng, trả về 0
    }
    
    public int editNV (Employee_DTO nv)
    {
        try {
            String sql = "Update NhanVien set MaCapBac = ?, HoTen = ?, NgaySinh = ?, GioiTinh = ?, SDT = ? where MaNV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setBoolean(2, nv.getCapBac());
            ps.setString(3, nv.getHoTen());
            ps.setString(4, nv.getNgaySinh());           
            ps.setBoolean(5, nv.getGioiTinh());
            ps.setString(6, nv.getSDT());
            int rowUpdate = ps.executeUpdate();
            
            if (rowUpdate > 0) {
                return 1;
            } 
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int delNV (String idNV)
    {
        try {
            String sql = "Delete from NhanVien where MaNV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idNV);
            int rowDel = ps.executeUpdate();
            if (rowDel > 0) {
                return 1;
            }
            
        } catch (Exception e) {
        }
        return 0;
    }
    
    public Employee_DTO findNV(String id)
    {
        Employee_DTO sp = null;
        try {
            String sql = "Select *from NhanVien where MaNV = ?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                sp = new Employee_DTO();
                sp.setMaNV(rs.getString("MaNV"));
                sp.setCapBac(rs.getBoolean("MaCapBac"));
                sp.setHoTen(rs.getString("HoTen"));
                sp.setNgaySinh(rs.getString("NgaySinh"));
                sp.setGioiTinh(rs.getBoolean("GioiTinh"));
                sp.setSDT(rs.getString("SDT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }
    
    
}
