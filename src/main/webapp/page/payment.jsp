<%@ page import="java.util.List" %>
<%@ page import="ir.maktabsharif.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/28/2026
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>payment</title>
</head>
<body>

<form action="payment" method="post">

    <h3>total price = ${totalPrice}</h3>
    <h3>balance = ${balance}</h3>

    <h3>discount = ${discount}</h3>
    <h3>finalPrice = ${finalPrice}</h3>

    <%
        HttpSession session1 = request.getSession(false);
        List<Product> products = (List<Product>) request.getAttribute("productList");
        session1.setAttribute("productList",products);
    %>
<%--    <input type="hidden" name="productList" value="<%=request.getAttribute("productList")%>">--%>
    <input type="hidden" name="finalPrice" value="${finalPrice}">
    <input type="hidden" name="balance" value="${balance}">
    <input type="hidden" name="userId" value="${userId}">
    <button type="submit">pay</button>
</form>

</body>
</html>
