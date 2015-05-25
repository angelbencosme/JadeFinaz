/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Controllers;

import com.compani.finaz.Entitys.garante.Garante;
import com.compani.finaz.Entitys.garante.Persona;
import com.compani.finaz.Entitys.garante.Vehiculo;
import com.compani.finaz.utility.Conexion;
import com.jsft.jdbc.connection.JdbcManager;
import com.jsft.jdbc.interfaces.PreparedStatementSet;
import com.jsft.jdbc.transactions.JdbcStatemant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VehiculoController extends JdbcStatemant {

    private static VehiculoController MANEJO = null;
    private static final JdbcStatemant SQl_EXECUTOR = new JdbcStatemant();

    public VehiculoController() {
        setJdbcConnection(JdbcManager.get());

    }

    public static VehiculoController getInstance() {
        if (MANEJO == null) {
            MANEJO = new VehiculoController();
        }
        return MANEJO;
    }

    public static void CreateOrUpdate(Vehiculo veh) {
        if (veh.getId() != null) {
            update(veh);
            return;
        }
        try {
            SQl_EXECUTOR.setJdbcConnection(JdbcManager.get());

            String query = "INSERT INTO garante_vehiculo (chasis, placa, modelo,"
                    + "marca,tipo,valoracion,descripcion"
                    + "VALUES (?, ?, ?, ? , ?, ?, ?)";

            PreparedStatementSet ps = new PreparedStatementSet() {

                @Override
                public void putParameters(PreparedStatement ps) throws SQLException {

                    ps.setString(1, veh.getChasis());
                    ps.setString(2, veh.getPlaca());
                    ps.setString(3, veh.getModelo());
                    ps.setString(4, veh.getMarca());
                    ps.setString(5, veh.getTipo());
                    ps.setInt(6, veh.getValoracion());
                    ps.setString(7, veh.getDescripcion());

                }

            };

            ps.setGenerateKey(true);
            veh.setId(SQl_EXECUTOR.saveGetId(query, true, ps));

            Garante garante = new Garante();
            garante.setGaranteID(veh.getId());
            garante.setId(veh.getSolicitud().getCodigo());
            garante.setTipoGarante(veh.getTipoGarante());

        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void update(Vehiculo veh) {
        try {

            String query = "UPDATE garante_persona SET chasis = ?,placa = ?, modelo = ?, "
                    + "marca = ? ,tipo =?, valoracion =?, descripcion =? WHERE id = ? ";

            PreparedStatement ps = Conexion.getConexion().prepareStatement(query);

            ps.setString(1, veh.getChasis());
            ps.setString(2, veh.getPlaca());
            ps.setString(3, veh.getModelo());
            ps.setString(4, veh.getMarca());
            ps.setString(5, veh.getTipo());
            ps.setInt(6, veh.getValoracion());
            ps.setString(7, veh.getDescripcion());
            ps.setInt(8, veh.getId());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(Vehiculo veh) {
        if (veh.getId()!= null) {
            update(veh);
            return;
        }
        try {
            String sql = "INSERT INTO garante_vehiculo (chasis, placa, modelo,"
                    + "marca,tipo,valoracion,descripcion)"
                    + "VALUES (?, ?, ?, ? , ?, ?, ?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, veh.getChasis());
            ps.setString(2, veh.getPlaca());
            ps.setString(3, veh.getModelo());
            ps.setString(4, veh.getMarca());
            ps.setString(5, veh.getTipo());
            ps.setInt(6, veh.getValoracion());
            ps.setString(7, veh.getDescripcion());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                veh.setId(rs.getInt(1));

            }
            Garante garante = new Garante();
            garante.setGaranteID(veh.getId());
            garante.setSolicitud(veh.getSolicitud());
            garante.setTipoGarante(veh.getTipoGarante());
            GaranteController cGarante = new GaranteController();
            System.out.println("aqui garante");
            cGarante.save(garante);
//            GaranteController.CreateOrUpdate(garante);

        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public Vehiculo find(int id) {

        Vehiculo veh = new Vehiculo();

        try {
            String sql = "SELECT * FROM garante_vehiculo WHERE id = " + id;

            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);

            while (rs.next()) {
               veh.setId(rs.getInt("id"));
                veh.setChasis(rs.getString("chasis"));
                veh.setTipo(rs.getString("tipo"));
                veh.setValoracion(rs.getInt("valoracion"));
                veh.setDescripcion(rs.getString("descripcion"));
                veh.setPlaca(rs.getString("placa"));
                veh.setModelo(rs.getString("modelo"));
                veh.setMarca(rs.getString("marca"));
                
              
                
       
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veh;
    }
}