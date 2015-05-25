/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Controllers;

import com.compani.finaz.Entitys.garante.Garante;
import com.compani.finaz.Entitys.garante.Hipoteca;
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


public class HipotecaController extends JdbcStatemant {

    private static HipotecaController MANEJO = null;
    private static final JdbcStatemant SQl_EXECUTOR = new JdbcStatemant();

    public HipotecaController() {
        setJdbcConnection(JdbcManager.get());

    }

    public static HipotecaController getInstance() {
        if (MANEJO == null) {
            MANEJO = new HipotecaController();
        }
        return MANEJO;
    }

    public static void CreateOrUpdate(Hipoteca hip) {
        if (hip.getId() != null) {
            update(hip);
            return;
        }
        try {
            SQl_EXECUTOR.setJdbcConnection(JdbcManager.get());

            String query = "INSERT INTO garante_hipoteca (titulo, tipo, valoracion,"
                    + "descripcion,codigo VALUES (?, ? , ? , ? , ?)";

            PreparedStatementSet ps = new PreparedStatementSet() {

                @Override
                public void putParameters(PreparedStatement ps) throws SQLException {

                    ps.setString(1, hip.getNumeroExp());
                    ps.setString(2, hip.getTipo());
                    ps.setInt(3, hip.getValoracion());
                    ps.setString(4, hip.getDescripcion());
                    ps.setString(5, hip.getCodigo());

                }

            };

            ps.setGenerateKey(true);
            hip.setId(SQl_EXECUTOR.saveGetId(query, true, ps));

            Garante garante = new Garante();
            garante.setGaranteID(hip.getId());
            garante.setId(hip.getSolicitud().getCodigo());
            garante.setTipoGarante(hip.getTipoGarante());

        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void update(Hipoteca hip) {
        try {

            String query = "UPDATE garante_persona SET chasis = ?,placa = ?, modelo = ?, "
                    + "marca = ? ,tipo =?, valoracion =?, descripcion =? WHERE id = ? ";

            PreparedStatement ps = Conexion.getConexion().prepareStatement(query);

            ps.setString(1, hip.getNumeroExp());
            ps.setString(2, hip.getTipo());
            ps.setInt(3, hip.getValoracion());
            ps.setString(4, hip.getDescripcion());
            ps.setString(5, hip.getCodigo());
            ps.setInt(8, hip.getId());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(Hipoteca hip) {
        if (hip.getId() != null) {
            update(hip);
            return;
        }
        try {
            String sql = "INSERT INTO garante_hipoteca (titulo, tipo, valoracion,"
                    + "descripcion,codigo) VALUES (?, ? , ? , ? , ?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, hip.getNumeroExp());
            ps.setString(2, hip.getTipo());
            ps.setInt(3, hip.getValoracion());
            ps.setString(4, hip.getDescripcion());
            ps.setString(5, hip.getCodigo());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                hip.setId(rs.getInt(1));

            }
            Garante garante = new Garante();
            garante.setGaranteID(hip.getId());
            garante.setSolicitud(hip.getSolicitud());
            garante.setTipoGarante(hip.getTipoGarante());
            GaranteController cGarante = new GaranteController();
            cGarante.save(garante);
//            GaranteController.CreateOrUpdate(garante);

        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public Hipoteca find(int id) {

        Hipoteca hip = new Hipoteca();

        try {
            String sql = "SELECT * FROM garante_hipoteca WHERE id = " + id;

            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);

            while (rs.next()) {
               hip.setId(rs.getInt("id"));
                hip.setCodigo(rs.getString("codigo"));
                hip.setTipo(rs.getString("tipo"));
                hip.setValoracion(rs.getInt("valoracion"));
                hip.setDescripcion(rs.getString("descripcion"));
                hip.setNumeroExp(rs.getString("titulo"));
              
                
       
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hip;
    }

}
