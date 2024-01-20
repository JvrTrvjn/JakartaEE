package org.jti.apiservlet.webapp.session.services;

import org.jti.apiservlet.webapp.session.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl  implements ProductoService{
    @Override
    public List<Producto> findAll() {
        return Arrays.asList(
                new Producto(1L, "Camisa", "Ropa", 100.0),
                new Producto(2L, "Pantalon", "Ropa", 200.0),
                new Producto(3L, "Zapatilla", "Calzado", 300.0));
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return findAll().stream().filter(p -> p.getId().equals(id)).findAny();
    }
}
