/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Mai
 */
public class GoodRecipe_DTO {
    private int MaPN;
    private int MaNCC;
    private Date NgLap;
    
    public GoodRecipe_DTO()
    {
    }

    public GoodRecipe_DTO(int MaPN, int MaNCC, Date NgLap) {
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.NgLap = NgLap;
    }

    public int getMaPN() {
        return MaPN;
    }

    public void setMaPN(int MaPN) {
        this.MaPN = MaPN;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

    public Date getNgLap() {
        return NgLap;
    }

    public void setNgLap(Date NgLap) {
        this.NgLap = NgLap;
    }
    
    
}
