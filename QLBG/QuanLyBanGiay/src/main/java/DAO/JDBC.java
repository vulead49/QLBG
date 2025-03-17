/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mai
 */
public class JDBC {
       public static Connection getConnection()
      {
          Connection con = null;
          try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
<<<<<<< HEAD
            String url = "jdbc:sqlserver://DESKTOP-R4P8GEL:1433;DatabaseName=QLYBANGIAY;encrypt=false;trustServerCertificate=true;";
=======
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=QLBANGIAY;encrypt=false;trustServerCertificate=true;";
>>>>>>> c06f6e2ff1ffc1ff3fba2dd4f196c0be0f20e5bc
            String user = "sa";
            String password = "123456";
            con = DriverManager.getConnection(url, user, password);
          } catch (Exception e) {
              e.printStackTrace();
          }
        return con;
      }
    
     public static void Closeconnection(Connection con)
     {
         try {
             if(con!=null)
             {
                 con.close();
             }
         } catch (Exception e) {
         }
     }
     
     public static void main(String[] args) {
        Connection con = null;
        try {
            con = JDBC.getConnection();
            if (con != null) {
                System.out.println("Connection established successfully.");
            } else {
                System.out.println("Failed to establish connection.");
            }
        } finally {
                JDBC.Closeconnection(con);
        }
    }
}