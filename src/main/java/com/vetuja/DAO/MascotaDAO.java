package com.vetuja.DAO;

import com.vetuja.clases.Mascota;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author dgl00018 y sjm00010
 */
@RequestScoped
@Transactional
public class MascotaDAO implements DAOgenerico<Mascota, String> {

    // Logger para depurar errores, e informar del estado de la aplicación
    private static final Logger logger = Logger.getLogger(MascotaDAO.class.getName());

    @PersistenceContext
    private EntityManager em;

    public MascotaDAO() {
    }

    @Override
    public Mascota buscaId(String id) {
        return em.find(Mascota.class, id);
    }

    @Override
    public List<Mascota> buscaTodos() {
        List<Mascota> lc = null;
        try {
            lc = em.createQuery("Select m from Mascota m", Mascota.class).getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lc;
    }

    @Override
    public boolean crea(Mascota m) {
        boolean creado = false;
        try {
            em.persist(m);
            creado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return creado;
    }

    @Override
    public boolean guarda(Mascota m) {
        boolean guardado = false;
        try {
            m = em.merge(m);
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
            Mascota c = null;
            c = em.find(Mascota.class, id);
            em.remove(c);
            borrado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return borrado;
    }

    /**
     * Busca todas las mascotas para un cliente
     * @param DNI Cliente
     * @return Devuelve todas las mascotas encontradas
     */
    public List<Mascota> busca(String DNI) {
        List<Mascota> lc = null;
        TypedQuery<Mascota> q = em.createQuery("Select m from Mascota m where m.cliDNI=:DNI", Mascota.class);
        q.setParameter("DNI", DNI);
        lc = q.getResultList();
        return lc;
    }

    public void borraCli(String cliDNI) {
        em.createQuery("DELETE FROM Mascota m WHERE m.cliDNI=:cliDNI").setParameter("cliDNI",cliDNI).executeUpdate();
    }

//    /**
//     * Función que actualiza los DNIs
//     *
//     * @param oldDNI DNI a actualizar
//     * @param newDNI Nuevo DNI
//     */
//    public void cambiaDNI(String oldDNI, String newDNI) {
//        em.createQuery("UPDATE Mascota m Set m.cliDNI=:newDNI WHERE m.cliDNI=:oldDNI").setParameter("newDNI",newDNI).setParameter("oldDNI",oldDNI).executeUpdate();
//    }
}
