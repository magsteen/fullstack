package ntnu.idatt2105.backend.model.jpa;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;
import ntnu.idatt2105.backend.model.Expression;
import ntnu.idatt2105.backend.model.Result;
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

    public Calculation(@NonNull Expression expression, @NonNull Result result) {
        this.expression = Objects.requireNonNull(expression, "expression cannot be null").toString();
        this.result = Objects.requireNonNull(result, "result cannot be null").toString();
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
