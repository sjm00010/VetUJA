package com.vetuja.DAO;

import com.vetuja.clases.Veterinario;
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
public class VeterinarioDAO implements DAOgenerico<Veterinario, String>{
    
    // Estructura de soporte
    private Map<String, Veterinario> veterinarios=null;
    
    public VeterinarioDAO() {
        if (veterinarios == null) {
            veterinarios = new HashMap<>();
            veterinarios.put("AS0489", new Veterinario("AS0489",
                    "José Ramón", "Balsas Almagro", "admin", 
                    "https://pbs.twimg.com/profile_images/1181225056078385154/A3eO3ove_400x400.jpg"));
            veterinarios.put("AS0008", new Veterinario("AS0008",
                    "Flo", "López Ortega", "francis", 
                    "https://i1.rgstatic.net/ii/profile.image/586016247279622-1516728569350_Q512/F_Charte.jpg"));
        }
    }

    @Override
    public Veterinario buscaId(String id) {
        return veterinarios.get(id);
    }

    @Override
    public List<Veterinario> buscaTodos() {
        return veterinarios.values().stream().collect(Collectors.toList());
    }

    /**
     * @param user Usuario a localizar
     * @return Contraseña
     */
    public String getPass(String user) {
        List<Veterinario> listaVet = buscaTodos();
        for (Veterinario next : listaVet) {
            if (user.equals(next.getCodCol())){
                return next.getPass();
            }
        }
        return null;
    }
    
    // NO SON USADAS, pero si la aplicación creciera se deberian implementar
    @Override
    public boolean crea(Veterinario c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guarda(Veterinario c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borra(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
