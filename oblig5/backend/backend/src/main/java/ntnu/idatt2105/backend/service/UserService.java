package ntnu.idatt2105.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ntnu.idatt2105.backend.model.UserCredentials;
import ntnu.idatt2105.backend.model.jpa.User;
import ntnu.idatt2105.backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(SessionService.class);

    public User create(UserCredentials credentials) {
        logger.debug("Creating session for user " + credentials.getEmail());

        User user = new User(credentials.getEmail(), credentials.getPassword());
        userRepository.save(user);
        // User user = userRepository.findByEmail(credentials.getEmail())
        // .filter((x) -> x.passwordMatches(credentials.getPassword()))
        // .orElseThrow(() -> {
        // logger.info("Unable to create session for user: Invalid username or
        // password.");
        // return new InvalidCredentialsException();
        // });

        logger.debug("User created for " + credentials.getEmail());

        return user;
    }
}
