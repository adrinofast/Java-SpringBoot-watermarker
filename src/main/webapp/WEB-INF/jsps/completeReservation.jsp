<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
       
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    <%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>

<h2>Complete Reservation</h2>

Airline : ${flight.operatingAirlines} <br/>
Departure City : ${flight.departureCity} 
Arrival City : ${flight.arrivalCity} 

<form action="completeReservation" method="post">

<h2>Passeenger Info</h2>

First Name : <input type="text" name="passengerFirstName"/>
Last Name : <input type="text" name="passengerlastName"/>
Email : <input type="text" name="passengerEmail"/>

Phone : <input type="text" name="passengerPhone"/>


<h2>Card Details</h2>

Name on the Card : <input type="text" name="nameOnTheCard"/>
Card No : <input type="text" name="cardNo"/>
Expiry Date : <input type="text" name="expiryDate"/>
CVV : <input type="text" name="cVV"/>

<input type="hidden" name="FlightId" value="${flight.id}"/> 

<input type="submit" value="confirm"/>
</form>

</body>
</html>