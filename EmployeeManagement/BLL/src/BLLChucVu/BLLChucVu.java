/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLChucVu;

import DALQueries.DALChucVu;
import java.sql.Array;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author NguyenPH
 */
public class BLLChucVu {
    private DALChucVu chucVu;

    public BLLChucVu() {
        this.chucVu = new DALChucVu();
    }
    
    
    
    public Map getAllChucVu() throws SQLException, ClassNotFoundException{
       try{
           
           ArrayList<String[]> arrList = chucVu.getAllChucVu();
           if(arrList != null){
               Map <String, String> mapChucVu = new HashMap<String, String>();
               for (String[] temp : arrList) {
                   String key = temp[1];
                   String value = temp[0];
                   mapChucVu.put(key, value);
		}
               
               return mapChucVu;
           }
           return null;
       } catch(SQLException e){
           throw e;
       }
        
    }
}
