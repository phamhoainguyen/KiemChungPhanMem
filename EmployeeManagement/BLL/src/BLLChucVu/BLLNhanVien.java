/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLChucVu;

import DALQueries.DALNhanVien;
import dataOjects.DAONhanVien;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NguyenPH
 */
public class BLLNhanVien {
    private DALNhanVien nhanVien;

    public BLLNhanVien() {
        this.nhanVien = new DALNhanVien();
    }
    
    public int insertNhanVien(DAONhanVien _nhanVien) throws Exception{
        try{
            return this.nhanVien.insertNhanVien(_nhanVien);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    
    public int updateNhanVien(DAONhanVien _nhanVien) throws Exception{
        try{
            return this.nhanVien.updateNhanVien(_nhanVien);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    
    public int deleteNhanVien(String _maNhanVien) throws Exception{
        try{
            return this.nhanVien.deleteNhanVien(_maNhanVien);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public String getLastesNhanVien() throws Exception{
        try{
            ArrayList<String[]> al = this.nhanVien.getLastestNhanVien();
            String lastesMaNV = al.get(0)[0];
            return lastesMaNV;
        }catch(ClassNotFoundException | SQLException ex){
            throw ex;
        }
    }
    
    public ArrayList<DAONhanVien> getAllNhanVien() throws Exception{
        try{
            ArrayList<String[]> al = this.nhanVien.getAllNhanVien();
            ArrayList<DAONhanVien> alNhanVien = new ArrayList<>();
            for(String[] ele:al){
                DAONhanVien nhanVien = new DAONhanVien();
                nhanVien.setMaNhanVien(ele[0]);
                nhanVien.setTenNhanVien(ele[1]);
                nhanVien.setGioiTinh(ele[2]);
                nhanVien.setNgaySinh(ele[3]);
                nhanVien.setSoCMND(ele[4]);
                nhanVien.setDiaChi(ele[5]);
                nhanVien.setQueQuan(ele[6]);
                nhanVien.setSoTaiKhoan(ele[7]);
                nhanVien.setSoDienThoai(ele[8]);
                nhanVien.setNgayVaoLam(ele[9]);
                nhanVien.setGhiChu(ele[11]);
                nhanVien.setMaPhongBan(ele[12]);
                nhanVien.setMaChucVu(ele[13]);
                nhanVien.setTenChucVu(ele[16]);
                nhanVien.setBacLuong(ele[14]);
                nhanVien.setTenPhongBan(ele[18]);

                alNhanVien.add(nhanVien);
            }
            return alNhanVien;
        }catch(ClassNotFoundException | SQLException ex){
            throw ex;
        }
    }
    
    // lay nhan vien tu ma nhan vien
    public DAONhanVien getNhanVienByID(String _maNhanVien) throws Exception{
        try{
            ArrayList<String[]> al = this.nhanVien.getNhanVienByID(_maNhanVien);
            String[] ele = al.get(0);
                DAONhanVien nhanVien = new DAONhanVien();
                nhanVien.setMaNhanVien(ele[0]);
                nhanVien.setTenNhanVien(ele[1]);
                nhanVien.setGioiTinh(ele[2]);
                nhanVien.setNgaySinh(ele[3]);
                nhanVien.setSoCMND(ele[4]);
                nhanVien.setDiaChi(ele[5]);
                nhanVien.setQueQuan(ele[6]);
                nhanVien.setSoTaiKhoan(ele[7]);
                nhanVien.setSoDienThoai(ele[8]);
                nhanVien.setNgayVaoLam(ele[9]);
                nhanVien.setGhiChu(ele[11]);
                nhanVien.setMaPhongBan(ele[12]);
                nhanVien.setMaChucVu(ele[13]);
                nhanVien.setTenChucVu(ele[16]);
                nhanVien.setBacLuong(ele[14]);
                nhanVien.setTenPhongBan(ele[18]);

            
            return nhanVien;
        }catch(ClassNotFoundException | SQLException ex){
            throw ex;
        }
    }
}
