/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.tablesModel;

import com.compani.finaz.Entitys.Solicitud;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class SolicitudTableModel extends AbstractTableModel {

    private List<Solicitud> lSolicitud;

    @Override
    public int getRowCount() {
      return lSolicitud.size();
    }
     public Solicitud getSolicitud(int row) {
        return lSolicitud.get(row);
    }


    @Override
    public int getColumnCount() {
       return 8;
    }

    @Override
    public Object getValueAt(int row, int colum) {
        Solicitud soli = lSolicitud.get(row);
        switch (colum) {
            case 0:
                return soli.getNoSolicitud();
            case 1:
                return soli.getCliente().getNombre() + " " + soli.getCliente().getApellido();
            case 2:
                return soli.getMonto();
            case 3:
                return soli.getMetodoAmortizacion();
            case 4:
                return soli.getTasaInteres();
            case 5:
                return soli.getModalidadPago();

            case 6:
                return soli.getTiempo();
            case 7:
                return soli.getTipoPrestamo();
            default:
                return "";

        }
    }

    @Override
    public String getColumnName(int colum) {
        switch (colum) {
            case 0:
                return "No";
            case 1:
                return "Cliente";
            case 2:
                return "Importe";
            case 3:
                return "Metodo de Amortizacion";
            case 4:
                return "Tasa";
            case 5:
                return "Pagos";
            case 6:
                return "Timpo";
            case 7:
                return "Tipo Prestamos";
            default:
                return "";

        }
    }

    public List<Solicitud> getlSolicitud() {
        return lSolicitud;
    }

    public void setlSolicitud(List<Solicitud> lSolicitud) {
        this.lSolicitud = lSolicitud;
    }

}
