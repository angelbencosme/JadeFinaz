/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Controllers;

import com.compani.finaz.Entitys.Cuota;
import com.compani.finaz.Entitys.Solicitud;
import com.compani.finaz.Entitys.SolicitudAutorizacion;
import com.compani.finaz.utility.Conexion;
import com.jsft.jdbc.transactions.JdbcStatemant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SolicitudAutorizadaController extends JdbcStatemant{
    public void save(SolicitudAutorizacion sa) {
        try {
            String sql =  "INSERT INTO prestamo (solicitud_id,monto_autorizado,"
                + "autorizacion)"
                + "VALUES(?,?,?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, sa.getSolicitud().getCodigo());
            ps.setInt(2, sa.getMontolAutorizado());
            ps.setString(3, sa.getAutorizada());

            

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                sa.setId(rs.getInt(1));
                
            }
            CuotasController cCouta = new CuotasController();
            for (Cuota couta : sa.getlCuotas()) {
                couta.setaSolicitud(sa);
                cCouta.save(couta);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<SolicitudAutorizacion> getlSolicitud() {

        List<SolicitudAutorizacion> lSolicitud = new ArrayList<>();

        try {
            String sql = "SELECT * FROM prestamo";

            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);

            while (rs.next()) {
                
                SolicitudAutorizacion asoli = new SolicitudAutorizacion();
                
                asoli.setId(rs.getInt("id"));
                asoli.setMontolAutorizado(rs.getInt("monto_autorizado"));
                asoli.setAutorizada(rs.getString("autorizacion"));
                SolicitudController cs = new SolicitudController();
                asoli.setSolicitud(cs.getSolicitud(rs.getInt("solicitud_id")));
                lSolicitud.add(asoli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lSolicitud;
    }
    public SolicitudAutorizacion getlSolicitud(int code) {
SolicitudAutorizacion asoli = new SolicitudAutorizacion();
        try {
            String sql = "SELECT * FROM prestamo WHERE ID =" +code;

            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);

            while (rs.next()) {
                
                
                
                asoli.setMontolAutorizado(rs.getInt("monto_autorizado"));
                asoli.setAutorizada(rs.getString("autorizacion"));
                SolicitudController cs = new SolicitudController();
                asoli.setSolicitud(cs.getSolicitud(rs.getInt("solicitud_id")));
 
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asoli;
    }
    
    
}
