/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetuja.clases;

import java.util.Date;
import java.util.logging.Logger;
import javax.validation.constraints.*;

/**
 *
 * @author dgl00018
 */
public class Mascota {

    @Pattern(regexp = "\\d{15}", message = "Código identificación incorrecto, debe tener 15 números")
    private String ci;

    @Size(min = 3, max = 12, message = "El nombre debe tener una longitud entre {min} y {max} caracteres.")
    private String nombre;

    @Size(min = 2, max = 12, message = "La raza debe tener una longitud entre {min} y {max} caracteres.")
    private String raza;

    @Pattern(regexp = "\\[MF]", message = "El sexo debe ser M(macho) o F(hembra)")
    private String sexo;
    private Date fechanac;

    @NotEmpty(message = "Debe introducir una foto de la mascota")
    private String foto;

    private static final Logger logger = Logger.getLogger(Mascota.class.getName());

    public Mascota() {
        ci = "1254125";
        nombre = "Rufo";
        raza = "BDF";
        sexo = "M";
        fechanac = null;
        foto = "img/mascotas/gato.jpg";
    }

    /**
     * @param ci Codigo de idenficicacion de la mascota
     * @param nombre Nombre de la mascota
     * @param raza Raza del animal
     * @param sexo Sexo de la mascota
     * @param fechanac Fecha nacimiento de la mascota
     * @param foto Nombre de la foto de usuario, dentro de la carpeta 'mascotas'
     */
    public Mascota(String ci, String nombre, String raza, String sexo, Date fechanac, String foto) {
        this.ci = ci;
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.fechanac = fechanac;
        this.foto = foto;
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

    /**
     * @return Nombre de la foto de mascota, dentro de la carpeta 'mascotas'
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto Nombre de la foto de mascota, dentro de la carpeta 'mascotas'
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }
}
