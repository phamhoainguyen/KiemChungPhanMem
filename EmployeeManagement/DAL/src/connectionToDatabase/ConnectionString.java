/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionToDatabase;

/**
 *
 * @author NguyenPH
 */
public class ConnectionString {
    public DBConnection cnn;
    
    public ConnectionString(){
        this.cnn = null;
        
        String connectionString = "jdbc:mysql://localhost:3306/EmployeeManagement";
        //String connectionString = "jdbc:jtds:sqlserver://localhost:1433/EmployeeManagement;instance=DESKTOP-HOAINGU\\NGUYENSQL;user=NguyenMSSQL;password=123456";
        //this.cnn = new DBConnection(connectionString, "NguyenMSSQL", "123456");
        this.cnn = new DBConnection(connectionString, "root", "");
    }
}
