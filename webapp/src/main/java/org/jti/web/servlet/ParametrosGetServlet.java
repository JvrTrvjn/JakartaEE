package org.jti.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametrosGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta charset=\"UTF-8\">");
        out.println("       <title>$title$</title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("       <h1>Parametros Get de la URL</h1>");
        if(saludo != null && nombre != null) {
            out.println("       <h2>El parametro es " + saludo + nombre + "</h2>");
        } else if (saludo != null) {
            out.println("       <h2>El parametro es " + saludo + "</h2>");
        } else if (nombre != null) {
            out.println("       <h2>El parametro es " + nombre + "</h2>");
        }else {
            out.println("       <h2>Los parametros no se han pasado correctamente (saludo y nombre)</h2>");
        }

        try{
            Integer edad = Integer.valueOf(req.getParameter("edad"));
            out.println("       <h2>La edad es " + edad + "</h2>");
        }catch(NumberFormatException e){
            out.println("       <h2>No se ha pasado la edad</h2>");
        }
        out.println("   </body>");
        out.println("</html>");
        //out.flush();
        out.close();
    }
}
