/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataHelper.DataHelper;
import Models.ChiTietPhieuAn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T3D Computer
 */
public class PhieuSDDVDao {
    public List<ChiTietPhieuAn> chiTietPhieuAn(int maPSDDV) throws Exception {
        String sql = "{call RS_DANH_SACH_MON_THEO_PSDDV(?)}";
        List<ChiTietPhieuAn> dsPhieuAn = new ArrayList<>();
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);) {
            csttmt.setInt(1, maPSDDV);
            ResultSet rs = csttmt.executeQuery();
            while (rs.next()) {
                csttmt.setInt(1, maPSDDV);
                ChiTietPhieuAn chiTietPhieuAn = new ChiTietPhieuAn();
                chiTietPhieuAn.setMaDichVu(rs.getInt("maDV"));
                chiTietPhieuAn.setTenDichVu(rs.getString("ten dich vu"));
                chiTietPhieuAn.setDonGia(rs.getInt("don gia"));
                chiTietPhieuAn.setSoLuong(rs.getInt("so luong"));
                chiTietPhieuAn.setMaLoaiDichVu(rs.getInt("maLoaiDV"));
                dsPhieuAn.add(chiTietPhieuAn);
            }
        }
        return dsPhieuAn;
    }

    public List<ChiTietPhieuAn> chiTietMonAnPhieuDaThanhToan(int maPSDDV) throws Exception {
        String sql = "{call RS_DANH_SACH_MON_THEO_PSDDV_DA_THANH_TOAN(?)}";
        List<ChiTietPhieuAn> dsPhieuAn = new ArrayList<>();
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);) {
            csttmt.setInt(1, maPSDDV);
            ResultSet rs = csttmt.executeQuery();
            while (rs.next()) {
                csttmt.setInt(1, maPSDDV);
                ChiTietPhieuAn chiTietPhieuAn = new ChiTietPhieuAn();
                chiTietPhieuAn.setMaDichVu(rs.getInt("maDV"));
                chiTietPhieuAn.setTenDichVu(rs.getString("ten dich vu"));
                chiTietPhieuAn.setDonGia(rs.getInt("don gia"));
                chiTietPhieuAn.setSoLuong(rs.getInt("so luong"));
                chiTietPhieuAn.setMaLoaiDichVu(rs.getInt("maLoaiDV"));
                dsPhieuAn.add(chiTietPhieuAn);
            }
        }
        return dsPhieuAn;
    }
    // public List<PhieuSuDungDV> getAll() throws Exception {
    // List<PhieuSuDungDV> dsPhieuSDDV = new ArrayList<>();
    // String sql = "select ban.maBan, soBan, SucChua = sucChua , ban.trangThai ,
    // maPSDDV, ngayVao, TrangThaiPhieu = phieu.trangThai from Ban ban, PhieuSDDV
    // phieu where ban.maBan = phieu.maBan";
    // try (
    // Connection con = DataHelper.openConnection();
    // Statement stmt = con.createStatement();
    // ResultSet rs = stmt.executeQuery(sql);) {
    // while(rs.next()) {
    // PhieuSuDungDV phieu = new PhieuSuDungDV();
    // phieu.setMaBan(rs.getString("maBan"));
    // phieu.setSoBan(rs.getInt("soBan"));
    // phieu.setSucChua(rs.getInt("sucChua"));
    // phieu.setMaPSSV(rs.getString("maPSDDV"));
    // phieu.setTrangThai(rs.getInt("trangThai"));
    // phieu.setTrangThaiPhieu(rs.getBoolean("trangThai"));
    // phieu.setThoiGianVao(rs.getDate("ngayVao").toString());
    // dsPhieuSDDV.add(phieu);
    // }
    // }
    // return dsPhieuSDDV;
    // }
    //
    // public List<ChiTietPhieuAn> getChiTietPhieuAn(int maPhieuSDDV) throws
    // Exception {
    // List<ChiTietPhieuAn> chiTietPhieuAn = new ArrayList<>();
    // String sql = "select dichVu.maDV, maLoaiDV, tenDV, chitiet.soLuong,
    // dichVu.donGia, dichVu.trangThai from PhieuSDDV phieu, DichVu dichVu,
    // CTPhieuSDDV chitiet, Ban ban where phieu.maPSDDV = chitiet.maPSDDV and
    // chitiet.maDV = dichVu.maDV and ban.maBan = phieu.maBan and phieu.maPSDDV =
    // ?";
    // try (
    // Connection con = DataHelper.openConnection();
    // PreparedStatement pstm = con.prepareStatement(sql);)
    //
    // {
    // pstm.setInt(1, maPhieuSDDV);
    // ResultSet rs = pstm.executeQuery();
    //
    // while(rs.next()) {
    // ChiTietPhieuAn chiTiet = new ChiTietPhieuAn();
    // chiTiet.setMaDichVu(rs.getString("maDV"));
    // chiTiet.setTenDichVu(rs.getString("tenDV"));
    // chiTiet.setDonGia(rs.getInt("donGia"));
    // chiTiet.setTrangThai(rs.getBoolean("trangThai"));
    // chiTiet.setMaLoaiDichVu(rs.getInt("maLoaiDV"));
    // chiTiet.setSoLuong(rs.getInt("soLuong"));
    // chiTietPhieuAn.add(chiTiet);
    // }
    // }
    // return chiTietPhieuAn;
    // }
}
