/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DALQueries;

import connectionToDatabase.ConnectionString;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NguyenPH
 */
public class DALPhongBan {
    public ConnectionString cnn;
    public DALPhongBan(){
        this.cnn = new ConnectionString();
    }
    public ArrayList getAllPhongBan() throws SQLException, ClassNotFoundException{
        try{
            String query = "SELECT * FROM `phongban` WHERE 1";
            
            return cnn.cnn.getResulSet(query);
        } catch(SQLException e){
        throw e;
        }
    }
}
