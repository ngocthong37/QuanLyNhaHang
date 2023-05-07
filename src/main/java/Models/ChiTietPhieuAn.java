/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author T3D Computer
 */
public class ChiTietPhieuAn extends DichVu {
    int soLuong;

    public ChiTietPhieuAn() {
    }

    public ChiTietPhieuAn(int soLuong, int maDichVu, String tenDichVu, int donGia, boolean trangThai,
            int maLoaiDichVu) {
        super(maDichVu, tenDichVu, donGia, trangThai, maLoaiDichVu);
        this.soLuong = soLuong;
    }

    @Override
    public int getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public int getDonGia() {
        return super.getDonGia();
    }

    @Override
    public int getMaDichVu() {
        return super.getMaDichVu();
    }

    public long getThanhTien() {
        return soLuong * donGia;
    }

}
