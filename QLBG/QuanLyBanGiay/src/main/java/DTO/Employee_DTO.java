
package DTO;

import java.sql.Date;


public class Employee_DTO{
    int MaNV;
    String HoTen;
    Date NgaySinh;
    String GioiTinh;
    String SDT;
    int MaCapBac;
    
    public Employee_DTO()
    {}

    public Employee_DTO(int MaNV, int MaCapBac, String HoTen, Date  NgaySinh, String GioiTinh, String SDT) {
        this.MaNV = MaNV;
        this.MaCapBac = MaCapBac;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
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

    public int getMaCapBac() {
        return MaCapBac;
    }

    public void setMaCapBac(int MaCapBac) {
        this.MaCapBac = MaCapBac;
    }



    
    
    
}
