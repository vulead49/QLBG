/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Anh
 */
import DAO.Schedule_DAO;
import DTO.Schedule_DTO;
import GUI.MyDialog;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Schedule_BUS {
    Schedule_DAO scheduleDAO = new Schedule_DAO();

    public boolean addSchedule(String MaNV, Date ngay, String giobd, String giokt) throws SQLException {
        try {
            int maNV = Integer.parseInt(MaNV);
            if (ngay == null) {
                new MyDialog("Ngày không được để rỗng!", MyDialog.ERROR_DIALOG);
                return false;
            }
            if (giobd.trim().equals("")) {
                new MyDialog("Giờ bắt đầu không được để rỗng!", MyDialog.ERROR_DIALOG);
                return false;
            }
            if (giokt.trim().equals("")) {
                new MyDialog("Giờ kết thúc không được để rỗng!", MyDialog.ERROR_DIALOG);
                return false;
            }
            
            Schedule_DTO sch = new Schedule_DTO();
            int ma=generateID();
            sch.setMaCaLam(ma);
            sch.setMaNV(maNV);
//            // Chuyển đổi giờ từ định dạng HH:mm:ss sang định dạng số nguyên
//            int hourBD = Integer.parseInt(giobd.split(":")[0]); // Lấy phần giờ
//            int minuteBD = Integer.parseInt(giobd.split(":")[1]); // Lấy phần phút
//            int hourKT = Integer.parseInt(giokt.split(":")[0]); // Lấy phần giờ
//            int minuteKT = Integer.parseInt(giokt.split(":")[1]); // Lấy phần phút
//
//            // Tạo số nguyên từ giờ và phút
//            int gioBD = hourBD * 100 + minuteBD; // Ví dụ: 12:45 -> 1245
//            int gioKT = hourKT * 100 + minuteKT;// Ví dụ: 8:30 -> 830
//            giobd = Integer.toString(gioBD);
//            giokt = Integer.toString(gioKT);
            String formattedGioBD = formatTime(giobd);
            String formattedGioKT = formatTime(giokt);
            if (formattedGioBD == null) {
                new MyDialog("Giờ bắt đầu không hợp lệ!", MyDialog.ERROR_DIALOG);
                return false;
            }
        
            if (formattedGioKT == null) {
                new MyDialog("Giờ kết thúc không hợp lệ!", MyDialog.ERROR_DIALOG);
                return false;
            }
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date sqlDate = new java.sql.Date(ngay.getTime());
             // Chuyển đổi sang java.sql.Date     
             
            // Chuyển đổi giờ
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); // Định dạng giờ
            Time timeStart = new Time(timeFormat.parse(formattedGioBD).getTime());
            Time timeEnd = new Time(timeFormat.parse(formattedGioKT).getTime());
            
            // Kiểm tra giờ bắt đầu phải sớm hơn giờ kết thúc
            if (timeStart.after(timeEnd)) {
                new MyDialog("Giờ bắt đầu phải sớm hơn giờ kết thúc!", MyDialog.ERROR_DIALOG);
                return false;
            }

            sch.setNgayLamViec(sqlDate);
            sch.setGioBatDau(timeStart); // Lưu giờ bắt đầu
            sch.setGioKetThuc(timeEnd); // Lưu giờ kết thúc
            sch.setDuyet(false);
            if (scheduleDAO.isTimesheetOverlapping(sch)) {
                new MyDialog("Lịch làm mới bị trùng giờ!", MyDialog.ERROR_DIALOG);
                return false;
            }
            if (scheduleDAO.addSchedule(sch)) {
                new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Schedule_BUS.class.getName()).log(Level.SEVERE, null, ex);
            new MyDialog("Định dạng ngày hoặc giờ không hợp lệ!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
    
    public int generateID(){
        return scheduleDAO.generateID();
    }
    

    public List<Schedule_DTO> getAllSchedules() throws SQLException {
        return scheduleDAO.getAllSchedules();
    }
    
//    public List<Schedule_DTO> selectScheduleByDate(Date ngay) throws SQLException {
//        return scheduleDAO.selectScheduleByDate(ngay);
//    }
    

    public boolean updateSchedule(int ma,String MaNV, Date ngay, String giobd, String giokt, boolean Duyet) throws SQLException {
        try {
            int maNV = Integer.parseInt(MaNV);
            if (Duyet == true){
                new MyDialog("Lịch làm đã duyệt không được sửa!", MyDialog.ERROR_DIALOG);
                return false;
            }
                
            if (giobd.trim().equals("")) {
                new MyDialog("Giờ bắt đầu không được để rỗng!", MyDialog.ERROR_DIALOG);
                return false;
            }
            if (giokt.trim().equals("")) {
                new MyDialog("Giờ kết thúc không được để rỗng!", MyDialog.ERROR_DIALOG);
                return false;
            }
            Schedule_DTO sch = new Schedule_DTO();
             sch.setMaCaLam(ma);
             sch.setMaNV(maNV);
//             // Chuyển đổi giờ từ định dạng HH:mm:ss sang định dạng số nguyên
//            int hourBD = Integer.parseInt(giobd.split(":")[0]); // Lấy phần giờ
//            int minuteBD = Integer.parseInt(giobd.split(":")[1]); // Lấy phần phút
//            int hourKT = Integer.parseInt(giokt.split(":")[0]); // Lấy phần giờ
//            int minuteKT = Integer.parseInt(giokt.split(":")[1]); // Lấy phần phút
//
//            // Tạo số nguyên từ giờ và phút
//            int gioBD = hourBD * 100 + minuteBD; // Ví dụ: 12:45 -> 1245
//            int gioKT = hourKT * 100 + minuteKT;// Ví dụ: 8:30 -> 830
//            giobd = Integer.toString(gioBD);
//            giokt = Integer.toString(gioKT);
            String formattedGioBD = formatTime(giobd);
            String formattedGioKT = formatTime(giokt);
        
            if (formattedGioBD == null) {
                new MyDialog("Giờ bắt đầu không hợp lệ!", MyDialog.ERROR_DIALOG);
                return false;
            }
        
            if (formattedGioKT == null) {
                new MyDialog("Giờ kết thúc không hợp lệ!", MyDialog.ERROR_DIALOG);
                return false;
            }
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date sqlDate = new java.sql.Date(ngay.getTime());
             // Chuyển đổi sang java.sql.Date     
             
            // Chuyển đổi giờ
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); // Định dạng giờ
            Time timeStart = new Time(timeFormat.parse(formattedGioBD).getTime());
            Time timeEnd = new Time(timeFormat.parse(formattedGioKT).getTime());
            
            // Kiểm tra giờ bắt đầu phải sớm hơn giờ kết thúc
            if (timeStart.after(timeEnd)) {
                new MyDialog("Giờ bắt đầu phải sớm hơn giờ kết thúc!", MyDialog.ERROR_DIALOG);
                return false;
            }

            sch.setNgayLamViec(sqlDate);
            sch.setGioBatDau(timeStart); // Lưu giờ bắt đầu
            sch.setGioKetThuc(timeEnd); // Lưu giờ kết thúc
            sch.setDuyet(Duyet);
            if (scheduleDAO.updateSchedule(sch)) {
                new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
        }catch (ParseException ex) {
            Logger.getLogger(Schedule_BUS.class.getName()).log(Level.SEVERE, null, ex);
            new MyDialog("Định dạng ngày hoặc giờ không hợp lệ!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
    
    public boolean check(int maCalam) throws SQLException {
        if (scheduleDAO.check(maCalam)) {
                new MyDialog("Duyệt thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Duyệt thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
    }

    public boolean deleteSchedule(int maCaLam) throws SQLException {
        if (scheduleDAO.checkDuyet(maCaLam)) {
            new MyDialog("Lịch làm đã duyệt không thể xóa!", MyDialog.ERROR_DIALOG);
                return false;
        }
        if (scheduleDAO.deleteSchedule(maCaLam)) {
                new MyDialog("Xóa thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Xóa thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
    }
    
    public void loadScheduleDataToTable(JTable table) {
        try {
        // Xóa dữ liệu cũ
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Lấy dữ liệu từ DAO và thêm vào bảng

            List<Schedule_DTO> schedules = scheduleDAO.getAllSchedules(); // Lấy danh sách lịch làm việc
            for (Schedule_DTO schedule : schedules) {
                String tenNV = scheduleDAO.getTenNV(schedule.getMaNV()); // Lấy tên NV
                Object[] rowData = {
                    schedule.getMaCaLam(),
                    schedule.getMaNV(),
                    tenNV,
                    schedule.getNgayLamViec(),
                    schedule.getGioBatDau(),
                    schedule.getGioKetThuc(),
                    schedule.isDuyet()
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
        }
    }
    
    public void loadScheduleDataToTableNV(JTable table) {
        try {
        // Xóa dữ liệu cũ
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Lấy dữ liệu từ DAO và thêm vào bảng

            List<Schedule_DTO> schedules = scheduleDAO.getAllSchedulesNV(); // Lấy danh sách lịch làm việc
            for (Schedule_DTO schedule : schedules) {
                String tenNV = scheduleDAO.getTenNV(schedule.getMaNV()); // Lấy tên NV
                Object[] rowData = {
                    schedule.getMaCaLam(),
                    schedule.getMaNV(),
                    tenNV,
                    schedule.getNgayLamViec(),
                    schedule.getGioBatDau(),
                    schedule.getGioKetThuc(),
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
        }
    }
    
    public void loadScheduleDataToTableNV1(JTable table, int id) {
        try {
        // Xóa dữ liệu cũ
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Lấy dữ liệu từ DAO và thêm vào bảng

            List<Schedule_DTO> schedules = scheduleDAO.selectScheduleByMaNV(id); // Lấy danh sách lịch làm việc
            for (Schedule_DTO schedule : schedules) { // Lấy tên NV
            // Lấy tên NV
                Object[] rowData = {
                    schedule.getMaCaLam(),
                    schedule.getNgayLamViec(),
                    schedule.getGioBatDau(),
                    schedule.getGioKetThuc(),
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void loadScheduleDataToTableByDate(JTable table, Date ngay) throws SQLException {
        // Xóa dữ liệu cũ
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // Lấy dữ liệu từ DAO và thêm vào bảng
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = new java.sql.Date(ngay.getTime());
        List<Schedule_DTO> schedules = scheduleDAO.selectScheduleByDate(sqlDate); // Lấy danh sách lịch làm việc
        for (Schedule_DTO schedule : schedules) {
            String tenNV = scheduleDAO.getTenNV(schedule.getMaNV()); // Lấy tên NV
            Object[] rowData = {
                schedule.getMaCaLam(),
                schedule.getMaNV(),
                tenNV,
                schedule.getNgayLamViec(),
                schedule.getGioBatDau(),
                schedule.getGioKetThuc(),
                schedule.isDuyet()
            };
            model.addRow(rowData);
        }
    }
    
    public String getTenNV(int maNV){
        return scheduleDAO.getTenNV(maNV);
    }
    
    private String formatTime(String input) {
    try {
        int hour, minute;
        switch (input.length()) {
            case 1 -> {
                // Nhập vào 1 chữ số (ví dụ: 8)
                hour = Integer.parseInt(input);
                minute = 0;
            }
            case 2 -> {
                // Nhập vào 2 chữ số (ví dụ: 25)
                hour = Integer.parseInt(input);
                minute = 0;
            }
            case 3 -> {
                // Nhập vào 3 chữ số (ví dụ: 845)
                hour = Integer.parseInt(input.substring(0, 1));
                minute = Integer.parseInt(input.substring(1, 3));
            }
            case 4 -> {
                // Nhập vào 4 chữ số (ví dụ: 1245)
                hour = Integer.parseInt(input.substring(0, 2));
                minute = Integer.parseInt(input.substring(2, 4));
            }
            default -> {
                hour = Integer.parseInt(input.split(":")[0]); // Lấy phần giờ
                minute = Integer.parseInt(input.split(":")[1]); // Lấy phần phút
            }
        }

        // Kiểm tra tính hợp lệ của giờ và phút
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            return null; // Không hợp lệ
        }

        // Trả về định dạng HH:mm:ss
        return String.format("%02d:%02d:00", hour, minute);
    } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
         return null;
    }
    }
    
    public List<Schedule_DTO> fetchScheduleForEmployee(int employeeId, int month, int year) throws SQLException{
        if (month<1 || month>12) {
                new MyDialog("Tháng không hợp lệ!", MyDialog.ERROR_DIALOG);
                return null;
            }
        if (year<2000 || year>2050) {
                new MyDialog("Năm không hợp lệ!", MyDialog.ERROR_DIALOG);
                return null;
            }
        return scheduleDAO.fetchScheduleForEmployee(employeeId, month, year);
    }
    

}
