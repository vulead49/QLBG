
package DTO;


public class Order_DTO{
    String MaDH;
    String TenKH;
    String NgayLap;
    float ThanhTien;
    String TrangThai;
    
    public Order_DTO()
    {}

    public Order_DTO(String MaDH, String TenKH, String NgayLap, float ThanhTien, String TrangThai) {
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

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap (String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien (float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getTrangThai () {
        return TrangThai;
    }

    public void setTrangThai (String TrangThai) {
        this.TrangThai = TrangThai;
    }

    
    
    
}
