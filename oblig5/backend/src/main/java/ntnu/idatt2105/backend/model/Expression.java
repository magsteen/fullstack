package ntnu.idatt2105.backend.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.NonNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expression {

    @NonNull
    private final String expression;

    @JsonCreator
    public Expression(@NonNull @JsonProperty("expression") final String expression) {
        this.expression = Objects.requireNonNull(expression, "expression cannot be null");
    }

    @JsonProperty("expression")
    public String getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return this.expression;
    }
}
