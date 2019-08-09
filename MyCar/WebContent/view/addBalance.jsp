<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Balance</title>
</head>
<body>
<p>Dodaj useru novac</p>

   <form action="../AddBalanceServlet" method="post">
   
      <input type="text" placeholder="UserName" name="UserName">
      <input type="text" placeholder="Balance" name="Balance">
              <input type="submit" value="DODAJ">
  
   </form>




</body>
</html>