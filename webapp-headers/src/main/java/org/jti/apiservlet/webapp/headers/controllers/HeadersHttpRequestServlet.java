package org.jti.apiservlet.webapp.headers.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/headers-request")
public class HeadersHttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

                String method = req.getMethod();
                String requestURI = req.getRequestURI();
                String requestURL = req.getRequestURL().toString();
                String contextPath = req.getContextPath();
                String servletPath = req.getServletPath();
                String ipClient = req.getRemoteAddr();
                String userAgent = req.getHeader("User-Agent");
                int portClient = req.getRemotePort();
                String serverName = req.getServerName();
                int serverPort = req.getServerPort();
                String protocol = req.getProtocol();
                String ip = req.getLocalAddr();
                int port = req.getLocalPort();
                String scheme = req.getScheme();
                String host = req.getHeader("Host");
                String url = scheme + "://" + host + contextPath + servletPath;
                String url2 = scheme + "://" + ip + ":" + port + contextPath + servletPath;

                try(PrintWriter out = resp.getWriter()){
                    out.println("<!DOCTYPE html>");
                    out.println("<html lang=\"en\">");
                    out.println("     <head>");
                    out.println("           <meta charset=\"UTF-8\">");
                    out.println("           <title>Resultado Form</title>");
                    out.println("     </head>");
                    out.println("   <body>");
                    out.println("       <h1>Resultado Form</h1>");
                    out.println("       <ul>");
                    out.println("<li>Method: " + method + "</li>");
                    out.println("<li>RequestURI: " + requestURI + "</li>");
                    out.println("<li>RequestURL: " + requestURL + "</li>");
                    out.println("<li>ContextPath: " + contextPath + "</li>");
                    out.println("<li>ServletPath: " + servletPath + "</li>");
                    out.println("<li>IP Client: " + ipClient + "</li>");
                    out.println("<li>User Agent: " + userAgent + "</li>");
                    out.println("<li>Port Client: " + portClient + "</li>");
                    out.println("<li>Server Name: " + serverName + "</li>");
                    out.println("<li>Server Port: " + serverPort + "</li>");
                    out.println("<li>Protocol: " + protocol + "</li>");
                    out.println("<li>IP: " + ip + "</li>");
                    out.println("<li>Port: " + port + "</li>");
                    out.println("<li>Scheme: " + scheme + "</li>");
                    out.println("<li>Host: " + host + "</li>");
                    out.println("<li>URL: " + url + "</li>");
                    out.println("<li>URL2: " + url2 + "</li>");
                    Enumeration<String> headerNames = req.getHeaderNames();
                    while (headerNames.hasMoreElements()) {
                        String headerName = headerNames.nextElement();
                        out.println("<li>" + headerName + ": " + req.getHeader(headerName) + "</li>");
                    }
                    out.println("</ul>");
                    out.println("   </body>");
                    out.println("</html>");
                }
    }
}
