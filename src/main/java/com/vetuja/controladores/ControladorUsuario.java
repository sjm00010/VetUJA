package com.vetuja.controladores;

import com.vetuja.DAO.ClienteDAO;
import com.vetuja.DAO.VeterinarioDAO;
import com.vetuja.clases.Cliente;
import com.vetuja.clases.Veterinario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped; // Netbeans recomienda que sea este
import javax.faces.validator.Validator;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.AssertFalse;

/**
 *
 * @author sjm00010
 */
@Named("ctrlUser")
@ApplicationScoped // Para que los datos se amntengan mientras la aplicación este iniciada
public class ControladorUsuario implements Serializable {

    @Inject
    private ClienteDAO clientesDAO;

    @Inject
    private VeterinarioDAO veterinariosDAO;

    //View-Model
    private Cliente cliente;
    private Veterinario veterinario;
    private String user; // Una vez logeado guarda el nombre
    private String pass; // Una vez logeado guarda la foto

    public ControladorUsuario() {
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

    public String login() {
        @AssertFalse(message = "Los datos introducidos son incorrectos.")
        boolean error = false;
        System.out.println(user);
        System.out.println(pass);
        if (user != null && pass != null) {
            Cliente comprueba = clientesDAO.buscaUser(user);
            if (comprueba != null) {
                if (pass.equals(comprueba.getPass())) {
                    cliente = comprueba;
                    user = cliente.getNombre();
                    pass = cliente.getFoto();
                    return "/user/inicio.jsf?faces-redirect=true";
                }
            } else {
                Veterinario comprueba2 = veterinariosDAO.buscaUser(user);
                if (comprueba2 != null) {
                    if (pass.equals(comprueba2.getPass())) {
                        veterinario = comprueba2;
                        user = veterinario.getNombre();
                        pass = veterinario.getFoto();
                        return "/admin/inicio.jsf?faces-redirect=true";
                    }
                }
            }
        }
        error = true;
        return null;
    }

    public String logout() {
        user = null;
        pass = null;
        return "/inicio/inicio.jsf?faces-redirect=true";
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
