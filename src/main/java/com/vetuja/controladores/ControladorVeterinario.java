package com.vetuja.controladores;

import com.vetuja.DAO.VeterinarioDAO;
import com.vetuja.clases.Veterinario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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
    private VeterinarioDAO veterinariosDAO;
    
    //View-Model
    private Veterinario veterinario;

    public ControladorVeterinario() {
    }
    
    @PostConstruct
    private void init() {
        veterinario = new Veterinario();
    }
    
    public Veterinario getVeterinario() {
        return veterinario;
    }
    
    public Veterinario getVeterinario(String id) {
        return veterinariosDAO.buscaId(id);
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinariosDAO.buscaTodos();
    }

    public void recupera() {
        veterinario = veterinariosDAO.buscaId(veterinario.getCodCol());
    }
    
}
