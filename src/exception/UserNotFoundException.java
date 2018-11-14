package exception;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@SuppressWarnings("serial")
public class UserNotFoundException extends WebApplicationException {
	public UserNotFoundException(String id) { super(Response.status(Response.Status.NOT_FOUND).entity("user " + id + " not found").type("text/plain").build()); }
}