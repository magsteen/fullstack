package ntnu.idatt2105.backend.model.jpa;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

@Entity
public class Session {
    public static final Duration ABSOLUTE_EXPIRY_DURATION = Duration.ofHours(4);
    public static final Duration IDLE_EXPIRY_DURATION = Duration.ofMinutes(30);
    public static final int TOKEN_SIZE = 32;

    @Id
    @Column(columnDefinition = "BINARY(" + TOKEN_SIZE + ")")
    private byte[] token;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User user;

    @Column(nullable = false)
    private Instant absoluteExpiry;

    @Column(nullable = false)
    private Instant idleExpiry;

    Session() {
    }

    public Session(@NonNull User user) {
        Instant now = Instant.now();
        this.token = generateToken();
        this.user = Objects.requireNonNull(user, "user cannot be null");
        this.idleExpiry = now.plus(IDLE_EXPIRY_DURATION);
        this.absoluteExpiry = now.plus(ABSOLUTE_EXPIRY_DURATION);
    }

    private static byte[] generateToken() {
        byte[] token = new byte[TOKEN_SIZE];
        try {
            SecureRandom.getInstanceStrong().nextBytes(token);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return token;
    }

    public byte[] getToken() {
        return this.token.clone();
    }

    @JsonIgnore
    public boolean isExpired() {
        Instant now = Instant.now();
        return (now.isAfter(this.idleExpiry) ||
                now.isAfter(this.absoluteExpiry));
    }

    public void refresh() {
        this.idleExpiry = Instant.now().plus(IDLE_EXPIRY_DURATION);
    }

    @JsonIgnore
    public User getUser() {
        this.throwIfExpired();
        return this.user;
    }

    private void throwIfExpired() {
        if (this.isExpired())
            throw new IllegalStateException("the session is expired");
    }
}
