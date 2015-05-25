/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.tablesModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModelComGarante extends AbstractTableModel {

    private List<String> lGarante;

    

    @Override
    public int getRowCount() {
      return lGarante.size();
    }

    @Override
    public int getColumnCount() {
     return 3;
    }

      /**
     *
     * @param row
     * @param colum
     * @return
     */
    @Override
    public Object getValueAt(int row, int colum) {

        
        switch (colum) {
            case 0:
                return "Tipo";
            case 1:
                return "Identificador";
            case 2:
                return "v";
            case 3:
                return "";
            default:
                return "";

        }
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        super.setValueAt(o, i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> getlGarante() {
        return lGarante;
    }

    public void setlGarante(List<String> lGarante) {
        this.lGarante = lGarante;
    }
    
    
 
  

}
