
package DTO;

import java.sql.Date;


public class Employee_DTO{
    String MaNV;
    String HoTen;
    Date NgaySinh;
    String GioiTinh;
    String SDT;
    String MaCapBac;
    
    public Employee_DTO()
    {}

    public Employee_DTO(String MaNV, String MaCapBac, String HoTen, Date  NgaySinh, String GioiTinh, String SDT) {
        this.MaNV = MaNV;
        this.MaCapBac = MaCapBac;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMaCapBac() {
        return MaCapBac;
    }

    public void setMaCapBac(String MaCapBac) {
        this.MaCapBac = MaCapBac;
    }



    
    
    
}
