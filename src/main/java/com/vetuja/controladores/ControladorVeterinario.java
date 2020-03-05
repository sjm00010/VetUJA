package com.vetuja.controladores;

import com.vetuja.DAO.VeterinarioDAO;
import com.vetuja.clases.Veterinario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sjm00010
 */
@Named("ctrlVet")
@ViewScoped
public class ControladorVeterinario implements Serializable{
    @Inject
    private VeterinarioDAO clientesDAO;

    //View-Model
    private Veterinario veterinario;

    public ControladorVeterinario() {
    }
    
    @PostConstruct
    private void init() {
        veterinario = new Veterinario();
    }

}
