package com.vetuja.controladores;

import com.vetuja.clases.Cliente;
import com.vetuja.clases.Veterinario;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sjm00010
 */
@Named(value="prefs")
@SessionScoped
public class Preferencias implements Serializable{
    
    private static final Logger logger = Logger.getLogger(Preferencias.class.getName());
    
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

    /**
     * Funcion para obtener la foto del usuario.
     * @return Foto
     */
    public String getFoto(){
        if (vet != null){
            return vet.getFoto();
        }else if(cli != null){
            return cli.getFoto();
        }
        return null;
    }
    
    /**
     * Funcion para obtener el nombre del usuario.
     * @return Nombre
     */
    public String getNombre(){
        if (vet != null){
            return vet.getNombre();
        }else if(cli != null){
            return cli.getNombre();
        }
        return null;
    }
    
    /**
     * Funcion para saber que tipo de usuario hay conectado.
     * @return Tipo de usuario USER, ADMIN, NULL(sin identificar)
     */
    public String isLogin(){
        if (vet != null){
//            logger.log(Level.INFO, "ADMIN");
            return "ADMIN";
        }else if(cli != null){
//            logger.log(Level.INFO, "USER");
            return "USER";
        }
//        logger.log(Level.INFO, "NULL");
        return null;
    }
    
}
