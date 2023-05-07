/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataHelper.DataHelper;
import Models.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T3D Computer
 */
public class NhanVienDAO {
    public List<NhanVien> getAll() throws Exception {
        List<NhanVien> lstSinhvien = new ArrayList<>();
        String sql = "select * from NhanVien";
        try (
                Connection con = DataHelper.openConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("maNV"));
                nv.setTen(rs.getString("tenNV"));
                nv.setHo(rs.getString("hoNV"));
                nv.setSdt(rs.getString("sdt"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setTrangThai(rs.getBoolean("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setMaVaiTro(rs.getInt("maVaiTro"));
                lstSinhvien.add(nv);
            }
        }
        return lstSinhvien;
    }

    public boolean themNhanVien(NhanVien nv) throws Exception {
        String sql = "insert into NhanVien(maNV, tenNV, hoNV, sdt, diaChi, trangThai, matKhau, maVaiTro) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection con = DataHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, nv.getMaNV());
            pstm.setString(2, nv.getTen());
            pstm.setString(3, nv.getHo());
            pstm.setString(4, nv.getSdt());
            pstm.setString(5, nv.getDiaChi());
            pstm.setBoolean(6, nv.getTrangThai());
            pstm.setString(7, nv.getMatKhau());
            pstm.setInt(8, nv.getMaVaiTro());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean capNhatNhanVien(NhanVien nv, String manv) throws Exception {
        String sql = "Update NhanVien set maNV = ?, tenNV = ?, hoNV = ?, sdt = ?, diaChi = ?, trangThai = ?, matKhau = ?, maVaiTro = ? where MaNV = ?";
        try (
                Connection con = DataHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, nv.getMaNV());
            pstm.setString(2, nv.getTen());
            pstm.setString(3, nv.getHo());
            pstm.setString(4, nv.getSdt());
            pstm.setString(5, nv.getDiaChi());
            pstm.setBoolean(6, nv.getTrangThai());
            pstm.setString(7, nv.getMatKhau());
            pstm.setInt(8, nv.getMaVaiTro());
            pstm.setString(9, manv);
            return pstm.executeUpdate() > 0;
        }
    }

    public NhanVien findByMaNV(String maNV) throws Exception {
        String sql = "select * from NhanVien where maNV = ?";
        try (
                Connection con = DataHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maNV);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("maNV"));
                nv.setTen(rs.getString("tenNV"));
                nv.setHo(rs.getString("hoNV"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setTrangThai(rs.getBoolean("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setMaVaiTro(rs.getInt("maVaiTro"));
                return nv;
            }
            return null;
        }
    }

    public boolean doiMatKhau(String maNV, String mk) throws Exception {
        String sql = "Update NhanVien set matKhau = ? where maNV = ?";
        try (
                Connection con = DataHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, mk);
            pstm.setString(2, maNV);
            return pstm.executeUpdate() > 0;
        }
    }

    // public boolean xoaNhanVien(String maNV) throws Exception {
    // String sql = "delete from NhanVien where MaNV = ?";
    // try (
    // Connection con = DataHelper.openConnection();
    // PreparedStatement pstm = con.prepareStatement(sql);)
    // {
    // pstm.setString(1, maNV);
    // return pstm.executeUpdate() > 0;
    // }
    // }
}
