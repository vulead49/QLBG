/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Anh
 */
public class Account_DAO {
    Connection con = JDBC.getConnection();
    // Lấy tất cả tài khoản
    public List<Account_DTO> getAllAccounts() throws SQLException {
        
        List<Account_DTO> accounts = new ArrayList<>();
        String sql = "SELECT * FROM TAIKHOAN";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Account_DTO account = new Account_DTO(
                    rs.getInt("TaiKhoanID"),
                    rs.getInt("MaNV"),
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau"),
                    rs.getInt("MaQuyen")
                );
                accounts.add(account);
            }
        }
        return accounts;
    }
    public List<Account_DTO> getAllAccountsWithRole() throws SQLException {
        
    List<Account_DTO> accounts = new ArrayList<>();
    String sql = "SELECT T.TaiKhoanID, T.MaNV, NV.HoTen AS TenNhanVien, T.TenDangNhap, T.MatKhau, P.TenQuyen " +
                 "FROM TAIKHOAN T " +
                 "JOIN NHANVIEN NV ON T.MaNV = NV.MaNV " +
                 "JOIN PHANQUYEN P ON T.MaQuyen = P.MaQuyen";
    try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Account_DTO account = new Account_DTO(
                rs.getInt("TaiKhoanID"),
                rs.getInt("MaNV"),
                rs.getString("TenNhanVien"),
                rs.getString("TenDangNhap"),
                rs.getString("TenQuyen"),
                rs.getString("MatKhau")
            );
            accounts.add(account);
        }
    }
    return accounts;
}
    public Account_DTO getAccountByMaNV(int maNV) {
    String sql = "SELECT * FROM TAIKHOAN WHERE MaNV = ?";
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setInt(1, maNV);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Account_DTO(
                rs.getInt("TaiKhoanID"),
                rs.getInt("MaNV"),
                rs.getString("TenDangNhap"),
                rs.getString("MatKhau"),
                rs.getInt("MaQuyen")
            );
        }
    } catch (SQLException e) {
    }
    return null;
}



    // Thêm tài khoản mới
    public boolean addAccount(Account_DTO acc) {
    String sql = "INSERT INTO TAIKHOAN (TaiKhoanID, MaNV, TenDangNhap, MatKhau, MaQuyen) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setInt(1, acc.getTaiKhoanID());
        stmt.setInt(2, acc.getIDNV());
        stmt.setString(3, acc.getTenDangNhap());
        stmt.setString(4, acc.getMatKhau());
        stmt.setInt(5, acc.getMaQuyen());

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();  // In ra lỗi để kiểm tra chi tiết
        return false;
    }
}


    // Cập nhật thông tin tài khoản
    public boolean updateAccount(Account_DTO account) throws SQLException {
        String sql = "UPDATE TAIKHOAN SET TenDangNhap = ?, MatKhau = ?, MaQuyen = ? WHERE TaiKhoanID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, account.getTenDangNhap());
            pstmt.setString(2, account.getMatKhau());
            pstmt.setInt(3, account.getMaQuyen());
            pstmt.setInt(4, account.getTaiKhoanID());
            return pstmt.executeUpdate() > 0;
        }
    }
    
    public boolean updateAccountPass(int id, String mk) throws SQLException {
        String sql = "UPDATE TAIKHOAN SET MatKhau = ? WHERE MaNV = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, mk);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        }
    }

    // Xóa tài khoản
    public boolean deleteAccount(int taiKhoanID) throws SQLException {
        String sql = "DELETE FROM TAIKHOAN WHERE TaiKhoanID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, taiKhoanID);
            return pstmt.executeUpdate() > 0;
        }
    }
    public Account_DTO getAccountByUsernameAndPassword(String tenTK, String matKhau) throws SQLException {
        String sql = "SELECT * FROM TAIKHOAN WHERE TenDangNhap = ? AND MatKhau = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, tenTK);
            stmt.setString(2, matKhau);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Account_DTO(
                    rs.getInt("TaiKhoanID"),
                    rs.getInt("MaNV"),
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau"),
                    rs.getInt("MaQuyen")
                );
            }
        }
        return null;
    }
    public int generateAccountID() {
        int newID = 1;
        String sql = "SELECT MAX(TaiKhoanID) FROM TAIKHOAN";
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
    
    public int getIDTKbyIDNV(int idnv) {
        String sql = "SELECT TaiKhoanID FROM TAIKHOAN WHERE MaNV=?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idnv);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return 0;
    } 
    
    private static final String FIND_ACCOUNT_QUERY = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";

    public Account_DTO authenticate(String username, String password) {
        try (
            PreparedStatement statement = con.prepareStatement(FIND_ACCOUNT_QUERY)) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("TaiKhoanID");
                    int idNV = resultSet.getInt("MaNV");
                    String tenDangNhap = resultSet.getString("TenDangNhap");
                    String matKhau = resultSet.getString("MatKhau");
                    int maQuyen = resultSet.getInt("MaQuyen");

                    return new Account_DTO(id, idNV, tenDangNhap, matKhau, maQuyen);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

