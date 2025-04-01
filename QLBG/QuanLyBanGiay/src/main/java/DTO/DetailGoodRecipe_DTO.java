/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Mai
 */
public class DetailGoodRecipe_DTO {
    private int MaPN ;
    private int MaSP ;
    private String tenSP ;
    private int sl ;
    private String Hang ;
    private String Loai ;
    private int Size ;
    private float GiaNhap ;
    
    
    public DetailGoodRecipe_DTO ()
    {
    }

    public DetailGoodRecipe_DTO(int MaPN, int MaSP, String tenSP, int sl, String Hang, String Loai, int Size, float GiaNhap) {
        this.MaPN = MaPN;
        this.MaSP = MaSP;
        this.tenSP = tenSP;
        this.sl = sl;
        this.Hang = Hang;
        this.Loai = Loai;
        this.Size = Size;
        this.GiaNhap = GiaNhap;
        
    }

    public int getMaPN() {
        return MaPN;
    }

    public void setMaPN(int MaPN) {
        this.MaPN = MaPN;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    
    
    
}
