/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DALQueries;

import connectionToDatabase.ConnectionString;
import dataOjects.DAONhanVien;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author NguyenPH
 */
public class DALNhanVien {
    ConnectionString cnn = new ConnectionString();
    
    public DALNhanVien(){
        this.cnn = new ConnectionString();
    }
    
    
    public ArrayList getAllNhanVien() throws SQLException, ClassNotFoundException{
        try{
            String query = "SELECT * FROM nhanvien n INNER JOIN chucvu c ON n.MACHUCVU=c.MACHUCVU\n" +
"INNER JOIN phongban p ON n.MAPHONGBAN=p.MAPHONGBAN\n" +
"WHERE n.ISDELETE <> 1";
            return cnn.cnn.getResulSet(query);
        } catch(SQLException e){
        throw e;
        }
    }
    
    public int insertNhanVien(DAONhanVien _nhanVien) throws Exception{
        try{
            String query = "INSERT INTO `nhanvien` (`MANHANVIEN`, `HOTEN`, `GIOITINH`, `NGAYSINH`, `CMND`, `DIACHI`, `QUEQUAN`, `SOTAIKHOAN`, `SODIENTHOAI`, `NGAYVAOLAM`, ISDELETE, `GHICHU`, `MAPHONGBAN`, `MACHUCVU`, `BACLUONG`) \n" +
"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            

            String[] arrPara = { _nhanVien.getMaNhanVien(), _nhanVien.getTenNhanVien(),
               _nhanVien.getGioiTinh(), _nhanVien.getNgaySinh(), _nhanVien.getSoCMND(), _nhanVien.getDiaChi(), _nhanVien.getQueQuan(), _nhanVien.getSoTaiKhoan(), _nhanVien.getSoDienThoai(), _nhanVien.getNgayVaoLam(), "0",  _nhanVien.getGhiChu(), _nhanVien.getMaPhongBan(), _nhanVien.getMaChucVu(), _nhanVien.getBacLuong()};
            int[] arrTypes = {Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
            int status = this.cnn.cnn.executeQueryReturnStatus(query, arrPara, arrTypes);
            return status;
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }
    }
    
    public ArrayList getLastestNhanVien() throws SQLException, ClassNotFoundException{
        try{
            String query = "SELECT MANHANVIEN FROM nhanvien ORDER BY MANHANVIEN DESC LIMIT 1";
            
            return cnn.cnn.getResulSet(query);
        } catch(SQLException e){
        throw e;
        }
    }
    
    public int deleteNhanVien(String _maNhanVien) throws SQLException, ClassNotFoundException{
        try{
            String query = "UPDATE nhanvien SET nhanvien.ISDELETE=1 WHERE nhanvien.MANHANVIEN=?";
            String[] arrPara = {_maNhanVien};
            int[] arrTypes = {Types.VARCHAR};
            int status = this.cnn.cnn.executeQueryReturnStatus(query, arrPara, arrTypes);
            return status;
        } catch(SQLException e){
        throw e;
        }
    }
    
    
    // lay nhan vien tu ma nhan vien
    public ArrayList getNhanVienByID(String _maNhanVien) throws SQLException, ClassNotFoundException{
        try{
            String query = "SELECT * FROM nhanvien n INNER JOIN chucvu c ON n.MACHUCVU=c.MACHUCVU\n" +
"INNER JOIN phongban p ON n.MAPHONGBAN=p.MAPHONGBAN WHERE n.MANHANVIEN=? AND n.ISDELETE<>1";
            

            String[] arrPara = {_maNhanVien};
            int[] arrTypes = {Types.VARCHAR};
            ArrayList al = this.cnn.cnn.getResultSet(query, arrPara, arrTypes);
            return al;
        } catch(SQLException e){
        throw e;
        }
    }
    
    // cap nhat thong tin nhan vien vao csdl
    public int updateNhanVien(DAONhanVien _nhanVien) throws Exception{
        try{
            String query = "UPDATE `nhanvien` SET `HOTEN`=?, `GIOITINH`=?, `NGAYSINH`?, `CMND`=?,"
                    + " `DIACHI=?`, `QUEQUAN`=?, `SOTAIKHOAN`=?, `SODIENTHOAI`=?, "
                    + "`NGAYVAOLAM`=?, `GHICHU`=?, `MAPHONGBAN`=?, `MACHUCVU`=?, `BACLUONG`=? WHERE `MANHANVIEN`=? ";
            
            String[] arrPara = {  _nhanVien.getTenNhanVien(), _nhanVien.getGioiTinh(),
                _nhanVien.getNgaySinh(), _nhanVien.getSoCMND(), _nhanVien.getDiaChi(),
                _nhanVien.getQueQuan(), _nhanVien.getSoTaiKhoan(), _nhanVien.getSoDienThoai(),
                _nhanVien.getNgayVaoLam(),  _nhanVien.getGhiChu(), _nhanVien.getMaPhongBan(), 
                _nhanVien.getMaChucVu(), _nhanVien.getBacLuong(), _nhanVien.getMaNhanVien()};
            int[] arrTypes = {Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.INTEGER, Types.VARCHAR};
            int status = this.cnn.cnn.executeQueryReturnStatus(query, arrPara, arrTypes);
            return status;
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }
    }
}
