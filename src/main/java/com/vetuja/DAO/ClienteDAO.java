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
                    "Campus Las Lagunillas", fnac,
                    "https://www.ujaen.es/departamentos/dinformatica/sites/departamento_dinformatica/files/styles/contact_photo/public/uploads/node_contacto_persona/2019-06/algarcia.jpg?itok=VjL78gZO",
                    "algarcia", "algarcia@ujaen.es","contrasena"));
            clientes.put(53914392, new Cliente(
                    53914392, "Francis", "Ortega López",
                    "La lloreria", fnac,
                    "https://i.pinimg.com/originals/d9/e9/7d/d9e97d15c8aefb3067372c36fa2abc26.png",
                    "fol00008", "fol00008@ujaen.es","paco"));
            clientes.put(24315522, new Cliente(
                    24315522, "Alejandro", "Expósito Pontiveros",
                    "Avenida Andalucía, 1", fnac,
                    "https://lh3.googleusercontent.com/proxy/awJOZdGfuF3X3Qf1pgZ2T8lTpPz-aAyWCbb4knCWY-y07VKOlZI028CnF5cQIFP8fYolENs_fBCWnUf2N3SBko701XsMO_3EW-040Iv6ow",
                    "algarcia", "aep00042@ujaen.es","erasmus"));
            clientes.put(34209621, new Cliente(
                    34209621, "ElRisas", "Joker",
                    "En su casa", fnac,
                    "https://img-cdn.hipertextual.com/files/2019/09/hipertextual-warner-no-tiene-planes-secuela-joker-ahora-2019170034.jpg?strip=all&lossy=1&quality=65&resize=740%2C490&ssl=1",
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
