/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import Models.ChiTietPhieuAn;
import Models.HoaDon;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface HoaDonService {
    public List<HoaDon> getAllHoaDon();

    public List<HoaDon> getHoaDonTrongKhoangTG(int year, int monthStart, int monthEnd, String maNV, int maQuyen);

    public List<ChiTietPhieuAn> getChiTietPhieuAn(int maPSDDV);

    public List<ChiTietPhieuAn> getChiTietPhieuAnDaThanhToan(int maPSDDV);
    
    public List<HoaDon> getHoaDonTheoNam(int year);
}
