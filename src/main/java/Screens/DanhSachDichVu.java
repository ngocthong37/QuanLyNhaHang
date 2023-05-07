/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Screens;

import DAO.DichVuDAO;
import Models.DichVu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class DanhSachDichVu extends javax.swing.JFrame {
    DichVuDAO dvDao = new DichVuDAO();
    List<DichVu> lstDichVu = new ArrayList<>();

    public DanhSachDichVu() {
        initComponents();
        try {
            lstDichVu = dvDao.getAll();
        } catch (Exception e) {
        }

        showData();
        BtnSua.setEnabled(false);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    @SuppressWarnings("unchecked")
    private void showData() {
        DefaultTableModel dsdv = (DefaultTableModel) Tabledv.getModel();
        DecimalFormat dcf = new DecimalFormat("###,### VND");
        dsdv.setRowCount(0);
        for (DichVu dv : lstDichVu) {
            dsdv.addRow(new Object[] { dv.getMaDichVu(), dv.getTenDichVu(), dcf.format(dv.getDonGia()),
                    tthai(dv.getTrangThai()), ldv(dv.getMaLoaiDichVu())
            });
        }
    }

    private String tthai(boolean a) {
        if (a)
            return "Đang phục vụ";
        else
            return "Ngưng phục vụ";
    }

    private String ldv(int a) {
        if (a == 1)
            return "Món ăn";
        if (a == 2)
            return "Đồ uống";
        return "Tiện ích";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabledv = new javax.swing.JTable();
        BtnThem = new javax.swing.JButton();
        BtnSua = new javax.swing.JButton();
        BtnTimKiem = new javax.swing.JButton();
        BtnSapXep = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BtnHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(197, 225, 172));
        jPanel1.setPreferredSize(new java.awt.Dimension(1172, 716));

        Tabledv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Tabledv.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "Mã dịch vụ", "Tên dịch vụ", "Đơn giá", "Trạng thái", "Loại dịch vụ"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        Tabledv.setRowHeight(35);
        Tabledv.getTableHeader().setReorderingAllowed(false);
        Tabledv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabledvMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tabledv);
        if (Tabledv.getColumnModel().getColumnCount() > 0) {
            Tabledv.getColumnModel().getColumn(0).setResizable(false);
            Tabledv.getColumnModel().getColumn(1).setResizable(false);
            Tabledv.getColumnModel().getColumn(2).setResizable(false);
            Tabledv.getColumnModel().getColumn(3).setResizable(false);
            Tabledv.getColumnModel().getColumn(4).setResizable(false);
        }

        BtnThem.setBackground(new java.awt.Color(214, 85, 23));
        BtnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add1.png"))); // NOI18N
        BtnThem.setText("Thêm");
        BtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnThemActionPerformed(evt);
            }
        });

        BtnSua.setBackground(new java.awt.Color(214, 85, 23));
        BtnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        BtnSua.setText("Sửa");
        BtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSuaActionPerformed(evt);
            }
        });

        BtnTimKiem.setBackground(new java.awt.Color(214, 85, 23));
        BtnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        BtnTimKiem.setText("Tìm kiếm");
        BtnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTimKiemActionPerformed(evt);
            }
        });

        BtnSapXep.setBackground(new java.awt.Color(214, 85, 23));
        BtnSapXep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnSapXep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Sort.png"))); // NOI18N
        BtnSapXep.setText("Sắp xếp");
        BtnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSapXepActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(61, 131, 24));

        BtnHome.setBackground(new java.awt.Color(214, 85, 23));
        BtnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Home.png"))); // NOI18N
        BtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DANH SÁCH DỊCH VỤ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(BtnHome)
                                .addGap(275, 275, 275)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(BtnHome))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel1)))
                                .addContainerGap(15, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BtnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnSapXep, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnSua, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnThem, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7,
                                                        Short.MAX_VALUE)
                                                .addComponent(BtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(97, 97, 97)
                                                .addComponent(BtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(87, 87, 87)
                                                .addComponent(BtnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(76, 76, 76)
                                                .addComponent(BtnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnHomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnHomeActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }// GEN-LAST:event_BtnHomeActionPerformed

    private void TabledvMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_TabledvMousePressed
        BtnSua.setEnabled(true);
        // TODO add your handling code here:
    }// GEN-LAST:event_TabledvMousePressed

    private void BtnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnThemActionPerformed
        ThemDichVu adddv = new ThemDichVu();
        adddv.setVisible(true);
        adddv.Them().addActionListener((e) -> {
            int gia = Integer.parseInt(adddv.getGia().getText());
            try {
                DichVu dv = new DichVu(
                        lstDichVu.size(),
                        adddv.getTen().getText(),
                        gia,
                        true,
                        adddv.getLoaiDV().getSelectedIndex() + 1);
                if (gia == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng thêm giá");
                } else {
                    if (dvDao.ThemDichVu(dv)) {
                        lstDichVu.add(dv);
                        adddv.dispose();
                        showData();
                        JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                        Tabledv.setRowSelectionInterval(dv.getMaDichVu(), dv.getMaDichVu());
                        BtnSua.setEnabled(true);
                    } else {
                    }
                }

            } catch (Exception a) {
            }
        });
        // TODO add your handling code here:
    }// GEN-LAST:event_BtnThemActionPerformed

    private void BtnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnSuaActionPerformed
        SuaDichVu sdv = new SuaDichVu();
        sdv.setVisible(true);
        int index = Tabledv.getSelectedRow();
        DichVu DVChon = lstDichVu.get(index);
        // Show Info
        sdv.maNV().setText(String.valueOf(DVChon.getMaDichVu()));
        sdv.getTen().setText(DVChon.getTenDichVu());
        sdv.getGia().setText(String.valueOf(DVChon.getDonGia()));
        sdv.getTrangThai().setSelectedItem(tthai(DVChon.getTrangThai()));
        sdv.getLoaiDV().setSelectedIndex(DVChon.getMaLoaiDichVu() - 1);
        // action
        sdv.Btn().addActionListener((e) -> {
            int gia = Integer.parseInt(sdv.getGia().getText());
            try {
                DichVu dv = new DichVu(
                        (index + 1),
                        sdv.getTen().getText(),
                        gia,
                        "Phục vụ".equals(sdv.getTrangThai().getSelectedItem()),
                        sdv.getLoaiDV().getSelectedIndex() + 1);
                dvDao.SuaDichVu(dv);
                sdv.dispose();
                lstDichVu.set(index, dv);
                showData();
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
                Tabledv.setRowSelectionInterval(index, index);
            } catch (Exception q) {
            }
        });
        // TODO add your handling code here:
    }// GEN-LAST:event_BtnSuaActionPerformed

    private void BtnSapXepActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnSapXepActionPerformed
        Tabledv.setAutoCreateRowSorter(true);
        BtnSua.setEnabled(false);
        JOptionPane.showMessageDialog(rootPane, "Chọn cột để sắp xếp");
    }// GEN-LAST:event_BtnSapXepActionPerformed

    private void BtnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnTimKiemActionPerformed
        String Smadv = JOptionPane.showInputDialog(rootPane, "Nhập mã dịch vụ cần tìm:", "Tìm dịch vụ", HEIGHT);
        int i = -1;
        int sma = Integer.parseInt(Smadv);
        for (DichVu dv : lstDichVu) {
            if (dv.getMaDichVu() == sma) {
                i = lstDichVu.indexOf(dv);
                Tabledv.setRowSelectionInterval(i, i);
                SuaDichVu tdv = new SuaDichVu();
                tdv.getTen().setText(Smadv);
                tdv.maNV().setText(String.valueOf(dv.getMaDichVu()));
                tdv.getTen().setText(dv.getTenDichVu());
                tdv.getGia().setText(String.valueOf(dv.getDonGia()));
                tdv.getTrangThai().setSelectedItem(tthai(dv.getTrangThai()));
                tdv.getLoaiDV().setSelectedIndex(dv.getMaLoaiDichVu() - 1);
                tdv.Btn().setVisible(false);
                tdv.Tag().setText("Thông tin dịch vụ");
                tdv.setVisible(true);
                break;
            }
        }
        if (i == -1)
            JOptionPane.showMessageDialog(rootPane, "Không tồn tại dịch vụ");
        // TODO add your handling code here:
    }// GEN-LAST:event_BtnTimKiemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnHome;
    private javax.swing.JButton BtnSapXep;
    private javax.swing.JButton BtnSua;
    private javax.swing.JButton BtnThem;
    private javax.swing.JButton BtnTimKiem;
    private javax.swing.JTable Tabledv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
