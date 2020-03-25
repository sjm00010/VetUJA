package com.vetuja.DAO;

import com.vetuja.clases.Veterinario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author sjm00010
 */
@RequestScoped
@Transactional
public class VeterinarioDAO implements DAOgenerico<Veterinario, String> {

//    // Estructura de soporte
//    private Map<String, Veterinario> veterinarios=null;
//    
//    public VeterinarioDAO() {
//        if (veterinarios == null) {
//            veterinarios = new HashMap<>();
//            veterinarios.put("AS0489", new Veterinario("AS0489",
//                    "José Ramón", "Balsas Almagro", "admin", 
//                    "https://pbs.twimg.com/profile_images/1181225056078385154/A3eO3ove_400x400.jpg"));
//            veterinarios.put("AS0008", new Veterinario("AS0008",
//                    "Flo", "López Ortega", "francis", 
//                    "https://i1.rgstatic.net/ii/profile.image/586016247279622-1516728569350_Q512/F_Charte.jpg"));
//        }
//    }
    
    private static final Logger logger = Logger.getLogger(VeterinarioDAO.class.getName());
    
    @PersistenceContext
    private EntityManager em;

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
