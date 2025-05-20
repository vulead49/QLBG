/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Payment_DAO;
import DTO.Payment_DTO;
import java.util.List;

/**
 *
 * @author Anh
 */
public class Payment_BUS {
    private final Payment_DAO paymentDAO = new Payment_DAO();

    public List<Payment_DTO> getAllPayments() {
        return paymentDAO.getAllPayments();
    }

    public boolean addPayment(Payment_DTO payment) {
        return paymentDAO.addPayment(payment);
    }

    public boolean updatePayment(Payment_DTO payment) {
        return paymentDAO.updatePayment(payment);
    }

    public boolean deletePayment(int madh) {
        return paymentDAO.deletePayment(madh);
    }
    
    public int generateID(){
        return paymentDAO.generateID();
    }
    
    public Payment_DTO findPaymentByMaDH(int maDH) {
        return paymentDAO.findPaymentByMaDH(maDH);
    }
}
