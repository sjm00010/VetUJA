/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetuja.controladores;

import com.vetuja.DAO.CitasDAO;
import com.vetuja.clases.Citas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
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
    private CitasDAO citasDAO;

    //View-Model
    private Citas cita;
    private Integer id;
    //private String prueba;

    public ControladorCitas() {

    }

    @PostConstruct
    private void init() {
        cita = new Citas();
        id = 0;
       // setPrueba("Des");
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

    public void recupera() {
        cita = citasDAO.buscaId((cita.getId()));
    }

    public String borra() {
        boolean registro = false;
        if (cita.getId() == this.getId()) {
            registro = citasDAO.borra(cita.getId());
        }
        if (registro) {
            return "";
        } else {
            return "/user/citas.xhtml?faces-redirect=true";
        }
    }

    public String creaCita() {
        boolean registro = false;
        if (cita.getId() == this.getId()) {

            registro = citasDAO.crea(cita);
        }
        if (registro) {
            return "/user/citas.xhtml?faces-redirect=true&user=" + cita.getId();
        } else {
            return "/user/registro_cita.xhtml?faces-redirect=true";
        }

    }

//    /**
//     * @return the prueba
//     */
//    public String getPrueba() {
//        return prueba;
//    }
//
//    /**
//     * @param prueba the prueba to set
//     */
//    public void setPrueba(String prueba) {
//        System.out.println(prueba);
//        this.prueba = prueba;
//    }

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
