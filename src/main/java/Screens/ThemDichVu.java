/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Screens;

import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class ThemDichVu extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ThemDichVu() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public ThemDichVu(JButton jButton1, JComboBox<String> jComboBox1, JComboBox<String> jComboBox2, JLabel jLabel1,
            JLabel jLabel2, JLabel jLabel3, JLabel jLabel4, JLabel jLabel5, JLabel jLabel6, JTextField jTextField2,
            JTextField jTextField3, JTextField jTextField4) throws HeadlessException {
        this.BtnThem = jButton1;
        this.CBLoaiDV = jComboBox2;
        this.jLabel1 = jLabel1;
        this.jLabel3 = jLabel3;
        this.jLabel4 = jLabel4;
        this.jLabel6 = jLabel6;
        this.txtTenDv = jTextField3;
        this.txtDonGia = jTextField4;
    }

    public JTextField getTen() {
        return txtTenDv;
    }

    public JTextField getGia() {
        return txtDonGia;
    }

    public JComboBox getLoaiDV() {
        return CBLoaiDV;
    }

    public JButton Them() {
        return BtnThem;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        BtnThem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        BtnLamMoi = new javax.swing.JButton();
        txtTenDv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CBLoaiDV = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(197, 225, 172));

        jPanel2.setBackground(new java.awt.Color(61, 131, 24));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THÊM DỊCH VỤ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(92, 92, 92)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Đơn giá");

        txtDonGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDonGia.setText("0");
        txtDonGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDonGiaKeyTyped(evt);
            }
        });

        BtnThem.setBackground(new java.awt.Color(214, 85, 23));
        BtnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        BtnThem.setText("Thêm");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Loại dịch vụ");

        BtnLamMoi.setBackground(new java.awt.Color(214, 85, 23));
        BtnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Clear.png"))); // NOI18N
        BtnLamMoi.setText("Làm mới");
        BtnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLamMoiActionPerformed(evt);
            }
        });

        txtTenDv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên dịch vụ");

        CBLoaiDV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CBLoaiDV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Món ăn ", "Đồ uống", "Tiện ích" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(BtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(BtnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3))
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(txtTenDv)
                                                        .addComponent(txtDonGia)
                                                        .addComponent(CBLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(17, 17, 17)))));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtTenDv, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(CBLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BtnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 19, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDonGiaKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtDonGiaKeyTyped
        char e = evt.getKeyChar();
        if (!Character.isDigit(e)) {
            evt.consume();
        }
        // TODO add your handling code here:
    }// GEN-LAST:event_txtDonGiaKeyTyped

    private void BtnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnLamMoiActionPerformed
        txtDonGia.setText("0");
        txtTenDv.setText("");
        // TODO add your handling code here:
    }// GEN-LAST:event_BtnLamMoiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLamMoi;
    private javax.swing.JButton BtnThem;
    private javax.swing.JComboBox<String> CBLoaiDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtTenDv;
    // End of variables declaration//GEN-END:variables
}
