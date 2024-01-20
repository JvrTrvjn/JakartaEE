package org.jti.apiservlet.webapp.session.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImpl implements LoginService{
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            return Optional.of(username);
        }else {
            return Optional.empty();
        }
    }
}
