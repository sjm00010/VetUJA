package com.vetuja.controladores;

import com.vetuja.DAO.ClienteDAO;
import com.vetuja.clases.Cliente;
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

    //View-Model
    private Cliente cliente;

    public ControladorCliente() {
    }

    @PostConstruct
    private void init() {
        cliente = new Cliente();
    }

    public Cliente getLibro() {
        return cliente;
    }

    public void setLibro(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getLibros() {
        return clientesDAO.buscaTodos();
    }
}
