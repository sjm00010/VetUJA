/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vetuja.controladores;

import com.vetuja.DAO.MascotaDAO;
import com.vetuja.clases.Mascota;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author dgl00018
 */
@Named("ctrlMascotas")
@ViewScoped
public class ControladorMascota implements Serializable{
@Inject
    private MascotaDAO mascotasDAO;

    //View-Model
    private Mascota mascota;

    public ControladorMascota() {
    }

    @PostConstruct
    private void init() {
        mascota = new Mascota();
    }

    public Mascota getMascota() {
        return mascota;
    }
    public Mascota getMascota(String ci) {
        return mascotasDAO.buscaId(ci);
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public List<Mascota> getMascotas() {
        return mascotasDAO.buscaTodos();
    }

    public void recupera() {
        mascota = mascotasDAO.buscaId(mascota.getCi());
    }
}
