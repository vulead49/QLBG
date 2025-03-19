    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.math.BigDecimal;

/**
 * Lớp đại diện cho bảng lương
 */
public class Payroll_DTO {
    private int stt;               // Số thứ tự
    private int maNV;              // Mã nhân viên
    private int thang;             // Tháng
    private int nam;               // Năm
    private int soNgayNghi;        // Số ngày nghỉ
    private BigDecimal luong;      // Lương

    // Constructor không tham số
    public Payroll_DTO() {}

    // Constructor có tham số
    public Payroll_DTO(int stt, int maNV, int thang, int nam, int soNgayNghi, BigDecimal luong) {
        this.stt = stt;
        this.maNV = maNV;
        this.thang = thang;
        this.nam = nam;
        this.soNgayNghi = soNgayNghi;
        this.luong = luong;
    }

    // Getter và Setter
    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public BigDecimal getLuong() {
        return luong;
    }

    public void setLuong(BigDecimal luong) {
        this.luong = luong;
    }
}

