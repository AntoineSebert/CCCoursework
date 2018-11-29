package resource;

//JAX-RS
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import aws.DynamoDB;

@Path("/")
public class Login {
	/**
	 * Login service returning JWT token.
	 * @param	username
	 * @return	
	 */
	@Path("login")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@FormParam("user_id") String user_id) {
		if(DynamoDB.is_user_present(user_id))
			return Response.status(200).entity("").build();
		else
			return Response.status(404).entity("user not found").build();
	}
	/**
	 * Registration service returning JWT token. Note that this service does not use AuthenticationFilter.
	 * @param	username
	 * @return	
	 */
	@Path("register")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(@FormParam("user_id") String user_id) {
		if(DynamoDB.is_user_present(user_id))
			return Response.status(409).entity("user already exists").build();
		return DynamoDB.createUser(user_id) ? Response.status(200).entity("user created").build() : Response.status(500).entity("server internal error").build();
	}
	/**
	 * Logout service which is also secured.
	 */
	@Path("logout")
	@POST
	public void logout() {}
}