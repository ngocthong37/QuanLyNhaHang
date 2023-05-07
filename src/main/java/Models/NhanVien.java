/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author T3D Computer
 */
public class NhanVien {
    String maNV;
    String ho;
    String ten;
    String diaChi;
    Boolean trangThai;
    String sdt;
    String matKhau;
    int maVaiTro;

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getMaVaiTro() {
        return maVaiTro;
    }

    public void setMaVaiTro(int maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public NhanVien(String maNV, String ho, String ten, String diaChi, Boolean trangThai, String sdt, String matKhau,
            int maVaiTro) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.maVaiTro = maVaiTro;
    }

    public boolean checkPassword(String password) {
        return this.matKhau.equals(password);
    }

}
