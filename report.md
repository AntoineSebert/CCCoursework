# Hints on Managing Date & Time Information

## Passing a Date & Time stamp to a web service

The easiest way to pass a date (and time) to a web service is to pass it as a long numeric value which contains both the date and time. The long value is the number of milliseconds since 1970-01-01 00:00. This avoids the problem of passing a string like "2017-02-28 12:30" as a parameter and then parse it into a Java/JavaScript representation. It also avoids the problem of having different date and time representations.

## Converting between a long value to a Date in JavaScript/Java

Both JavaScript and Java can convert between a long and a Date (either JavaScript/Java) object easily.

W3School has some good examples of JavaScript here: http://www.w3schools.com/jsref/jsref_obj_date.asp

In the above page you can also see the methods defined on a JavaScript Date object which allow you to get/set the year, month, day, hour, minute of a Date object. That means once you have a Date object (created from a long value) in JavaScript, you can choose how to display it on a web page.

The conversion between a long and the Java Date object is well-documented in the API document of the java.util.Date class.

