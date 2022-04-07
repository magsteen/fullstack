package ntnu.idatt2105.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ntnu.idatt2105.backend.model.jpa.Calculation;

public interface CalculationRepository extends JpaRepository<Calculation, Integer> {
    Optional<Calculation> findById(int id);

    List<Calculation> findAll();
}
