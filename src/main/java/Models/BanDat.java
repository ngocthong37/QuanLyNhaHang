/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author T3D Computer
 */
public class BanDat {
    int maPD;
    String soBan;
    String ngayVao;
    String gioVao;
    String hoKH;
    String tenKH;
    int maTT;
    String soDT;
    String ghiChu;

    public int getMaPD() {
        return maPD;
    }

    public BanDat() {
    }

    public void setMaPD(int maPD) {
        this.maPD = maPD;
    }

    public BanDat(int maPD, String soBan, String ngayVao, String gioVao, String hoKH, String tenKH, int maTT,
            String soDT, String ghiChu) {
        this.maPD = maPD;
        this.soBan = soBan;
        this.ngayVao = ngayVao;
        this.gioVao = gioVao;
        this.hoKH = hoKH;
        this.tenKH = tenKH;
        this.maTT = maTT;
        this.soDT = soDT;
        this.ghiChu = ghiChu;
    }

    public String getSoBan() {
        return soBan;
    }

    public void setSoBan(String soBan) {
        this.soBan = soBan;
    }

    public String getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

    public String getGioVao() {
        return gioVao;
    }

    public void setGioVao(String gioVao) {
        this.gioVao = gioVao;
    }

    public String getHoKH() {
        return hoKH;
    }

    public void setHoKH(String hoKH) {
        this.hoKH = hoKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getMaTT() {
        return maTT;
    }

    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}