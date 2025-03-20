/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Anh
 */
public class Schedule_DTO {
    private int maCaLam;
    private int maNV;
    private Date ngayLamViec;
    private Time gioBatDau;
    private Time gioKetThuc;
    private boolean duyet;
    
    public Schedule_DTO(){};

    // Constructor
    public Schedule_DTO(int maCaLam, int maNV, Date ngayLamViec, Time gioBatDau, Time gioKetThuc, boolean duyet) {
        this.maCaLam = maCaLam;
        this.maNV = maNV;
        this.ngayLamViec = ngayLamViec;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.duyet = duyet;
    }

    // Getters and Setters
    public int getMaCaLam() {
        return maCaLam;
    }

    public void setMaCaLam(int maCaLam) {
        this.maCaLam = maCaLam;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(Date ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public Time getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(Time gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Time getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Time gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public boolean isDuyet() {
        return duyet;
    }

    public void setDuyet(boolean duyet) {
        this.duyet = duyet;
    }
}

