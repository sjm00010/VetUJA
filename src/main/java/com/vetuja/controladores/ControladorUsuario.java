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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author sjm00010
 */
@Named("ctrlUser")
@ViewScoped // Para que los datos se amntengan mientras la aplicación este iniciada
public class ControladorUsuario implements Serializable {

    private static final Logger logger = Logger.getLogger(ControladorUsuario.class.getName());

    @Inject
    FacesContext fc;

    //SecurityContext and ExternalContext needed for programatic authentication
    @Inject
    SecurityContext sc;

    @Inject
    ExternalContext ec;

    @Inject
    HttpServletRequest request; //needed for logout

    @Inject
    private ClienteDAO clientesDAO;

    @Inject
    private VeterinarioDAO veterinariosDAO;

    //model-view
    @Size(min = 4, max = 16, message = "Identificador entre {min} y {max} caracteres")
    private String username;

    @NotEmpty(message = "Introduzca una clave válida")
    private String password;

    /*  Para cuando se modifiquen los identificadores hacer los cambios en las 
        clases que tienen referencias a clientes o veterinarios
     */
    @Inject
    private MascotaDAO mascotasDAO;

    @Inject
    private CitaDAO citasDAO;

    @Inject
    private Preferencias pref;

    //View-Model
    private Cliente cliente;
    private Veterinario veterinario;
    private String dni;
    private String aux;

    public ControladorUsuario() {
    }

    @PostConstruct
    private void init() {
        cliente = new Cliente();
        veterinario = new Veterinario();
        dni = null;
        setAux(null);
    }

    /**
     * Funcion auxiliar para asignar un dni al usurio actual
     */
    public void setDNIact() {
        dni = "54215624R";
    }

    /****************************************
     *          Getters y Setters           *
     ****************************************/
    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getNombreCli(String DNI) {
        Cliente cli = clientesDAO.buscaId(DNI);
        return cli.getNombre();
    }

    public String getNombreVet(String CC) {
        Veterinario vet = veterinariosDAO.buscaId(CC);
        return vet.getNombre();
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

    
    /****************************************
     *      Funciones para autenticación    *
     ****************************************/
    public String login() {
        String view = "";

        //Prepare data for programatic authentication
        AuthenticationParameters ap = new AuthenticationParameters();
        Credential credentials = new UsernamePasswordCredential(username, password);

        ap.credential(credentials).newAuthentication(true);

        HttpServletResponse response = (HttpServletResponse) ec.getResponse();

        //Programatic authentication
        if (sc.authenticate(request, response, ap) == AuthenticationStatus.SUCCESS) {
            final Pattern pattern = Pattern.compile("\\d{8}[A-Z]");
            logger.log(Level.INFO, username);
            if (pattern.matcher(username).matches()) {
                view = "/user/inicio?faces-redirect=true";
                pref.setCli(clientesDAO.buscaId(username));
            } else {
                pref.setVet(veterinariosDAO.buscaId(username));
                view = "/admin/inicio?faces-redirect=true";
            }
            logger.log(Level.INFO, "Usuario autenticado");
        } else {
            fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de autenticación", ""));
            logger.log(Level.WARNING, "Error de autenticación");
        }

        return view;
    }

    public String logout() throws ServletException {
        request.logout();
        request.getSession().invalidate();
        //ec.invalidateSession();
        return "/inicio/inicio.jsf?faces-redirect=true";
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
            clientesDAO.borra(dni);
            mascotasDAO.cambiaDNI(dni, cliente.getDNI());
            citasDAO.cambiaDNI(dni, cliente.getDNI());
            pref.setCli(cliente);
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
