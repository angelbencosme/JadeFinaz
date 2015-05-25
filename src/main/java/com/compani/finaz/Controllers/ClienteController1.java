 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Controllers;

import com.compani.finaz.Entitys.Cliente;
import com.compani.finaz.utility.Conexion;
import com.jsft.jdbc.connection.JdbcManager;
import com.jsft.jdbc.interfaces.PreparedStatementSet;
import com.jsft.jdbc.interfaces.RowMapper;
import com.jsft.jdbc.transactions.JdbcStatemant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController1 extends JdbcStatemant {

    private static ClienteController1 MANEJO = null;
   
    
  //  private static final JdbcStatemant SQl_EXECUTOR = new JdbcStatemant();

    public ClienteController1() {
        // Estableces la conexion aqui
        setJdbcConnection(JdbcManager.get());
       

    }

    public static ClienteController1 getInstance() {
        if (MANEJO == null) {
            MANEJO = new ClienteController1();
        }
        
        return MANEJO;
    }

//    public void CreateOrUpdate(Cliente cli) {
//        if (cli.getId() != null) {
////            update(cli);
//            return;
//        }
//        try {
//            String sql = "INSERT INTO cliente (identificacion, nombre, apellido,"
//                    + "estado_civil, sexo,telefono,celular,email,"
//                    + "limite,ocupacion,cuidad,dirrecion,empresa,cargo,"
//                    + "jefe,ingreso,cuidad_trabajo,telefono_trabajo,"
//                    + "dirrecion_trabajo, departamento,fecha_nacimiento, fehca_registro, fecha_ingreso)"
//                    + "VALUES (?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?,"
//                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ?)";
//
//            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
//
//            ps.setString(1, cli.getIdentificacion());
//            ps.setString(2, cli.getNombre());
//            ps.setString(3, cli.getApellido());
//            ps.setString(4, cli.getEstadoCivil());
//            ps.setString(5, cli.getSexo());
//            ps.setString(6, cli.getTelefono());
//            ps.setString(7, cli.getCelular());
//            ps.setString(8, cli.getEmail());
//            ps.setString(9, cli.getLimite());
//            ps.setString(10, cli.getOcupacion());
//            ps.setString(11, cli.getCuidad());
//            ps.setString(12, cli.getDirrecion());
//            ps.setString(13, cli.getEmpresa());
//            ps.setString(14, cli.getCargo());
//            ps.setString(15, cli.getJefe());
//            ps.setString(16, cli.getIngreso());
//            ps.setString(17, cli.getCuidadTrabajo());
//            ps.setString(18, cli.getTelefonoTrabajo());
//            ps.setString(19, cli.getDirrecionTrabajo());
//            ps.setString(20, cli.getDepartamento());
//            ps.setDate(21, new java.sql.Date(cli.getFechaNacimiento().getTime()));
//            ps.setDate(22, new java.sql.Date(cli.getFechaReg().getTime()));
//            ps.setDate(23, new java.sql.Date(cli.getFechaIngreso().getTime()));
//
//            ps.execute();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ClienteController1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public Cliente find(int id) {
        String query = "Select * From cliente where idcliente = " + id;

        return queryForObject(query, new ClienteRowMapper1());
    }
//public Cliente find(int id) {
//
//        Cliente cli = new Cliente();
//
//        try {
//            String sql = "SELECT * FROM cliente WHERE idcliente = " + id;
//
//            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);
//
//            while (rs.next()) {
//               cli.setId(rs.getInt("idcliente"));
//                cli.setIdentificacion(rs.getString("identificacion"));
//                cli.setNombre(rs.getString("nombre"));
//                cli.setApellido(rs.getString("apellido"));
//                cli.setEstadoCivil(rs.getString("estado_civil"));
//                cli.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
//                cli.setSexo(rs.getString("sexo"));
//                cli.setTelefono(rs.getString("telefono"));
//                cli.setCelular(rs.getString("celular"));
//                cli.setEmail(rs.getString("email"));
//                cli.setLimite(rs.getString("limite"));
//                cli.setFechaReg(rs.getDate("fehca_registro"));
//                cli.setOcupacion(rs.getString("ocupacion"));
//                cli.setCuidad(rs.getString("cuidad"));
//                cli.setDirrecion(rs.getString("dirrecion"));
//                cli.setEmpresa(rs.getString("empresa"));
//                cli.setCargo(rs.getString("cargo"));
//                cli.setDepartamento(rs.getString("departamento"));
//                cli.setJefe(rs.getString("jefe"));
//                cli.setFechaIngreso(rs.getDate("fecha_ingreso"));
//                cli.setIngreso(rs.getString("ingreso"));
//                cli.setCuidadTrabajo(rs.getString("cuidad_trabajo"));
//                cli.setTelefonoTrabajo(rs.getString("telefono_trabajo"));
//                cli.setDirrecionTrabajo(rs.getString("dirrecion_trabajo"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return cli;
//    }

    public void CreateOrUpdate(Cliente cli) {
        if (cli.getId() != null) {
            update(cli);
            return;
        }
        try {

            String query = "INSERT INTO cliente (identificacion, nombre, apellido,"
                    + "estado_civil, sexo,telefono,celular,email,"
                    + "limite,ocupacion,cuidad,dirrecion,empresa,cargo,"
                    + "jefe,ingreso,cuidad_trabajo,telefono_trabajo,"
                    + "dirrecion_trabajo, departamento,fecha_nacimiento, fehca_registro, fecha_ingreso,activo ,imagen)"
                    + "VALUES (?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?,"
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ? ,? ,?)";
            PreparedStatementSet ps = new PreparedStatementSet() {

                @Override
                public void putParameters(PreparedStatement ps) throws SQLException {
                    ps.setString(1, cli.getIdentificacion());
                    ps.setString(2, cli.getNombre());
                    ps.setString(3, cli.getApellido());
                    ps.setString(4, cli.getEstadoCivil());
                    ps.setString(5, cli.getSexo());
                    ps.setString(6, cli.getTelefono());
                    ps.setString(7, cli.getCelular());
                    ps.setString(8, cli.getEmail());
                    ps.setString(9, cli.getLimite());
                    ps.setString(10, cli.getOcupacion());
                    ps.setString(11, cli.getCuidad());
                    ps.setString(12, cli.getDirrecion());
                    ps.setString(13, cli.getEmpresa());
                    ps.setString(14, cli.getCargo());
                    ps.setString(15, cli.getJefe());
                    ps.setString(16, cli.getIngreso());
                    ps.setString(17, cli.getCuidadTrabajo());
                    ps.setString(18, cli.getTelefonoTrabajo());
                    ps.setString(19, cli.getDirrecionTrabajo());
                    ps.setString(20, cli.getDepartamento());
                    ps.setDate(21, new java.sql.Date(cli.getFechaNacimiento().getTime()));
                    ps.setDate(22, new java.sql.Date(cli.getFechaReg().getTime()));
                    ps.setDate(23, new java.sql.Date(cli.getFechaIngreso().getTime()));
                    ps.setBoolean(24, cli.isActivo());
                    ps.setBlob(25, cli.getImagen());
                }

            };
            save(query, ps);
//            ps.setGenerateKey(true);
//
//            cli.setId(SQl_EXECUTOR.saveGetId(sql,true, ps));

//            if (ps.getKeyId() != null) {
//                cli.setId(ps.getKeyId().intValue());
//                //System.out.println(ps.getKeyId().intValue());
//            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void update(Cliente cli) {
        try {
            String query = "UPDATE cliente SET identificacion = ?,nombre = ?, apellido = ?, "
                    + "estado_civil = ? ,fecha_nacimiento =?, sexo =?, telefono =? ,"
                    + "celular =? ,email = ? ,limite =?, fehca_registro =?, ocupacion =?,"
                    + "cuidad =?, dirrecion =?,empresa =? ,cargo =? , jefe =? , fecha_ingreso =?,"
                    + "ingreso =? ,cuidad_trabajo =? , telefono_trabajo =? ,dirrecion_trabajo =? ,departamento = ? ,imagen = ? WHERE idcliente = ? ";

            PreparedStatementSet ps = new PreparedStatementSet() {

                @Override
                public void putParameters(PreparedStatement ps) throws SQLException {
                    ps.setString(1, cli.getIdentificacion());
                    ps.setString(2, cli.getNombre());
                    ps.setString(3, cli.getApellido());
                    ps.setString(4, cli.getEstadoCivil());
                    ps.setDate(5, new java.sql.Date(cli.getFechaNacimiento().getTime()));
                    ps.setString(6, cli.getSexo());
                    ps.setString(7, cli.getTelefono());
                    ps.setString(8, cli.getCelular());
                    ps.setString(9, cli.getEmail());
                    ps.setString(10, cli.getLimite());
                    ps.setDate(11, new java.sql.Date(cli.getFechaReg().getTime()));
                    ps.setString(12, cli.getOcupacion());
                    ps.setString(13, cli.getCuidad());
                    ps.setString(14, cli.getDirrecion());
                    ps.setString(15, cli.getEmpresa());
                    ps.setString(16, cli.getCargo());
                    ps.setString(17, cli.getJefe());
                    ps.setDate(18, new java.sql.Date(cli.getFechaIngreso().getTime()));
                    ps.setString(19, cli.getIngreso());
                    ps.setString(20, cli.getCuidadTrabajo());
                    ps.setString(21, cli.getTelefonoTrabajo());
                    ps.setString(22, cli.getDirrecionTrabajo());
                    ps.setString(23, cli.getDepartamento());
                    ps.setInt(24, cli.getId());
                    ps.setBlob(25,cli.getImagen());
                }
            };
            save(query, ps);

        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//

    public List<Cliente> findAll() throws SQLException {
        String query = "SELECT * FROM cliente";
        return query(query, new ClienteRowMapper());

    }
//
//    public Cliente getClienteIdentificacion(String campo, String datos) {
//        SQl_EXECUTOR.setJdbcConnection(JdbcManager.get());
//
//        String sql = "SELECT * FROM cliente as e WHERE e." + campo + ""
//                + " like '" + datos + "%'";
//        //String sql = "SELECT * FROM estudiante as e  WHERE e.identificacion = " + Identificacion;
//        return (Cliente) queryForObject(sql, new ClienteRowMapper());
//    }
//

    public List<Cliente> getlClientes() {

        List<Cliente> Clientes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM cliente";

            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("idcliente"));
                cli.setIdentificacion(rs.getString("identificacion"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setEstadoCivil(rs.getString("estado_civil"));
                cli.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                cli.setSexo(rs.getString("sexo"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setCelular(rs.getString("celular"));
                cli.setEmail(rs.getString("email"));
                cli.setLimite(rs.getString("limite"));
                cli.setFechaReg(rs.getDate("fehca_registro"));
                cli.setOcupacion(rs.getString("ocupacion"));
                cli.setCuidad(rs.getString("cuidad"));
                cli.setDirrecion(rs.getString("dirrecion"));
                cli.setEmpresa(rs.getString("empresa"));
                cli.setCargo(rs.getString("cargo"));
                cli.setDepartamento(rs.getString("departamento"));
                cli.setJefe(rs.getString("jefe"));
                cli.setFechaIngreso(rs.getDate("fecha_ingreso"));
                cli.setIngreso(rs.getString("ingreso"));
                cli.setCuidadTrabajo(rs.getString("cuidad_trabajo"));
                cli.setTelefonoTrabajo(rs.getString("telefono_trabajo"));
                cli.setDirrecionTrabajo(rs.getString("dirrecion_trabajo"));

                Clientes.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Clientes;
    }

//
//    public void delete(Cliente cli) {
//        try {
//            String sql = "delete from cliente where idcliente = ?";
//
//            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
//            ps.setInt(1, cli.getId());
//            ps.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//    public void create(Cliente cli) {
//         if (cli.getId() != null) {
////            update(cli);
//            return;
//        }
//        try {
//            SQl_EXECUTOR.setJdbcConnection(JdbcManager.get());
//
//            String sql = "INSERT INTO cliente (identificacion, nombre, apellido,"
//                    + "estado_civil, sexo,telefono,celular,email,"
//                    + "limite,ocupacion,cuidad,dirrecion,empresa,cargo,"
//                    + "jefe,ingreso,cuidad_trabajo,telefono_trabajo,"
//                    + "dirrecion_trabajo, departamento,fecha_nacimiento, fehca_registro, fecha_ingreso,activo)"
//                    + "VALUES (?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?,"
//                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ? ,?)";
//            PreparedStatementSet ps = new PreparedStatementSet() {
//
//                @Override
//                public void putParameters(PreparedStatement ps) throws SQLException {
//                    ps.setString(1, cli.getIdentificacion());
//                    ps.setString(2, cli.getNombre());
//                    ps.setString(3, cli.getApellido());
//                    ps.setString(4, cli.getEstadoCivil());
//                    ps.setString(5, cli.getSexo());
//                    ps.setString(6, cli.getTelefono());
//                    ps.setString(7, cli.getCelular());
//                    ps.setString(8, cli.getEmail());
//                    ps.setString(9, cli.getLimite());
//                    ps.setString(10, cli.getOcupacion());
//                    ps.setString(11, cli.getCuidad());
//                    ps.setString(12, cli.getDirrecion());
//                    ps.setString(13, cli.getEmpresa());
//                    ps.setString(14, cli.getCargo());
//                    ps.setString(15, cli.getJefe());
//                    ps.setString(16, cli.getIngreso());
//                    ps.setString(17, cli.getCuidadTrabajo());
//                    ps.setString(18, cli.getTelefonoTrabajo());
//                    ps.setString(19, cli.getDirrecionTrabajo());
//                    ps.setString(20, cli.getDepartamento());
//                    ps.setDate(21, new java.sql.Date(cli.getFechaNacimiento().getTime()));
//                    ps.setDate(22, new java.sql.Date(cli.getFechaReg().getTime()));
//                    ps.setDate(23, new java.sql.Date(cli.getFechaIngreso().getTime()));
//                    ps.setBoolean(24, cli.isActivo());
//                }
//
//            };
//            ps.setGenerateKey(true);
//
//            cli.setId(SQl_EXECUTOR.saveGetId(sql,true, ps));
//
////            if (ps.getKeyId() != null) {
////                cli.setId(ps.getKeyId().intValue());
////                //System.out.println(ps.getKeyId().intValue());
////            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//    public static List<Cliente> findAll() throws SQLException {
//       JdbcStatemant sqlExecutor = new JdbcStatemant();
//        sqlExecutor.setJdbcConnection(JdbcManager.get("jadelab"));
//
//        String sql = "SELECT * FROM cliente";
//
//        return sqlExecutor.query(sql, new ClienteRowMapper());
//    }
}

class ClienteRowMapper1 implements RowMapper<Cliente> {

    @Override
    public Cliente getRow(ResultSet rs) throws SQLException {

        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("idcliente"));
        cliente.setIdentificacion(rs.getString("identificacion"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellido(rs.getString("apellido"));
        cliente.setEstadoCivil(rs.getString("estado_civil"));
        cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
        cliente.setSexo(rs.getString("sexo"));
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setCelular(rs.getString("celular"));
        cliente.setEmail(rs.getString("email"));
        cliente.setLimite(rs.getString("limite"));
        cliente.setFechaReg(rs.getDate("fehca_registro"));
        cliente.setOcupacion(rs.getString("ocupacion"));
        cliente.setCuidad(rs.getString("cuidad"));
        cliente.setDirrecion(rs.getString("dirrecion"));
        cliente.setEmpresa(rs.getString("empresa"));
        cliente.setCargo(rs.getString("cargo"));
        cliente.setDepartamento(rs.getString("departamento"));
        cliente.setJefe(rs.getString("jefe"));
        cliente.setFechaIngreso(rs.getDate("fecha_ingreso"));
        cliente.setIngreso(rs.getString("ingreso"));
        cliente.setCuidadTrabajo(rs.getString("cuidad_trabajo"));
        cliente.setTelefonoTrabajo(rs.getString("telefono_trabajo"));
        cliente.setDirrecionTrabajo(rs.getString("dirrecion_trabajo"));
        cliente.setActivo(rs.getBoolean("activo"));

        return cliente;

    }

    class NuevoClienteRM implements RowMapper<Cliente> {

        @Override
        public Cliente getRow(ResultSet rs) throws SQLException {

            Cliente cliente = new Cliente();
            cliente.setIdentificacion(rs.getString("identificacion"));
            return cliente;
        }

    }
}
