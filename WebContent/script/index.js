sessionStorage.removeItem("token");

function snackbar(message) {
	'use strict';
	var x = document.getElementById("snackbar");
	x.innerHTML = message;
	x.className = "show";
	setTimeout(function() { x.className = x.className.replace("show", ""); }, 3000);
}

function login() {
	'use strict';
	if (0 < $("#user_id").val().length) {
		var url = "api/login",
			user_id = $("#user_id").val(),
			params = {
				"user_id": user_id
			};

		$.ajax(url, {
			"type": "GET",
			"data": params,
			"success": function (data) {

				console.log(data);

				sessionStorage.token = token;
				snackbar("Logging in.");
			},
			"error": function () {
				$("#user_id").val("");
				snackbar("Login failed.");
			}
		});
	}
}

function register() {
	'use strict';
	if (0 < $("#user_id").val().length) {
		var url = "api/register",
			user_id = $("#user_id").val(),
			params = {
				"user_id": user_id
			};

		$.post(url, {
			"data": params,
			"success": function (data) {

				console.log(data);

				sessionStorage.token = token;
				snackbar("User registered.");
			},
			"error": function () {
				$("#user_id").val("");
				snackbar("Registration failed.");
			}
		});
	}
}
/*
// Post a tweet.
function tweet() {
	'use strict';
	var url = "api/tweet", // URL to post tweet
		token = sessionStorage.token, // get token from session storage
		headers = {
			"Authorization": "Bearer " + token
		},
		content = $("#content").val(), // get tweet content
		params = {
			"content": content
		}; // prepare parameters

	$.ajax(url, {
		"type": "POST",
		"headers": headers,
		"data": params,
		"success": function () {
			alert("Tweet posted.");
		},
		"error": function () {
			alert("Posting failed.\nHave you logged in?");
		}
	});
}

// Logout.
function logout() {
	'use strict';
	var url = "api/logout"; // URL to logout service
	var token = sessionStorage.token; // get token from session storage
	var headers = {
		"Authorization": "Bearer " + token
	}; // prepare header

	$.ajax(url, {
		"type": "POST",
		"headers": headers,
		"success": function () {
			sessionStorage.removeItem("token"); // remove token from session storage
			$("#login").show(); // show login section
			$("header").hide(); // hide header with user ID
		},
		"error": function () {
			alert("Logout failed.");
		}
	});
	$("input").val(""); // clear login boxes
}

$(function () {
	'use strict';
	$("header").hide(); // by default, hide user login status
	refresh(); // load tweets when page reloaded
});

// Load tweets and show them on page.
function refresh() {
	'use strict';
	if (sessionStorage.token == null) // check for token in session storage
		return;

	var url = "api/tweet"; // URL of service to retrieve tweets
	var token = sessionStorage.token; // get token if any
	var headers = {
		"Authorization": "Bearer " + token
	};

	$.ajax(url, {
		"type": "GET", // send GET
		"headers": headers,
		"dataType": "json", // expect JSON reply
		"success": function (tweets) {
			$("#tweets").empty(); // clear list of tweets on page
			for (var i in tweets) {
				var tweet = tweets[i];
				var user = tweet["userId"];
				var content = tweet["content"];
				var time = new Date(tweet["timestamp"]);
				var htmlCode = "<li>" + user + " (" + time + "): " + content + "</li>";
				$("#tweets").append(htmlCode);
			}
		},
		"error": function () {
			$("input").val("");
		}
	});
}
*/
