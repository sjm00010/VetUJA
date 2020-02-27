package com.vetuja.DAO;

import com.vetuja.clases.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author sjm00010
 */
@ApplicationScoped
public class ClienteDAO {

    private Map<Integer, Cliente> clientes=null;

    public ClienteDAO() throws ParseException {
        if (clientes == null) {
            clientes = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fnac = sdf.parse("1992-07-26");
            clientes.put(54215624, new Cliente(
                    54215624, "Ángel Luis", "García Fernández",
                    "Campus Las Lagunillas", fnac, "algarcia.jpg",
                    "algarcia", "algarcia@ujaen.es","contrasena"));
        }
    }

    public Cliente buscaDNI(Integer dni) {
        return clientes.get(dni);
    }

    public List<Cliente> buscaTodos() {
        return clientes.values().stream().collect(Collectors.toList());
    }

}
