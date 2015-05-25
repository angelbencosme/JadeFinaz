/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.utility;

import com.jsft.jdbc.connection.JdbcConnection;
import com.jsft.jdbc.connection.JdbcManager;
import com.jsft.jdbc.connection.ParametersConnection;


public class JdbcConfiguration {

    public static void init() {
        ParametersConnection pc = new ParametersConnection();
        pc.setDriver("com.mysql.jdbc.Driver");
        pc.setPassword("sqladmin");
        pc.setUserName("root");
        pc.setUrl("jdbc:mysql://localhost/jadefinaz");

        JdbcConnection jCon = new JdbcConnection();
        jCon.setConnectionParameters(pc);
        JdbcManager.put(pc);
//
//        pc = new ParametersConnection();
//        pc.setDriver("com.mysql.jdbc.Driver");
//        pc.setPassword("quisquella");
//        pc.setUserName("root");
//        pc.setUrl("jdbc:mysql://localhost/jadelab");
//
//        JdbcManager.put("jadelab", pc);

//        System.out.println(jCon.getConexion());
    }
}
