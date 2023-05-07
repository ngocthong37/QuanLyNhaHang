/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import Models.ChiTietPhieuAn;
import Models.HoaDon;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ClassTableModel {
    public DefaultTableModel setTableHoaDon(List<HoaDon> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DecimalFormat dcf = new DecimalFormat("###,### VND");
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        HoaDon hoaDon = null;
        for (int i = 0; i < num; i++) {
            hoaDon = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = hoaDon.getMaHoaDon();
            obj[2] = dcf.format(hoaDon.getTongTienDV());
            obj[3] = hoaDon.getTongTienKM();
            obj[4] = dcf.format(hoaDon.getThanhTien());
            obj[5] = hoaDon.getNgayRa();
            obj[6] = hoaDon.getGioRa();
            dtm.addRow(obj);
        }
        return dtm;
    }

    public DefaultTableModel setTableCTHoaDon(List<ChiTietPhieuAn> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DecimalFormat dcf = new DecimalFormat("###,### VND");
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        ChiTietPhieuAn ctMonAn = null;
        for (int i = 0; i < num; i++) {
            ctMonAn = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = ctMonAn.getTenDichVu();
            obj[2] = dcf.format(ctMonAn.getDonGia());
            obj[3] = ctMonAn.getSoLuong();
            obj[4] = dcf.format(ctMonAn.getThanhTien());
            dtm.addRow(obj);
        }
        return dtm;
    }
}
