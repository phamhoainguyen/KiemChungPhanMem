/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DALQueries;

import connectionToDatabase.ConnectionString;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenPH
 */
public class DALLamViec {
    
    public ConnectionString cnn;
    public DALLamViec(){
        this.cnn = new ConnectionString();
    }
    public ArrayList getAllThang(String _maNhanVien) throws SQLException, ClassNotFoundException{
        try{
            String query = "SELECT DISTINCT THANG FROM `lamviec` WHERE lamviec.MANHANVIEN=? ORDER BY lamviec.THANG ASC";
            String[] arrPara = {_maNhanVien};
            int[] arrTypes = {Types.VARCHAR};
            ArrayList al = this.cnn.cnn.getResultSet(query, arrPara, arrTypes);
            return al;
        } catch(SQLException e){
        throw e;
        }
    }
    
    public ArrayList getThongTinChiTiet(String _maNhanVien, String _thang) throws Exception{
        try{
            String query = "SELECT nv.MANHANVIEN, nv.HOTEN, pb.TENPHONGBAN, cv.TENCHUCVU, l.LUONGCB, l.HSLUONG, l.HSPC, l.PHUCAP, lv.THANG, lv.SONGAYNGHI, lv.SONGAYDITRE, lv.GHICHU, ((l.LUONGCB * (l.HSLUONG + l.HSPC)) + l.PHUCAP - (500000 * lv.SONGAYNGHI) - (200000*lv.SONGAYDITRE)) AS TONGLUONG FROM nhanvien nv INNER JOIN lamviec lv ON nv.MANHANVIEN=lv.MANHANVIEN INNER JOIN luong l ON nv.BACLUONG=l.BACLUONG INNER JOIN chucvu cv ON cv.MACHUCVU=nv.MACHUCVU INNER JOIN phongban pb ON pb.MAPHONGBAN = nv.MAPHONGBAN WHERE lv.MANHANVIEN=? AND lv.THANG=?";
            String[] arrPara = {_maNhanVien, _thang};
            int[] arrTypes = {Types.VARCHAR, Types.INTEGER};
            ArrayList al = this.cnn.cnn.getResultSet(query, arrPara, arrTypes);
             return al;
        }catch(Exception ex){
            throw ex;
        }
    }
    
//   public static void main(String[] args){
//       DALLamViec dal = new DALLamViec();
//        try {
//            ArrayList al =  dal.getAllThang("NV00006");
//            int i = 9;
//        } catch (SQLException ex) {
//            Logger.getLogger(DALLamViec.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(DALLamViec.class.getName()).log(Level.SEVERE, null, ex);
//        }
//   }
//    
}
