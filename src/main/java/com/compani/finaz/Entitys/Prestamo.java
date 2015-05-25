/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Entitys;


public class Prestamo {
    
    private Solicitud solicitud;
    private String autorizacion;
    private int MontoAutorizado;

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public int getMontoAutorizado() {
        return MontoAutorizado;
    }

    public void setMontoAutorizado(int MontoAutorizado) {
        this.MontoAutorizado = MontoAutorizado;
    }
    
    
    
}
