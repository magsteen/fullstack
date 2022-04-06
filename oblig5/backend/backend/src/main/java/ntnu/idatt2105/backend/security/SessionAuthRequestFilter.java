package ntnu.idatt2105.backend.security;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import ntnu.idatt2105.backend.model.jpa.Session;
import ntnu.idatt2105.backend.service.SessionService;

@Component
public class SessionAuthRequestFilter extends OncePerRequestFilter {
    @Autowired
    private SessionService sessionService;

    Logger logger = LoggerFactory.getLogger(SessionAuthExceptionEntryPoint.class);

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        Session session = getSessionFromRequest(request).orElseGet(() -> {
            logger.trace("No valid user session found.");
            return null;
        });

        if (session != null) {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    session,
                    null,
                    null);
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
            logger.trace("User authed successfully!");
        }

        filterChain.doFilter(request, response);
    }

    private Optional<Session> getSessionFromRequest(HttpServletRequest request) {
        final String authPrefix = "Bearer ";

        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith(authPrefix)) {
            logger.trace("No bearer session token provided.");
            return Optional.empty();
        }
        String base64SessionToken = authorizationHeader.substring(authPrefix.length());
        byte[] sessionToken = Base64.getDecoder().decode(base64SessionToken);
        return sessionService.findAndRefresh(sessionToken).filter(x -> !x.isExpired());
    }
}
