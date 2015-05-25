/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.tablesModel;

import com.compani.finaz.Entitys.Cuota;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class CuotaTableModel extends AbstractTableModel {

    List<Cuota> lCuota = new ArrayList<>();
    Double monto = 0.0;
    int noCuota = 0;

    public int getNoCuota() {
        return noCuota;
    }

    public void setNoCuota(int noCuota) {
        this.noCuota = noCuota;
    }
    

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    public List<Cuota> getlCuota() {
        return lCuota;
    }

    public void setlCuota(List<Cuota> lCuota) {
        this.lCuota = lCuota;
    }

    @Override
    public int getRowCount() {
        return lCuota.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int colum) {
        Cuota couta = lCuota.get(row);
        switch (colum) {
            case 0:
                return couta.getNoCuota();
            case 1:
                return couta.getPago();
            case 2:
                return couta.getPagoPeriodicol();
            default:
                return "";

        }

    }

    @Override
    public void setValueAt(Object value, int row, int colum) {
        Cuota couta = lCuota.get(row);
        switch (colum) {
            case 1:
                
                couta.setPago((String)value);
                if("PAGO".equals((String)value)){
                monto = monto + couta.getPagoPeriodicol();
                noCuota = noCuota + 1;
                }
                break;

            default:

        }

    }

    @Override
    public boolean isCellEditable(int row, int colum) {
        switch (colum) {
            case 1:
                return true;
        }
        return false;
    }

    @Override
    public String getColumnName(int colum) {
        switch (colum) {
            case 0:
                return "No";
            case 1:
                return "Pagar";

            case 2:
                return "Pago Periodico";
            default:
                return "";

        }
    }

}
