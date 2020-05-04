package com.vetuja.resources;

import com.vetuja.DAO.CitaDAO;
import com.vetuja.DAO.VeterinarioDAO;
import com.vetuja.clases.Cita;
import com.vetuja.clases.Veterinario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sjm00010
 */
@Path("/cita") //Acceso /api/duenio
@Produces(MediaType.APPLICATION_JSON)
public class CitaResource {

    @Inject
    private CitaDAO citasDAO;
    
    @Inject
    private VeterinarioDAO vetDAO;
    
    @GET
    public List<Veterinario> Listado() {
        return vetDAO.buscaTodos();
    }
   
    @GET
    @Path("/{cc}")
    public List<String> getHorario(@PathParam("cc") String cc) {
        List<String> l = citasDAO.buscaHorarios(cc);
        if( l.isEmpty() ) {
            //Error messages
            List<Map<String,Object>> errores=new ArrayList<>();
            Map<String,Object> err=new HashMap<>(); 
            err.put("message", "El veterinario no existe");
            errores.add(err);
            return null;
        }
        return l;
    }
}
