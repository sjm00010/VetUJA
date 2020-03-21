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
    private String user; // Una vez logeado guarda el nombre
    private String pass; // Una vez logeado guarda la foto
    private String dni;

    public ControladorUsuario() {
    }

    @PostConstruct
    private void init() {
        cliente = new Cliente();
        veterinario = new Veterinario();
        user = null;
        pass = null;
        dni = null;
    }

    /**
     * Funcion auxiliar para asignar un dni al usurio actual
     */
    public void setDNIact(){
        dni = clientesDAO.buscaUser("algarcia").getDNI();
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
    }
    
    /**
     * Función para obtener los datos para el detalle de las mascotas
     */
    public void recuperaAll() {
        cliente = clientesDAO.buscaId(cliente.getDNI());
        veterinario = veterinariosDAO.buscaId(veterinario.getCodCol());
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

    public String creaCliente(){
        if (cliente.getPass().equals(pass)) {
            if (clientesDAO.crea(cliente)) {
                return "/inicio/inicio.jsf?faces-redirect=true";
            }
        }
        return null;
    }

    public String modificaCliente() throws ParseException {    
        if (!clientesDAO.guarda(cliente)) {
            clientesDAO.crea(cliente);
            clientesDAO.borra(dni);
            mascotasDAO.cambiaDNI(dni, cliente.getDNI());
            citasDAO.cambiaDNI(dni, cliente.getDNI());
        }
        return "/admin/clientes.xhtml?faces-redirect=true";
    }

    public String borraCliente(String id) {
        clientesDAO.borra(id);
        return null;
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

    public String getNombreCli(String DNI){
        Cliente cli = clientesDAO.buscaId(DNI);
        return cli.getNombre();
    }
    
    public String getNombreVet(String CC){
        Veterinario vet = veterinariosDAO.buscaId(CC);
        return vet.getNombre();
    }
}
