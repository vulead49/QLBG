
package DTO;


public class Employee_DTO{
    String MaNV;
    String HoTen;
    String NgaySinh;
    Boolean GioiTinh;
    String SDT;
    Boolean CapBac;
    
    public Employee_DTO()
    {}

    public Employee_DTO(String MaNV, String HoTen, String NgaySinh, Boolean GioiTinh, String SDT, Boolean CapBac) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.CapBac = CapBac;
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

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Boolean getCapBac() {
        return CapBac;
    }

    public void setCapBac(Boolean CapBac) {
        this.CapBac = CapBac;
    }
    
    
    
}
