package org.jti.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/horaActualizada")
public class HoraActualizadaServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.setContentType("text/html;charset=UTF-8");
            resp.setHeader("refresh", "1");
            LocalTime hora = LocalTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaFormateada = hora.format(formato);
            try(PrintWriter out = resp.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<html lang=\"en\">");
                out.println("     <head>");
                out.println("           <meta charset=\"UTF-8\">");
                out.println("           <title>Hora Actualizada</title>");
                out.println("     </head>");
                out.println("   <body>");
                out.println("       <h1>Hora Actualizada</h1>");
                out.println("       <h3>" + horaFormateada + "</h3>");
                out.println("   </body>");
                out.println("</html>");
            }}}
