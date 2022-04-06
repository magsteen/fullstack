package ntnu.idatt2105.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ntnu.idatt2105.backend.model.jpa.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    List<User> findAll();

    void deleteById(int id);

    Optional<User> findByEmail(String email);
}
