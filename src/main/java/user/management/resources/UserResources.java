package user.management.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import javax.ws.rs.core.Response;

import user.management.data.Usuario;
import user.management.data.Usuarios;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/usersmanagement")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class UserResources {

	@GET
	public Usuarios listarUsuarios() {
		return new Usuarios();
	}

	@GET
	@Path("/{id}")
	public Response find(@PathParam("id") Integer id) {
		
		Usuario usuario = new Usuarios().findById(id);
		
		if (usuario.getId().equals(0)) {
			return Response.status(Response.Status.NOT_FOUND).build();	
		}
		
		return Response.ok(usuario).build();
		
	}
}
