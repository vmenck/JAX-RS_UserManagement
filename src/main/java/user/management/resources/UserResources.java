
package user.management.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import user.management.data.Usuarios;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/usersmanagement")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class UserResources {
    
    @GET
    public Usuarios listarUsuarios() {
    	return new Usuarios();
    }    
}
