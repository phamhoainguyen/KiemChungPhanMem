/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLChucVu;

import DALQueries.DALLuong;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author NguyenPH
 */
public class BLLLuong {
    private DALLuong bacLuong;

    public BLLLuong() {
        this.bacLuong = new DALLuong();
    }
    
    
    
    public Map getALlBacLuong() throws SQLException, ClassNotFoundException{
       try{
           
           ArrayList<String[]> arrList = this.bacLuong.getAllBacLuong();
           if(arrList != null){
               Map <String, String> mapLuong = new HashMap<String, String>();
               for (String[] temp : arrList) {
                   String key = temp[0];
                   String value = temp[1];
                   mapLuong.put(key, value);
		}
               
               return mapLuong;
           }
           return null;
       } catch(SQLException e){
           throw e;
       }
        
    }
}
