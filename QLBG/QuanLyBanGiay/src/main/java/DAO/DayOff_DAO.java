/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DayOff_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Anh
 */
public class DayOff_DAO {
    Connection con = JDBC.getConnection();

    public List<DayOff_DTO> getAllDayOff() {
        List<DayOff_DTO> dayOffList = new ArrayList<>();
        String sql = "SELECT * FROM NgayNghi";

        try (PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                DayOff_DTO dayOff = new DayOff_DTO();
                dayOff.setSTT(resultSet.getInt("STT"));
                dayOff.setNgayNghi(resultSet.getDate("NgayNghi"));
                dayOff.setMaNV(resultSet.getInt("MaNV"));
                dayOff.setLyDo(resultSet.getString("LyDo"));
                dayOff.setDuyet(resultSet.getBoolean("Duyet"));
                dayOffList.add(dayOff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dayOffList;
    }
    
    public List<DayOff_DTO> getAllDayOffbyNV(int manv) {
        List<DayOff_DTO> dayOffList = new ArrayList<>();
        String sql = "SELECT * FROM NgayNghi WHERE MaNV = ?";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, manv);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DayOff_DTO dayOff = new DayOff_DTO();
                dayOff.setSTT(resultSet.getInt("STT"));
                dayOff.setNgayNghi(resultSet.getDate("NgayNghi"));
                dayOff.setMaNV(resultSet.getInt("MaNV"));
                dayOff.setLyDo(resultSet.getString("LyDo"));
                dayOff.setDuyet(resultSet.getBoolean("Duyet"));
                dayOffList.add(dayOff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dayOffList;
    }


    public boolean insertDayOff(DayOff_DTO dayOff) {
        String sql = "INSERT INTO NgayNghi (STT, NgayNghi, MaNV, LyDo, Duyet) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, dayOff.getSTT());
            statement.setDate(2, new java.sql.Date(dayOff.getNgayNghi().getTime()));
            statement.setInt(3, dayOff.getMaNV());
            statement.setString(4, dayOff.getLyDo());
            statement.setBoolean(5, dayOff.isDuyet());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }       
    }

    public void updateDayOff(DayOff_DTO dayOff) {
        String sql = "UPDATE NgayNghi SET NgayNghi = ?, MaNV = ?, LyDo = ?, Duyet = ? WHERE STT = ?";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(dayOff.getNgayNghi().getTime()));
            statement.setInt(2, dayOff.getMaNV());
            statement.setString(3, dayOff.getLyDo());
            statement.setBoolean(4, dayOff.isDuyet());
            statement.setInt(5, dayOff.getSTT());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteDayOff(int manv, Date ngay) {
        String sql = "DELETE FROM NgayNghi WHERE MaNV = ? AND NgayNghi = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, manv);
            statement.setDate(2, ngay);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteDayOffByID (int stt) {
        String sql = "DELETE FROM NgayNghi WHERE STT=?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, stt);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean isKeyExists(int id, Date ngay) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(ngay.getTime());
        String query = "SELECT COUNT(*) FROM NgayNghi WHERE MaNV = ? AND NgayNghi = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setDate(2, sqlDate);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Nếu có bản ghi tồn tại
            }
        }
        return false; // Không có bản ghi nào tồn tại
    }
    
    public boolean check (int id) {
        String sql = "UPDATE NgayNghi SET Duyet = ? WHERE STT= ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setBoolean(1, true);
            statement.setInt(2, id);
            statement.executeUpdate();
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
        }
        return false;
    }
    
    public boolean checkDuyet(int stt) throws SQLException{
        String sql = "SELECT COUNT(*) FROM NgayNghi WHERE Duyet = ? AND STT = ?";
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
    
    public int generateDayOffID() {
        int newID = 1;
        String sql = "SELECT MAX(STT) FROM NgayNghi";
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
    
    public int tinhngaynghi(int month, int year, int idnv) throws SQLException {
        String sql = "SELECT COUNT(*) FROM NgayNghi WHERE MaNV=? AND MONTH(NgayNghi) = ? AND YEAR(NgayNghi) = ? AND Duyet =?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idnv);
            stmt.setInt(2, month);
            stmt.setInt(3, year);
            stmt.setBoolean(4, true);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // Nếu có bản ghi tồn tại
            }
        }
        return 0 ;
    }
}
