/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetuja.clases;

import java.util.Date;

/**
 *
 * @author juanc
 */
public class Citas {
    private Integer id;
    private String fecha;
    private String hora;
    private String nombreVet;
    private String nombreMascota;
    
    
public Citas() {
    id = 0;
    fecha = "";
    hora = "";
    nombreVet = "";
    nombreMascota = "";
}

public Citas(Integer id,String fecha, String hora, String nombreVet, String nombreMascota) {
    this.id = id;
    this.fecha = fecha;
    this.hora = hora;
    this.nombreMascota = nombreMascota;
    this.nombreVet = nombreVet;
}

    public Citas(Citas c) {
    this.id = c.id;
    this.fecha = c.fecha;
    this.hora = c.hora;
    this.nombreMascota = c.nombreMascota;
    this.nombreVet = c.nombreVet;
    }

  /**
     * @return El id de la cita
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id El id a poner
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return La fecha de la cita
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha La fecha de la cita a poner
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return La hora de la cita
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora La hora de la cita a poner
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return El nombre del veterinario con el que tendremos la cita
     */
    public String getNombreVet() {
        return nombreVet;
    }

    /**
     * @param nombreVet El nombre del veterinario a poner
     */
    public void setNombreVet(String nombreVet) {
        this.nombreVet = nombreVet;
    }

    /**
     * @return El nombre de la mascota que tendrá la cita
     */
    public String getNombreMascota() {
        return nombreMascota;
    }

    /**
     * @param nombreMascota El nombre de la mascota a poner
     */
    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }
}

