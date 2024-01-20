package org.example.aoiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username"); //como estan definidos en name del Index. Los capturamos en el servlet
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");

        String idiomas = req.getParameter("idiomas");
        String habilitar = req.getParameter("habilitar");
        String secreto = req.getParameter("secreto");

        Map<String,String> errores = new HashMap<>();
        if (username == null || username.trim().isEmpty()) {
            errores.put("username","El nombre de usuario es obligatorio");
        }

        if (password == null || password.isBlank()) {
            errores.put("password","La contraseña es obligatoria");
        }

        if (email == null || !email.contains("@")) {
            errores.put("email","El email es obligatorio");
        }
        if (pais == null || pais.trim().isEmpty()) {
            errores.put("pais","El país es obligatorio");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            errores.put("lenguajes","El lenguaje es obligatorio");
        }
        if (roles == null || roles.length == 0) {
            errores.put("roles","El rol es obligatorio");
        }
        if (idiomas == null || idiomas.trim().isEmpty()) {
            errores.put("idiomas","El idioma es obligatorio");
        }
        if (habilitar == null || habilitar.trim().isEmpty()) {
            errores.put("habilitar","El habilitar es obligatorio");
        }
        if (errores.isEmpty()) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html lang=\"en\">");
                out.println("     <head>");
                out.println("           <meta charset=\"UTF-8\">");
                out.println("           <title>Resultado Form</title>");
                out.println("     </head>");
                out.println("   <body>");
                out.println("       <h1>Resultado Form</h1>");
                out.println("   <ul>");
                out.println("       <li>Username: " + username + "</li>");
                out.println("       <li>Password: " + password + "</li>");
                out.println("       <li>Email: " + email + "</li>");
                out.println("       <li>Pais: " + pais + "</li>");
                //out.println("       <li>Lenguajes: " + String.join(", ", lenguajes) + "</li>");
                // out.println("       <li>Roles: " + String.join(", ", roles) + "</li>");
                out.println("       <li> Lenguajes <ul>");
                Arrays.stream(lenguajes).forEach(lenguaje -> out.println("           <li>" + lenguaje + "</li>"));
                out.println("       </ul></li>");
                out.println("       <li> Roles <ul>");
                Arrays.stream(roles).forEach(role -> out.println("           <li>" + role + "</li>"));
                out.println("       </ul></li>");
                out.println("       <li>Idioma: " + idiomas + "</li>");
                out.println("       <li> Habilitado: " + habilitar + "</li>");
                out.println("       <li> Secreto: " + secreto + "</li>");
                out.println("   </ul>");
                out.println("   </body>");
                out.println("</html>");
            }
        } else {
                        /*errores.forEach(error -> out.println("       <li>" + error + "</li>"));
                        out.println("<p><a href=\"/webapp-form/index.html\">Volver</a></p>");*/
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
}

