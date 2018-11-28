package resource;

//JAX-RS
import javax.ws.rs.*;
import javax.ws.rs.core.*;

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
		try {
			/*
			JWSHeader header = JWSHeader.parse("{\"alg\":\"HS256\"}");
			JWTClaimsSet claimsSet = new JWTClaimsSet.Builder().
				issueTime(new Date()).expirationTime(new Date(new Date().getTime() + 60 * 1000)).issuer(Config.ISSUER).subject(username)
				.build();
			SignedJWT signedJWT = new SignedJWT(header, claimsSet);
			signedJWT.sign(new MACSigner(Config.SIGNING_KEY));
			 */
			return Response.status(200).entity("this is a test").build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("server internal error").build();
		}
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
		try {
			return Response.status(200).entity("this is a test").build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("server internal error").build();
		}
	}
	/**
	 * Logout service which is also secured.
	 */
	@Path("logout")
	@POST
	public void logout() {}
}