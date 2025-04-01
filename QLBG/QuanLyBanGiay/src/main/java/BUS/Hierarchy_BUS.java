/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Hierarchy_DAO;
import DTO.Hierarchy_DTO;
import java.sql.SQLException;

/**
 *
 * @author Anh
 */
public class Hierarchy_BUS {
    Hierarchy_DAO hieDAO = new Hierarchy_DAO();
    
    public Hierarchy_DTO fetchHierarchyDatabyID(int id) throws SQLException {
        return hieDAO.fetchHierarchyDatabyID(id);
    }
    
    public String getTenCapBac(int macapbac) {
        return hieDAO.getTenCapBac(macapbac);
    }
}
