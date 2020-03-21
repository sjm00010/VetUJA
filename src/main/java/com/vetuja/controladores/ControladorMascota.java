package com.vetuja.controladores;

import com.vetuja.DAO.CitaDAO;
import com.vetuja.DAO.MascotaDAO;
import com.vetuja.clases.Mascota;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author dgl00018 y sjm00010
 */
@Named("ctrlMasc")
@ViewScoped
public class ControladorMascota implements Serializable {

    @Inject
    private MascotaDAO mascotasDAO;
    
    /*  Para cuando se modifiquen los identificadores hacer los cambios en las 
        clases que tienen referencias a clientes o veterinarios
    */
    
    @Inject
    private CitaDAO citasDAO;

    //View-Model
    private Mascota mascota;
    private String ci;

    public ControladorMascota() {
    }

    @PostConstruct
    private void init() {
        mascota = new Mascota();
        ci = null;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Mascota getMascota(String ci) {
        return mascotasDAO.buscaId(ci);
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public List<Mascota> getMascotas() {
        return mascotasDAO.buscaTodos();
    }
    
    public List<Mascota> getMascotasCliente(String DNI) {
        return mascotasDAO.busca(DNI);
    }

    public void recupera() {
        mascota = mascotasDAO.buscaId(mascota.getCi());
        this.ci = mascota.getCi();
    }

    public String getEdad(Date f) {
        Calendar c = Calendar.getInstance();
        c.setTime(f);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, date);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(l1, now1);
        String sol = "";
        if (diff1.getYears() != 0)
            sol += Integer.toString(diff1.getYears()) + " años, ";
        if (diff1.getMonths() != 0)
            sol += Integer.toString(diff1.getMonths()) + " meses, ";
        if (diff1.getDays() != 0)
            sol += Integer.toString(diff1.getDays()) + " días";
        return sol;
    }

    public String creaMascota() {
        if (mascotasDAO.crea(mascota)) {
            return "mascotas.jsf?faces-redirect=true";
        }
        return null;
    }
    
     public String modificaMascota() {    
        if (!mascotasDAO.guarda(mascota)) {
            mascotasDAO.crea(mascota);
            mascotasDAO.borra(ci);
            citasDAO.cambiaCi(ci, mascota.getCi());
        }
        return "mascotas.jsf?faces-redirect=true";
    }
     
    public String getNombreMas(String ci){
        Mascota mas = mascotasDAO.buscaId(ci);
        return mas.getNombre();
    }
}
