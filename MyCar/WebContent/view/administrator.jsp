
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    
<%@ page import="model.User" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.AdminDao"%>


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
	
	<p>Adminska strana </p>
	
	<a href = "addBalance.jsp"><button>ADD BALANCE</button></a>
	<a href = "updateBalance.jsp"><button>UPDATE BALANCE</button></a>
	<a href = "addCar.jsp"><button>ADD CAR</button></a>
	<a href="../index.html"> back to index</a>
	
	<hr>
	<br>
	<%
	   List<User> listaUsera = new ArrayList<>();
	   listaUsera = AdminDao.vratiSveUsere();
	%>
	
	
<table border="1">
       <tr>
        <th>ID</th>
        <th>UserName</th>  
        <th>Password</th>  
        <th>Novcanik</th>         
       </tr>
         <%
          for(User u: listaUsera){
         %>
         <tr>
        <td> <%=u.getIdUser() %> </td>
        <td> <%=u.getUserName() %></td>
        <td> <%=u.getPassword() %></td>
        <td> <%=u.getNovcanik() %></td>
        <%
          }
        %>
      </tr>
</table>

</body>
</html>