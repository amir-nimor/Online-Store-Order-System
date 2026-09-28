<%@ page import="ir.maktabsharif.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/27/2026
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>

<form action="pay" method="get">


    <%List<Product> productList = (List<Product>) request.getAttribute("products");%>

    <% for (Product p : productList){%>


    <input type="checkbox" name="ProductId" value="<%= p.getId()%>">
    <%= p %>>
    </input><br>



    <%}%>

    <button type="submit">go to pay</button>


</form>




</body>
</html>
