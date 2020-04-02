package com.vetuja.DAO;

import com.vetuja.clases.Cita;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * @author juanc
 */
@RequestScoped
@Transactional
public class CitaDAO implements DAOgenerico<Cita, Integer> {

    // Logger para depurar errores, e informar del estado de la aplicación
    private static final Logger logger = Logger.getLogger(CitaDAO.class.getName());

    @PersistenceContext
    private EntityManager em;

    private final Integer idCita = 5;

    public CitaDAO() {
    }

    @Override
    public Cita buscaId(Integer id) {
        return em.find(Cita.class, id);
    }

    @Override
    public List<Cita> buscaTodos() {
        List<Cita> lc = null;
        try {
            lc = em.createQuery("Select c from Cita c", Cita.class).getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lc;
    }

    @Override
    public boolean crea(Cita c) {
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
    public boolean guarda(Cita c) {
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
    public boolean borra(Integer id) {
        boolean borrado = false;
        try {
            Cita c = null;
            c = em.find(Cita.class, id);
            em.remove(c);
            borrado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return borrado;
    }

    /**
     * Busca todas las citas para un cliente en concreto
     *
     * @param DNI Cliente
     * @return Lista de citas encontradas
     */
    public List<Cita> buscaCitas(String DNI) {
        List<Cita> lc = null;
        TypedQuery<Cita> q = em.createQuery("Select c from Cita c where c.cliDNI=:DNI", Cita.class);
        q.setParameter("DNI", DNI);
        lc = q.getResultList();
        return lc;
    }

    /**
     * Borra todas las citas que hay de un cliente en caso de que este sea
     * borrado
     *
     * @param cliDNI Cliente
     */
    public void borraCli(String cliDNI) {
        em.createQuery("DELETE FROM Cita c WHERE c.cliDNI=:cliDNI").setParameter("cliDNI", cliDNI).executeUpdate();
    }

    /**
     * Borra todas las citas que hay de una mascota en caso de que esta sea
     * borrada
     *
     * @param masCI Mascota
     */
    public void borraCI(String masCI) {
        em.createQuery("DELETE FROM Cita c WHERE c.masCI=:masCI").setParameter("masCI", masCI).executeUpdate();
    }

//    /**
//     * Función que actualiza los DNIs
//     *
//     * @param oldDNI DNI a actualizar
//     * @param newDNI Nuevo DNI
//     */
//    public void cambiaDNI(String oldDNI, String newDNI) {
//        em.createQuery("UPDATE Cita c Set c.cliDNI=:newDNI WHERE c.cliDNI=:oldDNI").setParameter("newDNI",newDNI).setParameter("oldDNI",oldDNI).executeUpdate();
//    }
//
//    /**
//     * Función que actualiza los Códigos de Identificación de las mascotas
//     *
//     * @param oldCi Códigos de Identificación a actualizar
//     * @param newCi Nuevo Códigos de Identificación
//     */
//    public void cambiaCi(String oldCi, String newCi) {
//        em.createQuery("UPDATE Cita c Set c.masCI=:newCi WHERE c.masCI=:oldCi").setParameter("newCi",newCi).setParameter("oldCi",oldCi).executeUpdate();
//    }
}
