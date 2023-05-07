/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Screens;

import DAO.BanDatDAO;
import DAO.QuayOrderDAO;
import Models.BanDat;
import Models.NhanVien;
import Models.PhieuSuDungDV;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author T3D Computer
 */
public class DatBan extends javax.swing.JFrame {

    DefaultTableModel tableModel = new DefaultTableModel();
    DefaultTableModel tableModel1 = new DefaultTableModel();
    BanDatDAO banDatDAO = new BanDatDAO();
    List<BanDat> dsBanDat = new ArrayList<>();
    List<PhieuSuDungDV> dsPhieuDVHomNay = new ArrayList<>();
    Date now = new Date();
    QuayOrderDAO quayOrderDAO = new QuayOrderDAO();
    String sdtCu = "";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat anotherDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private NhanVien currentNV = null;
    DanhSachKhachDatBan ds = new DanhSachKhachDatBan();
    List<BanDat> dsBanDatCuaKH = new ArrayList<>();

    /**
     * Creates new form DatBan
     */
    public DatBan(NhanVien nv) {
        initComponents();
        currentNV = nv;
        tableModel = (DefaultTableModel) tblDatBan.getModel();
        tableModel1 = (DefaultTableModel) ds.dsBanDaDat().getModel();
        try {
            dsBanDat = banDatDAO.getAll();
        } catch (Exception e) {
        }
        hienThiThongTinBanDat();
        setLocationRelativeTo(null);
        setResizable(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        try {
            dsPhieuDVHomNay = quayOrderDAO.danhSachPhieuSDDVTheoNgay(dateFormat.format(now));
            for (PhieuSuDungDV phieu : dsPhieuDVHomNay) {
            }

        } catch (Exception ex) {
            Logger.getLogger(DatBan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void hienThiThongTinBanDat() {
        tableModel.setRowCount(0);
        for (BanDat banDat : dsBanDat) {
            tableModel.addRow(new Object[]{banDat.getHoKH() + " " + banDat.getTenKH(),
                banDat.getSoDT(), banDat.getSoBan(), banDat.getGioVao(), banDat.getNgayVao(), banDat.getGhiChu()});
        }
    }

    private void hienThiThongTinBanDatCuaKH() {
        tableModel1.setRowCount(0);
        for (BanDat banDat : dsBanDatCuaKH) {
            tableModel1.addRow(new Object[]{banDat.getHoKH() + " " + banDat.getTenKH(),
                banDat.getSoDT(), banDat.getSoBan(), banDat.getGioVao(), banDat.getNgayVao(), banDat.getGhiChu()});
        }
    }

    String tenKH = "";
    String hoKH = "";

    private void getHoTenKH(String s) {

        int i = s.length() - 1;
        while (s.charAt(i) != ' ') {
            tenKH = s.charAt(i) + tenKH;
            i--;
        }
        for (int j = 1; j < i; j++) {
            hoKH = hoKH + s.charAt(j);
        }
        System.out.println("Ho: " + hoKH);
        System.out.println("Ten:  " + tenKH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbGio = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbPhut = new javax.swing.JComboBox<>();
        cbBan = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatBan = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnSXTheoTen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cbGio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Giờ");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Phút");

        cbPhut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " " }));

        cbBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));

        jPanel1.setBackground(new java.awt.Color(197, 225, 172));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));

        tblDatBan.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        tblDatBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên khách hàng", "Số điện thoại", "Bàn số", "Giờ vào", "Ngày vào", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatBan.setRowHeight(25);
        tblDatBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatBan);

        btnThem.setBackground(new java.awt.Color(214, 85, 23));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add1.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(214, 85, 23));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setBorderPainted(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(61, 131, 24));

        btnHome.setBackground(new java.awt.Color(214, 85, 23));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Home.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐẶT BÀN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btnHome)
                .addGap(356, 356, 356)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnHome)
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnXoa.setBackground(new java.awt.Color(214, 85, 23));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Remove.png"))); // NOI18N
        btnXoa.setText("Hủy bàn");
        btnXoa.setBorderPainted(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(214, 85, 23));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorderPainted(false);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnSXTheoTen.setBackground(new java.awt.Color(214, 85, 23));
        btnSXTheoTen.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnSXTheoTen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sortAZ .png"))); // NOI18N
        btnSXTheoTen.setText("SX theo tên");
        btnSXTheoTen.setBorderPainted(false);
        btnSXTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXTheoTenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSXTheoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSXTheoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1209, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        //String sdt = JOptionPane.showInputDialog(this, "Nhập số điện thoại khách hàng");
        String sdt = JOptionPane.showInputDialog(rootPane, "Nhập số điện thoại khách hàng", "Tìm bàn đặt", HEIGHT);
        System.out.println("SDT vua nhap: " + sdt);
        dsBanDatCuaKH.clear();
        for (BanDat banDat : dsBanDat) {
            if (banDat.getSoDT().equals(sdt)) {
                dsBanDatCuaKH.add(banDat);
            }
        }
        if (dsBanDatCuaKH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có thông tin khách hàng");
        } else {
            hienThiThongTinBanDatCuaKH();
            ds.setVisible(true);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnSXTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXTheoTenActionPerformed
        Comparator<BanDat> com = new Comparator<BanDat>() {
            @Override
            public int compare(BanDat o1, BanDat o2) {
                String ten1 = o1.getTenKH();
                String ten2 = o2.getTenKH();
                return ten1.compareTo(ten2);
            }
        };
        Collections.sort(dsBanDat, com);
        hienThiThongTinBanDat();
    }//GEN-LAST:event_btnSXTheoTenActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
        DatBanPopUp addKh = new DatBanPopUp();
        String gioCu = "";
        addKh.setVisible(true);
        BanDat banDat = new BanDat(9012, "25", "20231212", "12:00", "Nguyen", "Thong", 1, "0123456789", "Ko");
        updateOrAdd(addKh, banDat, gioCu);
    }// GEN-LAST:event_btnThemActionPerformed

    private String getGio(String gio) {
        return gio.substring(0, 2);
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
        DatBanPopUp suaDB = new DatBanPopUp();
        suaDB.setVisible(true);
        suaDB.getBtnThem().setVisible(true);
        suaDB.showTen().setText("       Sửa thông tin");
        suaDB.getBtnThem().setText("Sửa");
        String gioCu;
        int index = tblDatBan.getSelectedRow();
        BanDat banDat = dsBanDat.get(index);

        String ten = banDat.getHoKH() + " " + banDat.getTenKH();
        suaDB.getHoTen().setText(ten);
        suaDB.getSDT().setText(banDat.getSoDT());
        suaDB.getSoBn().setSelectedItem(banDat.getSoBan());
        System.out.println("NGAY: " + banDat.getNgayVao());
        try {
            Date thedate = (Date) new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(banDat.getNgayVao());
            suaDB.getNgay().setDate(thedate);
        } catch (ParseException ex) {
            Logger.getLogger(DatBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        suaDB.getGhiChu().setText(banDat.getGhiChu());
        String gio = banDat.getGioVao().substring(0, 2);
        String phut = banDat.getGioVao().substring(3, 5);
        suaDB.getGio().setSelectedIndex(Integer.parseInt(gio));
        suaDB.getPhut().setSelectedIndex(Integer.parseInt(phut));
        gioCu = gio + ":" + phut + ":00";
        updateOrAdd(suaDB, banDat, gioCu);
    }// GEN-LAST:event_btnSuaActionPerformed

    private void updateOrAdd(DatBanPopUp suaDB, BanDat banDat, String gioCu) {
        suaDB.getBtnThem().addActionListener((l) -> {
            try {
                boolean check = true;
                Date now = new Date();

                SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

                sdtCu = banDat.getSoDT();
                hoKH = "";
                tenKH = "";
                int ngayVao = Integer.parseInt(dateFormat.format(suaDB.getNgay().getDate()));
                System.out.println("Ngay vao cua khach: " + ngayVao);
                int ngayHienTai = Integer.parseInt(dateFormat.format(now));
                String ngayVaoCu = banDat.getNgayVao();

                if (suaDB.getHoTen().getText().equals("")) {
                    System.out.println("ten dang null");
                    check = false;
                    suaDB.error1().setText("Tên không được để trống");
                } else {
                    suaDB.error1().setText("");
                }
                if (suaDB.getSDT().getText().length() != 10) {
                    suaDB.error2().setText("Định dạng đúng của số điện thoại là 10 số");
                    check = false;
                } else if (!banDat.getSoDT().equals(suaDB.getSDT().getText())
                        && "       Sửa thông tin".equals(suaDB.showTen().getText())) {
                    for (BanDat banDat1 : dsBanDat) {
                        if (banDat1.getSoDT().equals(suaDB.getSDT().getText())) {
                            System.out.println("so dien thoai man hình: " + suaDB.getSDT().getText());
                            suaDB.error2().setText("Số điện thoại này đã tồn tại");
                            // suaDB.getSDT().setText(sdtCu);
                            return;
                        }
                    }
                } else {
                    suaDB.error2().setText("");
                }
                if (suaDB.getNgay().toString().equals("")) {
                    suaDB.error3().setText("Ngày không được để trống");
                    check = false;
                } else if (ngayVao < ngayHienTai) {
                    check = false;
                    suaDB.error3().setText("Ngày không hợp lệ");
                } else if (ngayVao == ngayHienTai) {
                    int gioHienTai = Integer.valueOf(hourFormat.format(now).substring(0, 2));
                    int phutHienTai = Integer.valueOf(hourFormat.format(now).substring(3, 5));
                    System.out.println("Gio hien tai: " + gioHienTai);
                    if (gioHienTai > Integer.valueOf(suaDB.getGio().getSelectedItem().toString())) {
                        System.out.println("Gio hien tai: " + gioHienTai);
                        check = false;
                        suaDB.error3().setText("Giờ vào không hợp lệ");
                    } else if (gioHienTai == Integer.valueOf(suaDB.getGio().getSelectedItem().toString())
                            && Integer.valueOf(suaDB.getPhut().getSelectedItem().toString()) < phutHienTai) {
                        check = false;
                        suaDB.error3().setText("Giờ vào không hợp lệ");
                    } else if (suaDB.checkBanTrong(String.valueOf(ngayVao),
                            suaDB.getSoBn().getSelectedItem().toString(), gioCu)) {
                        check = false;
                        System.out.println("Vao 1");
                        suaDB.error3().setText("Bàn này đang được sử dụng");
                    } else {
                        suaDB.error3().setText("");
                    }
                } else if (suaDB.checkBanTrong(String.valueOf(ngayVao), suaDB.getSoBn().getSelectedItem().toString(),
                        gioCu)) {
                    check = false;
                    System.out.println("Vao 2");
                    suaDB.error3().setText("Bàn này đang được sử dụng");
                }
                boolean ok = false;
                if (dsPhieuDVHomNay.isEmpty()) {
                    ok = true;
                } else {
                    for (PhieuSuDungDV phieu : dsPhieuDVHomNay) {
                        int gioDangSD = Integer.parseInt(getGio(phieu.getGioVao())) - 2;
                        System.out.println("Gio dang su dung: " + gioDangSD);
                        int gioVaoKH = Integer.valueOf(suaDB.getGio().getSelectedItem().toString());
                        System.out.println("Ban dat cua phieu la: " + phieu.getSoBan());
                        System.out.println("Ban dat cua KH la:  " + suaDB.getSoBn().getSelectedItem());
                        System.out.println("Ngay vao cua phieu: " + phieu.getNgayVao());
                        String ngayKHVao = anotherDateFormat.format(suaDB.getNgay().getDate());
                        if (phieu.getNgayVao().equals(ngayKHVao)
                                && phieu.getSoBan().equals(suaDB.getSoBn().getSelectedItem().toString())) {
                            System.out.println("Trung ban so: " + banDat.getSoBan());
                            if ((gioVaoKH < gioDangSD)
                                    || (gioVaoKH > gioDangSD + 4)) {
                                System.out.println("Vo day de check");
                                ok = true;
                            } else {
                                System.out.println("Da vao ở đây");
                                ok = false;
                                break;
                            }
                        } else {
                            ok = true;
                        }
                    }
                }

                if (ok == false) {
                    System.out.println("Vao check case nay");
                    suaDB.error3().setText("Bàn này đang được sử dụng");
                }
                if (check && ok) {
                    String action;
                    getHoTenKH(" " + suaDB.getHoTen().getText());
                    banDat.setTenKH(tenKH);
                    banDat.setHoKH(hoKH);
                    banDat.setSoDT(suaDB.getSDT().getText());
                    banDat.setSoBan(String.valueOf(suaDB.getSoBn().getSelectedItem()));
                    String gioVao = suaDB.getGio().getSelectedItem().toString();
                    String phutVao = suaDB.getPhut().getSelectedItem().toString();
                    banDat.setNgayVao(String.valueOf(ngayVao));
                    banDat.setGioVao(gioVao + ":" + phutVao);
                    if ("       Sửa thông tin".equals(suaDB.showTen().getText())) {
                        action = "Cập nhật";
                    } else {
                        action = "Thêm";
                    }
                    banDat.setGhiChu(suaDB.getGhiChu().getText());
                    int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn " + action + " không?");
                    if (option == 0) {
                        System.out.println("sdt; " + banDat.getSoDT());
                        try {
                            System.out.println("Ma PD: " + banDat.getMaPD());
                            if ("Cập nhật".equals(action)) {
                                if (banDatDAO.capNhatBan(banDat, sdtCu, ngayVaoCu)) {
                                    System.out.println(action + " thanh cong");
                                    dsBanDat.clear();
                                    dsBanDat = banDatDAO.getAll();
                                    hienThiThongTinBanDat();
                                }
                            } else {
                                if (banDatDAO.datBan(banDat, currentNV.getMaNV())) {
                                    System.out.println(action + " thanh cong");
                                    dsBanDat.clear();
                                    dsBanDat = banDatDAO.getAll();
                                    hienThiThongTinBanDat();
                                }
                            }
                            suaDB.dispose();
                        } catch (Exception ex) {
                            System.out.println("Loi roi");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("error: " + e);
            }

        });
    }

    private void tblDatBanMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblDatBanMouseClicked
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }// GEN-LAST:event_tblDatBanMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed
        int index = tblDatBan.getSelectedRow();
        BanDat banDat = dsBanDat.get(index);
        int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy bàn này không?");
        if (option == 0) {
            try {
                System.out.println("Ma phieu dat: " + banDat.getMaPD());
                if (banDatDAO.huyBan(banDat, banDat.getMaPD())) {
                    System.out.println("Ma phieu dat: " + banDat.getMaPD());
                    System.out.println("Huy ban thanh cong");
                    dsBanDat.clear();
                    dsBanDat = banDatDAO.getAll();
                    hienThiThongTinBanDat();
                    // resetForm();
                } else {
                    System.out.println("Huy that bai");
                }
            } catch (Exception e) {
                System.out.println("error: " + e);
            }
        }
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }// GEN-LAST:event_btnXoaActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }// GEN-LAST:event_btnHomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSXTheoTen;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbBan;
    private javax.swing.JComboBox<String> cbGio;
    private javax.swing.JComboBox<String> cbPhut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatBan;
    // End of variables declaration//GEN-END:variables
}
