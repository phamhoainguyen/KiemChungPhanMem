/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLChucVu;

import DALQueries.DALLamViec;
import dataOjects.DAOChiTietLamViec;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author NguyenPH
 */
public class BLLLamViec {
    public DALLamViec dalLamViec;

    public BLLLamViec() {
        this.dalLamViec = new DALLamViec();
    }
    
    public ArrayList<String> getThang(String _maNhanVien) throws SQLException, ClassNotFoundException{
        try{
            ArrayList<String[]> arrList = new ArrayList<>();
            arrList = this.dalLamViec.getAllThang(_maNhanVien);
            if(arrList != null){
               ArrayList<String> alThang = new ArrayList<>();
               for (String[] temp : arrList) {
                   alThang.add(temp[0]);
		}
               
               return alThang;
           }
        return null;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public DAOChiTietLamViec getAllChiTietLamViecByThang(String _maNhanVien, String _thang) throws Exception{
        try{
            ArrayList<String[]> arrList = new ArrayList<>();
            arrList = this.dalLamViec.getThongTinChiTiet(_maNhanVien, _thang);
            if(arrList != null){
                DAOChiTietLamViec ctnv = new DAOChiTietLamViec();
               for (String[] temp : arrList) {
                   
                   ctnv.maNhanVien = temp[0];
                   ctnv.tenNhanVien = temp[1];
                   ctnv.tenBoPhan = temp[2];
                   ctnv.tenChucVu = temp[3];
                   ctnv.luongCB = temp[4];
                   ctnv.HSLuong = temp[5];
                   ctnv.HSPC = temp[6];
                   ctnv.phuCap = temp[7];
                   ctnv.thang = temp[8];
                   ctnv.soNgayNghi = temp[9];
                   ctnv.soNgayTre = temp[10];
                   ctnv.ghiChu = temp[11];
                   ctnv.tongLuong = temp[12];
		}
               
               return ctnv;
           }
        return null;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    
}
