/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.Entitys.garante;

import com.compani.finaz.Entitys.Solicitud;


public class Garante {

    private Integer id;
    private Solicitud solicitud;
    private Integer garanteID;
    private String tipoGarante;
    private Persona persona;
    private Hipoteca hipoteca;
    private Vehiculo vehiuclo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGaranteID() {
        return garanteID;
    }

    public void setGaranteID(Integer garanteID) {
        this.garanteID = garanteID;
    }

    public String getTipoGarante() {
        return tipoGarante;
    }

    public void setTipoGarante(String tipoGarante) {
        this.tipoGarante = tipoGarante;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Hipoteca getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(Hipoteca hipoteca) {
        this.hipoteca = hipoteca;
    }

    public Vehiculo getVehiuclo() {
        return vehiuclo;
    }

    public void setVehiuclo(Vehiculo vehiuclo) {
        this.vehiuclo = vehiuclo;
    }



}
