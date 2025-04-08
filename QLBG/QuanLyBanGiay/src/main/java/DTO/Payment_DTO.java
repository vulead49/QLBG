/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Time;

/**
 *
 * @author Anh
 */
public class Payment_DTO {
    private int maTT;
    private int maDH;
    private String hinhThucTT;
    private Time thoiGian;

    public Payment_DTO() {}

    public Payment_DTO(int maTT, int maDH, String hinhThucTT, Time thoiGian) {
        this.maTT = maTT;
        this.maDH = maDH;
        this.hinhThucTT = hinhThucTT;
        this.thoiGian = thoiGian;
    }

    public int getMaTT() {
        return maTT;
    }

    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public String getHinhThucTT() {
        return hinhThucTT;
    }

    public void setHinhThucTT(String hinhThucTT) {
        this.hinhThucTT = hinhThucTT;
    }

    public Time getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Time thoiGian) {
        this.thoiGian = thoiGian;
    }
}

