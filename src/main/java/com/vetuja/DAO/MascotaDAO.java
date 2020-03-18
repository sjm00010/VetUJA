package com.vetuja.DAO;

import com.vetuja.clases.Mascota;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author dgl00018 y sjm00010
 */
@ApplicationScoped
public class MascotaDAO implements DAOgenerico<Mascota, String> {

    private Map<String, Mascota> mascotas = null;

    public MascotaDAO() throws ParseException {
        if (mascotas == null) {
            mascotas = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechanac = sdf.parse("2008-07-26");
            mascotas.put("938000000455987", new Mascota(
                    "938000000455987", "Remy", "Rata", "M", fechanac, "img/mascotas/remy.png"));
            mascotas.put("938000159457532", new Mascota(
                    "938000159457532", "Misifu", "Gato Siames", "M", fechanac, "img/mascotas/gato.jpg"));
            mascotas.put("938000777000666", new Mascota(
                    "938000777000666", "Pipo", "Perro Gambino", "M", fechanac, "img/mascotas/pipo.jpg"));

        }
    }

    @Override
    public Mascota buscaId(String id) {
        return mascotas.get(id);
    }

    @Override
    public List<Mascota> buscaTodos() {
        return mascotas.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean crea(Mascota m) {
        mascotas.put(m.getCi(), m);
        return true;
    }

    @Override
    public boolean guarda(Mascota m) {
        boolean result = false;
        if (mascotas.containsKey(m.getCi())) {
            mascotas.replace(m.getCi(), m);
            result = true;
        }
        return result;
    }

    @Override
    public boolean borra(String id) {
        boolean result = false;
        if (mascotas.containsKey(id)) {
            mascotas.remove(id);
            result = true;
        }
        return result;
    }
}
