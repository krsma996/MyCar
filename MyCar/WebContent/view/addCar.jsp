<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj Vozila</title>
</head>
<body>


<a href="administrator.jsp"> BackToAdminPage</a><br><br>

<form action="../AddCarServlet" method="get">
   Marka <input type="text" name="Marka"> <br>
   Model <input type="text" name="Model"> <br>
   Cena <input type="text" name="Cena"> <br>
   Boja <input type="text" name="Boja"> <br>
   GodinaProizvodnje <input type="text" name="GodinaProizvodnje"> <br>
   Stanje <input type="text" name="Stanje">
           <input type="submit" value="DODAJ"> <br>
           
   



</form>

</body>
</html>