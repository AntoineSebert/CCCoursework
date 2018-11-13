# The Find-my-friends Domain

In this coursework, you are developing a web app that allows a user to send subscription requests to friends. Incoming requests can be accepted or rejected. A map shows the location of all friends who have accepted your subscription requests.

## Functional Requirements

The web app has the following functions:
* A user must enter his/her user ID to use the web app.
* Once an ID is entered, there are 2 groups of functions available:
	* Subscription Management
		* send a subscription request to another user identified by a user ID
		* see a list of incoming subscription requests from other users
		* approve or deny incoming subscription requests
	* Location Management
		* check-in the current user’s location using a marker on the map
		* see a list of friends (IDs) who have approved the requests
		* see a map with markers showing the last check-in locations of friends
		* click on a friend’s name to centre the map on that friend

## Non-functional Requirements

* You must use AWS DynamoDB for data storage. If you do not have AWS access, you can use a local DynamoDB server.
* You must use a Service-oriented Architecture. There must be web services that expose functionalities of your backend server.

## Assumptions

To simplify the tasks, we assume the followings:
* All user IDs are unique. A user ID is represented as a simple string.
* No login is required. The user ID is submitted as a simple HTTP request parameter[^1]

**Important Notice**
- In your report, please clearly specify the structure of your DynamoDB tables as I need to create them to test your web app. This includes all   table names, primary hash/partition key + sort key (if any), and any Seconday Global Index. **I won't have access to your AWS DynamoDB tables as I don't have your access key so this is a MUST !**

# The Tasks

## Task#1: Subscriptions, Requests, and Locations

You need to design Java classes to represent subscriptions, requests, and locations of users. Java objects created from these classes will be mapped into DynamoDB data items and stored.

## Task#2: Web Services

You need to design web services to support the required operations of the web app. Here are some operations potentially needed:
* To send/approve/deny a subscription request.
* To check-in a user’s current location.
* To retrieve a list of subscriptions.
* To retrieve a specification user’s location.
* To retrieve all friends’ locations.

Hints:
* Think about which services you need.
* For each service, think about:
	* The HTTP method to use.
	* The URL pattern to access the service.
	* The data required by the service, and how they are passed.
	* All possible return status codes of the request.
	* If the request succeeds, the reply data and format.
* In a web service, always validate all parameters. Do not assume that the client will pass all values correctly.

## Task#3: The User Interface

The user interface must be built using HTML, CSS and JavaScript, with the help of the jQuery, jQueryUI libraries and the GoogleMap JavaScript API.

Hints:
* See the example screenshot in Campus Moodle for ideas in designing the UI. Your UI does not need to look the same.
* Information like the a friend’s user ID can be kept in the web page but hidden from the user by using HTML tag attributes like name or id.
* Try to do some validation on the client side before sending any request. e.g. Empty/missing information should be prevented.

## Task#4: The Report

Your report describes the design of your web app. It should contain:
* A statement of compliance  listing all the implemented and un-implemented features. (i.e. a check-list of achieved functionalities)
* A description of your Java classes modelling the subscriptions, requests, and user locations.
* An API specification of your web services. For each web service, you should describe:
	* The operation performed by the web service.
	* The HTTP method used.
	* The URL pattern.
	* The parameters passed with the request.
	* All possible status codes returned by the web service, and their corresponding meanings.
	* The result returned on a successful request. Describe how the result is represented.

# Deliverables

Your submission should include the followings:
* A ZIP file containing all your program source code and supplementary files that allow your system to be tested. This should include:
	* all Java source files
	* all HTML, CSS, and JavaScript files (+image files if any)
	* the web.xml file that defines the web services and URL patterns
	* the pom.xml file that defines dependencies on other libraries
* A report, preferably in PDF format.

[^1]: In reality, secured web services usually expect the client to submit a token which contains the identity of the user. This token is usually sent to the client by the server after a successful authentication. We simplify this process by assuming the submit user ID is already authenticated.