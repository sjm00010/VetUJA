package com.vetuja.controladores;

import com.vetuja.DAO.CitaDAO;
import com.vetuja.DAO.ClienteDAO;
import com.vetuja.DAO.MascotaDAO;
import com.vetuja.DAO.VeterinarioDAO;
import com.vetuja.clases.Cliente;
import com.vetuja.clases.Veterinario;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sjm00010
 */
@Named("ctrlUser")
@ViewScoped
public class ControladorUsuario implements Serializable {
    
    private static final Logger logger = Logger.getLogger(ControladorUsuario.class.getName());

    @Inject
    FacesContext fc;
    
    @Inject
    private ClienteDAO clientesDAO;

    @Inject
    private VeterinarioDAO veterinariosDAO;


    /*  Para cuando se modifiquen los identificadores hacer los cambios en las 
        clases que tienen referencias a clientes o veterinarios
     */
    @Inject
    private MascotaDAO mascotasDAO;

    @Inject
    private CitaDAO citasDAO;

    //View-Model
    private Cliente cliente;
    private Veterinario veterinario;
    private String aux;

    public ControladorUsuario() {
    }

    @PostConstruct
    private void init() {
        cliente = new Cliente();
        veterinario = new Veterinario();
        aux=null;
    }

    /****************************************
     *          Getters y Setters           * 
     ****************************************/
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
    
    /**
     * @return the aux
     */
    public String getAux() {
        return aux;
    }

    /**
     * @param aux the aux to set
     */
    public void setAux(String aux) {
        this.aux = aux;
    }

    public void recuperaVet() {
        veterinario = veterinariosDAO.buscaId(veterinario.getCodCol());
    }

    public String getNombreCli(String DNI) {
        Cliente cli = clientesDAO.buscaId(DNI);
        return cli.getNombre();
    }

    public String getNombreVet(String CC) {
        Veterinario vet = veterinariosDAO.buscaId(CC);
        return vet.getNombre();
    }

    public void recupera() {
        cliente = clientesDAO.buscaId(cliente.getDNI());
        this.aux = cliente.getDNI();
    }

    /**
     * Función para obtener los datos para el detalle de las mascotas
     */
    public void recuperaAll() {
        cliente = clientesDAO.buscaId(cliente.getDNI());
        veterinario = veterinariosDAO.buscaId(veterinario.getCodCol());
    }

    /****************************************
     *          Funciones CRUD              * 
     ****************************************/
    public String creaCliente() {
        if (cliente.getPass().equals(getAux())) {
            if (clientesDAO.crea(cliente)) {
                return "/inicio/inicio.jsf?faces-redirect=true";
            }
        }
        return null;
    }

    public String modificaCliente() throws ParseException {
        if (!clientesDAO.guarda(cliente)) {
            clientesDAO.crea(cliente);
            clientesDAO.borra(aux);
        }
        return "/admin/clientes.xhtml?faces-redirect=true";
    }

    public String borraCliente(String id) {
        clientesDAO.borra(id);
        citasDAO.borraCli(id);
        mascotasDAO.borraCli(id);
        return null;
    }
}
