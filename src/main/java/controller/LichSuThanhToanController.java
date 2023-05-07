
package controller;

import Models.ChiTietPhieuAn;
import Models.HoaDon;
import Models.NhanVien;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import service.HoaDonService;
import service.HoaDonServiceImpl;
import utility.ClassTableModel;

/**
 *
 * @author ADMIN
 */
public class LichSuThanhToanController {
    private JPanel jpnView;
    private JPanel jpnViewCT;
    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;
    private NhanVien currentNV;

    private final String[] COLUMNS = {
            "STT", "Mã hoá đơn", "Tổng tiền dịch vụ", "Tổng tiền khuyến mãi",
            "Thành tiền", "Ngày ra", "Giờ ra",
    };

    private final String[] COLUMNS_CTHD = {
            "STT", "Mã dịch vụ", "Đơn giá", "Số lượng", "Thành tiền"
    };

    private HoaDonService hoaDonService = null;

    public LichSuThanhToanController(JPanel jpnView, JPanel jpnViewCT) {
        this.jpnView = jpnView;

        this.classTableModel = new ClassTableModel();

        this.hoaDonService = new HoaDonServiceImpl();

        this.jpnViewCT = jpnViewCT;
    }

    public void setDataTableThanhToan(int year, int monthStart, int monthEnd, String maNV, int maQuyen) {
        List<HoaDon> listItem = hoaDonService.getHoaDonTrongKhoangTG(year, monthStart, monthEnd, maNV, maQuyen);
        DefaultTableModel model = classTableModel.setTableHoaDon(listItem, COLUMNS);
        JTable table = new JTable(model);

        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedData = 0;

                int[] selectedRow = table.getSelectedRows();

                for (int i = 0; i < selectedRow.length; i++) {
                    selectedData = (int) table.getValueAt(selectedRow[i], 0);
                }
                for(int i = 0; i < listItem.size(); i++) {
                    if(i == selectedData - 1) {
                        setDataTableCTHoaDon(listItem.get(i).getMaSDDV());
                    }
                }
                
            }
        });

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));
        table.getTableHeader().setPreferredSize(new Dimension(80, 30));
        table.setRowHeight(30);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.setBackground(new Color(197, 225, 172));
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(650, 620));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setDataTableCTHoaDon(int maPSDDV) {
        List<ChiTietPhieuAn> listItem = hoaDonService.getChiTietPhieuAnDaThanhToan(maPSDDV);
        DefaultTableModel model = classTableModel.setTableCTHoaDon(listItem, COLUMNS_CTHD);
        JTable table = new JTable(model);

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));
        table.getTableHeader().setPreferredSize(new Dimension(80, 30));
        table.setRowHeight(30);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(500, 320));
        jpnViewCT.removeAll();
        jpnViewCT.setLayout(new CardLayout());
        jpnViewCT.add(scroll);
        jpnViewCT.validate();
        jpnViewCT.repaint();
    }

    public NhanVien getCurrentNV() {
        return currentNV;
    }

    public void setCurrentNV(NhanVien currentNV) {
        this.currentNV = currentNV;
    }
}
