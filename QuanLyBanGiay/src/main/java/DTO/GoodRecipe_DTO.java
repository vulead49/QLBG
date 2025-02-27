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
    private String MaPN;
    private String MaNCC;
    private Date NgLap;
    
    public GoodRecipe_DTO()
    {
    }

    public GoodRecipe_DTO(String MaPN, String MaNCC, Date NgLap) {
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.NgLap = NgLap;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public Date getNgLap() {
        return NgLap;
    }

    public void setNgLap(Date NgLap) {
        this.NgLap = NgLap;
    }
    
    
}
