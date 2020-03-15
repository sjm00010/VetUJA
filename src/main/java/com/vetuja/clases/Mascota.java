/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetuja.clases;

import java.util.Date;
import java.util.logging.Logger;
/**
 *
 * @author dgl00018
 */
    public class Mascota {
    private String ci;
    private String nombre;
    private String raza;
    private String sexo;
    private Date fechanac;
    private static final Logger logger = Logger.getLogger(Mascota.class.getName());

   public Mascota() {
    ci="1254125";
    nombre="Rufo";
    raza="BDF";
    sexo="M";
    fechanac= null;
}
    
/**
 * @param ci Codigo de idenficicacion de la mascota
 * @param nombre Nombre de la mascota
 * @param raza Raza del animal
 * @param sexo Sexo de la mascota
 * @param fechanac Fecha nacimiento de la mascota
*/
    public Mascota(String ci,String nombre,String raza,String sexo, Date fechanac){
this.ci = ci;
this.nombre = nombre;
this.raza = raza;
this.sexo = sexo;
this.fechanac = fechanac;

}

    /**
     * @return El codigo identificacion
     */
    public String getCi() {
        return ci;
    }

/**
     * @param DNI El codigo identificacion a cambiar
     */
    public void setCi(String ci) {
        this.ci = ci;
    }

/**
     * @return El nombre
     */
    public String getNombre() {
        return nombre;
    }

/**
     * @param nombre El nombre a cambiar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  /**
     * @return La raza
     */
    public String getRaza() {
        return raza;
    }

 /**
     * @param raza La raza a cambiar
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

  /**
     * @return El sexo
     */
    public String getSexo() {
        return sexo;
    }


 /**
     * @param sexo El sexo a cambiar
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


 /**
     * @return La fecha de nacimiento
     */
    public Date getFechanac() {
        return fechanac;
    }

/**
     * @param fnac La fecha de nacimiento a cambiar
     */
    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

}