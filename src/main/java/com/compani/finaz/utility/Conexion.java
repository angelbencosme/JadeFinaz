package com.compani.finaz.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Conexion {
    
    private static Connection conexion;
    
   static  {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jadefinaz", "root", "sqladmin");
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection conexion) {
        Conexion.conexion = conexion;
    }
   
    public static void main(String[] args) {
        Conexion.getConexion();
    }
}

