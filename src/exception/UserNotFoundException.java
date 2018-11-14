package exception;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * Represent an HTTP error with a message, used when a requested user cannot be found
 * @author	Antoine/Anthony Sébert
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends WebApplicationException {
	/**
	 * Create an HTTP error with a message
	 * @param	id	the requested user id
	 */
	public UserNotFoundException(String id) {
		super(Response.status(Response.Status.NOT_FOUND).entity("user " + id + " not found").type("text/plain").build());
	}
}