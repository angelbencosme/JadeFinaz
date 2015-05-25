/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Views.menuInterfaces;

import java.util.List;
import javax.swing.JButton;

public interface MenuAccion {

    /**
     *
     */
    public void save();

    /**
     *
     */
    public void update();

    /**
     *
     */
    public void newObject();

    default public  void consulta(){
        
    }

    /**
     *
     * @return
     */
    public List<JButton> getButtons();

}
