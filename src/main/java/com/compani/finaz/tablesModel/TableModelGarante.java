/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.tablesModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModelGarante extends AbstractTableModel{
    List<Object> lObject = new ArrayList<>();
    


    public Object getGarante(int row) {
        return lObject.get(row);
    }

    /**
     *
     * @param lObject
     */
    public void setlObject(List<Object> lObject) {
        this.lObject = lObject;
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        @Override
    public String getColumnName(int colum) {
        switch (colum) {
            case 0:
                return "Identificacion";
            case 1:
                return "Nombre";
            case 2:
                return "Limite";
            case 3:
                return "Ocupacion";
            default:
                return "";
        }

    }
    
}
