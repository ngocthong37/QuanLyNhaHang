/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author T3D Computer
 */
public class PhieuSuDungDV extends BanAn {
    int maPSDDV;
    String gioVao;
    String ngayVao;
    boolean trangThaiPhieu;

    public PhieuSuDungDV() {
    }

    public PhieuSuDungDV(int maBan, String soBan, int sucChua, int trangThai) {
        super(maBan, soBan, sucChua, trangThai);
    }

    public int getMaPSDDV() {
        return maPSDDV;
    }

    public void setMaPSDDV(int maPSDDV) {
        this.maPSDDV = maPSDDV;
    }

    public String getGioVao() {
        return gioVao;
    }

    public void setGioVao(String gioVao) {
        this.gioVao = gioVao;
    }

    public String getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

    public boolean getTrangThaiPhieu() {
        return trangThaiPhieu;
    }

    public void setTrangThaiPhieu(boolean trangThaiPhieu) {
        this.trangThaiPhieu = trangThaiPhieu;
    }

}
