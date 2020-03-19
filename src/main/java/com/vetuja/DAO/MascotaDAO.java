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
            java.util.Date fechanac2 = sdf.parse("2003-08-08");
            java.util.Date fechanac3 = sdf.parse("2015-11-17");
            mascotas.put("938000000455987", new Mascota(
                    "938000000455987", "Remy", "Domestica", "Rata", "Macho", 12, 230, fechanac,
                    "https://vignette.wikia.nocookie.net/dominios-encantados/images/6/66/REMY_WIKI.png/revision/latest/scale-to-width-down/340?cb=20151126195355&path-prefix=es",
                    "54215624R","AS0008"));
            mascotas.put("938000159457532", new Mascota(
                    "938000159457532", "Misifu", "Ragdoll", "Gato", "Hembra", 25, 3800, fechanac2, 
                    "https://www.lavanguardia.com/r/GODO/LV/p6/WebSite/2019/05/17/Recortada/img_pplaza_20190517-144227_imagenes_lv_otras_fuentes_60889244_295648354678280_6739256407041769472_n-kR3G-U462293423715hBH-992x558@LaVanguardia-Web.jpg",
                    "54215624R","AS0489"));
            mascotas.put("938000777000666", new Mascota(
                    "938000777000666", "Pipo", "Gambino", "Perro", "Macho", 60, 6000, fechanac3, 
                    "https://i1.sndcdn.com/artworks-000239253704-ikgw8q-t500x500.jpg",
                    "53914398T","AS0008"));

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
