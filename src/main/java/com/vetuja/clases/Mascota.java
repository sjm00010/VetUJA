/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetuja.clases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

/**
 *
 * @author dgl00018
 */
public class Mascota {

    @Pattern(regexp = "\\d{15}", message = "Código identificación incorrecto, debe tener 15 números.")
    private String ci;

    @Size(min = 3, max = 12, message = "El nombre debe tener una longitud entre {min} y {max} caracteres.")
    private String nombre;

    @Size(min = 2, max = 12, message = "La raza debe tener una longitud entre {min} y {max} caracteres.")
    private String raza;
    
    @Size(min = 2, max = 12, message = "La especie debe tener una longitud entre {min} y {max} caracteres.")
    private String especie;

    @Pattern(regexp = "(Macho|Hembra)", message = "El sexo debe ser Macho o Hembra.")
    private String sexo;
    
    @Positive(message = "La altura tiene que ser mayor a 0 cm.")
    private Integer altura;
    
    @Positive(message = "El peso tiene que ser mayor a 0 g.")
    private Integer peso;
    
    @Past(message = "Tu mascota debe haber nacido, revisa la fecha de nacimiento.")
    @NotNull(message = "La fecha de nacimiento es requerida.")
    @Temporal(TemporalType.DATE)
    private Date fechanac;

    @NotEmpty(message = "Debe introducir una foto de la mascota")
    private String foto;
    
    @Pattern(regexp = "\\d{8}[A-Z]", message = "DNI incorrecto, debe tener 8 números y la letra debe estar en mayúscula.")
    @NotNull(message = "Se debe seleccionar un cliente.")
    private String cliDNI;
    
    @Pattern(regexp = "[A-Z]{2}[0-9]{4}", message = "Código de colegiado incorrecto, debe tener 2 letras y 4 números.")
    @NotNull(message = "Se debe seleccionar un veterinario.")
    private String vetCC;

    private static final Logger logger = Logger.getLogger(Mascota.class.getName());

    public Mascota() {
        ci = "";
        nombre = "";
        raza = "";
        especie = "";
        sexo = "";
        fechanac = null;
        foto = "";
        altura = null;
        peso = null;
    }

    /**
     * @param ci Código de identificación
     * @param nombre Nombre de la mascota
     * @param raza Raza de la mascota
     * @param especie Especie de la mascota
     * @param sexo Sexo de la mascota
     * @param altura Altura de la mascota
     * @param peso Peso de la mascota
     * @param fechanac Fecha de nacimiento
     * @param foto Foto de la mascota
     * @param cliDNI DNI del dueño
     * @param vetCC Códogo de colegiado del veterinario que lo registro
     */
    public Mascota(String ci, String nombre, String raza, String especie, String sexo, Integer altura, Integer peso, Date fechanac, String foto, String cliDNI, String vetCC) {
        this.ci = ci;
        this.nombre = nombre;
        this.raza = raza;
        this.especie = especie;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.fechanac = fechanac;
        this.foto = foto;
        this.cliDNI = cliDNI;
        this.vetCC = vetCC;
    }

    /**
     * @return El codigo identificacion
     */
    public String getCi() {
        return ci;
    }

    /**
     * @param ci El codigo identificacion a cambiar
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

    /**
     * @return the cliDNI
     */
    public String getCliDNI() {
        return cliDNI;
    }

    /**
     * @param cliDNI the cliDNI to set
     */
    public void setCliDNI(String cliDNI) {
        this.cliDNI = cliDNI;
    }

    /**
     * @return the vetCC
     */
    public String getVetCC() {
        return vetCC;
    }

    /**
     * @param vetCC the vetCC to set
     */
    public void setVetCC(String vetCC) {
        this.vetCC = vetCC;
    }

    /**
     * @return the altura
     */
    public Integer getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    /**
     * @return the peso
     */
    public Integer getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public String leerFecha(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(this.fechanac);
    }
}
