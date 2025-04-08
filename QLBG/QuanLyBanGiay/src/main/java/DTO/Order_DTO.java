
package DTO;

import java.sql.Date;


public class Order_DTO{
    String MaDH;
    String TenKH;
    Date NgayLap;
    float ThanhTien;
    boolean TrangThai;
    
    public Order_DTO()
    {}

    public Order_DTO(String MaDH, String TenKH, Date NgayLap, float ThanhTien, boolean TrangThai) {
        this.MaDH = MaDH;
        this.TenKH = TenKH;
        this.NgayLap = NgayLap;
        this.ThanhTien = ThanhTien;
        this.TrangThai = TrangThai;
    }

    public String getMaHD() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getTenKH() {
        return TenKH;
    } 

    public void setTenKH (String TenKH) {
        this.TenKH = TenKH;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap (Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien (float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public boolean getTrangThai () {
        return TrangThai;
    }

    public void setTrangThai (boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    
    
    
}

