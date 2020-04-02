package com.vetuja.DAO;

import com.vetuja.clases.Veterinario;
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
public class VeterinarioDAO implements DAOgenerico<Veterinario, String> {
    
    private static final Logger logger = Logger.getLogger(VeterinarioDAO.class.getName());
    
    @PersistenceContext
    private EntityManager em;

    public VeterinarioDAO() { }
    
    @Override
    public Veterinario buscaId(String id) {
        return em.find(Veterinario.class, id);
    }

    @Override
    public List<Veterinario> buscaTodos() {
        List<Veterinario> lc = null;
        try {
            lc = em.createQuery("Select v from Veterinario v", Veterinario.class).getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lc;
    }

    /**
     * @param user Usuario a localizar
     * @return Contraseña
     */
    public String getPass(String cc) {
        Veterinario vet = em.find(Veterinario.class, cc);
        if (vet != null) {
            return vet.getPass();
        }
        return null;
    }

    // NO SON USADAS, pero si la aplicación creciera se deberian implementar
    @Override
    public boolean crea(Veterinario c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guarda(Veterinario c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borra(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
