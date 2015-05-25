/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.tablesModel;

import com.compani.finaz.Entitys.garante.Hipoteca;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class HipotecaGaranteTableModelo extends AbstractTableModel{
    private List<Hipoteca> lHipoteca;
    
    
     public void addHipoteca(Hipoteca hip){
    lHipoteca.add(hip);
    fireTableDataChanged();    
    }
    @Override
    public int getRowCount() {
        return lHipoteca.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    public Hipoteca getHipoteca(int row){
        return lHipoteca.get(row);    
    
    }

    @Override
    public Object getValueAt(int row, int  colum) {
        Hipoteca hep = lHipoteca.get(row);
        switch(colum){
            case 0:
                return hep.getNumeroExp();
            case 1:
                return hep.getValoracion();
            case 2:
                return hep.getDescripcion();
            default:
                return "";
                  
        
        }
        
    }

    public List<Hipoteca> getlHipoteca() {
        return lHipoteca;
    }

    public void setlHipoteca(List<Hipoteca> lHipotecas) {
        this.lHipoteca = lHipotecas;
    }

    @Override
    public String getColumnName(int colum) {
        switch(colum){
            case 0:
                return "Noº expediente";
            case 1:
                return "Valoracion";
            case 2:
                return "Descripcion";
            default:
                return"";
        
        
        }
    }
   
    
    
}
