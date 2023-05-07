/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DAO.HoaDonDAO;
import DAO.PhieuSDDVDao;
import Models.ChiTietPhieuAn;
import Models.HoaDon;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class HoaDonServiceImpl implements HoaDonService {
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private PhieuSDDVDao phieuSDDVDAO = new PhieuSDDVDao();

    public HoaDonServiceImpl() {
        this.hoaDonDAO = new HoaDonDAO();
    }

    @Override
    public List<HoaDon> getAllHoaDon() {
        try {
            return hoaDonDAO.getAllHoaDon();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HoaDon> getHoaDonTrongKhoangTG(int year, int monthStart, int monthEnd, String maNV, int maQuyen) {
        try {
            return hoaDonDAO.getHoaDonTrongKhoangTG(year, monthStart, monthEnd, maNV, maQuyen);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<ChiTietPhieuAn> getChiTietPhieuAn(int maPSDDV) {
        try {
            return phieuSDDVDAO.chiTietPhieuAn(maPSDDV);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<ChiTietPhieuAn> getChiTietPhieuAnDaThanhToan(int maPSDDV) {
        try {
            return phieuSDDVDAO.chiTietMonAnPhieuDaThanhToan(maPSDDV);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HoaDon> getHoaDonTheoNam(int year) {
         try {
            return hoaDonDAO.getHoaDonTheoNam(year);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
