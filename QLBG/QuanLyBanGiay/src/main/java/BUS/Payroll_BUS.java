/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DayOff_DAO;
import DAO.Hierarchy_DAO;
import DAO.Payroll_DAO;
import DTO.Hierarchy_DTO;
import DTO.Payroll_DTO;
import DTO.Schedule_DTO;
import GUI.MyDialog;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Payroll_BUS {
    Payroll_DAO payrollDAO = new Payroll_DAO();
    Hierarchy_DAO hierarchyDAO = new Hierarchy_DAO();
    DayOff_DAO day = new DayOff_DAO();


    public void createPayroll(Payroll_DTO payroll) throws SQLException {
        // Có thể thêm logic nghiệp vụ ở đây trước khi gọi DAO
        payrollDAO.addPayroll(payroll);
    }

    public List<Payroll_DTO> getAllPayrolls() throws SQLException {
        return payrollDAO.getAllPayrolls();
    }
    
    public List<Payroll_DTO> getAllPayrollsNV(int idnv) throws SQLException {
        return payrollDAO.getAllPayrollsNV(idnv);
    }
    
    public List<Integer> getAllYearsWithPayroll(int idnv) throws SQLException {
        return payrollDAO.getAllYearsWithPayroll(idnv);
    }
    
    public List<Payroll_DTO> getPayrollsNVbyYear(int id, int nam) throws SQLException {
        return payrollDAO.getPayrollsNVbyYear(id, nam);
    }
    
    public Payroll_DTO getPayrollsNV(int idnv, int thang, int nam) throws SQLException {
        return payrollDAO.getPayrollsNV(idnv, thang, nam);
    }
    
    public void calculateSalaryBasedOnRank(List<Schedule_DTO> scheduleList, List<Hierarchy_DTO> hierarchyList, int employeeId, int thang, int nam) throws SQLException {
        BigDecimal salary;
        long durationInMillis=0;
        int rankId = payrollDAO.getEmployeeRank(employeeId); // Gọi DAO để lấy rank ID
        Hierarchy_DTO hierarchy = payrollDAO.getRankById(rankId, hierarchyList); // Gọi DAO để lấy thông tin cấp bậc   
        int songaynghi= day.tinhngaynghi(thang, nam, employeeId);
        if (hierarchy.getBaseSalary().compareTo(BigDecimal.ZERO) > 0) {
            // Lương cố định
            int count = scheduleList.size();            
            BigDecimal daysWorked = BigDecimal.valueOf(count + songaynghi);
            BigDecimal dailySalary = hierarchy.getBaseSalary().divide(BigDecimal.valueOf(30), 2, RoundingMode.HALF_UP);
            salary = dailySalary.multiply(daysWorked);
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
        payroll.setSoNgayNghi(songaynghi);
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
//            new MyDialog("Bảng lương đã tồn tại!", MyDialog.ERROR_DIALOG);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean updatePayrollBySchedule(List<Schedule_DTO> scheduleList, List<Hierarchy_DTO> hierarchyList, int employeeId, int thang, int nam) throws SQLException{
        BigDecimal salary;
        long durationInMillis=0;
        int rankId = payrollDAO.getEmployeeRank(employeeId); // Gọi DAO để lấy rank ID
        Hierarchy_DTO hierarchy = payrollDAO.getRankById(rankId, hierarchyList); // Gọi DAO để lấy thông tin cấp bậc                                
        if (hierarchy.getBaseSalary().compareTo(BigDecimal.ZERO) > 0) {
            // Lương cố định
            int count = scheduleList.size();
            int songaynghi= day.tinhngaynghi(thang, nam, employeeId);
            BigDecimal daysWorked = BigDecimal.valueOf(count + songaynghi);
            BigDecimal dailySalary = hierarchy.getBaseSalary().divide(BigDecimal.valueOf(30), 2, RoundingMode.HALF_UP);
            salary = dailySalary.multiply(daysWorked);
        } else {
        for (Schedule_DTO schedule : scheduleList) {  
                // Lương theo giờ
                durationInMillis = durationInMillis + schedule.getGioKetThuc().getTime() - schedule.getGioBatDau().getTime();           
        }
            long durationInHours = durationInMillis / (1000 * 60 * 60); // Chuyển đổi sang giờ  
            long durationInWholeHours = (long) Math.floor(durationInHours); // Lấy phần nguyên của số giờ
            BigDecimal salaryForWholeHours = hierarchy.getHourlySalary().multiply(BigDecimal.valueOf(durationInWholeHours));
            BigDecimal salaryForFractionalHours = hierarchy.getHourlySalary().multiply(BigDecimal.valueOf(durationInHours - durationInWholeHours));
            salary = salaryForWholeHours.add(salaryForFractionalHours);
        }            
        if (payrollDAO.updatePayroll(employeeId, thang, nam , salary)) {
            new MyDialog("Sửa lương thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        } else {
            new MyDialog("Sửa lương thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
    
    public boolean updateDayoffPayroll(int id, int thang, int nam, int snn){
        if (payrollDAO.updateDayoffPayroll(id, thang, nam, snn)) {
            new MyDialog("Cập nhật số ngày nghỉ thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        } else {
            new MyDialog("Cập nhật số ngày nghỉ thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
    
//    public 

    // Các phương thức khác như UpdatePayroll, DeletePayroll...
}
