package ntnu.idatt2105.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expression {
    private final String expression;

    @JsonCreator
    public Expression(@JsonProperty("expression") final String expression) {
        this.expression = expression;
    }

    @JsonProperty("expression")
    public String getExpression() {
        return expression;
    }
}
