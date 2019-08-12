<%@page import="dao.UserDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="model.User"%>   
 <%@ page import="model.Car" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Racun</title>
</head>
<body>
<%
   User user = (User)session.getAttribute("OvdeJeUser");
   List<Car>listaAuta = (List<Car>)request.getAttribute("listaAuta");
   double TotalPrice = (Double)request.getAttribute("TotalPrice");
   List<String> listaKolicina = (List<String>)request.getAttribute("listaKolicina");
  
%>

User<%=user.getUserName()  %>

Racun <table border="1">
<tr>
   <th>Marka</th>
   <th>Model</th>
   <th>Cena</th>
   <th>Boja</th>
   <th>GodinaProizvodnje</th>
   <th>kolicina</th>
 </tr>
 <%
   for(int i = 0;i<listaAuta.size();i++){
 %>
 
 <tr>

 <td><%=listaAuta.get(i).getMarka() %></td>
 <td><%=listaAuta.get(i).getModel() %></td>
 <td><%=listaAuta.get(i).getCena() %></td>
 <td><%=listaAuta.get(i).getBoja() %></td>
 <td><%=listaAuta.get(i).getGodinaProizvodnje() %></td>
 <td><%=listaAuta.get(i) %>
    
    
 </tr>
<%
   }
 %>
 




</table>
<br><br>
Total Price : <%= TotalPrice %>
 <a href="view/user.jsp">Back to User</a>

</body>
</html>