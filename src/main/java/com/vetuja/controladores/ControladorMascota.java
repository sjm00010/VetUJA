package com.vetuja.controladores;

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

    //View-Model
    private Mascota mascota;

    public ControladorMascota() {
    }

    @PostConstruct
    private void init() {
        mascota = new Mascota();
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

    public void recupera() {
        mascota = mascotasDAO.buscaId(mascota.getCi());
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
        return Integer.toString(diff1.getYears()) + " años, " 
                + Integer.toString(diff1.getMonths()) + " meses, " 
                + Integer.toString(diff1.getDays()) + " días";
    }
}
