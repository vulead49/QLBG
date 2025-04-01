/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DayOff_DAO;
import DTO.DayOff_DTO;
import GUI.MyDialog;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mai
 */
public class DayOff_BUS {
    DayOff_DAO day = new DayOff_DAO();
    public boolean addDayOff(int idnv,String lydo, Date ngay) throws SQLException{
        int id = generateDayOffID(); 
        if (lydo.trim().equals("")) {
            new MyDialog("Lý do để trống!", MyDialog.WARNING_DIALOG);
        }
        if (ngay==null) {
            new MyDialog("Vui lòng chọn ngày!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (day.isKeyExists(idnv, ngay)) {
            new MyDialog("Ngày nghỉ đã tồn tại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        DayOff_DTO dto = new DayOff_DTO();
            dto.setSTT(generateDayOffID());
            dto.setMaNV(idnv);
            dto.setLyDo(lydo);
            dto.setNgayNghi(ngay);
            dto.setDuyet(false);
        if (day.insertDayOff(dto)) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
    
    public boolean deleteDayOff(int manv, Date ngay){
        if (ngay==null) {
            new MyDialog("Vui lòng chọn ngày!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (day.deleteDayOff(manv, ngay)) {
            new MyDialog("Xóa thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        } else {
            new MyDialog("Xóa thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
    
    public boolean deleteDayOffByID(int stt){
        if (day.deleteDayOffByID(stt)) {
            new MyDialog("Xóa thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        } else {
            new MyDialog("Xóa thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
    
    public int generateDayOffID(){
        return day.generateDayOffID();
    }
    
    public List<DayOff_DTO> getAllDayOffs() throws SQLException {
        return day.getAllDayOff();
    }
    
    public List<DayOff_DTO> getAllDayOffsByNV(int manv) throws SQLException {
        return day.getAllDayOffbyNV(manv);
    }
    
    
    public void loadDayOffNVDataToTable(JTable table, int id) {
        // Xóa dữ liệu cũ
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // Lấy dữ liệu từ DAO và thêm vào bảng
        
        List<DayOff_DTO> dayoffs = day.getAllDayOffbyNV(id); // Lấy danh sách lịch làm việc
        for (DayOff_DTO dayoff : dayoffs) {
            Object[] rowData = {
                dayoff.getNgayNghi(),
                dayoff.getLyDo(),
                dayoff.isDuyet()
            };
            model.addRow(rowData);
        }
    }
    
    public void loadDayOffDataToTable(JTable table) {
        // Xóa dữ liệu cũ
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // Lấy dữ liệu từ DAO và thêm vào bảng
        
        List<DayOff_DTO> dayoffs = day.getAllDayOff(); // Lấy danh sách lịch làm việc
        for (DayOff_DTO dayoff : dayoffs) {
            Object[] rowData = {
                dayoff.getSTT(),
                dayoff.getMaNV(),
                dayoff.getNgayNghi(),
                dayoff.getLyDo(),
                dayoff.isDuyet()
            };
            model.addRow(rowData);
        }
    }
    
    public boolean check(int ma) throws SQLException {
        if (day.check(ma)) {
                new MyDialog("Duyệt thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Duyệt thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
    }
    
    public int tinhngaynghi(int month, int year, int id) throws SQLException {
        return day.tinhngaynghi(month, year, id);
    }
    
    
    
    public boolean isKeyExists(int ma, Date ngay){
        try {
            if (day.isKeyExists(ma, ngay)){
                new MyDialog("Không thể xếp lịch làm trùng ngày nghỉ!", MyDialog.ERROR_DIALOG);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DayOff_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
