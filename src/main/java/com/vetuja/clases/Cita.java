/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetuja.clases;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author juanc
 */
@Entity
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental
    private Integer id;

    @Future(message = "La fecha debe ser posterior a hoy.")
    @NotNull(message = "La fecha no puede estar vacía.")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @NotEmpty(message = "La hora no puede estar vacía.")
    private String hora;

    @Pattern(regexp = "\\d{8}[A-Z]", message = "DNI incorrecto, debe tener 8 números y la letra debe estar en mayúscula.")
    @NotNull(message = "Se debe seleccionar un cliente")
    private String cliDNI;

    @Pattern(regexp = "[A-Z]{2}[0-9]{4}", message = "Código de colegiado incorrecto, debe tener 2 letras y 4 números. Ej. AA1111")
    @NotNull(message = "Se debe seleccionar un veterinario")
    private String vetCC;

    @Pattern(regexp = "\\d{15}", message = "Código identificación incorrecto, debe tener 15 números.")
    @NotNull(message = "Se debe seleccionar una mascota")
    private String masCI;

    public Cita() {
        id = 0;
        fecha = null;
        hora = "";
        cliDNI = "";
        vetCC = "";
        masCI = "";
    }

    public Cita(Integer id, Date fecha, String hora, String cliDNI, String vetCC, String masCI) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.cliDNI = cliDNI;
        this.vetCC = vetCC;
        this.masCI = masCI;
    }

    public Cita(Cita c) {
        this.id = c.id;
        this.fecha = c.fecha;
        this.hora = c.hora;
        this.cliDNI = c.cliDNI;
        this.vetCC = c.vetCC;
        this.masCI = c.masCI;
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
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha La fecha de la cita a poner
     */
    public void setFecha(Date fecha) {
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

    public String leerFecha() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(this.fecha);
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
     * @return the masCI
     */
    public String getMasCI() {
        return masCI;
    }

    /**
     * @param masCI the masCI to set
     */
    public void setMasCI(String masCI) {
        this.masCI = masCI;
    }
}
