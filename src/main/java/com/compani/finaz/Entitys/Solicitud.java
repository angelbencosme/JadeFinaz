/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.compani.finaz.Entitys;

import com.compani.finaz.Entitys.garante.Garante;
import com.compani.finaz.Entitys.garante.Hipoteca;
import com.compani.finaz.Entitys.garante.Persona;
import com.compani.finaz.Entitys.garante.Vehiculo;
import java.util.Date;
import java.util.List;


public class Solicitud {
    
    private Integer codigo;
    private String noSolicitud;
    private Integer monto;
    private String metodoAmortizacion;
    private Float tasaInteres;
    private String modalidadPago;
    private Integer tiempo;
    private String tipoPrestamo;
    private Integer cuotas;
    private Date fecha;
    private boolean prioridad;
    private Cliente cliente;
    private boolean autorizado;
    private List<Garante> lGarante;
    private List<Persona> lPersona;
    private List<Vehiculo> lVehiculo;
    private List<Hipoteca> lHipoteca;
    private String tiempo2;

    public String getTiempo2() {
        return tiempo2;
    }

    public void setTiempo2(String tiempo2) {
        this.tiempo2 = tiempo2;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getMetodoAmortizacion() {
        return metodoAmortizacion;
    }

    public void setMetodoAmortizacion(String metodoAmortizacion) {
        this.metodoAmortizacion = metodoAmortizacion;
    }

    public Float getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(Float tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public String getModalidadPago() {
        return modalidadPago;
    }

    public void setModalidadPago(String modalidadPago) {
        this.modalidadPago = modalidadPago;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNoSolicitud() {
        return noSolicitud;
    }

    public void setNoSolicitud(String noSolicitud) {
        this.noSolicitud = noSolicitud;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    public List<Garante> getlGarante() {
        return lGarante;
    }

    public void setlGarante(List<Garante> lGarante) {
        this.lGarante = lGarante;
    }

    public List<Persona> getlPersona() {
        return lPersona;
    }

    public void setlPersona(List<Persona> lPersona) {
        this.lPersona = lPersona;
    }

    public List<Vehiculo> getlVehiculo() {
        return lVehiculo;
    }

    public void setlVehiculo(List<Vehiculo> lVehiculo) {
        this.lVehiculo = lVehiculo;
    }

    public List<Hipoteca> getlHipoteca() {
        return lHipoteca;
    }

    public void setlHipoteca(List<Hipoteca> lHipoteca) {
        this.lHipoteca = lHipoteca;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "codigo=" + codigo + ", noSolicitud=" + noSolicitud + ", monto=" + monto + ", metodoAmortizacion=" + metodoAmortizacion + ", tasaInteres=" + tasaInteres + ", modalidadPago=" + modalidadPago + ", tiempo=" + tiempo + ", tipoPrestamo=" + tipoPrestamo + ", cuotas=" + cuotas + ", fecha=" + fecha + ", prioridad=" + prioridad + ", cliente=" + cliente + ", autorizado=" + autorizado + ", lGarante=" + lGarante + ", lPersona=" + lPersona + ", lVehiculo=" + lVehiculo + ", lHipoteca=" + lHipoteca + '}';
    }


    
    
}
