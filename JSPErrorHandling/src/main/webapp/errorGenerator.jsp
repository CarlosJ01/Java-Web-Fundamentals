<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorHandler.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Error generator</title>
	</head>
	<body>
		<%
			String s = "123456abc";
			int num = Integer.parseInt(s);
		%>
	</body>
</html>