/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Entitys;

import java.util.List;
import java.util.Objects;

public class SolicitudAutorizacion {
    private Integer id;
    private List<Solicitud> lSolicitudes;
    private  String autorizada;
    private  Integer montolAutorizado;
    private Solicitud solicitud;
    private double coutas;
    List<Cuota> lCuotas;

    public List<Cuota> getlCuotas() {
        return lCuotas;
    }

    public void setlCuotas(List<Cuota> lCuotas) {
        this.lCuotas = lCuotas;
    }

 
    

    public double getCoutas() {
        return coutas;
    }

    public void setCoutas(double coutas) {
        this.coutas = coutas;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    

    public List<Solicitud> getlSolicitudes() {
        return lSolicitudes;
    }

    public void setlSolicitudes(List<Solicitud> lSolicitudes) {
        this.lSolicitudes = lSolicitudes;
    }

    public String getAutorizada() {
        return autorizada;
    }

    public void setAutorizada(String autorizada) {
        this.autorizada = autorizada;
    }


    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.lSolicitudes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SolicitudAutorizacion other = (SolicitudAutorizacion) obj;
        return Objects.equals(this.lSolicitudes, other.lSolicitudes);
    }

    public Integer getMontolAutorizado() {
        return montolAutorizado;
    }

    public void setMontolAutorizado(Integer montolAutorizado) {
        this.montolAutorizado = montolAutorizado;
    }

    @Override
    public String toString() {
        return "SolicitudAutorizacion{" + "lSolicitudes=" + lSolicitudes + ", autorizada=" + autorizada + ", montolAutorizado=" + montolAutorizado + '}';
    }


    
    
    
    
}
