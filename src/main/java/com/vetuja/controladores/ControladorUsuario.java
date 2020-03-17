package com.vetuja.controladores;

import com.vetuja.DAO.ClienteDAO;
import com.vetuja.DAO.VeterinarioDAO;
import com.vetuja.clases.Cliente;
import com.vetuja.clases.Veterinario;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sjm00010
 */
@Named("ctrlUser")
@ViewScoped // Para que los datos se amntengan mientras la aplicación este iniciada
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
    private String fecha; // Fecha de nacimiento
    private String dni;
    private Integer id;

    public ControladorUsuario() {
    }

    @PostConstruct
    private void init() {
        cliente = new Cliente();
        veterinario = new Veterinario();
        user = null;
        pass = null;
        dni = null;
        setFecha(null);
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
        this.dni = cliente.getDNI();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        this.fecha = dateFormat.format(cliente.getFnac());
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
        return "/user/inicio.jsf?faces-redirect=true";
    }

    public String logout() {
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

    public String creaCliente() throws ParseException {
        if (cliente.getPass().equals(pass)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date fnac = sdf.parse(getFecha());
            cliente.setFnac(fnac);
            if (clientesDAO.crea(cliente)) {
                return "/inicio/inicio.jsf?faces-redirect=true";
            }

        }
        return null;
    }

    public String modificaCliente() throws ParseException {
        // Transformo la fecha para hacerla compatible
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date fnac = sdf.parse(this.fecha);
        cliente.setFnac(fnac);
        
        if (!cliente.getDNI().equals(dni) && clientesDAO.buscaId(cliente.getDNI()) != null) {
            clientesDAO.crea(cliente);
            clientesDAO.borra(dni);
        }else{
            clientesDAO.guarda(cliente);
        }
        return "/admin/clientes.xhtml?faces-redirect=true";

    }

    public String borraCliente(String id) {
        clientesDAO.borra(id);
        return null;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @param dni the dni to set
     */
    public void setDNI(String dni) {
        this.dni = dni;
    }

    /**
     * @return the DNI
     */
    public String getDNI() {
        return dni;
    }

}
