/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Screens;

import DAO.BanDatDAO;
import DAO.KhachHangDAO;
import Models.BanDat;
import Models.KhachHang;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DatBanPopUp extends javax.swing.JFrame {

    /**
     * Creates new form DatBanPopUp
     */
    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    List<BanDat> dsBanDaDatHomNay = new ArrayList<>();
    List<KhachHang> dsKhachHang = new ArrayList<>();
    BanDatDAO banDatDAO = new BanDatDAO();
    KhachHangDAO khDao = new KhachHangDAO();
    int ngayHienTai;
    String gioHienTai;

    public DatBanPopUp() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        btnThem.setVisible(true);
        try {
            dsKhachHang = khDao.danhSachKhachHang();
        } catch (Exception ex) {
            Logger.getLogger(DatBanPopUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        clock();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtTit = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ChuY1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        ChuY2 = new javax.swing.JLabel();
        ChuY3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        ChuY4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        ChuY5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtThoiGian = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        CBGio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        CBPhut = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        CBSoBan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jComboBox2.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(197, 225, 172));

        jPanel2.setBackground(new java.awt.Color(61, 131, 24));

        txtTit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTit.setForeground(new java.awt.Color(255, 255, 255));
        txtTit.setText("Thông tin khách hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTit)
                                .addGap(68, 68, 68)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addComponent(txtTit)
                                .addGap(15, 15, 15)));

        btnThem.setBackground(new java.awt.Color(214, 85, 23));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Done.png"))); // NOI18N
        btnThem.setText("Thêm");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Ghi chú");

        ChuY1.setForeground(new java.awt.Color(255, 51, 51));

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        ChuY2.setForeground(new java.awt.Color(255, 51, 51));

        ChuY3.setForeground(new java.awt.Color(255, 51, 51));
        ChuY3.setText(" ");

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        ChuY4.setForeground(new java.awt.Color(255, 51, 51));
        ChuY4.setText(" ");

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSDTKeyPressed(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSDTKeyTyped(evt);
            }
        });

        ChuY5.setForeground(new java.awt.Color(255, 51, 51));
        ChuY5.setText(" ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Họ tên");

        txtThoiGian.setDateFormatString("dd-MM-yyyy");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Số điện thoại");

        CBGio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số bàn");

        CBPhut.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                        "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",
                        "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47",
                        "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Thời gian");

        CBSoBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CBSoBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8",
                "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));
        CBSoBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBSoBanActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giờ");

        jButton2.setBackground(new java.awt.Color(214, 85, 23));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Clear.png"))); // NOI18N
        jButton2.setText("Nhập lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Phút");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel3,
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel2)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                .addComponent(ChuY2,
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(txtSDT,
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 235,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(CBSoBan, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ChuY1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ChuY3, javax.swing.GroupLayout.DEFAULT_SIZE, 262,
                                                                Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addGap(55, 55, 55))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel1Layout.createSequentialGroup()
                                                                        .addGap(62, 62, 62)
                                                                        .addComponent(jLabel6)
                                                                        .addGap(18, 18, 18)))
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(CBGio,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jLabel7)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(CBPhut,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(ChuY4,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(ChuY5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                197,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addGap(38, 38, 38)
                                                                .addComponent(txtThoiGian,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 235,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnThem,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 137,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(33, 33, 33)
                                                                .addComponent(jButton2)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 21, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChuY2, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(1, 1, 1)
                                .addComponent(ChuY1, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(CBSoBan, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(ChuY3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChuY4, javax.swing.GroupLayout.PREFERRED_SIZE, 14,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(CBGio, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CBPhut, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addComponent(ChuY5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(btnThem))
                                .addGap(18, 18, 18)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSDTKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtSDTKeyTyped
        char e = evt.getKeyChar();
        if (!Character.isDigit(e)) {
            evt.consume();
        }
        // TODO add your handling code here:
    }// GEN-LAST:event_txtSDTKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        txtHoTen.setText("");
        txtSDT.setText("");
        CBSoBan.getItemAt(0);
        CBGio.getItemAt(0);
        CBPhut.getItemAt(0);
        txtGhiChu.setText("");
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton2ActionPerformed

    public final void clock() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        ngayHienTai = Integer.parseInt(format1.format(now));
                        gioHienTai = hourFormat.format(now);
                        sleep(1000);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
            }
        };
        clock.start();
    }

    public boolean checkBanTrong(String ngayVao, String soBan, String gioCu) {
        boolean ok = true;
        try {
            System.out.println("Ngay vao khi check ban trong: " + ngayVao);
            dsBanDaDatHomNay = banDatDAO.layBanDatHomNay(ngayVao);
            System.out.println("So ban dat hom hay la: " + dsBanDaDatHomNay.size());
            if (dsBanDaDatHomNay.isEmpty()) {
                System.out.println("Khong co ban ");
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(DatBanPopUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (BanDat banDat : dsBanDaDatHomNay) {
            if (String.valueOf(banDat.getGioVao()).equals(gioCu)) {
                System.out.println("Vo day roi nhe");
                ok = true;
                continue;
            }
            System.out.println("Nhay vao day");
            int gioDangSD = Integer.valueOf(banDat.getGioVao().substring(0, 2)) + 2;
            System.out.println("So ban 1: " + banDat.getSoBan());
            System.out.println("So ban 2: " + soBan);
            if (banDat.getSoBan().equals(soBan)) {
                System.out.println("Gio toi da: " + gioDangSD);
                if ((gioDangSD < Integer.valueOf(CBGio.getSelectedItem().toString()))
                        || (Integer.valueOf(CBGio.getSelectedItem().toString()) < gioDangSD - 4)) {
                    System.out.println("Gio muon vao: " + CBGio.getSelectedItem().toString());
                    ok = true;
                } else {
                    System.out.println("Gio muon vao: " + CBGio.getSelectedItem().toString());
                    System.out.println("Gio dang su dung: " + gioDangSD);
                    ok = false;
                    break;
                }
            }

        }
        if (ok) {
            return false;
        }
        return true;
    }

    private void btnKiemTraActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKiemTraActionPerformed

        // TODO add your handling code here:
    }// GEN-LAST:event_btnKiemTraActionPerformed

    private void CBSoBanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CBSoBanActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_CBSoBanActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtHoTenActionPerformed

    private void txtSDTKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtSDTKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            KhachHang kh = kiemTraTonTaiKhachHang(getSDT().getText());
            if (kh != null) {
                txtHoTen.setText(kh.getHoKH() + " " + kh.getTenKH());

            }

        }
    }// GEN-LAST:event_txtSDTKeyPressed

    private KhachHang kiemTraTonTaiKhachHang(String sdt) {
        for (KhachHang kh : dsKhachHang) {
            if (sdt.equals(kh.getSdt())) {
                return kh;
            }
        }
        return null;
    }

    public JLabel error1() {
        return ChuY1;
    }

    public JLabel error2() {
        return ChuY2;
    }

    public JLabel error3() {
        return ChuY4;
    }

    public JTextField getHoTen() {
        return txtHoTen;
    }

    public JTextField getSDT() {
        return txtSDT;
    }

    public JComboBox getSoBn() {
        return CBSoBan;
    }

    public JTextArea getGhiChu() {
        return txtGhiChu;
    }

    public JDateChooser getNgay() {
        return txtThoiGian;
    }

    public JComboBox getGio() {
        return CBGio;
    }

    public JComboBox getPhut() {
        return CBPhut;
    }

    public JButton getBtnThem() {
        return btnThem;
    }

    public JLabel showTen() {
        return txtTit;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBGio;
    private javax.swing.JComboBox<String> CBPhut;
    private javax.swing.JComboBox<String> CBSoBan;
    private javax.swing.JLabel ChuY1;
    private javax.swing.JLabel ChuY2;
    private javax.swing.JLabel ChuY3;
    private javax.swing.JLabel ChuY4;
    private javax.swing.JLabel ChuY5;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSDT;
    private com.toedter.calendar.JDateChooser txtThoiGian;
    private javax.swing.JLabel txtTit;
    // End of variables declaration//GEN-END:variables
}