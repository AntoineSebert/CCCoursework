/**
 * 
 */
package resource;

import javax.ws.rs.core.*;

/**
 * @author Antoine/Anthony S�bert
 *
 */
public class JSON_answer {
	public static Response generate(int status_code, String payload) {
		return Response.status(status_code).entity(payload).build();
	}
}
