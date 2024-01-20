package org.jti.apiservlet.webapp.session.services;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {
    Optional<String> getUsername(HttpServletRequest req);
}
