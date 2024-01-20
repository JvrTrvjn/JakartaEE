package org.jti.apiservlet.webapp.session.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.jti.apiservlet.webapp.session.models.Carro;

@WebListener
public class AppListener implements ServletContextListener,
        ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("App iniciada");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje", "Valor global");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("App destruida");
    }


    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Request iniciada");
        sre.getServletRequest().setAttribute("mensaje", "valor para el request");
    }
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("Request destruida");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("Session http creada");
        Carro carro = new Carro();
        HttpSession session = se.getSession();
        session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Session http destruida");
    }
}
