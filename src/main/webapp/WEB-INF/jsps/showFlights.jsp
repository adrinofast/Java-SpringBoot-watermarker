<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    <%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>------------Flights----------------------</title>
</head>
<body>
<h2>------------Flights----------------------</h2>
<table>
<tr>
<th>ARRIVAL</th>
<th>DEPARTURE CITY</th>
<th>arrivalCity</th>
<th>DEPARTURE TIME</th>	
<tr>

<c:forEach items="${flights}" var="eachFlight">
<tr>
<td>${eachFlight.operatingAirlines}</td>
<td>${eachFlight.departureCity}</td>
<td>${eachFlight.arrivalCity}</td>
<td>${eachFlight.estimatedDepartureTime}</td>

<td><a href="showCompleteReservation?id=${eachFlight.id}"> SELECT</a></td>

</tr>

</c:forEach>

</table>

</body>
</html>