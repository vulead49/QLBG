
package DTO;

import java.sql.Date;


public class Order_DTO{
    String MaDH;
    String TenKH;
    Date NgayLap;
    float ThanhTien;
    String PhuongThuc;
    
    public Order_DTO()
    {}

    public Order_DTO(String MaDH, String TenKH, Date NgayLap, float ThanhTien, String PhuongThuc) {
        this.MaDH = MaDH;
        this.TenKH = TenKH;
        this.NgayLap = NgayLap;
        this.ThanhTien = ThanhTien;
        this.PhuongThuc = PhuongThuc;
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

    public String getPhuongThuc () {
        return PhuongThuc;
    }

    public void setPhuongThuc (String PhuongThuc) {
        this.PhuongThuc = PhuongThuc;
    }

    
    
    
}

