/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetuja.DAO;

import com.vetuja.clases.Citas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author juanc
 */
@ApplicationScoped
public class CitasDAO implements DAOgenerico <Citas, Integer>, DAOcrud <Citas, Integer>{
    private Map<Integer, Citas> citas = null;
    private Integer idCliente = 6;
    public CitasDAO() throws ParseException {
        if(citas == null) {
            citas = new HashMap<>();
//            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//            java.util.Date fecha = sdf.parse("08-02-2020");
//            java.util.Date fecha2 = sdf.parse("06-05-2020");
//            java.util.Date fecha3 = sdf.parse("15-07-2020");
//            java.util.Date fecha4 = sdf.parse("01-09-2020");
            citas.put(1, new Citas(1,"2020-02-08","16:30","José Ramón","Remy"));
            citas.put(2, new Citas(2,"2020-05-06","10:30","Flo","Remy"));
            citas.put(3, new Citas(3,"2020-07-15","9:00","José Ramón","Misifu"));
            citas.put(4, new Citas(4,"2020-07-15","17:10","José Ramón","Desconocida"));
            citas.put(5, new Citas(5,"2020-09-01","12:15","Flo","Misifu"));



        
    }
}

    @Override
    public Citas buscaId(Integer id){
        return citas.get(id);
    }

    @Override
    public List<Citas> buscaTodos() {
        return citas.values().stream().collect(Collectors.toList());
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
        if(citas.containsKey(c.getId())){
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



}
