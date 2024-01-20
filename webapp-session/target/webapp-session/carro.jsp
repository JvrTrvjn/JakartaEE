<%@page contentType="text/html" pageEncoding="UTF-8" import="org.jti.apiservlet.webapp.session.models.*"%>
<%
Carro carro = (Carro) session.getAttribute("carro");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carro de compra</title>
</head>
<body>
<h1>Carro de compra</h1>
<% if(carro == null || carro.getItems().isEmpty()){%>
<p>Lo siento, aun no agregaste productos al carrito</p>
<%}else { %>
<%} %>
<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>precio</th>
        <th>cantidad</th>
        <th>precio</th>
    </tr>
    <%for(ItemCarro item : carro.getItems()){%>
    <tr>
        <td><%=item.getProducto().getId()%></td>
        <td><%=item.getProducto().getNombre()%></td>
        <td><%=item.getProducto().getPrecio()%></td>
        <td><%=item.getCantidad()%></td>
        <td><%=item.getImporte()%></td>
    </tr>
    <%} %>
    <tr>
        <td colspan="4">Total</td>
        <td><%=carro.getTotal()%></td>
    </tr>
</table>
<p><a href="<%=request.getContextPath()%>/productos">Seguir comprando</a></p>
<p><a href="<%=request.getContextPath()%>/index.html">Volver</a></p>

</body>
</html>