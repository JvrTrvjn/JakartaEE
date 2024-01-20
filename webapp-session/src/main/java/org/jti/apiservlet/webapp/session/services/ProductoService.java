package org.jti.apiservlet.webapp.session.services;

import org.jti.apiservlet.webapp.session.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
}
