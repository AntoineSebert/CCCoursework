package exception;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * Represent an HTTP error with a message, used when the parameters of a request are invalid
 * @author	Antoine/Anthony Sébert
 */
@SuppressWarnings("serial")
public class InvalidParamException extends WebApplicationException {
	/**
	 * Create an HTTP error with a message
	 * @param	msg	the error message to be displayed
	 */
	public InvalidParamException(String msg) { super(Response.status(Response.Status.BAD_REQUEST).entity(msg).type("text/plain").build()); }
}