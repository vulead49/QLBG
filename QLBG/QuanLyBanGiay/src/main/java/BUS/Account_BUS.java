/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Account_DAO;
import DTO.Account_DTO;
import java.util.Vector;

/**
 *
 * @author tranl
 */
public class Account_BUS {
    Account_DAO tkDAO = new Account_DAO();
    
    public Vector<Account_DTO> getALLtk()
    {
        return tkDAO.getALLtk();
    }
    public String addTK(Account_DTO tk) {

        // Gửi xuống DAO để thêm vào DB
        if (tkDAO.addTK(tk)) {
            return "Thêm thành công!";
        }
        return "Thêm thất bại! ";
    }
    
    public int generateMaTK() {
        int lastMaTK = tkDAO.getLastMaTK();
    return lastMaTK + 1; // Mã mới là số lớn nhất + 1
    }
    public String deleteTK (String id)
    {
        if (tkDAO.delTK(id) == 1)
        {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }
    public String updateTK (Account_DTO tk)
    {
        if (tkDAO.editTK(tk)==1)
        {
            return "Cập nhật thành công";
        }
        return "Cập nhật thất bại";
    }
}
