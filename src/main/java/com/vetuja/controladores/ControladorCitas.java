/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetuja.controladores;

import com.vetuja.DAO.CitaDAO;
import com.vetuja.clases.Citas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author juanc
 */
@Named("ctrlCitas")
@ViewScoped
public class ControladorCitas implements Serializable {

    @Inject
    private CitaDAO citasDAO;

    //View-Model
    private Citas cita;
    private Integer id;

    public ControladorCitas() {

    }

    @PostConstruct
    private void init() {
        cita = new Citas();
        id = 0;
    }

    public Citas getCita() {
        return cita;
    }

    public Citas getCita(int id) {
        return citasDAO.buscaId(id);
    }

    public void setCita(Citas cita) {
        this.cita = cita;
    }

    public List<Citas> getCitas() {
        return citasDAO.buscaTodos();
    }
    
    public List<Citas> getCitasCliente(String DNI) {
        return citasDAO.busca(DNI);
    }

    public void recupera() {
        cita = citasDAO.buscaId((cita.getId()));
    }

    public String borra(Citas c) {
        if (citasDAO.borra(c.getId())) {
            return "citas.xhtml?faces-redirect=true";
        } else {
            return "inicio.xhtml?faces-redirect=true";
        }
    }

    public String creaCita() {
        if (citasDAO.crea(cita)) {
            return "citas.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
