/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Anh
 */
public class Account_DTO {
    private int ID;
    private int IDNV;
    private String tenDangNhap;
    private String matKhau;
    private int maQuyen;
    private String tenQuyen;
    private String tenNV;
            

    // Constructor không tham số
    public Account_DTO() {
    }

    // Constructor đầy đủ tham số
    public Account_DTO(int ID, int IDNV, String tenDangNhap, String matKhau, int maQuyen) {
        this.ID = ID;
        this.IDNV = IDNV;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maQuyen = maQuyen;
    }

    public Account_DTO(int ID, int IDNV, String tenNV, String tenDangNhap, String tenQuyen, String matKhau) {
        this.ID = ID;
        this.IDNV = IDNV;
        this.tenNV = tenNV;
        this.tenDangNhap = tenDangNhap;
        this.tenQuyen = tenQuyen;
        this.matKhau = matKhau;
    }

    // Getter và Setter
    public int getTaiKhoanID() {
        return ID;
    }

    public void setTaiKhoanID(int ID) {
        this.ID = ID;
    }
    public int getIDNV() {
        return IDNV;
    }

    public void setIDNV(int IDNV) {
        this.IDNV = IDNV;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }
    public String getTenQuyen() {
        return tenQuyen;
    }

    public void seTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }
    public String getTenNV() {
        return tenNV;
    }

    public void seTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
}
