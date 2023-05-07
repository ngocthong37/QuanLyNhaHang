/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataHelper.DataHelper;
import Models.BanAn;
import Models.ChiTietPhieuAn;
import Models.DichVu;
import Models.PhieuSuDungDV;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T3D Computer
 */
public class QuayOrderDAO {

    public List<BanAn> danhSachBanAn() throws Exception {

        String sql = "{call DanhSachBanDangHoatDong()}";
        List<BanAn> dsBan = new ArrayList<>();
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);
                ResultSet rs = csttmt.executeQuery();) {
            while (rs.next()) {
                BanAn banAn = new BanAn();
                banAn.setMaBan(rs.getInt("maBan"));
                banAn.setSoBan(rs.getString("soBan"));
                banAn.setSucChua(rs.getInt("sucChua"));
                banAn.setTrangThai(1);
                dsBan.add(banAn);
            }
        }
        return dsBan;
    }

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

    public List<PhieuSuDungDV> danhSachPhieuSDDV() throws Exception {
        List<PhieuSuDungDV> dsPhieuSDDV = new ArrayList<>();
        String sql = "SELECT PhieuSDDV.maPSDDV, PhieuSDDV.ngayVao, PhieuSDDV.gioVao, trangThaiPhieu = PhieuSDDV.trangThai, Ban.maBan, Ban.soBan, Ban.trangThai, Ban.sucChua from PhieuSDDV, Ban Where PhieuSDDV.maBan = Ban.maBan and PhieuSDDV.trangThai = 0";
        try (
                Connection con = DataHelper.openConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                PhieuSuDungDV phieu = new PhieuSuDungDV();
                phieu.setMaBan(rs.getInt("maBan"));
                phieu.setSoBan(rs.getString("soBan"));
                phieu.setSucChua(rs.getInt("sucChua"));
                phieu.setMaPSDDV(rs.getInt("maPSDDV"));
                phieu.setTrangThai(rs.getInt("trangThai"));
                phieu.setTrangThaiPhieu(rs.getBoolean("trangThaiPhieu"));
                phieu.setGioVao(rs.getString("gioVao"));
                phieu.setNgayVao(rs.getString("ngayVao"));
                dsPhieuSDDV.add(phieu);
            }
        }
        return dsPhieuSDDV;
    }

    public List<PhieuSuDungDV> danhSachPhieuSDDVTheoNgay(String ngayVao) throws Exception {
        List<PhieuSuDungDV> dsPhieuSDDV = new ArrayList<>();
        String sql = "{call danhSachPhieuTheoNgay(?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);) {

            csttmt.setString(1, ngayVao);
            ResultSet rs = csttmt.executeQuery();
            while (rs.next()) {
                PhieuSuDungDV phieu = new PhieuSuDungDV();
                phieu.setMaBan(rs.getInt("maBan"));
                phieu.setSoBan(rs.getString("soBan"));
                phieu.setSucChua(rs.getInt("sucChua"));
                phieu.setMaPSDDV(rs.getInt("maPSDDV"));
                phieu.setTrangThai(rs.getInt("trangThai"));
                phieu.setTrangThaiPhieu(rs.getBoolean("trangThaiPhieu"));
                phieu.setGioVao(rs.getString("gioVao"));
                phieu.setNgayVao(rs.getString("ngayVao"));
                dsPhieuSDDV.add(phieu);
            }
        }
        return dsPhieuSDDV;
    }

    public boolean themPhieuSDDV(String ngayVao, String gioVao, int trangThai, String maNV, int maBan)
            throws Exception {
        String sql = "{call ThemPhieuDichVu(?, ?, ?, ?, ?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql)) {
            csttmt.setString(1, ngayVao);
            csttmt.setString(2, gioVao);
            csttmt.setInt(3, 0);
            csttmt.setString(4, maNV);
            csttmt.setInt(5, maBan);
            return csttmt.executeUpdate() > 0;
        }
    }

    public boolean capNhatThanhToan(int trangThai, int maPSDDV) throws Exception {
        String sql = "{call capNhatThanhToan(?, ?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql)) {
            csttmt.setInt(1, trangThai);
            csttmt.setInt(2, maPSDDV);
            return csttmt.executeUpdate() > 0;
        }
    }

    public List<DichVu> danhSachDichVu() throws Exception {
        List<DichVu> dsDichVu = new ArrayList<>();
        String sql = "select * from DichVu where trangThai = 1";
        try (
                Connection con = DataHelper.openConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                DichVu dichVu = new DichVu();
                dichVu.setMaDichVu(rs.getInt("maDV"));
                dichVu.setTenDichVu(rs.getString("tenDV"));
                dichVu.setDonGia(rs.getInt("donGia"));
                dichVu.setTrangThai(rs.getBoolean("trangThai"));
                dichVu.setMaLoaiDichVu(rs.getInt("maLoaiDV"));
                dsDichVu.add(dichVu);
            }
        }
        return dsDichVu;
    }

    public boolean themMonAnChoKhach(int maPSDDV, int maDV, int soLuong) throws Exception {
        String sql = "{call RS_THEM_MON_AN_CHO_KHACH(?, ?, ?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql)) {
            csttmt.setInt(1, maPSDDV);
            csttmt.setInt(2, maDV);
            csttmt.setInt(3, soLuong);
            return csttmt.executeUpdate() > 0;
        }
    }

    public boolean capNhatTrangThaiBanDat(int trangThai, String maKH, int maPD) throws Exception {
        String sql = "{call capNhatTrangThaiBanDat(?, ?, ?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);) {
            csttmt.setInt(1, trangThai);
            csttmt.setString(2, maKH);
            csttmt.setInt(3, maPD);
            return csttmt.executeUpdate() > 0;
        }
    }

    public boolean xoaPhieuSDDV(int maPSDDV) throws Exception {
        String sql = "{call xoaPhieuDV (?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);) {
            csttmt.setInt(1, maPSDDV);
            return csttmt.executeUpdate() > 0;
        }
    }

    public boolean luuThongTinHoaDon(long tongTienDV, int maPSDDV, long tongTienKM, String ngayRa, String gioRa,
            String maNV) throws Exception {
        try (
                Connection con = DataHelper.openConnection();
                Statement stmt = con.createStatement();) {
            String sql = "Insert into HoaDon (tongTienDV, tongTienKM, ngayRa, gioRa, maNV, maPSDDV) ";
            sql += " Values("
                    + tongTienDV + ", "
                    + tongTienKM + ", '"
                    + ngayRa + "', '"
                    + gioRa + "', '"
                    + maNV + "', "
                    + maPSDDV + ")";
            int count = stmt.executeUpdate(sql);
            return count > 1;
        }
    }
}
