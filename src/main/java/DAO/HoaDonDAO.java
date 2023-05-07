/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataHelper.DataHelper;
import Models.HoaDon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonDAO {

    public List<HoaDon> getAllHoaDon() throws Exception {
        List<HoaDon> lstHoaDon = new ArrayList<>();
        String sql = "Select * from HoaDon";
        try (
                Connection con = DataHelper.openConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getInt("maHoaDon"));
                hd.setThanhTien(rs.getLong("thanhTien"));
                hd.setNgayRa(rs.getString("ngayRa"));
                hd.setGioRa(rs.getString("gioRa"));
                hd.setMaNV(rs.getString("maNV"));
                hd.setTongTienDV(rs.getInt("tongTienDV"));
                hd.setMaSDDV(rs.getInt("maPSDDV"));
                lstHoaDon.add(hd);
            }
        }
        return lstHoaDon;
    }

    public List<HoaDon> getHoaDonTrongKhoangTG(int year, int monthStart, int monthEnd, String maNV, int maQuyen)
            throws Exception {
        List<HoaDon> lstHoaDon = new ArrayList<>();
        String sql = "{call LayHoaDonTrongKhoangTG(?, ?, ?, ?, ?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);) {
            csttmt.setInt(1, year);
            csttmt.setInt(2, monthStart);
            csttmt.setInt(3, monthEnd);
            csttmt.setString(4, maNV);
            csttmt.setInt(5, maQuyen);
            ResultSet rs = csttmt.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getInt("maHoaDon"));
                hd.setThanhTien(rs.getLong("thanhTien"));
                hd.setNgayRa(rs.getString("ngayRa"));
                hd.setGioRa(rs.getString("gioRa"));
                hd.setMaNV(rs.getString("maNV"));
                hd.setTongTienDV(rs.getInt("tongTienDV"));
                hd.setMaSDDV(rs.getInt("maPSDDV"));
                lstHoaDon.add(hd);
            }
        }
        return lstHoaDon;
    }

    public boolean themHoaDon(HoaDon t) throws Exception {
        String sql = "insert into HoaDon(tongTienDV, tongTienKM, ngayRa, gioRa, maNV, maPSDDV ) values (?, ?, ?, ?, ?, ?)";
        try (Connection con = DataHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setLong(1, t.getTongTienDV());
            pstm.setInt(2, t.getTongTienKM());
            pstm.setString(3, t.getNgayRa());
            pstm.setString(4, t.getGioRa());
            pstm.setString(5, t.getMaNV());
            pstm.setInt(6, t.getMaSDDV());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean capNhatHoaDon(HoaDon t) throws Exception {
        String sql = "Update HoaDon set tongTienDV= ?, tongTienKM = ?, ngayRa = ?, gioRa = ? where maHoaDon = ?";
        try (
                Connection con = DataHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setLong(1, t.getTongTienDV());
            pstm.setInt(2, t.getTongTienKM());
            pstm.setString(3, t.getNgayRa());
            pstm.setString(4, t.getGioRa());
            pstm.setInt(5, t.getMaHoaDon());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean delete(int maHoaDon) throws Exception {
        String sql = "delete from HoaDon where maHoaDon = ?";
        try (
                Connection con = DataHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setInt(1, maHoaDon);
            return pstm.executeUpdate() > 0;

        }
    }
    
    public List<HoaDon> getHoaDonTheoNam(int year)
            throws Exception {
        List<HoaDon> lstHoaDon = new ArrayList<>();
        String sql = "{call LayHoaDonTheoNam(?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);) {
            csttmt.setInt(1, year);
            ResultSet rs = csttmt.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getInt("maHoaDon"));
                hd.setThanhTien(rs.getLong("thanhTien"));
                hd.setNgayRa(rs.getString("ngayRa"));
                hd.setGioRa(rs.getString("gioRa"));
                hd.setMaNV(rs.getString("maNV"));
                hd.setTongTienDV(rs.getInt("tongTienDV"));
                hd.setMaSDDV(rs.getInt("maPSDDV"));
                lstHoaDon.add(hd);
            }
        }
        return lstHoaDon;
    }
}
