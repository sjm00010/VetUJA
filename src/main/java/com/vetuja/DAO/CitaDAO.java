package com.vetuja.DAO;

import com.vetuja.clases.Cita;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
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
    
    /**
     * Funcion para obtener el horario de un veterinario
     * @param cc Código colegiado del veterinario
     * @return Lista de horas disponibles
     */
    public List<String> buscaHorarios(String cc) {
        List<String> totalHoras = new ArrayList<>();
        for(int i = 9;i < 21;i++){
            if(i != 14 && i != 15){
                totalHoras.add(i+":00");
            }
        }
        List<Cita> lc;
        List<String> hora = new ArrayList<>();
        java.sql.Date hoy = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        try {
            lc = em.createQuery("Select c from Cita c where c.vetCC=:cc and c.fecha=:hoy", Cita.class).setParameter("hoy", hoy).setParameter("cc",cc).getResultList();
            for (Iterator<Cita> iterator = lc.iterator(); iterator.hasNext();) {
                Cita next = iterator.next();
                    hora.add(next.getHora());
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        totalHoras.removeAll(hora);
        return totalHoras;
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
            logger.log(Level.INFO, "No se ha podido crear la cita, para mas información mirar CitaDAO.java");
            // Para mayor limpieza en la ejecucion comento esta linea, ya que da errores al crear la cita desde el model.
//            logger.log(Level.SEVERE, ex.getMessage(), ex); // Si se producen
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
