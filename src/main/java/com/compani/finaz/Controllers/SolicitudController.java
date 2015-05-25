/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Controllers;

import com.compani.finaz.Entitys.Solicitud;
import com.compani.finaz.Entitys.garante.Garante;
import com.compani.finaz.Entitys.garante.Hipoteca;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SolicitudController extends JdbcStatemant {

    private static SolicitudController MANEJO = null;
    private static final JdbcStatemant SQL_EXECUTOR = new JdbcStatemant();
    private static Solicitud sol = new Solicitud();

    private static void update(Solicitud soli) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SolicitudController() {
        setJdbcConnection(JdbcManager.get());
    }

    public static SolicitudController getIntance() {
        if (MANEJO == null) {
            MANEJO = new SolicitudController();
        }
        return MANEJO;

    }

    public static void CreateOrUpdate(Solicitud soli) {
        if (soli.getCodigo() != null) {
            update(soli);

        }
        SQL_EXECUTOR.setJdbcConnection(JdbcManager.get());
        String sql = "INSERT INTO solicitud (idcliente,importe_financiar,"
                + "metodo_amortizacion,tasa_interes,"
                + "modalidad_pago,tiempo,cuotas,tiempo_estimado)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatementSet ps = new PreparedStatementSet() {

            @Override
            public void putParameters(PreparedStatement ps) throws SQLException {
                ps.setInt(1, soli.getCliente().getId());
                ps.setInt(2, soli.getMonto());
                ps.setString(3, soli.getModalidadPago());
                ps.setFloat(4, soli.getTasaInteres());
                ps.setString(5, soli.getModalidadPago());
                ps.setInt(6, soli.getTiempo());
                ps.setInt(7, soli.getCuotas());
                ps.setString(8, soli.getTiempo2());

            }
        };
        try {
            SQL_EXECUTOR.save(sql, ps);
//            ps.setGenerateKey(true);

//            soli.setCodigo(SQL_EXECUTOR.saveGetId(sql,true, ps));
            sol.getlPersona().stream().forEach((Persona per) -> {
                per.setSolicitud(soli);
                PersonaController.CreateOrUpdate(per);
            });

            soli.getlVehiculo().stream().forEach((Vehiculo veh) -> {
                veh.setSolicitud(soli);
                VehiculoController.CreateOrUpdate(veh);
            });

            soli.getlHipoteca().stream().forEach((Hipoteca hip) -> {
                hip.setSolicitud(soli);
                HipotecaController.CreateOrUpdate(hip);
            });
            soli.getlGarante().stream().forEach((Garante garante) -> {
                garante.setSolicitud(soli);
            });
            sol = soli;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Solicitud getSolicitud() {
        return sol;
    }

    public void save(Solicitud soli) {
        if (soli.getCodigo() != null) {
            update(soli);
            return;
        }
        try {
            String sql = "INSERT INTO solicitud (idcliente,importe_financiar,"
                    + "metodo_amortizacion,tasa_interes,"
                    + "modalidad_pago,tiempo,cuotas,numero_solicitud,tipo_prestamo,tiempo_estimado)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, soli.getCliente().getId());
            ps.setInt(2, soli.getMonto());
            ps.setString(3, soli.getModalidadPago());
            ps.setFloat(4, soli.getTasaInteres());
            ps.setString(5, soli.getModalidadPago());
            ps.setInt(6, soli.getTiempo());
            ps.setInt(7, soli.getCuotas());
            ps.setString(8, soli.getNoSolicitud());
            ps.setString(9, soli.getTipoPrestamo());
            ps.setString(10, soli.getTiempo2());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                soli.setCodigo(rs.getInt(1));

            }
            PersonaController cPersona = new PersonaController();
            VehiculoController cVehiculo = new VehiculoController();
            HipotecaController cHipoteca = new HipotecaController();
            for (Persona per : soli.getlPersona()) {
                per.setSolicitud(soli);
                cPersona.save(per);
//                PersonaController.save(per);
            }
            for (Vehiculo veh : soli.getlVehiculo()) {
                veh.setSolicitud(soli);
                cVehiculo.save(veh);
//                VehiculoController.save(veh);
            }
            for (Hipoteca hip : soli.getlHipoteca()) {
                hip.setSolicitud(soli);
                cHipoteca.save(hip);
            }

            sol = soli;

        } catch (SQLException ex) {
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Solicitud> getlSolicitud() {

        List<Solicitud> Solicitud = new ArrayList<>();

        try {
            String sql = "SELECT * FROM solicitud";

            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);

            while (rs.next()) {
                Solicitud soli = new Solicitud();
                soli.setCodigo(rs.getInt("idsolicitud"));
                ClienteController cCliente = new ClienteController();
                soli.setCliente(cCliente.find(rs.getInt("idcliente")));
                soli.setNoSolicitud(rs.getString("numero_solicitud"));
                soli.setMonto(Integer.parseInt(rs.getString("importe_financiar")));
                soli.setMetodoAmortizacion(rs.getString("metodo_amortizacion"));
                soli.setTasaInteres(Float.parseFloat(String.valueOf(rs.getInt("tasa_interes"))));
                soli.setModalidadPago(rs.getString("modalidad_pago"));
                soli.setTiempo(rs.getInt("tiempo"));
                soli.setCuotas(rs.getInt("cuotas"));
                soli.setTipoPrestamo(rs.getString("tipo_prestamo"));
                soli.setTiempo2(rs.getString("tiempo_estimado"));
                GaranteController cGarante = new GaranteController();
                soli.setlGarante(cGarante.getlGarante(soli));
                Solicitud.add(soli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Solicitud;
    }

    public Solicitud getSolicitud(int code) {

        Solicitud soli = new Solicitud();
        try {
            String sql = "SELECT * FROM solicitud WHERE  idsolicitud = " + code;

            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(sql);

            while (rs.next()) {

                soli.setCodigo(code);
                ClienteController cCliente = new ClienteController();
                soli.setCliente(cCliente.find(rs.getInt("idcliente")));
                soli.setNoSolicitud(rs.getString("numero_solicitud"));
                soli.setMonto(Integer.parseInt(rs.getString("importe_financiar")));
                soli.setMetodoAmortizacion(rs.getString("metodo_amortizacion"));
                soli.setTasaInteres(Float.parseFloat(String.valueOf(rs.getInt("tasa_interes"))));
                soli.setModalidadPago(rs.getString("modalidad_pago"));
                soli.setTiempo(rs.getInt("tiempo"));
                soli.setCuotas(rs.getInt("cuotas"));
                soli.setTipoPrestamo(rs.getString("tipo_prestamo"));
                soli.setTiempo2(rs.getString("tiempo_estimado"));
                GaranteController cGarante = new GaranteController();
                soli.setlGarante(cGarante.getlGarante(soli));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soli;
    }

}
