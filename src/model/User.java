package model;

import java.util.List;

/*
 * Represent an user
 * @author Antoine/Anthony Sébert
 */
public class User {
	/* ATTRIBUTES */
		/**
		 * The longitude of the user
		 * @see	#long()
		 * @see	#set_long(double)
		 */
		private double longitude = 0.0,
		/**
		 * The latitude of the user
		 * @see	#lat()
		 * @see	#set_lat(double)
		 */
		latitude = 0.0;
		/**
		 * The unique user id
		 * @see	#id()
		 */
		private String id = null;
		/**
		 * List all requests that have not yet been accepted/rejected by the user
		 * @see	#incoming_requests()
		 * @see	#add_incoming_request(String)
		 * @see	#accept_incoming_request(String)
		 * @see	#reject_incoming_request(String)
		 */
		private List<String> incoming_requests = null,
		/**
		 * List all users that have accepted the user request
		 * @see	#subscriptions()
		 */
			subscriptions = null,
		/**
		 * List all users whose requests have been accepted by the user
		 * @see	#subscribers()
		 */
			subscribers = null,
		/**
		 * List all request from the user that have not yet been accepted/rejected by other users
		 * @see	#outgoing_requests()
		 * @see	#add_outgoing_request(String)
		 * @see	#outgoing_request_accepted(String)
		 * @see	#outgoing_request_rejected(String)
		 */
			outgoing_requests = null;
	/* METHODS */
		// constructors
			/**
			 * Need this default constructor for AWS SDK
			 * @deprecated	Create an empty {@code User} should not be possible, but the AWS SDK needs it
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
			/**
			 * @return	the user's longitude
			 * @see		#longitude
			 */
			public double longitude() { return longitude; }
			/**
			 * @return	the user's latitude
			 * @see		#latitude
			 */
			public double latitude() { return latitude; }
			/**
			 * @return	the user's id
			 * @see		#id
			 */
			public String id() { return id; }
			/**
			 * @return	the user's incoming requests
			 * @see		#incoming_requests
			 */
			public List<String> incoming_requests() { return incoming_requests; }
			/**
			 * @return	the user's subscriptions
			 * @see		#subscriptions
			 */
			public List<String> subscriptions() { return subscriptions; }
			/**
			 * @return	the user's subscribers
			 * @see		#subscribers
			 */
			public List<String> subscribers() { return subscribers; }
			/**
			 * @return	the user's outgoing requests
			 * @see		#outgoing_requests
			 */
			public List<String> outgoing_requests() { return outgoing_requests; }
		// setters
			/**
			 * Set the user's longitude attribute
			 * @param	_longitude	the new longitude value
			 * @see		#longitude
			 */
			public void set_longitude(double _longitude) { longitude = _longitude; }
			/**
			 * Set the user's latitude attribute
			 * @param	_longitude	the new latitude value
			 * @see		#latitude
			 */
			public void set_latitude(double _latitude) { latitude = _latitude; }
		// incrementers
			/**
			 * Add a user id to the incoming requests list
			 * @param	_id	the user id to add
			 * @return	true if the operation is a success, false otherwise
			 * @see		#incoming_requests
			 */
			public boolean add_incoming_request(String _id) { return incoming_requests.add(_id); }
			/**
			 * Add a user id to the outgoing requests list
			 * @param	_id	the user id to add
			 * @return	true if the operation is a success, false otherwise
			 * @see		#outgoing_requests
			 */
			public boolean add_outgoing_request(String _id) { return outgoing_requests.add(_id); }
		// decrementers
			/**
			 * Remove a user id from the incoming requests list
			 * @param	_id	the user id to remove
			 * @return	true if the operation is a success, false otherwise
			 * @see		#incoming_requests
			 */
			public boolean reject_incoming_request(String _id) { return incoming_requests.remove(_id); }
			/**
			 * Remove a user id from the outgoing requests list
			 * @param	_id	the user id to remove
			 * @return	true if the operation is a success, false otherwise
			 * @see		#outgoing_requests
			 */
			public boolean outgoing_request_rejected(String _id) { return outgoing_requests.remove(_id); }
		// movers
			/**
			 * Move a user id from the incoming requests list to the subscribers list
			 * @param	_id	the user id to move
			 * @return	true if the operation is a success, false otherwise
			 * @see		#incoming_requests
			 * @see		#subscribers
			 */
			public boolean accept_incoming_request(String _id) {
				return subscribers.add(incoming_requests.remove(incoming_requests.indexOf(_id)));
			}
			/**
			 * Move a user id from the outgoing requests list to the subscriptions list
			 * @param	_id	the user id to move
			 * @return	true if the operation is a success, false otherwise
			 * @see		#outgoing_requests
			 * @see		#subscriptions
			 */
			public boolean outgoing_request_accepted(String _id) {
				return subscriptions.add(outgoing_requests.remove(outgoing_requests.indexOf(_id)));
			}
}
