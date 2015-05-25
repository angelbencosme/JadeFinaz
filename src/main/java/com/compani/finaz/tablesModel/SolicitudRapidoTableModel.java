/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.tablesModel;

import com.compani.finaz.Entitys.Solicitud;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class SolicitudRapidoTableModel extends AbstractTableModel {
    List<Solicitud> lSolicitud = new ArrayList<>();

    @Override
    public int getRowCount() {
        return lSolicitud.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int colum) {
        Solicitud solicitud = lSolicitud.get(row);
        switch(colum){
            case 0:
                return solicitud.getNoSolicitud();
            case 1:
                return solicitud.getCliente().getNombre() + " " + solicitud.getCliente().getApellido();
            case 2:
                return solicitud.getMonto();
            case 3:
                return solicitud.getTiempo();
            case 4:
                return solicitud.isAutorizado();
            default:
                return "";
        
        
        }
    }

    @Override
    public String getColumnName(int colum) {
        switch(colum){
            case 0 :
                return "Noº";
            case 1:
                return "Cliente";
            case 2:
                return "Monto";
            case 3:
                return "Tiempo";
            case 4:
                return "Autorizado";
             default:
                 return "";
                        
        
        }
    }
    
    
}
