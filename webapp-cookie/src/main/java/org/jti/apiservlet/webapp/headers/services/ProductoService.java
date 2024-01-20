package org.jti.apiservlet.webapp.headers.services;

import org.jti.apiservlet.webapp.headers.models.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> findAll();
}
