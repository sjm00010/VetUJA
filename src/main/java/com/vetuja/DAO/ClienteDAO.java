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
            clientes.put(53914392, new Cliente(
                    53914392, "Francis", "Ortega López",
                    "La lloreria", fnac, "default-user.png",
                    "fol00008", "fol00008@ujaen.es","paco"));
            clientes.put(24315522, new Cliente(
                    24315522, "Alejandro", "Expósito Pontiveros",
                    "Avenida Andalucía, 1", fnac, "default-user.pngg",
                    "algarcia", "aep00042@ujaen.es","erasmus"));
            clientes.put(34209621, new Cliente(
                    34209621, "ElRisas", "Joker",
                    "En su casa", fnac, "default-user.png",
                    "ElPrisas", "algarcia@ujaen.es","sanic"));
        }
    }

    public Cliente buscaDNI(int dni) {
        return clientes.get(dni);
    }

    public List<Cliente> buscaTodos() {
        return clientes.values().stream().collect(Collectors.toList());
    }

}
