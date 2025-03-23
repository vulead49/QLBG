/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Hierarchy_DTO;
import DTO.Payroll_DTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Payroll_DAO {
    Connection con = JDBC.getConnection(); // Kết nối đến cơ sở dữ liệu


    // Thêm bảng lương
    public boolean addPayroll(Payroll_DTO payroll) throws SQLException {
        String query = "INSERT INTO BangLuong (STT, MaNV, Thang, Nam, SoNgayNghi, Luong) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, payroll.getStt());
            stmt.setInt(2, payroll.getMaNV());
            stmt.setInt(3, payroll.getThang());
            stmt.setInt(4, payroll.getNam());
            stmt.setInt(5, payroll.getSoNgayNghi());
            stmt.setBigDecimal(6, payroll.getLuong());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
        catch (SQLException e) {
        e.printStackTrace();  // In ra lỗi để kiểm tra chi tiết
        return false;
        }
    }

    // Lấy danh sách bảng lương
    public List<Payroll_DTO> getAllPayrolls() throws SQLException {
        List<Payroll_DTO> payrolls = new ArrayList<>();
        String query = "SELECT * FROM BangLuong";
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Payroll_DTO payroll = new Payroll_DTO(
                    rs.getInt("STT"),
                    rs.getInt("MaNV"),
                    rs.getInt("Thang"),
                    rs.getInt("Nam"),
                    rs.getInt("SoNgayNghi"),
                    rs.getBigDecimal("Luong")
                );
                payrolls.add(payroll);
            }
        }
        return payrolls;
    }
    
    // Phương thức để lấy rank ID của nhân viên
    public int getEmployeeRank(int employeeId) throws SQLException {
        String query = "SELECT MaCapBac FROM NHANVIEN WHERE MaNV = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("MaCapBac");
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }
    
    // Phương thức để lấy thông tin cấp bậc theo ID
    public Hierarchy_DTO getRankById(int rankId, List<Hierarchy_DTO> hierarchyList) {
        for (Hierarchy_DTO hierarchy : hierarchyList) {
            if (hierarchy.getRankId() == rankId) {
                return hierarchy;
            }
        }
        return null; // Hoặc xử lý trường hợp không tìm thấy
    }
    
    public int generateID() {
        int newID = 1;
        String sql = "SELECT MAX(STT) FROM BangLuong";
        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                newID = rs.getInt(1) + 1;  // Lấy mã lớn nhất + 1
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newID;
    }
    
    public String getTenNV(int maNV) {
        String tenNV = "";
        String sql = "SELECT HoTen FROM NHANVIEN WHERE MaNV = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, maNV);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tenNV = rs.getString("HoTen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenNV;
    }
    
    public int getMaCapBac(int maNV) {
        int ma = 0;
        String sql = "SELECT MaCapBac FROM NHANVIEN WHERE MaNV = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, maNV);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ma = rs.getInt("MaCapBac");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ma;
    }
    
    // Phương thức kiểm tra bảng lương đã được tạo hay chưa
    public boolean checkPayrollExists(int maNV, int thang, int nam) throws SQLException {
        String query = "SELECT COUNT(*) FROM BangLuong WHERE MaNV = ? AND Thang = ? AND Nam = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, maNV);
            stmt.setInt(2, thang);
            stmt.setInt(3, nam);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu có bản ghi
            }
        }
        return false; // Trả về false nếu không có bản ghi
    }
    
    public boolean updatePayroll(int id,int thang, int nam , BigDecimal luong){
        String sql = "UPDATE BangLuong SET Luong = ? WHERE MaNV = ? AND Thang = ? AND Nam = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, luong);
            pstmt.setInt(2, id);
            pstmt.setInt(3, thang);
            pstmt.setInt(4, nam);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }catch (SQLException e) {
        e.printStackTrace();  // In ra lỗi để kiểm tra chi tiết
        return false;
        }
    }
    // Các phương thức khác như UpdatePayroll, DeletePayroll...
}

