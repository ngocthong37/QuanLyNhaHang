/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//file cu
package Screens;

import DAO.BanDatDAO;
import DAO.QuayOrderDAO;
import Models.BanAn;
import Models.BanDat;
import Models.ChiTietPhieuAn;
import Models.DichVu;
import Models.NhanVien;
import Models.PhieuSuDungDV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author T3D Computer
 */
public class QuayOrder extends javax.swing.JFrame implements Runnable, ActionListener {

    public JLabel nameNV() {
        return nvName;
    }

    DefaultTableModel tableModel = new DefaultTableModel();

    QuayOrderDAO quayOrderDAO = new QuayOrderDAO();
    BanDatDAO banDatDAO = new BanDatDAO();
    List<BanAn> dsBanAn = new ArrayList<>();
    List<PhieuSuDungDV> dsPhieuSDDV = new ArrayList<>();
    List<ChiTietPhieuAn> dsChiTietPhieuAn = new ArrayList<>();
    List<BanDat> dsBanDaDatHomNay = new ArrayList<>();
    List<DichVu> dsDichVu = new ArrayList<>();
    JButton[] ban = new JButton[5 * 5];
    private NhanVien currentNV = null;
    DecimalFormat dcf = new DecimalFormat("###,### VND");

    private ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/Icon/BlankTable.png"));
    private ImageIcon icon2 = new javax.swing.ImageIcon(getClass().getResource("/Icon/UsingTable.png"));
    private ImageIcon icon3 = new javax.swing.ImageIcon(getClass().getResource("/Icon/TableOrdered.png"));

    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

    String today = format1.format(now);
    String date = sdf.format(now);

    Map<String, Integer> thucAn = new HashMap<>();
    Map<String, Integer> doUong = new HashMap<>();
    Map<String, Integer> tienIch = new HashMap<>();
    Set<String> key1 = thucAn.keySet();
    Set<String> key2 = doUong.keySet();
    Set<String> key3 = tienIch.keySet();
    String banSo = "0";
    String gio;
    ThongTinKhachHang thongTin = new ThongTinKhachHang();

    private void dichVuTheoMaDichVu() {
        for (DichVu dichVu : dsDichVu) {
            switch (dichVu.getMaLoaiDichVu()) {
                case 1:
                    thucAn.put(dichVu.getTenDichVu(), dichVu.getMaDichVu());
                    break;
                case 2:
                    doUong.put(dichVu.getTenDichVu(), dichVu.getMaDichVu());
                    break;
                case 3:
                    tienIch.put(dichVu.getTenDichVu(), dichVu.getMaDichVu());
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Creates new form QuayOrder
     */
    public QuayOrder(NhanVien nv) {
        initComponents();
        try {
            System.out.println("Date: " + date);
            dsBanAn = quayOrderDAO.danhSachBanAn();
            dsPhieuSDDV = quayOrderDAO.danhSachPhieuSDDV();
            dsBanDaDatHomNay = banDatDAO.layBanDatHomNay(today);
            dsDichVu = quayOrderDAO.danhSachDichVu();
            dsBanAn = hienThiThongTinBan(dsBanAn, dsPhieuSDDV);
            System.out.println("So dien thoai khach hang: " + thongTin.hienThiSDT());
            dichVuTheoMaDichVu();
            taoBan();
            veBan();
            clock();
            currentNV = nv;
            nvName.setText(currentNV.getHo() + " " + currentNV.getTen());
        } catch (Exception e) {
            System.out.println(e);
        }

        tableModel = (DefaultTableModel) tblMonDat.getModel();
        setLocationRelativeTo(null);
        setResizable(false);
        cbDaChon.setEnabled(false);
        cbLuaChon.setEnabled(false);
        if (!cbDaChon.isEnabled()) {
            btnThemSoLuong.setEnabled(false);
        }
    }

    private void hienThiThongTinMonDat() {
        tableModel.setRowCount(0);
        if (dsChiTietPhieuAn != null) {
            for (ChiTietPhieuAn phieuAn : dsChiTietPhieuAn) {
                tableModel.addRow(
                        new Object[]{phieuAn.getTenDichVu(), phieuAn.getSoLuong(), dcf.format(phieuAn.getDonGia())});
            }
        }
    }

    void showThongTinComboBox() {
        if (cbLuaChon.getSelectedItem() == "Món ăn") {
            cbDaChon.removeAllItems();
            for (String x : key1) {
                cbDaChon.addItem(x);
            }
        } else if (cbLuaChon.getSelectedItem() == "Thức uống") {
            cbDaChon.removeAllItems();
            for (String x : key2) {
                cbDaChon.addItem(x);
            }
        } else if (cbLuaChon.getSelectedItem() == "Tiện ích") {
            cbDaChon.removeAllItems();
            for (String x : key3) {
                cbDaChon.addItem(x);
            }
        }
    }

    private int kiemTraPhieuSDDV(String maBan) {
        for (PhieuSuDungDV phieu : dsPhieuSDDV) {
            if (maBan.equals(phieu.getSoBan()) && phieu.getNgayVao().equals(date)
                    && phieu.getTrangThaiPhieu() == false) {
                System.out.println("Get ma" + phieu.getMaPSDDV());
                return phieu.getMaPSDDV();
            }
        }
        return 0;
    }

    private List<BanAn> hienThiThongTinBan(List<BanAn> dsBanAn, List<PhieuSuDungDV> dsPhieu) {

        for (BanAn banAn : dsBanAn) {
            for (PhieuSuDungDV phieu : dsPhieu) {
                if (banAn.getMaBan() == phieu.getMaBan() && phieu.getNgayVao().equals(date)) {
                    banAn.setTrangThai(2);
                    break;
                }
            }
        }
        return dsBanAn;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblThongBaoThanhCong = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        PanelBan = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jlab = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nvName = new javax.swing.JLabel();
        lblNgay = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblGio = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblBanSo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbLuaChon = new javax.swing.JComboBox<>();
        cbDaChon = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        btnThemSoLuong = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMonDat = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnThanhToan1 = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(197, 225, 172));

        jPanel7.setBackground(new java.awt.Color(61, 131, 24));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẦY ORDER ĐỒ ĂN");

        btnHome.setBackground(new java.awt.Color(214, 85, 23));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Home.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnHome)
                .addGap(304, 304, 304)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Bảng phục vụ bàn");

        PanelBan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        PanelBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelBanMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelBanLayout = new javax.swing.GroupLayout(PanelBan);
        PanelBan.setLayout(PanelBanLayout);
        PanelBanLayout.setHorizontalGroup(
            PanelBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        PanelBanLayout.setVerticalGroup(
            PanelBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(197, 225, 172));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/BlankTable.png"))); // NOI18N
        jLabel3.setText("Bàn trống ");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/UsingTable.png"))); // NOI18N
        jLabel6.setText("Đang sử dụng");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TableOrdered.png"))); // NOI18N
        jLabel5.setText("Đã được đặt");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(60, 60, 60)
                .addComponent(jLabel5)
                .addGap(74, 74, 74))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(175, 175, 85));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Thông tin ");

        jlab.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlab.setText("Bàn số: ");

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Họ tên nhân viên");

        nvName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nvName.setText("Nguyễn Ngọc Thông");

        lblNgay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblNgay.setText("28/10/2022");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setText("Thời gian");

        lblGio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblGio.setText("14:04:59");

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Ngày");

        lblBanSo.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblBanSo.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(nvName)
                    .addComponent(lblGio)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBanSo))
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addComponent(lblNgay)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlab)
                    .addComponent(lblBanSo))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nvName)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGio)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel9.setText("Số lượng");

        cbLuaChon.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        cbLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Món ăn", "Thức uống", "Tiện ích" }));
        cbLuaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLuaChonActionPerformed(evt);
            }
        });

        cbDaChon.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        cbDaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDaChonActionPerformed(evt);
            }
        });

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyTyped(evt);
            }
        });

        btnThemSoLuong.setBackground(new java.awt.Color(214, 85, 23));
        btnThemSoLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnThemSoLuong.setBorderPainted(false);
        btnThemSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSoLuongActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(197, 225, 172));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("Giá:");

        lblGia.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblGia.setText("0");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Thành tiền:");

        lblThanhTien.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblThanhTien.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGia)
                .addGap(111, 111, 111)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(lblThanhTien)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblGia)
                    .addComponent(jLabel11)
                    .addComponent(lblThanhTien)))
        );

        tblMonDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món ăn", "Số lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMonDat.setRowHeight(25);
        tblMonDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonDatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMonDat);

        jPanel2.setBackground(new java.awt.Color(197, 225, 172));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });

        btnThanhToan1.setBackground(new java.awt.Color(214, 85, 23));
        btnThanhToan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cash.png"))); // NOI18N
        btnThanhToan1.setText("Tính tiền");
        btnThanhToan1.setBorderPainted(false);
        btnThanhToan1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThanhToan1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnThanhToan1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThanhToan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToan1ActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(214, 85, 23));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Remove.png"))); // NOI18N
        btnXoa.setText("Xóa phiếu");
        btnXoa.setBorderPainted(false);
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThanhToan1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(btnXoa)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnThanhToan1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbDaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbLuaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(btnThemSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cbLuaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbDaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9)
                            .addComponent(btnThemSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblThongBaoThanhCong)
                .addGap(598, 598, 598))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblThongBaoThanhCong)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

    private void PanelBanMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PanelBanMousePressed
        // TODO add your handling code here:
    }// GEN-LAST:event_PanelBanMousePressed

    private void cbLuaChonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbLuaChonActionPerformed
        cbDaChon.setEnabled(true);
        btnThemSoLuong.setEnabled(true);
        showThongTinComboBox();// TODO add your handling code here:

    }// GEN-LAST:event_cbLuaChonActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSoLuongActionPerformed

    }// GEN-LAST:event_txtSoLuongActionPerformed

    private void cbDaChonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbDaChonActionPerformed
        // TODO add your handling code here:
        btnThemSoLuong.setEnabled(true);

    }// GEN-LAST:event_cbDaChonActionPerformed

    public final void clock() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Date now = new Date();
                        gio = hourFormat.format(now);
                        lblGio.setText(gio);
                        if (!dsBanDaDatHomNay.isEmpty()) {
                            for (BanDat banDat : dsBanDaDatHomNay) {
                                String actual = gio;
                                String limit = banDat.getGioVao();
                                String[] parts = actual.split(":");
                                Calendar gioHienTai = Calendar.getInstance();
                                gioHienTai.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
                                gioHienTai.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
                                gioHienTai.set(Calendar.SECOND, Integer.parseInt(parts[2]));

                                parts = limit.split(":");
                                Calendar gioKhoaBan = Calendar.getInstance();
                                gioKhoaBan.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]) - 1);
                                gioKhoaBan.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
                                gioKhoaBan.set(Calendar.SECOND, Integer.parseInt(parts[2]));

                                parts = limit.split(":");
                                Calendar gioMoBan = Calendar.getInstance();
                                gioMoBan.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
                                gioMoBan.set(Calendar.MINUTE, Integer.parseInt(parts[1]) + 30);
                                gioMoBan.set(Calendar.SECOND, Integer.parseInt(parts[2]));
                                if (gioHienTai.after(gioKhoaBan) && banDat.getMaTT() == 1) {
                                    capNhatTrangThaiBan(banDat.getSoBan(), 3);
                                }
                                if (gioHienTai.after(gioMoBan) && banDat.getMaTT() == 1) {
                                    if (quayOrderDAO.capNhatTrangThaiBanDat(4, banDat.getSoDT(), banDat.getMaPD())) {
                                        capNhatTrangThaiBan(banDat.getSoBan(), 1);
                                        banDat.setMaTT(4);
                                        break;
                                    } else {
                                        System.out.println("Cap nhat that bai");
                                    }
                                }

                                // System.out.println("date: " +date);
                            }
                        }

                        sleep(1000);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);

                }
            }
        };
        clock.start();
    }

    private void xoaPhieuDat(String banSo) {
        for (BanDat banDat : dsBanDaDatHomNay) {
            if (banDat.getSoBan().equals(banSo)) {
                dsBanDaDatHomNay.remove(banDat);
                return;
            }
        }
    }

    private int kiemTraTrangThaiBan(String banSo) {
        for (BanAn banAn : dsBanAn) {
            if (banAn.getSoBan().equals(banSo)) {
                return banAn.getTrangThai();
            }
        }
        return 1;
    }

    private boolean tonTaiMon(String monAn) {
        for (ChiTietPhieuAn chiTiet : dsChiTietPhieuAn) {
            if (chiTiet.getTenDichVu().equals(monAn)) {
                return true;
            }
        }
        return false;
    }

    private void capNhatSoLuongMonAn(String monAn, int soLuong) {
        for (ChiTietPhieuAn chiTiet : dsChiTietPhieuAn) {
            if (chiTiet.getTenDichVu().equals(monAn)) {
                chiTiet.setSoLuong(soLuong);
                break;
            }
        }
    }

    private BanDat thongTinBanDat(String banSo) {
        for (BanDat banDat : dsBanDaDatHomNay) {
            if (Objects.equals(Integer.valueOf(banDat.getGioVao().substring(0, 2)),
                    Integer.valueOf(hourFormat.format(now).substring(0, 2))) && banSo.equals(banDat.getSoBan())
                    || Integer.valueOf(banDat.getGioVao().substring(0, 2)) - 1 == Integer
                    .valueOf(hourFormat.format(now).substring(0, 2)) && banSo.equals(banDat.getSoBan())) {
                return banDat;
            }
        }
        return null;
    }

    private void btnThemSoLuongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemSoLuongActionPerformed
        int maDV = 0;
        int maLoaiDV = 0;
        if (cbLuaChon.getSelectedItem() == "Món ăn") {
            maDV = thucAn.get(cbDaChon.getSelectedItem());
            maLoaiDV = 1;
        } else if (cbLuaChon.getSelectedItem() == "Thức uống") {
            maDV = doUong.get(cbDaChon.getSelectedItem());
            maLoaiDV = 2;
        } else if (cbLuaChon.getSelectedItem() == "Tiện ích") {
            maDV = tienIch.get(cbDaChon.getSelectedItem());
            maLoaiDV = 3;
        }
        int gia = 0;
        for (DichVu dichVu : dsDichVu) {
            if (dichVu.getMaDichVu() == maDV) {
                gia = dichVu.getDonGia();
                break;
            }
        }
        ChiTietPhieuAn chiTiet = new ChiTietPhieuAn(Integer.valueOf(txtSoLuong.getText()), maDV,
                cbDaChon.getSelectedItem().toString(), gia, true, maLoaiDV);
        if (tonTaiMon(cbDaChon.getSelectedItem().toString())) {
            String soLuongMoi = JOptionPane.showInputDialog("Cập nhật số lượng", txtSoLuong.getText());
            if (soLuongMoi != null) {
                capNhatSoLuongMonAn(cbDaChon.getSelectedItem().toString(), Integer.valueOf(soLuongMoi));
            }
        } else {
            dsChiTietPhieuAn.add(chiTiet);
        }
        if (kiemTraPhieuSDDV(banSo) == 0) {
            String thoiGianVao = format1.format(now);
            try {
                if (quayOrderDAO.themPhieuSDDV(thoiGianVao, gio, 1, currentNV.getMaNV(), Integer.valueOf(banSo))) {
                    System.out.println("Them phieu thanh cong");
                    for (BanAn banAn : dsBanAn) {
                        if (banAn.getMaBan() == Integer.valueOf(banSo)) {
                            banAn.setTrangThai(2);
                            try {
                                System.out.println("Dang lay lai");
                                dsPhieuSDDV = quayOrderDAO.danhSachPhieuSDDV();
                                for (JButton jButton : ban) {
                                    if (banSo.equals(jButton.getText())) {
                                        jButton.setIcon(icon2);
                                    }
                                }

                            } catch (Exception e) {
                            }
                        }
                    }
                } else {
                    System.out.println("Them phieu That bai");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            System.out.println("Khong phai nee");
        }
        try {
            dsPhieuSDDV = quayOrderDAO.danhSachPhieuSDDV();
            quayOrderDAO.themMonAnChoKhach(kiemTraPhieuSDDV(banSo), maDV, chiTiet.getSoLuong());
        } catch (Exception e) {
            System.out.println("Them mon that bai: " + e);
        }

        hienThiThongTinMonDat();
    }// GEN-LAST:event_btnThemSoLuongActionPerformed

    private void btnThanhToan1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThanhToan1ActionPerformed
        int maPSDDV = kiemTraPhieuSDDV(this.banSo);
        if (maPSDDV != 0) {
            XuatHoaDonPopUp xuatHDPU = new XuatHoaDonPopUp(maPSDDV);
            xuatHDPU.setVisible(true);
            xuatHDPU.btnThanhToan().addActionListener((ActionEvent e) -> {
                xuatHDPU.xuatHoaDonCTR.thanhToan(this.currentNV.getMaNV());
                xuatHDPU.btnThanhToan().setEnabled(false);
                capNhatTrangThaiBan(banSo, 1);
                try {
                    dsPhieuSDDV = quayOrderDAO.danhSachPhieuSDDV();
                } catch (Exception ex) {
                    Logger.getLogger(QuayOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
                xuatHDPU.dispose();
                dsChiTietPhieuAn.clear();
                hienThiThongTinMonDat();
            });
        }
    }// GEN-LAST:event_btnThanhToan1ActionPerformed

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel2MouseReleased
        // TODO add your handling code here:

    }// GEN-LAST:event_jPanel2MouseReleased

    private void tblMonDatMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblMonDatMouseClicked
        int index = tblMonDat.getSelectedRow();
        ChiTietPhieuAn monDaChon = dsChiTietPhieuAn.get(index);
        System.out.println("Ma dich vu: " + monDaChon.getMaLoaiDichVu());
        cbLuaChon.setSelectedIndex(monDaChon.getMaLoaiDichVu() - 1);
        cbDaChon.setSelectedItem(monDaChon.getTenDichVu());
        lblGia.setText(dcf.format(monDaChon.getDonGia()));
        lblThanhTien.setText(dcf.format(monDaChon.getSoLuong() * monDaChon.getDonGia()));
        txtSoLuong.setText(String.valueOf(monDaChon.getSoLuong()));

    }// GEN-LAST:event_tblMonDatMouseClicked

    private void capNhatTrangThaiBan(String maBan, int trangThai) {
        for (BanAn banAn : dsBanAn) {
            if (banAn.getSoBan().equals(maBan)) {
                banAn.setTrangThai(trangThai);
                for (JButton jButton : ban) {
                    if (maBan.equals(jButton.getText())) {
                        if (trangThai == 1) {
                            jButton.setIcon(icon1);
                        } else if (trangThai == 2) {
                            jButton.setIcon(icon2);
                        } else {
                            jButton.setIcon(icon3);
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    private void txtSoLuongKeyPressed(java.awt.event.KeyEvent evt) {

    }// GEN-LAST:event_txtSoLuongKeyPressed

    private void txtSoLuongKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtSoLuongKeyTyped
        // TODO add your handling code here:
        char e = evt.getKeyChar();
        if (!Character.isDigit(e)) {
            evt.consume();
        }
    }// GEN-LAST:event_txtSoLuongKeyTyped

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed
        if (kiemTraPhieuSDDV(banSo) != 0) {
            System.out.println("So phieu: " + kiemTraPhieuSDDV(banSo));
            try {
                int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa phiếu này không?");
                if (option == 0) {
                    quayOrderDAO.xoaPhieuSDDV(kiemTraPhieuSDDV(banSo));
                    capNhatTrangThaiBan(banSo, 1);
                    dsPhieuSDDV = quayOrderDAO.danhSachPhieuSDDV();
                    dsChiTietPhieuAn.clear();
                    hienThiThongTinMonDat();
                    lblGia.setText("0");
                    lblThanhTien.setText("0");
                }
            } catch (Exception e) {
            }
        } else {
            System.out.println("Khong co phieu");
        }
    }// GEN-LAST:event_btnXoaActionPerformed

    private void taoBan() {
        lblGio.setText(String.valueOf(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date())));
        lblNgay.setText(String.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date())));
        txtSoLuong.setText("1");
        int count = 1;
        JButton oldButton = new JButton();
        oldButton.setBounds(10, 10, 0, 10);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int trangThai = dsBanAn.get(i * 5 + j).getTrangThai();
                JButton button;
                System.out.println("Ban so: " + (i * 5 + j + 1));
                System.out.println("Trang thai: " + trangThai);
                if (trangThai == 1) {
                    button = new JButton("" + count, icon1);
                } else if (trangThai == 2) {
                    button = new JButton("" + count, icon2);
                } else {
                    button = new JButton("" + count, icon3);
                }
                button.setHorizontalTextPosition(JButton.CENTER);
                button.setVerticalTextPosition(JButton.BOTTOM);
                button.setBounds(oldButton.getX() + oldButton.getWidth(), oldButton.getY(), 75, 75);
                oldButton.setBounds(button.getX(), button.getY(), button.getWidth() + 15, button.getHeight() + 15);
                button.addActionListener(this);
                ban[count - 1] = button;
                count++;
            }
            oldButton.setBounds(10, oldButton.getY() + oldButton.getHeight(), 0, 10);
        }
    }

    private void veBan() {
        for (JButton jButton : ban) {
            PanelBan.add(jButton);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBan;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnThanhToan1;
    private javax.swing.JButton btnThemSoLuong;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbDaChon;
    private javax.swing.JComboBox<String> cbLuaChon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlab;
    private javax.swing.JLabel lblBanSo;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblGio;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblThongBaoThanhCong;
    private javax.swing.JLabel nvName;
    private javax.swing.JTable tblMonDat;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        banSo = ((JButton) e.getSource()).getText();
        System.out.println("Ban so: " + banSo);
        lblGia.setText("0");
        lblThanhTien.setText("0");
        lblBanSo.setText(banSo);
        cbDaChon.removeAllItems();
        btnThemSoLuong.setEnabled(false);
        txtSoLuong.setText("1");
        switch (kiemTraTrangThaiBan(banSo)) {
            case 2 -> {
                cbLuaChon.setEnabled(true);
                try {
                    dsChiTietPhieuAn = null;
                    dsChiTietPhieuAn = quayOrderDAO.chiTietPhieuAn(kiemTraPhieuSDDV(banSo));
                    hienThiThongTinMonDat();

                } catch (Exception ex) {
                    Logger.getLogger(QuayOrder.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 1 -> {
                cbLuaChon.setEnabled(true);
                dsChiTietPhieuAn.clear();
                hienThiThongTinMonDat();
            }
            default -> {
                cbLuaChon.setEnabled(false);
                System.out.println("Vo day");
                thongTin = new ThongTinKhachHang();
                System.out.println("So phieu dat ban la: " + kiemTraPhieuSDDV(banSo));
                thongTin.setVisible(true);
                BanDat banDat = thongTinBanDat(banSo);
                System.out.println("Ban dat: " + banDat);
                thongTin.hienThiHoTen().setText(banDat.getHoKH() + " " + banDat.getTenKH());
                thongTin.hienThiSDT().setText(banDat.getSoDT());
                thongTin.hienThiGhiChu().setText(banDat.getGhiChu());
                thongTin.hienThiGhiChu().setEditable(false);
                thongTin.hienThiHoTen().setEditable(false);
                thongTin.hienThiSDT().setEditable(false);
                thongTin.huyBan().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Vo day roi nhe");
                        xoaPhieuDat(banSo);
                        thongTin.setVisible(false);
                        try {
                            quayOrderDAO.capNhatTrangThaiBanDat(4, banDat.getSoDT(), banDat.getMaPD());
                            capNhatTrangThaiBan(banSo, 1);
                        } catch (Exception ex) {
                            Logger.getLogger(QuayOrder.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                });
                thongTin.goiMon().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        thongTin.setVisible(false);
                        try {
                            String thoiGianVao = format1.format(now);
                            if (quayOrderDAO.themPhieuSDDV(thoiGianVao, gio, 1, currentNV.getMaNV(), Integer.valueOf(banSo))) {
                                for (BanDat banDat : dsBanDaDatHomNay) {
                                    if (banDat.getSoBan().equals(banSo)) {
                                        try {
                                            dsPhieuSDDV = quayOrderDAO.danhSachPhieuSDDV();
                                            for (JButton jButton : ban) {
                                                if (banSo.equals(jButton.getText())) {
                                                    try {
                                                        quayOrderDAO.capNhatTrangThaiBanDat(2,
                                                                thongTin.hienThiSDT().getText(), banDat.getMaPD());
                                                        dsBanDaDatHomNay = banDatDAO.layBanDatHomNay(today);
                                                        banDat.setMaTT(2);
                                                        capNhatTrangThaiBan(banSo, 2);
                                                        break;
                                                    } catch (Exception error) {
                                                        System.out.println("Cap nhap loi");
                                                    }
                                                }
                                            }
                                        } catch (Exception ee) {
                                            System.out.println("Lay thong tin loi");
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Them phieu That bai");
                            }

                        } catch (Exception eee) {
                            System.out.println("Error: " + eee);
                        }
                    }
                }
                );
            }
        }
    }
}
