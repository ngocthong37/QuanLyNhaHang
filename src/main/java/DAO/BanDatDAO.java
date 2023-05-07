/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataHelper.DataHelper;
import Models.BanDat;
import Models.NhanVien;
import java.sql.CallableStatement;
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
public class BanDatDAO {

    List<BanDat> dsBanDat = new ArrayList<>();

    public List<BanDat> getAll() throws Exception {

        String sql = "{call danhSachBanDaDat()}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);

                ResultSet rs = csttmt.executeQuery();) {
            while (rs.next()) {
                BanDat banDat = new BanDat();
                banDat.setMaPD(rs.getInt("maPD"));
                banDat.setSoBan(rs.getString("soBan"));
                banDat.setHoKH(rs.getString("hoKH"));
                banDat.setTenKH(rs.getString("tenKH"));
                banDat.setSoDT(rs.getString("sdt"));
                banDat.setNgayVao(rs.getDate("ngayVao").toString());
                banDat.setGioVao(rs.getTime("gioVao").toString());
                banDat.setMaTT(rs.getInt("maTT"));
                banDat.setGhiChu(rs.getString("ghiChu"));
                dsBanDat.add(banDat);
            }
        }
        return dsBanDat;
    }

    public List<BanDat> layBanDatHomNay(String ngayHienTai) throws Exception {

        String sql = "{call danhSachBanDatHomNay(?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);

        ) {
            csttmt.setString(1, ngayHienTai);
            ResultSet rs = csttmt.executeQuery();
            while (rs.next()) {
                BanDat banDat = new BanDat();
                banDat.setMaPD(rs.getInt("maPD"));
                banDat.setSoBan(rs.getString("soBan"));
                banDat.setHoKH(rs.getString("hoKH"));
                banDat.setTenKH(rs.getString("tenKH"));
                banDat.setSoDT(rs.getString("sdt"));
                banDat.setNgayVao(rs.getDate("ngayVao").toString());
                banDat.setGioVao(rs.getTime("gioVao").toString());
                banDat.setMaTT(rs.getInt("maTT"));
                banDat.setGhiChu(rs.getString("ghiChu"));
                dsBanDat.add(banDat);
            }
        }
        return dsBanDat;
    }

    public boolean datBan(BanDat banDat, String maNV) throws Exception {
        String sql = "{call RS_DAT_BAN_AN(?, ?, ?, ?, ?,?, ?, ?, ?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);) {
            csttmt.setString(1, banDat.getSoDT());
            csttmt.setString(2, banDat.getTenKH());
            csttmt.setString(3, banDat.getHoKH());
            csttmt.setString(4, banDat.getGhiChu());
            csttmt.setString(5, banDat.getNgayVao());
            csttmt.setString(6, banDat.getGioVao());
            csttmt.setInt(7, Integer.valueOf(banDat.getSoBan()));
            csttmt.setString(8, maNV);
            csttmt.setInt(9, 5);
            return csttmt.executeUpdate() > 0;
        }
    }

    public boolean huyBan(BanDat banDat, int maPD) throws Exception {
        String sql = "Update PhieuDatBan set maTT = ? where maKH = ? and maPD = ?";
        try (
                Connection con = DataHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(2, banDat.getSoDT());
            pstm.setInt(1, 2);
            pstm.setInt(3, maPD);
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean capNhatBan(BanDat banDat, String soDTCu, String ngayVaoCu) throws Exception {
        String sql = "{call capNhatThongTinDatHang(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (
                Connection con = DataHelper.openConnection();
                CallableStatement csttmt = con.prepareCall(sql);) {
            csttmt.setString(1, soDTCu);
            csttmt.setString(2, banDat.getSoDT());
            csttmt.setString(3, banDat.getTenKH());
            csttmt.setString(4, banDat.getHoKH());
            csttmt.setString(5, banDat.getGhiChu());
            csttmt.setString(6, banDat.getNgayVao());
            csttmt.setString(7, banDat.getGioVao());
            csttmt.setInt(8, Integer.valueOf(banDat.getSoBan()));
            csttmt.setInt(9, 5);
            csttmt.setString(10, ngayVaoCu);
            csttmt.setInt(11, banDat.getMaPD());
            return csttmt.executeUpdate() > 0;
        }

    }

}
