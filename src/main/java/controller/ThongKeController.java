package controller;

import DAO.DichVuDAO;
import DAO.NhanVienDAO;
import Models.HoaDon;
import Models.NhanVien;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import service.HoaDonService;
import service.HoaDonServiceImpl;
import utility.ClassChartModel;
import utility.ClassTableModel;

/**
 *
 * @author Tien
 */
public class ThongKeController {
    private JPanel jpnView;
    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;
    private NhanVienDAO nvDAO = new NhanVienDAO();
    private HoaDonService hoaDonService = null;
    private DichVuDAO dichVu = new DichVuDAO();

    private final String[] COLUMNS = {
            "STT", "Mã hoá đơn", "Tổng tiền dịch vụ", "Tổng tiền khuyến mãi",
            "Thành tiền", "Ngày ra", "Giờ ra",
    };

    public ThongKeController() {
    }

    public ThongKeController(JPanel jpnView) {
        this.jpnView = jpnView;

        this.classTableModel = new ClassTableModel();

        this.hoaDonService = new HoaDonServiceImpl();
    }

    public void setDataTable(int year) {
        List<HoaDon> listItem = hoaDonService.getHoaDonTheoNam(year);
        DefaultTableModel model = classTableModel.setTableHoaDon(listItem, COLUMNS);
        JTable table = new JTable(model);

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));
        table.getTableHeader().setPreferredSize(new Dimension(80, 30));
        table.setRowHeight(30);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1180, 300));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public int getTongNhanVien() throws Exception {
        List<NhanVien> allNV = nvDAO.getAll();
        return allNV.size();
    }

    public int getTongMonAn() {
        try {
            return dichVu.getAll().size();
        } catch (Exception ex) {
            Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getTongHoaDon() {
        List<HoaDon> listItem = hoaDonService.getAllHoaDon();
        return listItem.size();
    }

    public void setDataLineChart(int year) {
        System.out.print(year);
        List<HoaDon> listItem = hoaDonService.getHoaDonTheoNam(year);
        ClassChartModel chart = new ClassChartModel();
        jpnView.removeAll();
        jpnView.setLayout(new java.awt.BorderLayout());
        jpnView.add(chart.lineChart("Doanh thu và tháng",
                String.format("Biểu đồ doanh thu trong năm %d", year), listItem), BorderLayout.CENTER);
        jpnView.validate();
        jpnView.repaint();
    }
}
