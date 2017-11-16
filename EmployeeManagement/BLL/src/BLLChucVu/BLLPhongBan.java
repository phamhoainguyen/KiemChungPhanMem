/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLChucVu;

import DALQueries.DALPhongBan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author NguyenPH
 */
public class BLLPhongBan {
    private DALPhongBan phongBan;

    public BLLPhongBan() {
        this.phongBan = new DALPhongBan();
    }
    
    
    
    public Map getAllPhongBan() throws SQLException, ClassNotFoundException{
       try{
           
           ArrayList<String[]> arrList = this.phongBan.getAllPhongBan();
           if(arrList != null){
               Map <String, String> mapPhongBan = new HashMap<String, String>();
               for (String[] temp : arrList) {
                   String key = temp[1];
                   String value = temp[0];
                   mapPhongBan.put(key, value);
		}
               
               return mapPhongBan;
           }
           return null;
       } catch(SQLException e){
           throw e;
       }
        
    }
}
