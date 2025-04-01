/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Employee_DTO;
import GUI.Employee;
import java.sql.Connection;
import java.sql.Date;
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
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setMaCapBac(rs.getInt("MaCapBac"));
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
            ps.setInt(1, nv.getMaNV());
            ps.setInt(2, nv.getMaCapBac());
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
            ps.setInt(1, nv.getMaCapBac());  // Ép kiểu sang int
        ps.setString(2, nv.getHoTen());
        ps.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
        ps.setString(4, nv.getGioiTinh());
        ps.setString(5, nv.getSDT());
        ps.setInt(6, nv.getMaNV());  // Ép kiểu sang int
            int rowUpdate = ps.executeUpdate();
            
            if (rowUpdate > 0) {
                return 1;
            } 
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int delNV (int idNV)
    {
        try {
        // Xóa tài khoản trước (vì MaNV đang là khóa ngoại trong TaiKhoan)
        String deleteTaiKhoan = "DELETE FROM TaiKhoan WHERE MaNV = ?";
        PreparedStatement ps1 = con.prepareStatement(deleteTaiKhoan);
        ps1.setInt(1, idNV);
        ps1.executeUpdate();

        // Sau đó xóa nhân viên
        String deleteNhanVien = "DELETE FROM NhanVien WHERE MaNV = ?";
        PreparedStatement ps2 = con.prepareStatement(deleteNhanVien);
        ps2.setInt(1, idNV);
        int rowDel = ps2.executeUpdate();

        if (rowDel > 0) {
            return 1; // Thành công
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Xóa thất bại
    }
    
    public Employee_DTO findNV(int id)
    {
        Employee_DTO sp = null;
        try {
            String sql = "Select *from NhanVien where MaNV = ?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                sp = new Employee_DTO();
                sp.setMaNV(rs.getInt("MaNV"));
                sp.setMaCapBac(rs.getInt("MaCapBac"));
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
    
    public Employee_DTO getEmployeeByMaNV(int maNV) throws SQLException {
        String sql = "SELECT * FROM NHANVIEN WHERE MaNV = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, maNV);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Employee_DTO nv = new Employee_DTO();
                    nv.setMaNV(rs.getInt("MaNV"));
                    nv.setHoTen(rs.getString("HoTen"));  // Cần có getter/setter cho TenNV
                    nv.setMaCapBac(rs.getInt("MaCapBac"));
                    nv.setNgaySinh(rs.getDate("NgaySinh"));
                    nv.setGioiTinh(rs.getString("GioiTinh"));
                    nv.setSDT(rs.getString("SDT"));
                    return nv;
                }
            }
        }
        return null;
    }
    
    public String getTenbyID(int manv) throws SQLException{
        String sql = "SELECT HoTen FROM NHANVIEN WHERE MaNV = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {      
            stmt.setInt(1, manv);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        }
        return null;
    }
    
    public int getMaCapBacByID(int manv) throws SQLException {
        String sql = "SELECT MaCapBac FROM NHANVIEN WHERE MaNV = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {      
            stmt.setInt(1, manv);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
    
    public boolean editNVV(int id, String ten, Date ngay,String gioitinh,String sdt) {
         try {
            String sql = "Update NhanVien set  HoTen = ?, NgaySinh = ?, GioiTinh = ?, SDT = ? where MaNV = ?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, ten);
            ps.setDate(2, ngay);
            ps.setString(3, gioitinh);
            ps.setString(4, sdt);
            ps.setInt(5, id); 
            int rowUpdate = ps.executeUpdate();
            
            if (rowUpdate > 0) {
                return true;
            } 
        } catch (Exception e) {
        }
        return false;
    }
}
