/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


public class Supplier_DTO {
    private String MaNCC;
    private String tenNCC; 
    private String DiaChi;
    private String SDT;
    
    public  Supplier_DTO()
    {
    }

    public Supplier_DTO(String MaNCC, String tenNCC, String DiaChi, String SDT) {
        this.MaNCC = MaNCC;
        this.tenNCC = tenNCC;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
    
}
