/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.compani.finaz.Entitys;

import java.io.FileInputStream;
import java.sql.Blob;
import java.util.Date;


public class Cliente {
    private Integer id;
    private String identificacion;
    //Datos Personales
    private String nombre;
    private String apellido;
    private String estadoCivil;
    private Date fechaNacimiento;
    private String sexo;
    private String telefono;
    private String celular;
    private String email;
    private String limite;
    private Date fechaReg;
    private String ocupacion;
    private String cuidad;
    private String dirrecion;
    //Datos Laborales
    private String empresa;
    private String cargo;
    private String departamento;
    private String jefe;
    private Date fechaIngreso;
    private String ingreso;
    private String cuidadTrabajo;
    private String telefonoTrabajo;
    private String dirrecionTrabajo;
    private boolean activo;
//    private FileInputStream imagen;
    private Blob imagen;

    private String historial;

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer codigo) {
        this.id = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return identificacion;
    }

    public void setCedula(String cedula) {
        this.identificacion = cedula;
    }
    
    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getLimite() {
        return limite;
    }

    public void setLimite(String limite) {
        this.limite = limite;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSupervisor() {
        return jefe;
    }

    public void setSupervisor(String supervisor) {
        this.jefe = supervisor;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public String getCuidadTrabajo() {
        return cuidadTrabajo;
    }

    public void setCuidadTrabajo(String cuidadTrabajo) {
        this.cuidadTrabajo = cuidadTrabajo;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }
    
    public String getDirrecionTrabajo() {
        return dirrecionTrabajo;
    }

    public void setDirrecionTrabajo(String dirrecionTrabajo) {
        this.dirrecionTrabajo = dirrecionTrabajo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", estadoCivil=" + estadoCivil + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", telefono=" + telefono + ", celular=" + celular + ", email=" + email + ", limite=" + limite + ", fechaReg=" + fechaReg + ", ocupacion=" + ocupacion + ", cuidad=" + cuidad + ", dirrecion=" + dirrecion + ", empresa=" + empresa + ", cargo=" + cargo + ", departamento=" + departamento + ", jefe=" + jefe + ", fechaIngreso=" + fechaIngreso + ", ingreso=" + ingreso + ", cuidadTrabajo=" + cuidadTrabajo + ", telefonoTrabajo=" + telefonoTrabajo + ", dirrecionTrabajo=" + dirrecionTrabajo + ", activo=" + activo + ", historial=" + historial + '}';
    }

    
    
    
}
