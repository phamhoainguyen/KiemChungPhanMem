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
            String query = "SELECT DISTINCT THANG FROM `lamviec` WHERE lamviec.MANHANVIEN=? ORDER BY ASC";
            String[] arrPara = {_maNhanVien};
            int[] arrTypes = {Types.VARCHAR};
            ArrayList al = this.cnn.cnn.getResultSet(query, arrPara, arrTypes);
            return al;
        } catch(SQLException e){
        throw e;
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
