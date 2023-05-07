/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Screens;

import DAO.NhanVienDAO;
import Models.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DanhSachNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form DanhSachNhanVien
     */
    NhanVienDAO nvDAO = new NhanVienDAO();
    List<NhanVien> lstNhanVien = new ArrayList<>();

    public DanhSachNhanVien() {
        initComponents();

        try {

            lstNhanVien = nvDAO.getAll();
        } catch (Exception e) {
        }
        showData();
        btnSua.setEnabled(false);
        btnDoiMK.setEnabled(false);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnDoiMK = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnSapxep = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BtnHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(197, 225, 172));

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ", "Tên", "Số điện thoại", "Địa chỉ", "Trạng Thái", "Vai Trò"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table1.setRowHeight(25);
        Table1.getTableHeader().setReorderingAllowed(false);
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Table1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);
        if (Table1.getColumnModel().getColumnCount() > 0) {
            Table1.getColumnModel().getColumn(0).setResizable(false);
            Table1.getColumnModel().getColumn(1).setResizable(false);
            Table1.getColumnModel().getColumn(2).setResizable(false);
            Table1.getColumnModel().getColumn(3).setResizable(false);
            Table1.getColumnModel().getColumn(4).setResizable(false);
            Table1.getColumnModel().getColumn(5).setResizable(false);
            Table1.getColumnModel().getColumn(6).setResizable(false);
        }

        btnThem.setBackground(new java.awt.Color(214, 85, 23));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/AddUser.png"))); // NOI18N
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
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnDoiMK.setBackground(new java.awt.Color(214, 85, 23));
        btnDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Reset-Pass.png"))); // NOI18N
        btnDoiMK.setText("Đổi mật khẩu");
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(214, 85, 23));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnSapxep.setBackground(new java.awt.Color(214, 85, 23));
        btnSapxep.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSapxep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Sort.png"))); // NOI18N
        btnSapxep.setText("Sắp xếp");
        btnSapxep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapxepActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(61, 131, 24));

        BtnHome.setBackground(new java.awt.Color(214, 85, 23));
        BtnHome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Home.png"))); // NOI18N
        BtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(BtnHome)
                .addGap(320, 320, 320)
                .addComponent(jLabel1)
                .addContainerGap(398, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BtnHome)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSapxep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnHomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnHomeActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }// GEN-LAST:event_BtnHomeActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
        ThemNhanVien addnv = new ThemNhanVien();
        addnv.setVisible(true);
        addnv.lstNhanVien = lstNhanVien;
        addnv.buttonThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    NhanVien nv = new NhanVien(
                            maNhanVien(lstNhanVien.get(lstNhanVien.size() - 1).getMaNV()),
                            addnv.getHo().getText(),
                            addnv.getTen().getText(),
                            addnv.getDiaChi().getText(),
                            true,
                            addnv.getSdt().getText(),
                            addnv.getMatKhau().getText(),
                            addnv.getvaitro().getSelectedIndex() + 1);
                    if (nvDAO.themNhanVien(nv)) {
                        lstNhanVien.add(nv);
                        addnv.dispose();
                        showData();
                        JOptionPane.showMessageDialog(rootPane, "Thêm thành công.");
                    }
                } catch (Exception e) {
                }
            }
        });

        // TODO add your handling code here:
    }// GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
        SuaNhanVien snv = new SuaNhanVien();
        snv.setVisible(true);
        int index = Table1.getSelectedRow();
        NhanVien nvChon = lstNhanVien.get(index);
        snv.SDTcu = nvChon.getSdt();
        snv.lstNhanVien = lstNhanVien;

        // Show infor
        snv.getHo().setText(nvChon.getHo());
        snv.getTen().setText(nvChon.getTen());
        snv.getDiaChi().setText(nvChon.getDiaChi());
        snv.getSdt().setText(nvChon.getSdt());
        snv.gettrangthai().setSelectedItem(tthai(nvChon));
        snv.getvaitro().setSelectedIndex(nvChon.getMaVaiTro() - 1);
        snv.manv().setText(nvChon.getMaNV());

        // Button sua
        snv.buttonSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhanVien nv = new NhanVien(
                        nvChon.getMaNV(),
                        snv.getHo().getText(),
                        snv.getTen().getText(),
                        snv.getDiaChi().getText(),
                        "Hoạt động".equals(snv.gettrangthai().getSelectedItem()),
                        snv.getSdt().getText(),
                        nvChon.getMatKhau(),
                        snv.getvaitro().getSelectedIndex() + 1);
                try {
                    nvDAO.capNhatNhanVien(nv, nv.getMaNV());
                    snv.dispose();
                    lstNhanVien.set(index, nv);
                    showData();
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công.");
                    Table1.setRowSelectionInterval(index, index);
                } catch (Exception ex) {
                    Logger.getLogger(DanhSachNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        // TODO add your handling code here:
    }// GEN-LAST:event_btnSuaActionPerformed

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDoiMKActionPerformed
        DoiMK dmk = new DoiMK();
        dmk.setLocationRelativeTo(null);
        dmk.setVisible(true);

        int index = Table1.getSelectedRow();
        NhanVien nvChon = lstNhanVien.get(index);
        dmk.showMa().setText(nvChon.getMaNV());
        dmk.btndoimk().addActionListener((e) -> {
            if( "".equals(dmk.GPass1().getText()))
                JOptionPane.showMessageDialog(this, "Không được để trống mật khẩu", "Không được để trống mật khẩu",
                        JOptionPane.ERROR_MESSAGE);
            else
            {   
            if (dmk.GPass1().getText() == null ? dmk.GPass2().getText() == null
                    : dmk.GPass1().getText().equals(dmk.GPass2().getText())) {
                try {
                    nvDAO.doiMatKhau(nvChon.getMaNV(), dmk.GPass1().getText());
                } catch (Exception ex) {
                    Logger.getLogger(DanhSachNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                showData();
                dmk.dispose();
                JOptionPane.showMessageDialog(rootPane, "Đổi thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Mật khẩu không khớp", "Mật khẩu không khớp",
                        JOptionPane.ERROR_MESSAGE);
            }
            }
        });
    }// GEN-LAST:event_btnDoiMKActionPerformed

    private void btnSapxepActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSapxepActionPerformed
        Table1.setAutoCreateRowSorter(true);
        btnSua.setEnabled(false);
        btnDoiMK.setEnabled(false);
        JOptionPane.showMessageDialog(rootPane, "Chọn cột để sắp xếp");
        // TODO add your handling code here:
    }// GEN-LAST:event_btnSapxepActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTimKiemActionPerformed

        String Smanv = JOptionPane.showInputDialog(rootPane, "Nhập mã nhân viên cần tìm:", "Tìm nhân viên", HEIGHT).toUpperCase();
        int i = -1;
        for (NhanVien nv : lstNhanVien) {
            if (Smanv == null ? nv.getMaNV() == null : Smanv.equals(nv.getMaNV())) {
                i = lstNhanVien.indexOf(nv);
                TimKiemNV a = new TimKiemNV();
                a.setVisible(true);
                a.getHo().setText(lstNhanVien.get(i).getHo());
                a.getTen().setText(lstNhanVien.get(i).getTen());
                a.getDiaChi().setText(lstNhanVien.get(i).getDiaChi());
                a.getSdt().setText(lstNhanVien.get(i).getSdt());
                a.gettrangthai().setSelectedItem(tthai(lstNhanVien.get(i)));
                a.getvaitro().setSelectedIndex(lstNhanVien.get(i).getMaVaiTro() - 1);
                a.manv().setText(lstNhanVien.get(i).getMaNV());
                break;
            }
        }
        if (i == -1)
            JOptionPane.showMessageDialog(rootPane, "Không tồn tại nhân viên");
        // TODO add your handling code here:
    }// GEN-LAST:event_btnTimKiemActionPerformed

    private void Table1MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_Table1MousePressed
        btnSua.setEnabled(true);
        btnDoiMK.setEnabled(true);
    }// GEN-LAST:event_Table1MousePressed

    private String tthai(NhanVien a) {
        if (a.getTrangThai())
            return "Hoạt động";
        else
            return "Không hoạt động";
    }

    private String vtro(int i) {
        if (i == 1)
            return "Quản lý";
        else
            return "Nhân viên";
    }

    public DanhSachNhanVien(JTable Table1, JButton btnDoiMK, JButton btnSapxep, JButton btnSua, JButton btnThem,
            JButton btnTimKiem, JButton jButton9, JFrame jFrame1, JLabel jLabel1, JLabel jLabel2,
            JScrollPane jScrollPane1) throws HeadlessException {
        this.Table1 = Table1;
        this.btnDoiMK = btnDoiMK;
        this.btnSapxep = btnSapxep;
        this.btnSua = btnSua;
        this.btnThem = btnThem;
        this.btnTimKiem = btnTimKiem;
        this.BtnHome = jButton9;
        this.jFrame1 = jFrame1;
        this.jLabel1 = jLabel1;

        this.jScrollPane1 = jScrollPane1;
    }

    private String maNhanVien(String ma) {
        String maMoi = "";
        for (int i = 2; i < ma.length(); i++) {
            maMoi += ma.charAt(i);
        }
        int mm = Integer.parseInt(maMoi);
        mm++;
        maMoi = "NV";
        if (mm < 10) {
            maMoi += "00" + String.valueOf(mm);
        } else if (mm < 100) {
            maMoi += "0" + String.valueOf(mm);
        } else {
            maMoi += String.valueOf(mm);
        }
        return maMoi;
    }

    public void showData() {
        DefaultTableModel dsnv = (DefaultTableModel) Table1.getModel();
        dsnv.setRowCount(0);
        for (NhanVien nv : lstNhanVien) {
            dsnv.addRow(new Object[] { nv.getMaNV(), nv.getHo(), nv.getTen(), nv.getSdt(), nv.getDiaChi(), tthai(nv),
                    vtro(nv.getMaVaiTro())
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnHome;
    private javax.swing.JTable Table1;
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnSapxep;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
