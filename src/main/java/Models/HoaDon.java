/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author T3D Computer
 */
public class HoaDon {
    int maHoaDon;
    int tongTienDV;
    int tongTienKM;
    String ngayRa;
    String gioRa;
    String maNV;
    int maSDDV;
    long thanhTien;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, int tongTienDV, int tongTienKM, String ngayRa, String gioRa, String maNV, int maSDDV,
            long thanhTien) {
        this.maHoaDon = maHoaDon;
        this.tongTienDV = tongTienDV;
        this.tongTienKM = tongTienKM;
        this.ngayRa = ngayRa;
        this.gioRa = gioRa;
        this.maNV = maNV;
        this.maSDDV = maSDDV;
        this.thanhTien = thanhTien;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getTongTienDV() {
        return tongTienDV;
    }

    public void setTongTienDV(int tongTienDV) {
        this.tongTienDV = tongTienDV;
    }

    public String getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(String ngayRa) {
        this.ngayRa = ngayRa;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getMaSDDV() {
        return maSDDV;
    }

    public void setMaSDDV(int maSDDV) {
        this.maSDDV = maSDDV;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setGioRa(String gioRa) {
        this.gioRa = gioRa;
    }

    public String getGioRa() {
        return gioRa;
    }

    public void setTongTienKM(int tongTienKM) {
        this.tongTienKM = tongTienKM;
    }

    public int getTongTienKM() {
        return tongTienKM;
    }
}
