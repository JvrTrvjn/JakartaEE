<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.Map" %>
<%
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de usuario</title>
    <link href=<%request.getContextPath();%>"css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h3 class="text-lg-center">Formulario de usuario</h3>

<%
    if (errores != null && errores.size() > 0) {
%>
<ul class="alert-danger">
    <% for (String error : errores.values()) {%>
    <li><%=error%>
    </li> <!-- se conoce como 'expresion' es igual a out.println(error) -->
    <%}%>
</ul>
<%}%>
<form action="/webapp-form/registro" method="post">
    <div class="container-fluid">
        <label for="username">Nombre de usuario:</label>
        <div class="col-sm-4"><input type="text" name="username" id="username" class="form-control" value="${param.username}"><br>
            <%
                if (errores != null && errores.containsKey("username")) {
                    out.println("<small style='color: red;'>" + errores.get("username") + "</small>");
                }
            %>
        </div>
    </div>
    <div class="container-fluid">
        <label for="password">Contraseña:</label>
        <div class="col-sm-4"><input type="password" name="password" id="password" class="form-control"><br>
            <%
                if (errores != null && errores.containsKey("password")) {
                    out.println("<small style='color: red;'>" + errores.get("password") + "</small>");
                }
            %>
        </div>
    </div>
    <div class="container-fluid">
        <label for="email">Email:</label>
        <div class="col-sm-4"><input type="email" name="email" id="email" class="form-control" value="${param.email}"><br></div>
        <%
            if (errores != null && errores.containsKey("email")) {
                out.println("<small style='color: red;'>" + errores.get("email") + "</small>");
            }
        %>
    </div>
    <div class="container-fluid">
        <label for="pais">Pais:</label>
        <div class="col-sm-4"><select name="pais" id="pais" class="form-select">
            <option value="es" ${param.pais.equals("es")?"selected": ""}>España</option>
            <option value="en" ${param.pais.equals("en")?"selected": ""}>Inglaterra</option>
            <option value="fr" ${param.pais.equals("fr")?"selected": ""}>Francia</option>
            <option value="de" ${param.pais.equals("de")?"selected": ""}>Alemania</option>
            <option value="it" ${param.pais.equals("it")?"selected": ""}>Italia</option>
            <option value="pt" ${param.pais.equals("pt")?"selected": ""}>Portugal</option>
            <option value="ru" ${param.pais.equals("ru")?"selected": ""}>Rusia</option>
            <option value="ch" ${param.pais.equals("ch")?"selected": ""}>Suiza</option>
            <option value="jp" ${param.pais.equals("jp")?"selected": ""}>Japon</option>
        </select></div>
        <%
            if (errores != null && errores.containsKey("pais")) {
                out.println("<small style='color: red;'>" + errores.get("pais") + "</small>");
            }
        %>
    </div>
    <div class="container-fluid">
        <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes:</label>
        <div class="col-sm-4"><select name="lenguajes" id="lenguajes" multiple class="form-select">
            <option value="java" ${paramValues.lenguajes.stream().anyMatch(v-> v.equals("java")).get()?"selected": ""}>Java SE</option>
            <option value="js" ${paramValues.lenguajes.stream().anyMatch(v-> v.equals("js")).get()?"selected": ""}>JavaScript</option>
            <option value="php"${paramValues.lenguajes.stream().anyMatch(v-> v.equals("php")).get()?"selected": ""}>PHP</option>
            <option value="c++"${paramValues.lenguajes.stream().anyMatch(v-> v.equals("c++")).get()?"selected": ""}>C++</option>
            <option value="c#"${paramValues.lenguajes.stream().anyMatch(v-> v.equals("c#")).get()?"selected": ""}>C#</option>
            <option value="python"${paramValues.lenguajes.stream().anyMatch(v-> v.equals("python")).get()?"selected": ""}>Python</option>
            <option value="ruby"${paramValues.lenguajes.stream().anyMatch(v-> v.equals("ruby")).get()?"selected": ""}>Ruby</option>
            <option value="go"${paramValues.lenguajes.stream().anyMatch(v-> v.equals("go")).get()?"selected": ""}>Go</option>
            <option value="scala"${paramValues.lenguajes.stream().anyMatch(v-> v.equals("scala")).get()?"selected": ""}>Scala</option>
        </select></div>
        <%
            if (errores != null && errores.containsKey("lenguajes")) {
                out.println("<small style='color: red;'>" + errores.get("lenguajes") + "</small>");
            }
        %>
    </div>

    <div class="container-fluid">
        <label class="col-form-label col-sm-2">Roles:</label>
        <div class="form-check">
            <input type="checkbox" name="roles" value="Role_ADMIN"
            ${paramValues.roles.stream().anyMatch(v-> v.equals("Role_ADMIN")).get()?"checked": ""}
                   class="form-check-input">
            <label class="form-check-label">ADMIN</label>
        </div>
        <div class="form-check">
            <input type="checkbox" name="roles" value="Role_USER"
            ${paramValues.roles.stream().anyMatch(v-> v.equals("Role_USER")).get()?"checked": ""}
                   checked class="form-check-input">
            <label class="form-check-label">USER</label>
        </div>
        <div class="form-check">
            <input type="checkbox" name="roles" value="Role_MODERATOR"
            ${paramValues.roles.stream().anyMatch(v-> v.equals("Role_MODERATOR")).get()?"checked": ""}
                   class="form-check-input">
            <label class="form-check-label">MODERATOR</label>
        </div>
        <div class="form-check">
            <input type="checkbox" name="roles" value="Role_GUEST"
            ${paramValues.roles.stream().anyMatch(v-> v.equals("Role_GUEST")).get()?"checked": ""}
                   class="form-check-input">
            <label class="form-check-label">GUEST</label>
        </div>
    </div>
    <%
        if (errores != null && errores.containsKey("roles")) {
            out.println("<small style='color: red;'>" + errores.get("roles") + "</small>");
        }
    %>
    <div class="container-fluid">
        <label class="col-form-label col-sm-2">Idiomas</label>
        <div class="form-check">
            <input type="radio" name="idiomas" value="es" class="form-check-input" ${param.idiomas.equals("es")?"checked": ""}>
            <label class="form-check-label">Español</label>
        </div>
        <div class="form-check">
            <input type="radio" name="idiomas" value="en" class="form-check-input" ${param.idiomas.equals("en")?"checked": ""}>
            <label class="form-check-label">Inglés</label>
        </div>
        <div class="form-check">
            <input type="radio" name="idiomas" value="fr" class="form-check-input" ${param.idiomas.equals("fr")?"checked": ""}>
            <label class="form-check-label">Frances</label>
        </div>
    </div>
    <%
        if (errores != null && errores.containsKey("idiomas")) {
            out.println("<small style='color: red;'>" + errores.get("idiomas") + "</small>");
        }
    %>
    <div class="container-fluid">
        <label for="habilitar" class="col-form-label col-sm-2">Habilitar</label>
        <div class="form-check"><input type="checkbox" name="habilitar" id="habilitar" checked
                                       class="form-check-input"></div>
    </div>
    <div class="container-fluid">
        <div>
            <input type="submit" value="Enviar" class="btn btn-primary">
        </div>
    </div>
    <input type="hidden" name="secreto" value="12345">
</form>
</body>
</html>