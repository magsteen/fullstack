package ntnu.idatt2105.backend.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ntnu.idatt2105.backend.model.InvalidCredentialsException;
import ntnu.idatt2105.backend.model.SessionNotFoundException;
import ntnu.idatt2105.backend.model.UserCredentials;
import ntnu.idatt2105.backend.model.jpa.Session;
import ntnu.idatt2105.backend.model.jpa.User;
import ntnu.idatt2105.backend.repository.SessionRepository;
import ntnu.idatt2105.backend.repository.UserRepository;

@Service
public class SessionService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    Logger logger = LoggerFactory.getLogger(SessionService.class);

    public Session create(UserCredentials credentials) {
        logger.debug("Creating session for user " + credentials.getEmail());

        User user = userRepository.findByEmail(credentials.getEmail())
                .filter((x) -> x.passwordMatches(credentials.getPassword()))
                .orElseThrow(() -> {
                    logger.info("Unable to create session for user: Invalid username or password.");
                    return new InvalidCredentialsException();
                });

        Session session = new Session(user);
        sessionRepository.save(session);

        logger.debug("Session created for " + credentials.getEmail());

        return session;
    }

    @Transactional
    public Optional<Session> findAndRefresh(byte[] token) {
        logger.debug("Finding session");

        Optional<Session> session = sessionRepository.findById(token);
        session.ifPresent(Session::refresh);

        logger.debug(session.isPresent() ? "Session found" : "Session not found");

        return session;
    }

    public void delete(byte[] token) {
        logger.debug("Deleting session");

        Session session = sessionRepository.findById(token)
                .orElseThrow(() -> {
                    logger.warn("Attempted to delete a non-existent session");
                    return new SessionNotFoundException();
                });

        sessionRepository.delete(session);

        logger.debug("Session deleted");
    }

    @Scheduled(fixedDelay = 1000 * 60 * 5) // every 5 minutes
    public void purgeExpired() {
        logger.debug("Cleaning up expired sessions");
        sessionRepository.deleteAllExpired();
    }
}
