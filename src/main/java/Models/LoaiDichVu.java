/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author T3D Computer
 */
public class LoaiDichVu {
    String maLoaiDV;
    String tenLoaiDV;

    public LoaiDichVu() {
    }

    public LoaiDichVu(String maLoaiDV, String tenLoaiDV) {
        this.maLoaiDV = maLoaiDV;
        this.tenLoaiDV = tenLoaiDV;
    }

    public String getMaLoaiDV() {
        return maLoaiDV;
    }

    public void setMaLoaiDV(String maLoaiDV) {
        this.maLoaiDV = maLoaiDV;
    }

    public String getTenLoaiDV() {
        return tenLoaiDV;
    }

    public void setTenLoaiDV(String tenLoaiDV) {
        this.tenLoaiDV = tenLoaiDV;
    }

}
