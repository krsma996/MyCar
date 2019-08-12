<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import= "model.User" %>   
 <%@page import="java.util.List" %>
 <%@page import="dao.UserDao" %>
 <%@page import="model.Car" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body>

<%
      User user = (User)session.getAttribute("OvdeJeUser");
%>
<h1> Zdravo user</h1>
<h2> Dobrodosli <%=user.getUserName() %></h2>
<h3>Stanje na vasem racunu je <%= user.getNovcanik() %></h3>

 <%
   UserDao userDao = new UserDao();
   List<Car>listaAuta = userDao.vratiSveAutomobile();
 %>
 
 <form action="../PlatiRacunServlet" method="post">
 <table border="1">
 <tr>
   <th>ID</th>
   <th>Marka</th>
   <th>Model</th>
   <th>Cena</th>
   <th>Boja</th>
   <th>GodinaProizvodnje</th>
   <th>check</th>
   <th>kolicina</th>
 </tr>
 <%
   for(Car car:listaAuta){
 %>
 
 <tr>
 <td><%=car.getIdCar() %></td>
 <td><%=car.getMarka() %></td>
 <td><%=car.getModel() %></td>
 <td><%=car.getCena() %></td>
 <td><%=car.getBoja() %></td>
 <td><%=car.getGodinaProizvodnje() %></td>
 <td><input type="checkbox" name="check" value="<%=car.getIdCar()%>"></td>
 <td>
     <select name="kolicina">
     <%
       for(int i = 0; i<=car.getStanje();i++){
     %>
       <option value="<%=i %>"><%=i %>></option>
     <%
       }
     %>
     </select>
 
 
 
 </td>

 
 
 </tr>
  <%
   }
 %>
 
 
 </table>
 
 <input type="submit" value="RentCar">
 
 
 
 </form>
 
 </body>
 </html>