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
    
    public List<Schedule_DTO> getAllSchedulesNV() throws SQLException {
        List<Schedule_DTO> schedules = new ArrayList<>();
        String sql = "SELECT * FROM LICHLAM WHERE DuyetCong=?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setBoolean(1, false);
            ResultSet rs = pstmt.executeQuery();
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
    
    public List<Schedule_DTO> selectScheduleByMaNV(int id) throws SQLException {
        List<Schedule_DTO> schedules = new ArrayList<>();
        String sql = "SELECT * FROM LICHLAM WHERE MaNV = ? AND DuyetCong = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setBoolean(2, true);
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
    
    public boolean checkDuyet(int stt) throws SQLException{
        String sql = "SELECT COUNT(*) FROM LICHLAM WHERE DuyetCong = ? AND STT = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, stt);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Nếu có bản ghi tồn tại
            };
        }
        return false;      
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
    public List<Schedule_DTO> fetchScheduleForEmployee(int employeeId, int month, int year) throws SQLException {
        List<Schedule_DTO> scheduleList = new ArrayList<>();
        String query = "SELECT * FROM LichLam WHERE MaNV = ? AND MONTH(Ngay) = ? AND YEAR(Ngay) = ? AND DuyetCong = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            stmt.setInt(2, month);
            stmt.setInt(3, year);
            stmt.setBoolean(4, true);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int maCaLam = rs.getInt("STT");
                int maNV = rs.getInt("MaNV");
                Date ngayLamViec = rs.getDate("Ngay");
                Time gioBatDau = rs.getTime("GioBatDau");
                Time gioKetThuc = rs.getTime("GioKetThuc");
                boolean duyet = rs.getBoolean("DuyetCong");

                Schedule_DTO schedule = new Schedule_DTO(maCaLam, maNV, ngayLamViec, gioBatDau, gioKetThuc, duyet);
                scheduleList.add(schedule);
            }
        }
        return scheduleList;
    }
      
    
    public boolean isTimesheetOverlapping(Schedule_DTO newSchedule) {
        try {
            System.out.println(newSchedule.getGioBatDau()+" and "+newSchedule.getGioKetThuc());
            String sql = "SELECT COUNT(*) FROM LichLam WHERE MaNV = ? AND Ngay = ? " +
            "  AND ((GioBatDau BETWEEN ? AND ?) OR (GioKetThuc BETWEEN ? AND ?) OR (? < GioBatDau AND ? > GioKetThuc))";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, newSchedule.getMaNV());
            stmt.setDate(2, newSchedule.getNgayLamViec());
            stmt.setTime(3, newSchedule.getGioBatDau());
            stmt.setTime(4, newSchedule.getGioKetThuc());
            stmt.setTime(5, newSchedule.getGioBatDau());
            stmt.setTime(6, newSchedule.getGioKetThuc());
            stmt.setTime(7, newSchedule.getGioBatDau());
            stmt.setTime(8, newSchedule.getGioKetThuc());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt(1));
                return rs.getInt(1) > 0; // Nếu có bản ghi tồn tại
            }
        } catch (SQLException e) {
            // Xử lý lỗi kết nối hoặc truy vấn
        }
        return false;
    }
    
    public boolean isDuplicateScheduleDate(int maNV, Date ngay) {
    try {String sql = "SELECT COUNT(*) FROM LichLam WHERE MaNV = ? AND Ngay = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, maNV);
        ps.setDate(2, new java.sql.Date(ngay.getTime()));
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Nếu đã có ít nhất 1 lịch thì coi như trùng
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

}

