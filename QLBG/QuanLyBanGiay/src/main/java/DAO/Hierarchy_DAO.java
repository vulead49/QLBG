/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Hierarchy_DTO;
import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for handling database operations related to employee hierarchy
 */
public class Hierarchy_DAO {

    Connection con = JDBC.getConnection();

    // Constructor to initialize the database connection
    

    // Phương thức để lấy dữ liệu cấp bậc nhân viên
    public List<Hierarchy_DTO> fetchHierarchyData() throws SQLException {
        List<Hierarchy_DTO> hierarchyList = new ArrayList<>();
        String query = "SELECT * FROM CapBac"; // Thay đổi tên bảng nếu cần

        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int maCapBac = rs.getInt("MaCapBac");
                String tenCapBac = rs.getString("TenCapBac");
                BigDecimal luongCoBan = rs.getBigDecimal("LuongCoBan");
                BigDecimal luongTheoGio = rs.getBigDecimal("MucLuongGio");
                Hierarchy_DTO hierarchy = new Hierarchy_DTO(maCapBac, tenCapBac, luongCoBan, luongTheoGio);
                hierarchyList.add(hierarchy);
            }
        }
        return hierarchyList;
    }
    
    public String getTenCapBac(int macapbac) {
        String tencapbac = "";
        String sql = "SELECT TenCapBac FROM CapBac WHERE MaCapBac = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, macapbac);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tencapbac = rs.getString("TenCapBac");
            }
        } catch (SQLException e) {
        }
        return tencapbac;
    }   
    
    public Hierarchy_DTO fetchHierarchyDatabyID(int id) throws SQLException {
        String query = "SELECT * FROM CapBac WHERE MaCapBac = ?"; // Thay đổi tên bảng nếu cần

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int maCapBac = rs.getInt("MaCapBac");
                String tenCapBac = rs.getString("TenCapBac");
                BigDecimal luongCoBan = rs.getBigDecimal("LuongCoBan");
                BigDecimal luongTheoGio = rs.getBigDecimal("MucLuongGio");
                Hierarchy_DTO hierarchy = new Hierarchy_DTO(maCapBac, tenCapBac, luongCoBan, luongTheoGio);
                return hierarchy;
            }
        }
        return null;
    }
    
}
