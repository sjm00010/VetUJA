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
 * @author dgl00018
 */
@ApplicationScoped
public class MascotaDAO implements DAOgenerico <Mascota, String>, DAOcrud <Mascota, String> {

    private Map<String, Mascota> mascotas=null; 

public MascotaDAO() throws ParseException {
        if (mascotas == null) {
            mascotas = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechanac = sdf.parse("2008-07-26");
            mascotas.put("938000000455987", new Mascota(
                    "938000000455987", "Remy","Rata","M", fechanac));
            mascotas.put("938000159457532", new Mascota(
                    "938000159457532", "Misifu","Gato Siames","M", fechanac));
            mascotas.put("938000777000666", new Mascota(
                    "938000777000666", "Pipo","Perro Gambino","M", fechanac));

        }
    }

@Override
    public Mascota buscaId(String ci) {
        return mascotas.get(ci);
    }

    @Override
    public List<Mascota> buscaTodos() {
        return mascotas.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean crea(Mascota m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guarda(Mascota m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borra(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

