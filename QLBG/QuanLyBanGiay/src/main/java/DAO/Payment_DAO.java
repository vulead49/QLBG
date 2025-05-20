/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Payment_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anh
 */
public class Payment_DAO {
    Connection con = JDBC.getConnection(); // Kết nối SQL Server

    public List<Payment_DTO> getAllPayments() {
        List<Payment_DTO> paymentList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ThanhToan";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Payment_DTO payment = new Payment_DTO(
                    rs.getInt("MaTT"),
                    rs.getInt("MaDH"),
                    rs.getString("HinhThucTT"),
                    rs.getTime("ThoiGian")
                );
                paymentList.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentList;
    }

    public boolean addPayment(Payment_DTO payment) {
        try {
            String sql = "INSERT INTO ThanhToan (MaTT, MaDH, HinhThucTT, ThoiGian) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, payment.getMaTT());
            ps.setInt(2, payment.getMaDH());
            ps.setString(3, payment.getHinhThucTT());
            ps.setTime(4, Time.valueOf(LocalTime.now()));

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean updatePayment(Payment_DTO payment) {
        try {
            String sql = "UPDATE ThanhToan SET MaDH = ?, HinhThucTT = ?, ThoiGian = ? WHERE MaTT = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, payment.getMaDH());
            ps.setString(2, payment.getHinhThucTT());
            ps.setTime(3, payment.getThoiGian());
            ps.setInt(4, payment.getMaTT());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletePayment(int madh) {
        try {
            String sql = "DELETE FROM ThanhToan WHERE MaDH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, madh);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public int generateID() {
        int newID = 1;
        String sql = "SELECT MAX(MaTT) FROM ThanhToan";
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
    
    public Payment_DTO findPaymentByMaDH(int maDH) {
        try {
            String sql = "SELECT * FROM ThanhToan WHERE MaDH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, maDH);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Payment_DTO payment = new Payment_DTO(
                    rs.getInt("MaTT"),
                    rs.getInt("MaDH"),
                    rs.getString("HinhThucTT"),
                    rs.getTime("ThoiGian")
                );
                return payment;
            }
        } catch (SQLException e) {
        }
        return null;
    }
}

