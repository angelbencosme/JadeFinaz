/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Controllers;

import com.compani.finaz.Entitys.Cliente;
import com.compani.finaz.Entitys.Solicitud;
import com.compani.finaz.Entitys.garante.Garante;
import com.compani.finaz.utility.Conexion;
import com.jsft.jdbc.connection.JdbcManager;
import com.jsft.jdbc.interfaces.PreparedStatementSet;
import com.jsft.jdbc.transactions.JdbcStatemant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GaranteController extends JdbcStatemant {

    private static GaranteController MANEJO = null;
    private static final JdbcStatemant SQL_EXECUTOR = new JdbcStatemant();

    public GaranteController() {
        setJdbcConnection(JdbcManager.get());
    }

    public static GaranteController getIntance() {
        if (MANEJO == null) {
            MANEJO = new GaranteController();
        }
        return MANEJO;

    }

    public static void CreateOrUpdate(Garante garante) {
        SQL_EXECUTOR.setJdbcConnection(JdbcManager.get());
        String sql = "INSERT INTO solicitud (idsolicitud,garante_id,"
                + "tipo_garante)"
                + "VALUES(?,?,?)";
        PreparedStatementSet ps = new PreparedStatementSet() {

            @Override
            public void putParameters(PreparedStatement ps) throws SQLException {
                ps.setInt(1, garante.getSolicitud().getCodigo());
                ps.setInt(2, garante.getGaranteID());
                ps.setString(3, garante.getTipoGarante());

            }
        };
        try {
            SQL_EXECUTOR.save(sql, ps);
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void save(Garante garante) {
        if (garante.getId() != null) {
//            update(garante);
            return;
        }
        try {
            String sql = "INSERT INTO garante_prestamo (idsolicitud,garante_id,"
                    + "tipo_garante)"
                    + "VALUES(?,?,?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, garante.getSolicitud().getCodigo());
            ps.setInt(2, garante.getGaranteID());
            ps.setString(3, garante.getTipoGarante());

            ps.execute();
            System.out.println("ps" + ps);

        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Garante> getlGarante(Solicitud soli) {

        List<Garante> lGarante = new ArrayList<>();

        try {
            String sql = "SELECT * FROM garante_prestamo where idsolicitud = " + soli.getCodigo();

            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);

            while (rs.next()) {
                Garante gar = new Garante();
                gar.setSolicitud(soli);
                gar.setTipoGarante(rs.getString("tipo_garante"));
                switch (gar.getTipoGarante()) {
                    case "PERSONA":
                        PersonaController cPersona = new PersonaController();
                        gar.setGaranteID(rs.getInt("garante_id"));
                        gar.setPersona(cPersona.find(gar.getGaranteID()));
                        break;
                    case "VEHICULO":
                        VehiculoController cVehiculo = new VehiculoController();
                        gar.setGaranteID(rs.getInt("garante_id"));
                        gar.setVehiuclo(cVehiculo.find(gar.getGaranteID()));
                        break;
                    case "HIPOTECA":
                        HipotecaController cHipoteca = new HipotecaController();
                        gar.setGaranteID(rs.getInt("garante_id"));
                        gar.setHipoteca(cHipoteca.find(gar.getGaranteID()));

                }

                lGarante.add(gar);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lGarante;
    }
}
