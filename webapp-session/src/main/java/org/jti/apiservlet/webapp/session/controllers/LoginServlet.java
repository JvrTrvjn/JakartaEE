package org.jti.apiservlet.webapp.session.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.jti.apiservlet.webapp.session.services.LoginService;
import org.jti.apiservlet.webapp.session.services.LoginServiceCookieImpl;
import org.jti.apiservlet.webapp.session.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login.html", "/login"})
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html lang=\"en\">");
                out.println("     <head>");
                out.println("           <meta charset=\"UTF-8\">");
                out.println("           <title>Has iniciado sesion + " + usernameOptional.get() + "</title>");
                out.println("     </head>");
                out.println("   <body>");
                out.println("       <h3>Hola " + usernameOptional.get()+ " has iniciado sesion con Exito ;)</h3>");
                out.println("<p><a href='"+ req.getContextPath() + "/index.html'>Volver</a></p>");
                out.println("<p><a href='"+ req.getContextPath() + "/logout.html'>Cerrar sesion</a></p>");
                out.println("   </body>");
                out.println("</html>");
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {

            HttpSession session = req.getSession();
            session.setAttribute("username", username);


            resp.sendRedirect(req.getContextPath() + "/login.html");
            //Ya no va a aparecer el login si le damos para atras en el navegador (+ seguridad)
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No estas autorizado");
        }
    }
}
