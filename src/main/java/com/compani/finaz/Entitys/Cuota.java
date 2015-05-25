/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Entitys;


public class Cuota {
    private Integer id;
    private Integer noCuota;
    private Double capital;
    private Double interes;
    private Double pagoPeriodicol;
    private Double capitalPagado;
    private SolicitudAutorizacion aSolicitud;
    private String pago;

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    

    public SolicitudAutorizacion getaSolicitud() {
        return aSolicitud;
    }

    public void setaSolicitud(SolicitudAutorizacion aSolicitud) {
        this.aSolicitud = aSolicitud;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoCuota() {
        return noCuota;
    }

    public void setNoCuota(Integer noCuota) {
        this.noCuota = noCuota;
    }

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Double getPagoPeriodicol() {
        return pagoPeriodicol;
    }

    public void setPagoPeriodicol(Double pagoPeriodicol) {
        this.pagoPeriodicol = pagoPeriodicol;
    }

    public Double getCapitalPagado() {
        return capitalPagado;
    }

    public void setCapitalPagado(Double capitalPagado) {
        this.capitalPagado = capitalPagado;
    }

    @Override
    public String toString() {
        return "Cuota{" + "id=" + id + ", noCuota=" + noCuota + ", capital=" + capital + ", interes=" + interes + ", pagoPeriodicol=" + pagoPeriodicol + ", capitalPagado=" + capitalPagado + ", aSolicitud=" + aSolicitud + ", pago=" + pago + '}';
    }
    
            
    
    
    
}
