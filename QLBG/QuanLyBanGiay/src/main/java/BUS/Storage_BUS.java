/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Storage_DAO;
import DTO.Storage_DTO;
import java.util.Vector;

/**
 *
 * @author Mai
 */
public class Storage_BUS {
    Storage_DAO khodao = new Storage_DAO();
    
    public Vector<Storage_DTO> getALLkho()
    {
        return khodao.getALLkho();
    }
}
