package ntnu.idatt2105.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ntnu.idatt2105.backend.model.jpa.Session;

public interface SessionRepository extends JpaRepository<Session, byte[]> {

    Optional<Session> findById(byte[] token);

    List<Session> findAll();

    void deleteById(byte[] token);

    @Modifying
    @Transactional
    @Query("DELETE FROM Session WHERE absoluteExpiry <= CURRENT_TIMESTAMP OR idleExpiry <= CURRENT_TIMESTAMP")
    void deleteAllExpired();
}
