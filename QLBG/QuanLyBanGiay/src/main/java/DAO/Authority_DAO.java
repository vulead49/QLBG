/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Authority_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anh
 */
public class Authority_DAO {
    Connection con = JDBC.getConnection();
    public List<Authority_DTO> getAllAuthorities() throws SQLException {
        List<Authority_DTO> authorities = new ArrayList<>();
        String query = "SELECT * FROM PHANQUYEN";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Authority_DTO auth = new Authority_DTO(
                    rs.getInt("MaQuyen"),
                    rs.getString("TenQuyen"),
                    rs.getString("MoTa")
                );
                authorities.add(auth);
            }
        }
        return authorities;
    }
    
    public String getTenQuyenByMaQuyen(int maQuyen) {
        String sql = "SELECT TenQuyen FROM PHANQUYEN WHERE MaQuyen = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, maQuyen);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("TenQuyen");
            }
        } catch (SQLException e) {
        }
        return null; // Không tìm thấy
    }


    public void addAuthority(Authority_DTO auth) throws SQLException {
        String query = "INSERT INTO PHANQUYEN (MaQuyen, TenQuyen, MoTa) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, auth.getMaQuyen());
            pstmt.setString(2, auth.getTenQuyen());
            pstmt.setString(3, auth.getMoTa());
            pstmt.executeUpdate();
        }
    }

    public void updateAuthority(Authority_DTO auth) throws SQLException {
        String query = "UPDATE PHANQUYEN SET TenQuyen = ?, MoTa = ? WHERE MaQuyen = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, auth.getTenQuyen());
            pstmt.setString(2, auth.getMoTa());
            pstmt.setInt(3, auth.getMaQuyen());
            pstmt.executeUpdate();
        }
    }

    public void deleteAuthority(int maQuyen) throws SQLException {
        String query = "DELETE FROM PHANQUYEN WHERE MaQuyen = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, maQuyen);
            pstmt.executeUpdate();
        }
    }
}

