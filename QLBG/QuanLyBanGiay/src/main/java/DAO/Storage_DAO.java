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
        
        public boolean addGiay(DetailGoodRecipe_DTO giay) {
        String sql = "INSERT INTO Kho (MaSP, TenSP, Hang, PhanLoai, Size, SoLuong, GiaBan) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, giay.getMaSP());
            ps.setString(2, giay.getTenSP());
            ps.setString(3, giay.getHang());
            ps.setString(4, giay.getLoai());
            ps.setInt(5, giay.getSize());
            ps.setInt(6, 0); // Ban đầu số lượng = 0
            ps.setFloat(7, giay.getGiaNhap() * 1.2f); // Giá bán = Giá nhập * 1.2

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        
        
        public void updateKho(DetailGoodRecipe_DTO ctpn) {
    try {
        // Kiểm tra sản phẩm đã có trong kho chưa
        String checkSql = "SELECT SoLuong FROM Kho WHERE MaSP = ?";
        PreparedStatement checkPs = con.prepareStatement(checkSql);
        checkPs.setString(1, ctpn.getMaSP());
        ResultSet rs = checkPs.executeQuery();

        if (rs.next()) {
            // Nếu sản phẩm đã có trong kho -> Cập nhật số lượng và giá bán
            int soLuongMoi = rs.getInt("SoLuong") + ctpn.getSl();
            String updateSql = "UPDATE Kho SET SoLuong = ?, GiaBan = ? WHERE MaSP = ?";
            PreparedStatement updatePs = con.prepareStatement(updateSql);
            updatePs.setInt(1, soLuongMoi);
            updatePs.setFloat(2, (float) (ctpn.getGiaNhap() * 1.2)); // Giá bán cao hơn giá nhập 20%
            updatePs.setString(3, ctpn.getMaSP());
            updatePs.executeUpdate();
        } else {
            // Nếu sản phẩm chưa có trong kho -> Thêm mới vào Kho
            System.out.println("Cập nhật kho cho sản phẩm: " + ctpn.getMaSP() + " - Số lượng thêm: " + ctpn.getSl());

            String insertSql = "INSERT INTO Kho (MaSP, TenSP, Hang, PhanLoai, Size, SoLuong, GiaBan) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertPs = con.prepareStatement(insertSql);
            insertPs.setString(1, ctpn.getMaSP());
            insertPs.setString(2, ctpn.getTenSP());
            insertPs.setString(3, ctpn.getHang());
            insertPs.setString(4, ctpn.getLoai());
            insertPs.setInt(5, ctpn.getSize());
            insertPs.setInt(6, ctpn.getSl());
            insertPs.setFloat(7, (float) (ctpn.getGiaNhap() * 1.2)); // Giá bán 20% cao hơn giá nhập
            insertPs.executeUpdate();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
   }
        
        public boolean updateKhoAfterDelete(String maSP, int size, int soLuongXoa) {
    String sql = "UPDATE Kho SET SoLuong = SoLuong - ? WHERE MaSP = ? AND Size = ? AND SoLuong >= ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, soLuongXoa);
        ps.setString(2, maSP);
        ps.setInt(3, size);
        ps.setInt(4, soLuongXoa); // Đảm bảo số lượng không âm

        int rows = ps.executeUpdate();
        return rows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    
   
    
}


