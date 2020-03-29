package com.vetuja.DAO;

import com.vetuja.clases.Cliente;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author sjm00010
 */
@RequestScoped
@Transactional
public class ClienteDAO implements DAOgenerico<Cliente, String> {

    private static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

    @PersistenceContext
    private EntityManager em;

    public ClienteDAO() throws ParseException {
    }

    @Override
    public Cliente buscaId(String id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscaTodos() {
        List<Cliente> lc = null;
        try {
            lc = em.createQuery("Select v from Cliente v", Cliente.class).getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lc;
    }

    @Override
    public boolean crea(Cliente c) {
        boolean creado = false;
        try {
            em.persist(c);
            creado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return creado;
    }

    @Override
    public boolean guarda(Cliente c) {
        boolean guardado = false;
        try {
            c = em.merge(c);
            guardado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return guardado;
    }

    @Override
    public boolean borra(String id) {
        boolean borrado = false;
        try {
            Cliente c = null;
            c = em.find(Cliente.class, id);
            em.remove(c);
            borrado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return borrado;
    }

    /**
     * @param dni Usuario a localizar
     * @return Contraseña
     */
    public String getPass(String dni) {
        Cliente cli = em.find(Cliente.class, dni);
        if (cli != null) {
            return cli.getPass();
        }
        return null;
    }
}
