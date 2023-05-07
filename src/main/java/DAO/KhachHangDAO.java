/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataHelper.DataHelper;
import Models.KhachHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T3D Computer
 */
public class KhachHangDAO {
    public List<KhachHang> danhSachKhachHang() throws Exception {
        List<KhachHang> dsKhachHang = new ArrayList<>();
        String sql = "select * from KhachHang";
        try (
                Connection con = DataHelper.openConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setHoKH(rs.getString("hoKH"));
                kh.setTenKH(rs.getString("tenKH"));
                kh.setSdt(rs.getString("sdt"));
                kh.setDiaChi(rs.getString("diaChi"));
                dsKhachHang.add(kh);
            }
        }
        return dsKhachHang;
    }
}
