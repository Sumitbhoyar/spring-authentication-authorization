<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<P>Your Roles are ${loggedInUser}.</P>
	<a href="/j_spring_security_logout">Logout</a>
</body>
</html>