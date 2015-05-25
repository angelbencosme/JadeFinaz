/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.tablesModel;

import com.compani.finaz.Entitys.garante.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class VehiculoGaranteTableModel extends AbstractTableModel {

    private List<Vehiculo> lVehiculo;
    
    public void addVehiculo(Vehiculo veh){
    lVehiculo.add(veh);
    fireTableDataChanged();
    }

    public VehiculoGaranteTableModel() {
        this.lVehiculo = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lVehiculo.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int colum) {
        Vehiculo veh = lVehiculo.get(row);
        switch (colum) {
            case 0:
                return veh.getChasis();
            case 1:
                return veh.getTipo();
            case 2:
                return veh.getValoracion();
            default:
                return "";
              

        }

    }

    public List<Vehiculo> getlVehiculo() {
        return lVehiculo;
    }

    public void setlVehiculo(List<Vehiculo> lVehiculo) {
        this.lVehiculo = lVehiculo;
    }

    @Override
    public String getColumnName(int colum) {
        switch (colum) {
            case 0:
                return "Chasis";
            case 1:
                return "Tipo";
            case 2:
                return "Valoracion";
            default:
                return "";
        }
    }

}
