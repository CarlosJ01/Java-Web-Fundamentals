<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product Details</title>
	</head>
	<body>
		<jsp:useBean id="product" class="jsp.Product">
			<jsp:setProperty name="product" property="*"/>
		</jsp:useBean>
		
		Product Details <hr>
		<jsp:getProperty property="id" name="product"/><br>
		<jsp:getProperty property="name" name="product"/><br>	
		<jsp:getProperty property="description" name="product"/><br>	
		<jsp:getProperty property="price" name="product"/><br>
		
	</body>
</html>