/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T3D Computer
 */
public class BanDatModify {
    List<BanDat> dsBanDat;

    public BanDatModify() {
        this.dsBanDat = new ArrayList<>();
    }

    public void themBanDat(BanDat banDat) {
        this.dsBanDat.add(banDat);
    }

}
