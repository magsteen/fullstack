package ntnu.idatt2105.backend.model.jpa;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import ntnu.idatt2105.backend.model.PasswordEncoder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "`user`")
public class User {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    public User(
            @NonNull String email,
            @NonNull String password) {
        this.email = Objects.requireNonNull(email, "email cannot be null");
        this.passwordHash = PasswordEncoder.getInstance()
                .encode(Objects.requireNonNull(password, "password cannot be null"));
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.passwordHash = PasswordEncoder.getInstance().encode(password);
    }

    public boolean passwordMatches(String password) {
        return PasswordEncoder.getInstance().matches(password, this.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.email,
                this.passwordHash);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (this.email == null) {
            if (other.email != null)
                return false;
        } else if (!this.email.equals(other.email))
            return false;
        if (this.id != other.id)
            return false;
        if (this.passwordHash == null) {
            if (other.passwordHash != null)
                return false;
        } else if (!this.passwordHash.equals(other.passwordHash))
            return false;
        return true;
    }
}
