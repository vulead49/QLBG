/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Anh
 */
import DTO.Schedule_DTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Schedule_DAO {
    Connection con = JDBC.getConnection();

    public boolean addSchedule(Schedule_DTO schedule) throws SQLException {
        String sql = "INSERT INTO LICHLAM (STT, MaNV, Ngay, GioBatDau, GioKetThuc, DuyetCong) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, schedule.getMaCaLam());
            pstmt.setInt(2, schedule.getMaNV());
            pstmt.setDate(3, schedule.getNgayLamViec());
            pstmt.setTime(4, schedule.getGioBatDau());
            pstmt.setTime(5, schedule.getGioKetThuc());
            pstmt.setBoolean(6, schedule.isDuyet());
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
        }
        catch (SQLException e) {
        e.printStackTrace();  // In ra lỗi để kiểm tra chi tiết
        return false;
        }
    }

    public List<Schedule_DTO> getAllSchedules() throws SQLException {
        List<Schedule_DTO> schedules = new ArrayList<>();
        String sql = "SELECT * FROM LICHLAM";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Schedule_DTO schedule = new Schedule_DTO(
                        rs.getInt("STT"),
                        rs.getInt("MaNV"),
                        rs.getDate("Ngay"),
                        rs.getTime("GioBatDau"),
                        rs.getTime("GioKetThuc"),
                        rs.getBoolean("DuyetCong")
                );
                schedules.add(schedule);
            }
        }
        return schedules;
    }

    public boolean updateSchedule(Schedule_DTO schedule) throws SQLException {
        String sql = "UPDATE LICHLAM SET MaNV = ?, Ngay = ?, GioBatDau = ?, GioKetThuc = ?, DuyetCong = ? WHERE STT = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, schedule.getMaNV());
            pstmt.setDate(2, schedule.getNgayLamViec());
            pstmt.setTime(3, schedule.getGioBatDau());
            pstmt.setTime(4, schedule.getGioKetThuc());
            pstmt.setBoolean(5, schedule.isDuyet());
            pstmt.setInt(6, schedule.getMaCaLam());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }catch (SQLException e) {
        e.printStackTrace();  // In ra lỗi để kiểm tra chi tiết
        return false;
        }
    }
    
    public List<Schedule_DTO> selectScheduleByDate(Date ngay) throws SQLException {
        List<Schedule_DTO> schedules = new ArrayList<>();
        String sql = "SELECT * FROM LICHLAM WHERE Ngay = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setDate(1, ngay);
            ResultSet rs = pstmt.executeQuery(); // Chỉ gọi executeQuery() mà không có tham số
            while (rs.next()) {
                Schedule_DTO schedule = new Schedule_DTO(
                        rs.getInt("STT"),
                        rs.getInt("MaNV"),
                        rs.getDate("Ngay"),
                        rs.getTime("GioBatDau"),
                        rs.getTime("GioKetThuc"),
                        rs.getBoolean("DuyetCong")
                );
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
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
    
    public boolean check(int stt) throws SQLException {
        String sql = "UPDATE LICHLAM SET DuyetCong = ? WHERE STT = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, stt);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }catch (SQLException e) {
        e.printStackTrace();  // In ra lỗi để kiểm tra chi tiết
        return false;
        }
    }

    public boolean deleteSchedule(int maCaLam) throws SQLException {
        String sql = "DELETE FROM LICHLAM WHERE STT = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, maCaLam);
            return pstmt.executeUpdate() > 0;
        }
    }
    

    
    public int generateID() {
    int newID = 1;
    String sql = "SELECT MAX(STT) FROM LICHLAM";
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
    public boolean isKeyExists(int maCaLam) throws SQLException {
    // Thực hiện truy vấn để kiểm tra xem khóa chính đã tồn tại chưa
    String query = "SELECT COUNT(*) FROM LichLam WHERE STT = ?";
    try (PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setInt(1, maCaLam);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Nếu có bản ghi tồn tại
        }
    }
    return false; // Không có bản ghi nào tồn tại
}

}

