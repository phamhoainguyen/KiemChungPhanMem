
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionToDatabase;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author NguyenPH
 */
public class DBConnection {
    private Connection conn;
    private String connectionString;
    private String userName;
    private String password;
    
    public DBConnection(){
        
    }
    
    
    public DBConnection(String _connectionString, String _userName, String _password){
        this.connectionString = _connectionString;
        this.userName = _userName;
        this.password = _password;
    }
    
    public void openConnection() throws SQLException, ClassNotFoundException{
        try{
            
            this.conn = DriverManager.getConnection(this.connectionString, this.userName, this.password);
            //this.cnn = DriverManager.getConnection(this.connectionString);
        } catch(SQLException e){
            throw e;
        }
    }
    
    public ArrayList getResulSet(String _queryString) throws SQLException, ClassNotFoundException{
        try{
            this.openConnection();
            Statement statement = this.conn.createStatement();
            ResultSet rs = statement.executeQuery(_queryString);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            if(rs!= null){
                ArrayList<String[]> list = new ArrayList<>();
                while(rs.next()){
                    String arr[] = new String[columnsNumber];
                    for(int i = 0; i < columnsNumber; i ++){
                        
                        arr[i] = rs.getString(i + 1);
                    }
                    
                    list.add(arr);
                }
                return list;
            }
            return null;
        }catch (SQLException e){
            throw e;
        }finally{
            this.closeConnection();
        }

    }
    
    public ResultSet getResultSet(String _queryString, String arrPara[], int arrType[]) throws SQLException, ClassNotFoundException{
        try{
            this.openConnection();
            
            PreparedStatement preStatement = this.conn.prepareStatement(_queryString);
            for(int i = 0; i < arrPara.length; i++){
                if(arrType[i] == Types.INTEGER){
                    preStatement.setInt(i + 1, Integer.parseInt(arrPara[i]));
                }
                
                else if(arrType[i] == Types.FLOAT){
                    preStatement.setFloat(i + 1, Float.parseFloat(arrPara[i]));
                }
                else if(arrType[i] == Types.DATE){
                    
                    preStatement.setDate(i + 1, Date.valueOf(arrPara[i]));
                }
                else{
                    preStatement.setString(i + 1, arrPara[i].toString());
                }
            }
            
            ResultSet rs = preStatement.executeQuery();
            return rs;
        } catch(SQLException e){
            throw e;
        } finally{
            this.closeConnection();
        }
        
    }
    
    
    // insert query
    public int executeQueryReturnStatus(String _queryString, String arrPara[], int arrType[]) throws SQLException, ClassNotFoundException{
        try{
            this.openConnection();
            PreparedStatement preStatement = this.conn.prepareStatement(_queryString);
            for(int i = 0; i < arrPara.length; i++){
                if(arrType[i] == Types.INTEGER){
                    preStatement.setInt(i + 1, Integer.parseInt(arrPara[i]));
                }
                
                else if(arrType[i] == Types.FLOAT){
                    preStatement.setFloat(i + 1, Float.parseFloat(arrPara[i]));
                }
                else if(arrType[i] == Types.DATE){
                    
                    preStatement.setDate(i + 1, Date.valueOf(arrPara[i]));
                }
                else if(arrType[i] == Types.TINYINT){
                    
                    preStatement.setInt(i + 1, Integer.parseInt(arrPara[i]));
                }
                else{
                    preStatement.setString(i + 1, arrPara[i].toString());
                }
            }
            
             int status = preStatement.executeUpdate();
             return status;
        } catch(SQLException e){
            throw e;
        }finally{
            this.closeConnection();
        }
    }
    
    
    public int executeQueryReturnStatus(String _queryString) throws SQLException, ClassNotFoundException{
        try{
            this.openConnection();
            Statement statement = this.conn.createStatement();
            int status = statement.executeUpdate(_queryString);
            return status;
        }catch (SQLException e){
            throw e;
        }finally{
            this.closeConnection();
        }

    }
    public Connection getConnection(){
        return this.conn;
    }
    
    public void closeConnection() throws SQLException{
        try{
            if(this.conn != null)
                this.conn.close();
        } catch(SQLException e){
            throw e;
        }
    }
}
