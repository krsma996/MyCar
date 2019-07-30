
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    
<%@ page import="model.User" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>administrator page</title>
</head>
<body>

	<%
		User user = (User)session.getAttribute("OvdeJeUser");
	%>
	
	<h1>DOBRODOŠLI <%=user.getUserName() %> </h1>
	
	<p>Ovo je administratorova strana. Ovde cu ubaciti stvari koje se ticu administratorskih poslova</p>
	
	<a href = "addBalance.jsp"><button>ADD BALANCE</button></a>
	<a href = "updateBalance.jsp"><button>UPDATE BALANCE</button></a>
	<a href = "addCar.jsp"><button>ADD CAR</button></a>