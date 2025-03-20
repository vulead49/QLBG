/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Hierarchy_DAO;
import DAO.Payroll_DAO;
import DTO.Hierarchy_DTO;
import DTO.Payroll_DTO;
import DTO.Schedule_DTO;
import GUI.MyDialog;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Payroll_BUS {
    Payroll_DAO payrollDAO = new Payroll_DAO();
    Hierarchy_DAO hierarchyDAO = new Hierarchy_DAO();


    public void createPayroll(Payroll_DTO payroll) throws SQLException {
        // Có thể thêm logic nghiệp vụ ở đây trước khi gọi DAO
        payrollDAO.addPayroll(payroll);
    }

    public List<Payroll_DTO> getAllPayrolls() throws SQLException {
        return payrollDAO.getAllPayrolls();
    }
    
    public void calculateSalaryBasedOnRank(List<Schedule_DTO> scheduleList, List<Hierarchy_DTO> hierarchyList, int employeeId, int thang, int nam) throws SQLException {
        BigDecimal salary;
        long durationInMillis=0;
        int rankId = payrollDAO.getEmployeeRank(employeeId); // Gọi DAO để lấy rank ID
        Hierarchy_DTO hierarchy = payrollDAO.getRankById(rankId, hierarchyList); // Gọi DAO để lấy thông tin cấp bậc                                
        if (hierarchy.getBaseSalary().compareTo(BigDecimal.ZERO) > 0) {
            // Lương cố định
            salary = hierarchy.getBaseSalary();
        } else {
        for (Schedule_DTO schedule : scheduleList) {  
                // Lương theo giờ
                durationInMillis = durationInMillis + schedule.getGioKetThuc().getTime() - schedule.getGioBatDau().getTime();           
        }
            long durationInHours = durationInMillis / (1000 * 60 * 60); // Chuyển đổi sang giờ  
            salary = hierarchy.getHourlySalary().multiply(BigDecimal.valueOf(durationInHours));
        }            
        // Tạo đối tượng Payroll_DTO
        Payroll_DTO payroll = new Payroll_DTO();
        int ma=generateID();
        payroll.setStt(ma);
        payroll.setMaNV(employeeId);
        payroll.setThang(thang);
        payroll.setNam(nam);
        payroll.setSoNgayNghi(0); // Giả định không có ngày nghỉ
        payroll.setLuong(salary);

        // Gọi DAO để thêm vào cơ sở dữ liệu
        if (payrollDAO.addPayroll(payroll)) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
            return;
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return;
        }        
    }
    
    public int generateID(){
        return payrollDAO.generateID();
    }
    
    public void loadPayrollDataToTable(JTable table) {
        try {
        // Xóa dữ liệu cũ
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Lấy dữ liệu từ DAO và thêm vào bảng

            List<Payroll_DTO> payrolls = payrollDAO.getAllPayrolls(); // Lấy danh sách lịch làm việc
            for (Payroll_DTO payroll : payrolls) {
                String tenNV = payrollDAO.getTenNV(payroll.getMaNV());// Lấy tên NV
                int maCapBac = payrollDAO.getMaCapBac(payroll.getMaNV());
                String capbac = hierarchyDAO.getTenCapBac(maCapBac);
                Object[] rowData = {
                    payroll.getStt(),
                    payroll.getMaNV(),
                    tenNV,
                    capbac,
                    payroll.getThang(),
                    payroll.getNam(),
                    payroll.getSoNgayNghi(),
                    payroll.getLuong()
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkPayrollExists(int id, int thang, int nam) throws SQLException{
        if (payrollDAO.checkPayrollExists(id, thang, nam)){
            new MyDialog("Bảng lương đã tồn tại!", MyDialog.ERROR_DIALOG);
            return true;
        } else {
            return false;
        }
    }
    
//    public 

    // Các phương thức khác như UpdatePayroll, DeletePayroll...
}
