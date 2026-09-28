<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/28/2026
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addProduct</title>
</head>
<body>


<form method="POST" action="addProduct">


    <label>Product Name:
    <input type="text" name="product_name">
    </label>


    <label>Product Price:
    <input  type="number" name="product_price">
    </label>

    <label> Product quantity:
    <input type="number" name="product_quantity">
    </label>

    <label>Product description:
        <input type="text" name="product_description">
    </label>

    <button type="submit">Submit</button>

</form>

</body>
</html>
