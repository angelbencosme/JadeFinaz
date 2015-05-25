/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Views;

import com.compani.finaz.Controllers.SolicitudAutorizadaController;
import com.compani.finaz.Controllers.SolicitudController;
import com.compani.finaz.Entitys.Cuota;
import com.compani.finaz.Entitys.Prestamo;
import com.compani.finaz.Entitys.Solicitud;
import com.compani.finaz.Entitys.SolicitudAutorizacion;
import com.compani.finaz.Views.consulta.ConsultaIinterface;
import com.compani.finaz.Views.menuInterfaces.MenuAccion;
import com.compani.finaz.tablesModel.SolicitudAutorizacionTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;

public class PnAutorizacion extends javax.swing.JPanel implements MenuAccion, ConsultaIinterface<Object> {

    /**
     * Creates new form PnAutorizacion
     */
    SolicitudAutorizacionTableModel tmSolicitudAutorizacion;
    SolicitudAutorizadaController caSolicitud = new SolicitudAutorizadaController();

    public PnAutorizacion() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAutorizacion = new javax.swing.JTable();

        jXHeader1.setDescription("Autorizacion de solicitud");
        jXHeader1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Bill-48(1).png"))); // NOI18N
        jXHeader1.setTitle("Autorizacion");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbAutorizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbAutorizacion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 1211, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 519, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(63, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    private javax.swing.JTable tbAutorizacion;
    // End of variables declaration//GEN-END:variables

    public void setTableModel() {
        SolicitudController cSolicitud = new SolicitudController();
        tmSolicitudAutorizacion = new SolicitudAutorizacionTableModel();
        List<SolicitudAutorizacion> lSolicitudAutorizacion = new ArrayList<>();
        List<Solicitud> lSolicitud = cSolicitud.getlSolicitud();
        for (Solicitud Solicitud : lSolicitud) {
            SolicitudAutorizacion sa = new SolicitudAutorizacion();
            sa.setMontolAutorizado(0);
            sa.setAutorizada("");
            sa.setSolicitud(Solicitud);
            lSolicitudAutorizacion.add(sa);
        }
        tmSolicitudAutorizacion.setlSolicitud(lSolicitudAutorizacion);
        tbAutorizacion.setModel(tmSolicitudAutorizacion);
        TableColumn tableColumn = tbAutorizacion.getColumnModel().getColumn(0);

        JComboBox cbtipoAsistencia;
        List list = new ArrayList<>();
        list.add("Autorizado");
        list.add("Rechazado");

        cbtipoAsistencia = new JComboBox(list.toArray());
        tableColumn.setCellEditor(new DefaultCellEditor(cbtipoAsistencia));

    }

    @Override
    public void save() {
        tmSolicitudAutorizacion.getlSolicitud();

        for (SolicitudAutorizacion sa : tmSolicitudAutorizacion.getlSolicitud()) {
            List<Cuota> lCuotas = new ArrayList<>();
            if ("Autorizado".equals(sa.getAutorizada())) {
                
                System.out.println(".:"+sa.getMontolAutorizado());
                System.out.println("..:");
                double coutas = calcularCouta(sa.getMontolAutorizado(), Math.round(sa.getSolicitud().getTasaInteres()), sa.getSolicitud().getTiempo(), sa.getSolicitud().getTiempo2(), sa.getSolicitud().getCuotas());
                System.out.println("pagos.:");
                Cuota cuota = new Cuota();
                cuota.setCapital(Double.parseDouble(String.valueOf(sa.getMontolAutorizado())));
                cuota.setInteres(0.0);
                cuota.setCapitalPagado(0.0);
                cuota.setNoCuota(0);
                cuota.setPagoPeriodicol(coutas);
                Double capital = Double.parseDouble(String.valueOf(sa.getMontolAutorizado())) + Double.parseDouble(String.valueOf(sa.getMontolAutorizado()))* sa.getSolicitud().getTasaInteres() ;
                double interes;
                double capitalPagado;
                double pagosPeriodico = coutas;
                lCuotas.add(cuota);
                
                System.out.println("sa.."+sa.getSolicitud().getCuotas());
                for (int i = 1; i < sa.getSolicitud().getCuotas() + 1; i++) {
                    cuota = new Cuota();
                    interes = capital * 0.05;
                    capitalPagado = pagosPeriodico - interes;
                    capital = capital - capitalPagado;
                    cuota.setCapital(capital);
                    cuota.setInteres(interes);
                    cuota.setCapitalPagado(capitalPagado);
                    cuota.setNoCuota(i);
                    cuota.setPagoPeriodicol(coutas);
                    lCuotas.add(cuota);
                    System.out.println("couta.:"+cuota);
                }
                sa.setlCuotas(lCuotas);
                SolicitudAutorizadaController sac = new SolicitudAutorizadaController();
              
                sac.save(sa);

            }

        }

    }

    @Override
    public void update() {
        ///
    }

    @Override
    public void newObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<JButton> getButtons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeAccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onSelectedValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Double calcularCouta(int monto, int tasa, int tiempo, String frecuencia, int cuotas) {
        Double coutas = 0.0;
        Double potencia;
        System.out.println("f.:"+frecuencia);
        
        switch (frecuencia) {
            case "Dia":
                potencia = Math.pow((1 + tasa), (tiempo * (-1)));
                coutas = monto * ((tasa) / (1 - potencia));

                System.out.println("couta...." + coutas);
                break;
            case "Meses":
                tasa = tasa / 12;
                potencia = Math.pow((1 + tasa), (tiempo * 12 * (-1)));
                coutas = monto * ((tasa) / (1 - potencia));
                System.out.println("couta...." + coutas);
                break;

            case "Anos":
                potencia = Math.pow((1 + tasa), (tiempo * 1 * (-1)));
                coutas = monto * ((tasa) / (1 - potencia));
                System.out.println("cou...." + coutas);
                break;

        }

        return coutas;
    }
}
