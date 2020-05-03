package com.vetuja.resources;

import com.vetuja.DAO.ClienteDAO;
import com.vetuja.clases.Cliente;
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
    private ClienteDAO clientesDAO;

    
    @GET
    @Path("/{id}")
    public Response getLibro(@PathParam("id") String id) {
        Response response;
        Cliente l = clientesDAO.buscaId(id);
        if( l != null) {
            response= Response.ok(l).build();
        } else {
            //Error messages
            List<Map<String,Object>> errores=new ArrayList<>();
            Map<String,Object> err=new HashMap<>(); 
            err.put("message", "El libro no existe");
            errores.add(err);
            response=Response.status(Response.Status.BAD_REQUEST)
                             .entity(errores).build();            
        }
        return response;
    }

}
