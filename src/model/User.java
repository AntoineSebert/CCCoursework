package model;

import java.util.List;

/*
 * Represent an user
 * @author Antoine/Anthony Sébert
 * */
public class User {
	/* ATTRIBUTES */
		/**
		 * The longitude of the user
		 * @see #get_long()
		 * @see #set_long(double)
		 */
		private double longitude = 0.0,
		/**
		 * The latitude of the user
		 * @see #get_lat()
		 * @see #set_lat(double)
		 */
		latitude = 0.0;
		/**
		 * The unique user id
		 * @see #get_id()
		 */
		private String id = null;
		/**
		 * List all requests that have not yet been approved by the user
		 * @see #get_incoming_requests()
		 * @see #add_incoming_request(String)
		 */
		private List<String> incoming_requests = null,
		/**
		 * List all users that have accepted/rejected the user request
		 * @see #get_subscriptions()
		 * @see #add_subscription(String)
		 */
			subscriptions = null,
		/**
		 * List all users whose requests have been accepted by the user
		 * @see #get_subscribers()
		 * @see #add_subscriber(String)
		 */
			subscribers = null,
		/**
		 * List all request from the user that have not yet been accepted/rejected by other users
		 * @see #get_outgoing_requests()
		 * @see #add_outgoing_request(String)
		 */
			outgoing_requests = null;
	/* METHODS */
		// constructors
			/**
			 * Need this default constructor for AWS SDK
			 * @deprecated Create an empty {@code User} should not be possible, but the AWS SDK needs it
			 */
			public User() {}
			/**
			 * Create a User object
			 * @param	_id			The user id
			 * @param	_longitude	The user's longitude
			 * @param	_latitude	The user's latitude
			 * @see		#id
			 * @see		#longitude
			 * @see		#latitude
			 */
			public User(String _id, double _longitude, double _latitude) {
				id = _id;
				longitude = _longitude;
				latitude = _latitude;
			}
		// getters
			public double get_longitude() { return longitude; }
			public double get_latitude() { return latitude; }
			public String get_id() { return id; }
			public List<String> get_incoming_requests() { return incoming_requests; }
			public List<String> get_subscriptions() { return subscriptions; }
			public List<String> subscribers() { return subscribers; }
			public List<String> get_outgoing_requests() { return outgoing_requests; }
		// setters
	public String getCode() { return code; }

	public void setCode(String code) { this.code = code; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }


	public void setLongitude(double longitude) { this.longitude = longitude; }


	public void setLatitude(double latitude) { this.latitude = latitude; }
}
