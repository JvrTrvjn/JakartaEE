package org.jti.apiservlet.webapp.headers.services;

import org.jti.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl  implements ProductoService{
    @Override
    public List<Producto> findAll() {
        return Arrays.asList(
                new Producto("P1", "Camisa", "Ropa", 100.0),
                new Producto("P2", "Pantalon", "Ropa", 200.0),
                new Producto("P3", "Zapatilla", "Calzado", 300.0));
    }
}
