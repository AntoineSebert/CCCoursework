package resource;

// Jersey
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import aws.Config;
import aws.dynamo_util;
import exception.UserNotFoundException;

/**
 * User service
 * @author	Antoine/Anthony Sébert
 */
@Path("/user")
public class User {
	/**
	 * This method handles a POST request to the URL "/user" to store a User object into DynamoDB
	 * @param	id
	 * @return	A {@code Response} object with a status describing the success or fail of the creation operation
	 * @see		dynamo_util
	 * @see		Config
	 * @see		User
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response add_user(@FormParam("id") String id) {
		try {
			dynamo_util.get_mapper(Config.REGION, Config.LOCAL_ENDPOINT).save(new model.User(id));
			return Response.status(201).entity(id + " saved sucessfully").build();
		}
		catch(Exception e) { return Response.status(400).entity("Something went wrong. Parameter accepted: id").build(); }
	}
	/**
	 * This method should handle a GET request to the URL pattern "/user/<code>" to retrieve a user's information and return it as a JSON map
	 * @param	id
	 * @return	The {@code User} object retrieved from the database using the given id
	 * @see		dynamo_util
	 * @see		Config
	 * @see		User
	 */
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public model.User retrieve_user(@PathParam("id") String id) {
		model.User user = dynamo_util.get_mapper(Config.REGION, Config.LOCAL_ENDPOINT).load(model.User.class, id);
		if(user == null)
			throw new UserNotFoundException(id);

		return user;
	}
	/**
	 * This method handles a GET request to the URL "/user" to retrieve all users as a JSON list
	 * @return	A list of all {@code User} objects present in the database
	 * @see		dynamo_util
	 * @see		Config
	 * @see		User
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<model.User> retrieve_all_users() {
		return dynamo_util.get_mapper(Config.REGION, Config.LOCAL_ENDPOINT).scan(model.User.class, new DynamoDBScanExpression());
	}
}
