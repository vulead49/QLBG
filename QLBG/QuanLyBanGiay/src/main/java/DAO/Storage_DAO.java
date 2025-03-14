/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DetailGoodRecipe_DTO;
import DTO.Storage_DTO;
import DTO.Supplier_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
public class Storage_DAO {
        Connection con = JDBC.getConnection();

        public Vector<Storage_DTO> getALLkho()
    {
        Vector<Storage_DTO> k = new Vector<>();
        try {
            String sql = "Select * from Kho";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Storage_DTO kho = new Storage_DTO();
                kho.setMaSP(rs.getString("MaSP"));
                kho.setTenSP(rs.getString("TenSP"));
                kho.setHang(rs.getString("Hang"));
                kho.setLoai(rs.getString("PhanLoai"));
                kho.setSize(rs.getString("Size"));
                kho.setSl(rs.getString("SoLuong"));
                kho.setGia(rs.getFloat("GiaBan"));
                k.add(kho);
            }
                
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return k;
}
    
    
    public boolean updateKhoByCTPN(DetailGoodRecipe_DTO ctpn) {
        try {
            // 1. Kiểm tra sản phẩm đã tồn tại chưa
            String checkSQL = "SELECT COUNT(*) FROM Kho WHERE MaSP = ?";
            PreparedStatement checkPs = con.prepareStatement(checkSQL);
            checkPs.setString(1, ctpn.getMaSP());
            ResultSet rs = checkPs.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                // 2. Sản phẩm chưa tồn tại, thêm mới vào Kho
                String insertSQL = "INSERT INTO Kho (MaSP, TenSP, Hang, PhanLoai, Size, SoLuong, GiaBan) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertPs = con.prepareStatement(insertSQL);
                insertPs.setString(1, ctpn.getMaSP());
                insertPs.setString(2, ctpn.getTenSP());
                insertPs.setString(3, ctpn.getHang());
                insertPs.setString(4, ctpn.getLoai());
                insertPs.setInt(5, ctpn.getSize());
                insertPs.setInt(6, ctpn.getSl()); // Số lượng nhập vào
                float giaBanMoi = ctpn.getGiaNhap() * 1.2f; // Tăng 20%
                insertPs.setFloat(7, giaBanMoi);
                insertPs.executeUpdate();
            } else {
                // 3. Nếu sản phẩm đã tồn tại, cập nhật số lượng & giá bán
                float giaBanMoi = ctpn.getGiaNhap() * 1.2f;
                String updateSQL = "UPDATE Kho SET SoLuong = SoLuong + ?, GiaBan = ? WHERE MaSP = ?";
                PreparedStatement updatePs = con.prepareStatement(updateSQL);
                updatePs.setInt(1, ctpn.getSl()); // Cộng dồn số lượng
                updatePs.setFloat(2, giaBanMoi);
                updatePs.setString(3, ctpn.getMaSP());
                updatePs.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
