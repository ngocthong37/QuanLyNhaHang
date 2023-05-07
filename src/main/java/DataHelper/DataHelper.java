/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataHelper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author T3D Computer
 */
public class DataHelper {
    public static Connection openConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databasename=quanlynhahang;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    };
}
