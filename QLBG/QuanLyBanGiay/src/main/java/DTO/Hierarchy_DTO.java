/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.math.BigDecimal;

/**
 * Class representing the Rank table
 */
public class Hierarchy_DTO {
    private int rankId;            // Rank ID
    private String rankName;       // Rank Name
    private BigDecimal baseSalary; // Base Salary
    private BigDecimal hourlySalary; // Hourly Salary

    // Default constructor
    public Hierarchy_DTO() {}

    // Parameterized constructor
    public Hierarchy_DTO(int rankId, String rankName, BigDecimal baseSalary, BigDecimal hourlySalary) {
        this.rankId = rankId;
        this.rankName = rankName;
        this.baseSalary = baseSalary;
        this.hourlySalary = hourlySalary;
    }

    // Getters and Setters
    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BigDecimal getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(BigDecimal hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}

