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
    
    public Vector<Employee_DTO> getALLnv()
    {
        Vector<Employee_DTO> nccList = new Vector<>();
        try {
            String sql = "Select * from NhanVien";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Employee_DTO nv = new Employee_DTO();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setMaCapBac(rs.getString("MaCapBac"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setSDT(rs.getString("SDT"));
                nccList.add(nv);

                
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
            String sql = "Insert into NhanVien (MaNV, MaCapBac, HoTen, NgaySinh, GioiTinh, SDT ) values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getMaCapBac());
            ps.setString(3, nv.getHoTen());
            ps.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));           
            ps.setString(5, nv.getGioiTinh());
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
            ps.setInt(1, Integer.parseInt(nv.getMaCapBac()));  // Ép kiểu sang int
        ps.setString(2, nv.getHoTen());
        ps.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
        ps.setString(4, nv.getGioiTinh());
        ps.setString(5, nv.getSDT());
        ps.setInt(6, Integer.parseInt(nv.getMaNV()));  // Ép kiểu sang int
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
        // Xóa tài khoản trước (vì MaNV đang là khóa ngoại trong TaiKhoan)
        String deleteTaiKhoan = "DELETE FROM TaiKhoan WHERE MaNV = ?";
        PreparedStatement ps1 = con.prepareStatement(deleteTaiKhoan);
        ps1.setInt(1, Integer.parseInt(idNV));
        ps1.executeUpdate();

        // Sau đó xóa nhân viên
        String deleteNhanVien = "DELETE FROM NhanVien WHERE MaNV = ?";
        PreparedStatement ps2 = con.prepareStatement(deleteNhanVien);
        ps2.setInt(1, Integer.parseInt(idNV));
        int rowDel = ps2.executeUpdate();

        if (rowDel > 0) {
            return 1; // Thành công
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Xóa thất bại
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
                sp.setMaCapBac(rs.getString("MaCapBac"));
                sp.setHoTen(rs.getString("HoTen"));
                sp.setNgaySinh(rs.getDate("NgaySinh"));
                sp.setGioiTinh(rs.getString("GioiTinh"));
                sp.setSDT(rs.getString("SDT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }
    
    
}
