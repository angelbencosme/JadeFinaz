/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.tablesModel;

import com.compani.finaz.Entitys.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ClienteTableModel extends AbstractTableModel {

    private List<Cliente> lCliente;

    public List<Cliente> getlCliente() {
        return lCliente;
    }

    public void setlCliente(List<Cliente> lCliente) {
        this.lCliente = lCliente;
    }

    public Cliente getCliente(int row) {
        return lCliente.get(row);
    }

    @Override
    public int getRowCount() {
        return lCliente.size();
//        return 10;
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return 4;
    }

    /**
     *
     * @param row
     * @param colum
     * @return
     */
    @Override
    public Object getValueAt(int row, int colum) {
        Cliente cli = lCliente.get(row);
        switch (colum) {
            case 0:
                return cli.getIdentificacion();
            case 1:
                return cli.getNombre() +" "+  cli.getApellido();
            case 2:
                return cli.getLimite();
            case 3:
                return cli.getOcupacion();
            default:
                return "";

        }
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
