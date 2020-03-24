package com.vetuja.DAO;

import com.vetuja.clases.Citas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author juanc
 */
@ApplicationScoped
public class CitaDAO implements DAOgenerico<Citas, Integer> {

    private Map<Integer, Citas> citas = null;
    private Integer idCliente = 6;

    public CitaDAO() throws ParseException {
        if (citas == null) {
            citas = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            java.util.Date fecha = sdf.parse("08-02-2020");
            citas.put(1, new Citas(1, fecha, "16:30", "54215624R", "AS0489", "938000000455987"));
            fecha = sdf.parse("06-05-2020");
            citas.put(2, new Citas(2, fecha, "10:30", "54215624R", "AS0008", "938000777000666"));
            fecha = sdf.parse("15-07-2020");
            citas.put(3, new Citas(3, fecha, "9:00", "54215624R", "AS0489", "938000159457532"));
            fecha = sdf.parse("01-09-2020");
            citas.put(5, new Citas(5, fecha, "12:15", "53914398T", "AS0008", "938000777000666"));
        }
    }

    @Override
    public Citas buscaId(Integer id) {
        return citas.get(id);
    }

    @Override
    public List<Citas> buscaTodos() {
        return citas.values().stream().collect(Collectors.toList());
    }

    public List<Citas> busca(String DNI) {
        List<Citas> resultado = new ArrayList();
        citas.entrySet().stream().filter((entry) -> (entry.getValue().getCliDNI().equals(DNI))).forEachOrdered((entry) -> {
            resultado.add(entry.getValue());
        });
        return resultado;
    }

    @Override
    public boolean crea(Citas c) {
        c.setId(idCliente++);
        citas.put(c.getId(), c);
        return true;
    }

    @Override
    public boolean guarda(Citas c) {
        boolean result = false;
        if (citas.containsKey(c.getId())) {
            Citas nc = new Citas(c);
            citas.replace(c.getId(), c);
            result = true;
        }
        return result;
    }

    @Override
    public boolean borra(Integer id) {
        boolean result = false;
        if (citas.containsKey(id)) {
            citas.remove(id);
            result = true;
        }
        return result;

    }

    public void borraCli(String cliDNI) {
        List<Integer> borrar = new ArrayList<>();
        for (Map.Entry<Integer, Citas> entry : citas.entrySet()) {
            if (entry.getValue().getCliDNI() == cliDNI) {
                borrar.add(entry.getKey());
            }
        }
        if(!borrar.isEmpty()){
            for (Iterator<Integer> iterator = borrar.iterator(); iterator.hasNext();) {
                Integer next = iterator.next();
                citas.remove(next);
            }
        }
    }

    /**
     * Función que actualiza los DNIs
     *
     * @param oldDNI DNI a actualizar
     * @param newDNI Nuevo DNI
     */
    public void cambiaDNI(String oldDNI, String newDNI) {
        for (Map.Entry<Integer, Citas> entry : citas.entrySet()) {
            if (entry.getValue().getCliDNI() == oldDNI) {
                entry.getValue().setCliDNI(newDNI);
            }
        }
    }

    /**
     * Función que actualiza los Códigos de Identificación de las mascotas
     *
     * @param oldCi Códigos de Identificación a actualizar
     * @param newCi Nuevo Códigos de Identificación
     */
    public void cambiaCi(String oldCi, String newCi) {
        for (Map.Entry<Integer, Citas> entry : citas.entrySet()) {
            if (entry.getValue().getCliDNI() == oldCi) {
                entry.getValue().setCliDNI(newCi);
            }
        }
    }

}
