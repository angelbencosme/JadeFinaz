/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Controllers;

import com.compani.finaz.Entitys.Cliente;
import com.compani.finaz.Entitys.garante.Garante;
import com.compani.finaz.Entitys.garante.Persona;
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


public class PersonaController extends JdbcStatemant {

    private static PersonaController MANEJO = null;
    private static final JdbcStatemant SQl_EXECUTOR = new JdbcStatemant();

    public PersonaController() {
        setJdbcConnection(JdbcManager.get());

    }

    public static PersonaController getInstance() {
        if (MANEJO == null) {
            MANEJO = new PersonaController();
        }
        return MANEJO;
    }

    public static void CreateOrUpdate(Persona per) {
        if (per.getId() != null) {
            update(per);
            return;
        }
        try {
            SQl_EXECUTOR.setJdbcConnection(JdbcManager.get());

            String query = "INSERT INTO garante_persona (cedula, nombre, apellido,"
                    + "celular,telefono,trabajo,puesto,ingreso,jefe"
                    + "VALUES (?, ?, ?, ? , ?, ?, ?, ?, ?)";

            PreparedStatementSet ps = new PreparedStatementSet() {

                @Override
                public void putParameters(PreparedStatement ps) throws SQLException {
                    ps.setString(1, per.getIndentificacion());
                    ps.setString(2, per.getNombre());
                    ps.setString(3, per.getApellido());
                    ps.setString(4, per.getCelular());
                    ps.setString(5, per.getTelefono());
                    ps.setString(6, per.getTrabajo());
                    ps.setString(7, per.getPuesto());
                    ps.setString(8, per.getPuesto());

                    ps.setString(10, per.getIngreso());
                    ps.setString(11, per.getJefe());

                }

            };

            ps.setGenerateKey(true);
            per.setId(SQl_EXECUTOR.saveGetId(query, true, ps));

            Garante garante = new Garante();
            garante.setGaranteID(per.getId());
            garante.setId(per.getSolicitud().getCodigo());
            garante.setTipoGarante(per.getTipoGarante());
            GaranteController.CreateOrUpdate(garante);

        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void update(Persona per) {
        try {

            String query = "UPDATE garante_persona SET cedula = ?,nombre = ?, apellido = ?, "
                    + "celular = ? ,telefono =?, trabajo =?, puesto =? ,"
                    + "ingreso =? ,jefe = ? WHERE id = ? ";

            PreparedStatement ps = Conexion.getConexion().prepareStatement(query);

            ps.setString(1, per.getIndentificacion());
            ps.setString(2, per.getNombre());
            ps.setString(3, per.getApellido());
            ps.setString(4, per.getCelular());
            ps.setString(5, per.getTelefono());
            ps.setString(6, per.getTrabajo());
            ps.setString(7, per.getPuesto());
            ps.setString(8, per.getIngreso());
            ps.setString(9, per.getJefe());
            ps.setInt(10, per.getId());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(Persona per) {
        if (per.getId() != null) {
            update(per);
            return;
        }
        try {
            String sql = "INSERT INTO garante_persona (cedula, nombre, apellido,"
                    + "celular,telefono,trabajo,puesto,ingreso,jefe)"
                    + "VALUES (?, ?, ?, ? , ?, ?, ?, ?, ?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, per.getIndentificacion());
            ps.setString(2, per.getNombre());
            ps.setString(3, per.getApellido());
            ps.setString(4, per.getCelular());
            ps.setString(5, per.getTelefono());
            ps.setString(6, per.getTrabajo());
            ps.setString(7, per.getPuesto());
            ps.setString(8, per.getIngreso());
            ps.setString(9, per.getJefe());

            ps.execute();
            System.out.println("ps:"+ps);

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                per.setId(rs.getInt(1));

            }
            Garante garante = new Garante();
            garante.setGaranteID(per.getId());
            garante.setSolicitud(per.getSolicitud());
            garante.setTipoGarante(per.getTipoGarante());
            GaranteController cGarante = new GaranteController();
            cGarante.save(garante);
//            GaranteController.CreateOrUpdate(garante);
            
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public Persona find(int id) {

        Persona per = new Persona();

        try {
            String sql = "SELECT * FROM garante_persona WHERE id = " + id;

            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);

            while (rs.next()) {
               per.setId(rs.getInt("id"));
                per.setIndentificacion(rs.getString("cedula"));
                per.setNombre(rs.getString("nombre"));
                per.setApellido(rs.getString("apellido"));
                per.setCelular(rs.getString("celular"));
                per.setTelefono(rs.getString("telefono"));
                
                per.setTrabajo(rs.getString("trabajo"));
                per.setPuesto(rs.getString("puesto"));
                per.setIngreso(rs.getString("ingreso"));
                
                
                per.setJefe(rs.getString("jefe"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return per;
    }
    
}
