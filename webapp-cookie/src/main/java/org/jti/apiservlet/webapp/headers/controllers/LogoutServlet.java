package org.jti.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jti.apiservlet.webapp.headers.services.LoginService;
import org.jti.apiservlet.webapp.headers.services.LoginServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet({"/logout.html", "/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceImpl();
        Optional<String> username = auth.getUsername(req);
        if (username.isPresent()) {
            Cookie usernameCookie = new Cookie("username", "");
            usernameCookie.setMaxAge(0); //Hace que expire la cookie en el navegador, no se queda en cache y puedes volver al login
            resp.addCookie(usernameCookie);
        }else{
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }
}