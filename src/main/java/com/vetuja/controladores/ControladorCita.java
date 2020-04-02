package com.vetuja.controladores;

import com.vetuja.DAO.CitaDAO;
import com.vetuja.clases.Cita;
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
public class ControladorCita implements Serializable {

    @Inject
    private CitaDAO citasDAO;

    //View-Model
    private Cita cita;
    private Integer id;

    public ControladorCita() {

    }

    @PostConstruct
    private void init() {
        cita = new Cita();
        id = 0;
    }

    public Cita getCita() {
        return cita;
    }

    public Cita getCita(int id) {
        return citasDAO.buscaId(id);
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public List<Cita> getCitas() {
        return citasDAO.buscaTodos();
    }
    
    public List<Cita> getCitasCliente(String DNI) {
        return citasDAO.buscaCitas(DNI);
    }

    public void recupera() {
        cita = citasDAO.buscaId((cita.getId()));
    }

    public String borra(Cita c) {
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
