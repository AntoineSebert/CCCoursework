# Cloud Computing - coursework report

Anthony Sébert - 1705851

## Statement of compliance

### Subscriptions, Requests, and Locations

see [Implementation](#Implementation)

### Web Services

`null`

### The User Interface

The project provide a landing page with a login form to log in or register, created in pure HTML/CSS.

## Implementation

### `User` class

Class representing a user as an object, with the following attributes and methods.

#### attributes

* longitude (double) : The longitude of the user
* latitude (double) : The latitude of the user
* id (String) :  The unique user id
* incoming_requests (List<String>) : List all requests that have not yet been accepted/rejected by the user
* subscriptions (List<String>) : List all users that have accepted the user request
* subscribers (List<String>) : List all users whose requests have been accepted by the user
* outgoing_requests (List<String>) : List all request from the user that have not yet been accepted/rejected by other users

#### methods

* User() : Need this default constructor for AWS SDK. Create a User object
* User(String _id) : Create a User object
* longitude() (double) : Get a user's longitude
* latitude() (double) : Get a user's latitude
* id() (String) : Get a user's id
* incoming_requests() : Returns a user's incoming requests
* subscriptions() (List<String>) : Returns a user's subscriptions
* subscribers() (List<String>) : Returns a user's subscribers
* outgoing_requests() (List<String>) : Returns a user's outgoing_requests
* set_longitude(double) : Set a user's longitude attribute
* set_latitude(double) : Set a user's latitude attribute
* add_incoming_request(String) (boolean) : Add a user id to the incoming requests list
* add_outgoing_request(String) (boolean) : Add a user id to the outgoing requests list
* Remove a user id from the incoming requests list
* @return	true if the operation is a success, false otherwise
boolean reject_incoming_request(String id) { return incoming_requests.remove(id); }
* Remove a user id from the outgoing requests list
* @return	true if the operation is a success, false otherwise
boolean outgoing_request_rejected(String id) { return outgoing_requests.remove(id); }
* Move a user id from the incoming requests list to the subscribers list
* @return	true if the operation is a success, false otherwise
boolean accept_incoming_request(String)
* Move a user id from the outgoing requests list to the subscriptions list
boolean outgoing_request_accepted(String)

## API specification

### Register

This service is responsible for the registration of new users. It is called by a **POST** request at */api/register*. The parameter `user_id`, extracted from the HTML form, corresponds to the user to create. The service returns:
- **409** if the user is already present in the database
- **200** if the operation have been performed successfully
- **500** in case of a server error (very likely during the communicatino with the database)
On success, the service returns a JSON object containing a message that describes the result of the operation.

### Login

This service is responsible for the login of existing users. It is called by a **POST** request at */api/login*. The parameter `user_id`, extracted from the HTML form, corresponds to the user to retrieve. The service returns:
- **200** if the operation have been performed successfully
- **404** if the user cannot be found
On success, the service returns a JSON object containing a message that describes the result of the operation.

### Logout

This service is responsible for logout an user. It is called by a **GET** request at */api/logout*. No parameter is required. The service returns **200** since the operation cannot fail
On success, the service returns a JSON object containing a message that describes the result of the operation.

### User

This service is responsible for the creation of users and the retrieval of user information. A **POST** request at */api/user* can be performed to create an user. The parameter `user_id`, extracted from the HTML form, corresponds to the user to create. The service returns:
- **201** if the operation have been performed successfully
- **400** if a problem occured
On success, the service returns a JSON object containing a message that describes the result of the operation.

#### {id}

This service is responsible for retrieve user information. It is called by a **GET** request at */api/user/{id}*. The parameter `user_id`, extracted from the HTML form, corresponds to the user which information is requested.