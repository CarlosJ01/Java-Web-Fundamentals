<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> <!-- Importando JSTL -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- Importando FMT -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">	
		<title>JSTL Demo</title>	
	</head>
	<body>
		<c:out value="${10+9}"></c:out> <!-- Escribir -->
		
		<c:set var="testScore" value="${10}" scope="session"></c:set> <!-- Definir variables -->
		<c:out value="${testScore}"></c:out>
		
		
		<c:if test="${testScore>=80}"> <!-- Condificon if -->
			<p> Score: <c:out value="${testScore}"></c:out> </p>
		</c:if>
		
		<!-- Swith -->
		<c:choose>
			<c:when test="${ testScore >= 80 }">
				A
			</c:when>
			<c:when test="${ testScore >= 60 && testScore <= 80}">
				B
			</c:when>
			<c:otherwise>
				Default
			</c:otherwise>
		</c:choose>
		
		<!-- For -->
		<c:forEach var="i" begin="1" end="3">
			<c:out value="${i}"></c:out>
		</c:forEach>
		
		<%
			List<String> list = new ArrayList<String>();
			list.add("Steve");
			list.add("John");
			list.add("Alfacentauri");
			request.setAttribute("list", list);
		%>
		
		<!-- Foreach -->
		<c:forEach var="nombre" items="${list}">
			<c:out value="${nombre}"></c:out>
		</c:forEach>
		
		
		<!-- 
		<c:remove var="testScore"/> <!-- Eliminar variable Si afecta si esta comentada @o@
		Remove variable <c:out value="${testScore}"></c:out>		 
		-->
		
		
		<c:set var="accountBalance" value="123.456"></c:set>
		<fmt:parseNumber var="i" type="number" value="${ accountBalance }"></fmt:parseNumber>
		<p> <c:out value="${ i }"></c:out> </p>
		
		<c:set var="accountBalance" value="77777.45456"></c:set>
		<fmt:formatNumber value="${ accountBalance }" type="currency"></fmt:formatNumber> <br>
		<fmt:formatNumber value="${ accountBalance }" type="number"></fmt:formatNumber><br>
		<fmt:formatNumber value="${ accountBalance }" type="number" maxFractionDigits="2"></fmt:formatNumber><br>
		<fmt:formatNumber value="${ accountBalance }" type="number" maxIntegerDigits="2"></fmt:formatNumber><br>
		<fmt:formatNumber value="${ accountBalance }" type="percent"></fmt:formatNumber><br>
		<fmt:formatNumber value="${ accountBalance }" type="number" pattern="###.##$"></fmt:formatNumber><br>
		
		<c:set var="myDate" value="12-07-2019"></c:set>
		<fmt:parseDate var="parseDate" value="${ myDate }" pattern="dd-MM-yyyy"></fmt:parseDate>
		<c:out value="${ parseDate }"></c:out>
	</body>
</html>