package user.management.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;



import user.management.data.Usuario;
import user.management.data.RepositoryUsuarios;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/usersmanagement")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class UserResources {

	@GET
	public RepositoryUsuarios listarUsuarios() {
		return new RepositoryUsuarios();
	}

	@GET
	@Path("/{id}")
	public Response find(@PathParam("id") Integer id) {
		
		Usuario usuario = new RepositoryUsuarios().findById(id);
		
		if (usuario.getId().equals(0)) {
			return Response.status(Response.Status.NOT_FOUND).build();	
		}
		
		return Response.ok(usuario).build();
		
	}
	
	@POST
	public Response create(@Context UriInfo uriInfo, Usuario user)
	{
		new RepositoryUsuarios().addUsuario(user);
		
		// Constrói a URL onde o recurso estará disponível
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		URI location = uriBuilder.path("/{id}").build(user.getId());
		
		return Response.created(location).build();		
	}
}
