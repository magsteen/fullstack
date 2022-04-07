package ntnu.idatt2105.backend.model.jpa;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Calculation {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String expression;

    @Column(nullable = false)
    private String result;

    Calculation() {
    }

    public Calculation(@NonNull String expression, @NonNull String result) {
        this.expression = Objects.requireNonNull(expression, "expression cannot be null");
        this.result = Objects.requireNonNull(result, "result cannot be null");
    }

    public int getId() {
        return id;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }
}
