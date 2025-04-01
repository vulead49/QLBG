/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Anh
 */
public class OrderDetails_DTO{
    int MaCTDH;
    int MaDH;
    int MaSP;
    int SoLuong;
    double GiaBan;
    
    public OrderDetails_DTO()
    {}

    public OrderDetails_DTO(int MaCTDH, int MaDH, int MaSP, int SoLuong, double GiaBan) {
        this.MaCTDH = MaCTDH;
        this.MaDH = MaDH;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
    }
    
    public int getMaCTDH() {
        return MaCTDH;
    }

    public int getMaDH() {
        return MaDH;
    }

    public int getMaSP() {
        return MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public double getGiaBan() {
        return GiaBan;
    }
    
    public void setMaCTDH(int MaCTDH) {
        this.MaCTDH = MaCTDH;
    }

    public void setMaDH(int MaDH) {
        this.MaDH = MaDH;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

}
