/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.tablesModel;

import com.compani.finaz.Entitys.Cliente;
import com.compani.finaz.Entitys.garante.Persona;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PersonaGaranteTableModel extends AbstractTableModel{
    private List<Persona> lPersona;
    
    public void addCliente(Persona per){
    lPersona.add(per);   
    fireTableDataChanged();
    }
    
    

    @Override
    public int getRowCount() {
       return lPersona.size();
    }
    public Persona getPersona(int row) {
        return lPersona.get(row);
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
    public String getValueAt(int row, int colum) {
        Persona persona = lPersona.get(row);
        switch (colum) {
            case 0:
                return persona.getIndentificacion();                
            case 1:
                return persona.getNombre() + " " + persona.getApellido() ;
            case 2:
                return persona.getIngreso();
            default:
                return "";

        }
    }

    public List<Persona> getlCliente() {
        return lPersona;
    }

    public void setlCliente(List<Persona> lPersona) {
        this.lPersona = lPersona;
    }
       @Override
    public String getColumnName(int colum) {
        switch (colum) {
            case 0:
                return "Identificacion";
            case 1:
                return "Nombre";
            case 2:
                return "Ingreso";
            default:
                return "";
        }

    }
}
