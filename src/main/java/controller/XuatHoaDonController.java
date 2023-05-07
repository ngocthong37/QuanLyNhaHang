/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.QuayOrderDAO;
import Models.ChiTietPhieuAn;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
public class XuatHoaDonController {
    private JEditorPane txtHoaDon;
    private JLabel labelTongTien;
    private JLabel labelMaPSDDV;
    private QuayOrderDAO quayOrderDAO = null;
    private int maPSDDV;
    private long tongTien = 0;
    LocalDateTime now;

    public XuatHoaDonController() {
    }

    public XuatHoaDonController(JEditorPane txtHoaDon, JLabel labelTongTien, JLabel labelMaPSDDV, int maPSDDV) {
        this.txtHoaDon = txtHoaDon;
        this.labelTongTien = labelTongTien;
        this.labelMaPSDDV = labelMaPSDDV;
        this.maPSDDV = maPSDDV;
        this.quayOrderDAO = new QuayOrderDAO();
        this.labelMaPSDDV.setText("");
        this.now = LocalDateTime.now();
    }

    public void setPhieuXuatHoaDon() {
        try {
            List<ChiTietPhieuAn> ctPhieuAn = quayOrderDAO.chiTietPhieuAn(this.maPSDDV);
            txtHoaDon.setContentType("text/html");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            DecimalFormat dcf = new DecimalFormat("###,### VND");
            String hd = "<style> "
                    + "table {"
                    + "border: 1px solid;"
                    + "border-bottom: none"
                    + "}"
                    + "tr {"
                    + "border-bottom: 1px solid;"
                    + "}"
                    + "td {"
                    + "padding: 8px;"
                    + "} "
                    + "th {"
                    + "font-size:16pt"
                    + "}"
                    + "</style>";
            hd += "<h1 style='text-align:center;'>HOÁ ĐƠN THANH TOÁN</h1>";

            hd += "Ngày lập: " + dtf.format(now) + "<br/>";
            hd += "<div style='text-align:center;'>==========================================</div><br/>";
            hd += "<div style='text-align:center'>";
            hd += "<table style='max-width:100%'>";
            hd += "<tr>"
                    + "<th>Mã SP</th>"
                    + "<th>Tên SP</th>"
                    + "<th>Số lượng</th>"
                    + "<th>Đơn giá</th>"
                    + "<th>Thành tiền</th>"
                    + "</tr>";
            for (int i = 0; i < ctPhieuAn.size(); i++) {
                hd += "<tr>";
                hd += "<td style='text-align:center;'>" + ctPhieuAn.get(i).getMaDichVu() + "</td>";
                hd += "<td style='text-align:left;'>" + ctPhieuAn.get(i).getTenDichVu() + "</td>";
                hd += "<td style='text-align:center;'>" + ctPhieuAn.get(i).getSoLuong() + "</td>";
                hd += "<td style='text-align:center;'>" + ctPhieuAn.get(i).getDonGia() + "</td>";
                hd += "<td style='text-align:center;'>" + ctPhieuAn.get(i).getThanhTien() + "</td>";
                hd += "</tr>";
                this.tongTien += ctPhieuAn.get(i).getThanhTien();
            }
            hd += "<tr>";
            hd += "<td style='text-align:center;'>" + "</td>";
            hd += "<td style='text-align:left;'>" + "</td>";
            hd += "<td style='text-align:center;'>" + "</td>";
            hd += "<td style='text-align:center;font-weight:bold'>Tổng cộng</td>";
            hd += "<td style='text-align:center;'>" + dcf.format(tongTien) + "</td>";
            hd += "</tr>";
            hd += "</table>";
            hd += "</div>";
            hd += "<div style='text-align:center;'>==========================================</div><br/>";
            labelTongTien.setText(dcf.format(tongTien));
            txtHoaDon.setText(hd);
            labelMaPSDDV.setText(String.valueOf(this.maPSDDV));
        } catch (Exception ex) {
            Logger.getLogger(XuatHoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void thanhToan(String maNV) {
        DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyy/MM/dd");
        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            quayOrderDAO.luuThongTinHoaDon(tongTien, maPSDDV, 0, dtfDate.format(now), dtfTime.format(now), maNV);
            quayOrderDAO.capNhatThanhToan(1, maPSDDV);
        } catch (Exception ex) {
            Logger.getLogger(XuatHoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
