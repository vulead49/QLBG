/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Anh
 */
public class DayOff_DTO {
    private int STT;
    private Date NgayNghi;
    private int MaNV;
    private String LyDo;
    private boolean Duyet;

    // Getters và Setters
    public int getSTT() { return STT; }
    public void setSTT(int STT) { this.STT = STT; }

    public Date getNgayNghi() { return NgayNghi; }
    public void setNgayNghi(Date NgayNghi) { this.NgayNghi = NgayNghi; }

    public int getMaNV() { return MaNV; }
    public void setMaNV(int MaNV) { this.MaNV = MaNV; }

    public String getLyDo() { return LyDo; }
    public void setLyDo(String LyDo) { this.LyDo = LyDo; }

    public boolean isDuyet() { return Duyet; }
    public void setDuyet(boolean Duyet) { this.Duyet = Duyet; }
}
