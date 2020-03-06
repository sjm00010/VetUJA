package com.vetuja.controladores;

import com.vetuja.DAO.ClienteDAO;
import com.vetuja.DAO.VeterinarioDAO;
import com.vetuja.clases.Cliente;
import com.vetuja.clases.Veterinario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sjm00010
 */
@Named("ctrlClientes")
@ViewScoped
public class ControladorCliente implements Serializable {

    @Inject
    private ClienteDAO clientesDAO;
    
    @Inject
    private VeterinarioDAO veterinariosDAO;

    //View-Model
    private Cliente cliente;
    private Veterinario veterinario;
    private String user;
    private String pass;

    public ControladorCliente() {
    }

    @PostConstruct
    private void init() {
        cliente = new Cliente();
        veterinario = new Veterinario();
        user = null;
        pass = null;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public Cliente getCliente(String dni) {
        return clientesDAO.buscaId(dni);
    }

    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientesDAO.buscaTodos();
    }

    public void recupera() {
        cliente = clientesDAO.buscaId(cliente.getDNI());
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

    public void recuperaVet() {
        veterinario = veterinariosDAO.buscaId(veterinario.getCodCol());
    }
    
    public String login(){
        if(user != null && pass != null){
            if(user.length() > 6) { // La longitud del codCol es de 6
                Cliente comprueba = clientesDAO.buscaUser(cliente.getUser());
                if(comprueba != null){
                    if(pass.equals(comprueba.getPass()) && comprueba != null){
                        cliente = comprueba;
                        return "/user/inicio.jsf";
                    }
                }
            }else{
                Veterinario comprueba = veterinariosDAO.buscaUser(veterinario.getUser());
                if(comprueba != null){
                    if(pass.equals(comprueba.getPass())){
                        veterinario = comprueba;
                        return "/admin/inicio.jsf";
                    }
                }
            }
        }
        return "/inicio/login.jsf";
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}
