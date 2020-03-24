package com.vetuja.controladores;

import com.vetuja.clases.Cliente;
import com.vetuja.clases.Veterinario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sjm00010
 */
@Named(value="prefs")
@SessionScoped
public class Preferencias implements Serializable{
    // Variables
    private Cliente cli;
    private Veterinario vet;
    
    public Preferencias() {
        this.cli = null;
        this.vet = null;
    }

    public Preferencias(Cliente cli, Veterinario vet) {
        this.cli = cli;
        this.vet = vet;
    }

    /**
     * @return the cli
     */
    public Cliente getCli() {
        return cli;
    }

    /**
     * @param cli the cli to set
     */
    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    /**
     * @return the vet
     */
    public Veterinario getVet() {
        return vet;
    }

    /**
     * @param vet the vet to set
     */
    public void setVet(Veterinario vet) {
        this.vet = vet;
    }

    
}
