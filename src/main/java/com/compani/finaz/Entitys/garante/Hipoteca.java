/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.compani.finaz.Entitys.garante;

import com.compani.finaz.Entitys.Solicitud;


public class Hipoteca {
    private Integer id;
    private String numeroExp;
    private String tipo;
    private String codigo;
    private Integer valoracion;
    private String descripcion;
    private String tipoGarante;
    private Solicitud solicitud;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroExp() {
        return numeroExp;
    }

    public void setNumeroExp(String numeroExp) {
        this.numeroExp = numeroExp;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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


    
    
    
    
}
