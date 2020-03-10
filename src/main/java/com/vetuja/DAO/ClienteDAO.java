package com.vetuja.DAO;

import com.vetuja.clases.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author sjm00010
 */
@ApplicationScoped
public class ClienteDAO implements DAOgenerico<Cliente, String> {

    private Map<String, Cliente> clientes = null;

    public ClienteDAO() throws ParseException {
        if (clientes == null) {
            clientes = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fnac = sdf.parse("1992-07-26");
            clientes.put("54215624R", new Cliente(
                    "54215624R", "Ángel Luis", "García Fernández",
                    "Campus Las Lagunillas", fnac,
                    "https://www.ujaen.es/departamentos/dinformatica/sites/departamento_dinformatica/files/styles/contact_photo/public/uploads/node_contacto_persona/2019-06/algarcia.jpg?itok=VjL78gZO",
                    "algarcia", "algarcia@ujaen.es", "contrasena"));
            clientes.put("53914392T", new Cliente(
                    "53914392T", "Francis", "Ortega López",
                    "La lloreria", fnac,
                    "https://i.pinimg.com/originals/d9/e9/7d/d9e97d15c8aefb3067372c36fa2abc26.png",
                    "fol00008", "fol00008@ujaen.es", "paco"));
            clientes.put("24315522B", new Cliente(
                    "24315522B", "Alejandro", "Expósito Pontiveros",
                    "Avenida Andalucía, 1", fnac,
                    "https://www.pngitem.com/pimgs/m/204-2040760_contact-starwars-user-default-yoda-comments-users-icon.png",
                    "aep00047", "aep00042@ujaen.es", "erasmus"));
            clientes.put("34209621C", new Cliente(
                    "34209621C", "ElRisas", "Joker",
                    "En su casa", fnac,
                    "https://img-cdn.hipertextual.com/files/2019/09/hipertextual-warner-no-tiene-planes-secuela-joker-ahora-2019170034.jpg?strip=all&lossy=1&quality=65&resize=740%2C490&ssl=1",
                    "ElPrisas", "algarcia@ujaen.es", "sanic"));
        }
    }

    @Override
    public Cliente buscaId(String id) {
        return clientes.get(id);
    }

    @Override
    public List<Cliente> buscaTodos() {
        return clientes.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean crea(Cliente c) {
        clientes.put(c.getDNI(), c);
        return true;
    }

    @Override
    public boolean guarda(Cliente c) {
        boolean result = false;
        if (clientes.containsKey(c.getDNI())) {
            Cliente nc = new Cliente(c);
            clientes.replace(c.getDNI(), c);
            result = true;
        }
        return result;
    }

    @Override
    public boolean borra(String id) {
        boolean result = false;
        if (clientes.containsKey(id)) {
            clientes.remove(id);
            result = true;
        }
        return result;
    }

    public Cliente buscaUser(String user) {
        List<Cliente> listaClientes = buscaTodos();
        for (Cliente next : listaClientes) {
            if (user.equals(next.getUser())) {
                return next;
            }
        }
        return null;
    }
}
