/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhnd.ultils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author PC
 */
public class DBIUltilis {
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException{
        Connection con = null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=UserManagement";
//        con = DriverManager.getConnection(url,"sa","admin");
        Context context = new InitialContext();
        Context end = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) end.lookup("NDV123");
        con = ds.getConnection();
        return con;
    }
}
