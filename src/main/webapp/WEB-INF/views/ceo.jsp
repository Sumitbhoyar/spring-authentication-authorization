<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CEO</title>
</head>
<body>
	<h1>Hello CEO!</h1>
    <P>Your Roles are ${loggedInUser}.</P>
	<P>The time on the server is ${serverTime}.</P>
	<a href="/j_spring_security_logout">Logout</a>
</body>
</html>