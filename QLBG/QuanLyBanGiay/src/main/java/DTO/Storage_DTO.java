/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Mai
 */
public class Storage_DTO {
    private int maSP;
    private String tenSP;
    private String hang;
    private String loai;
    private int size ;
    private int sl;
    private float gia;
    
    public Storage_DTO(){}
    
    public Storage_DTO(int maSP, String tenSP, String hang, String loai, int size, int sl, float gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.hang = hang;
        this.loai = loai;
        this.size = size;
        this.sl = sl;
        this.gia = gia;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    
}
