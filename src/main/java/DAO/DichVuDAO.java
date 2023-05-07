/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ASUS
 */
import DataHelper.DataHelper;
import Models.DichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DichVuDAO {

    public List<DichVu> getAll() throws Exception {
        List<DichVu> lstDichvu = new ArrayList<>();
        String sql = "select * from DichVu";
        try (
                Connection con = DataHelper.openConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                DichVu dv = new DichVu();
                dv.setMaDichVu(rs.getInt("maDV"));
                dv.setTenDichVu(rs.getString("tenDV"));
                dv.setDonGia(rs.getInt("donGia"));
                dv.setTrangThai(rs.getBoolean("trangThai"));
                dv.setMaLoaiDichVu(rs.getInt("maLoaiDV"));
                lstDichvu.add(dv);
            }
        }
        return lstDichvu;
    }

    public boolean ThemDichVu(DichVu dV) throws Exception {
        String sql = "insert into DichVu(  tenDV,donGia,trangThai,maLoaiDV) values(?,?,?,?)";
        try (
                Connection con = DataHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {

            pstm.setString(1, dV.getTenDichVu());
            pstm.setInt(2, dV.getDonGia());
            pstm.setBoolean(3, dV.getTrangThai());
            pstm.setInt(4, dV.getMaLoaiDichVu());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean SuaDichVu(DichVu dV) throws Exception {
        String sql = "update DichVu set  tenDV=?,donGia=?,trangThai=?,maLoaiDV=? where maDV =?";
        try (
                Connection con = DataHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {

            pstm.setString(1, dV.getTenDichVu());
            pstm.setInt(2, dV.getDonGia());
            pstm.setBoolean(3, dV.getTrangThai());
            pstm.setInt(4, dV.getMaLoaiDichVu());
            pstm.setInt(5, dV.getMaDichVu());
            return pstm.executeUpdate() > 0;
        }
    }

}