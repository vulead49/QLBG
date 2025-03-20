/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author tranl
 */
public class Account_DTO {
    String MaTK;
    String MaNV;
    String TenTK;
    String LoaiTK;
    String MatKhau;
    
    
    public Account_DTO(){}

    public Account_DTO(String MaTK, String MaNV, String TenTK, String LoaiTK, String MatKhau) {
        this.MaTK = MaTK;
        this.MaNV = MaNV;
        this.TenTK = TenTK;
        this.LoaiTK = LoaiTK;
        this.MatKhau = MatKhau;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getLoaiTK() {
        return LoaiTK;
    }

    public void setLoaiTK(String LoaiTK) {
        this.LoaiTK = LoaiTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
}
