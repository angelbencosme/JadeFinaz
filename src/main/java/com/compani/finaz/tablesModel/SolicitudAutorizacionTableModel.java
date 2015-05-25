/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.tablesModel;

import com.compani.finaz.Entitys.SolicitudAutorizacion;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class SolicitudAutorizacionTableModel extends AbstractTableModel {

    private List<SolicitudAutorizacion> lSolicitud;

    @Override
    public int getRowCount() {
        return lSolicitud.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }
    public SolicitudAutorizacion getSolicitudAutorizacion(int row){
    return lSolicitud.get(row);
    
    }

    @Override
    public Object getValueAt(int row, int colum) {
        SolicitudAutorizacion aSolicitud = lSolicitud.get(row);
        switch (colum) {
            case 0:
                return aSolicitud.getAutorizada();
            case 1:
                return aSolicitud.getSolicitud().getCliente().getNombre() + " " + aSolicitud.getSolicitud().getCliente().getApellido();
            case 2:
                return aSolicitud.getSolicitud().getCliente().getEmpresa() + " " + aSolicitud.getSolicitud().getCliente().getCargo();
            case 3:
                return aSolicitud.getSolicitud().getCliente().getIngreso();
            case 4:
                return aSolicitud.getSolicitud().getCliente().getFechaIngreso();
            case 5:
                return aSolicitud.getSolicitud().getMonto();
            case 6:
                return aSolicitud.getMontolAutorizado();
            case 7:
                return aSolicitud.getSolicitud().getModalidadPago();
            default:
                return "";
        }
    }
        @Override
    public boolean isCellEditable(int row, int colum) {
        switch(colum){
            case 0:
                return true;
            case 6:
                return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object value, int row, int colum) {
        SolicitudAutorizacion aSolicitud = lSolicitud.get(row);
        switch(colum){
            case 0:
                aSolicitud.setAutorizada(value.toString());
                break;
            case 6:
             aSolicitud.setMontolAutorizado(Integer.parseInt( value.toString()));
            break;
        
        
        }
    }
    

    @Override
    public String getColumnName(int colum) {
        switch (colum) {
            case 0 :
                return "Autorizacion";
            case 1:
                return "Cliente";
            case 2:
                return "Empleo";
            case 3:
                return "Ingreso";
            case 4:
                return "Fecha de Ingreso";
            case 5:
                return "Monto Solicitado";
            case 6:
                return "Monto Autorizado";
            case 7:
                return "Modalidad de pago";
            default:
                return "";

        }
    }


    public List<SolicitudAutorizacion> getlSolicitud() {
        return lSolicitud;
    }

    public void setlSolicitud(List<SolicitudAutorizacion> lSolicitud) {
        this.lSolicitud = lSolicitud;
    }

}
