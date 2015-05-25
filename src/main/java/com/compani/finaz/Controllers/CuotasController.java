/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Controllers;

import com.compani.finaz.Entitys.Cuota;
import com.compani.finaz.utility.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CuotasController {
    
    public void save(Cuota couta) {
        if (couta.getId()!= null) {
            update(couta);
            return;
        }
        try {
            String sql =  "INSERT INTO cuota (numero_cuotas,pago_periodicos,"
                + "capital_pagado,prestamo_id,"
                + "pago_periodico)"
                + "VALUES(?,?,?,?,?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, couta.getNoCuota());
            ps.setDouble(2, couta.getPagoPeriodicol());
            ps.setDouble(3, couta.getCapitalPagado());
            ps.setInt(4, couta.getaSolicitud().getId());
            ps.setDouble(5, couta.getPagoPeriodicol());
           
            

            ps.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update(Cuota couta) {
               try {
            String sql =  "SET UPDATE cuota numero_cuotas = @numero_cuotas ,pago_periodicos = @pago_periodicos,"
                + "capital_pagado = @capital_pagado ,prestamo_id = @prestamo_id,"
                + "pago_periodico = @pago_periodico";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, couta.getNoCuota());
            ps.setDouble(2, couta.getPagoPeriodicol());
            ps.setDouble(3, couta.getCapitalPagado());
            ps.setInt(4, couta.getaSolicitud().getId());
            ps.setDouble(5, couta.getPagoPeriodicol());
            ps.setInt(6, couta.getId());
           
            

            ps.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public List<Cuota> getlCuotas(int code) {

        List<Cuota> lCuota = new ArrayList<>();

        try {
            String sql = "SELECT * FROM cuota where  prestamo_id = "+code;

            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);

            while (rs.next()) {
                
                Cuota asoli = new Cuota();
                
                asoli.setNoCuota(rs.getInt("numero_cuotas"));
                asoli.setPagoPeriodicol(rs.getDouble("pago_periodicos"));
                asoli.setCapitalPagado(rs.getDouble("capital_pagado"));
                SolicitudAutorizadaController sa = new SolicitudAutorizadaController();
                asoli.setaSolicitud(sa.getlSolicitud(rs.getInt("prestamo_id")));
                
 
                lCuota.add(asoli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lCuota;
    }
    
}
