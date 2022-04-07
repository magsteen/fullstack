package ntnu.idatt2105.backend.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.NonNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    @NonNull
    private String result;

    @JsonCreator
    public Result(@NonNull @JsonProperty("result") double result) {
        this.result = Objects.requireNonNull(Double.toString(result), "result cannot be null");
    }

    @JsonCreator
    public Result(@NonNull @JsonProperty("result") String result) {
        this.result = Objects.requireNonNull(result, "result cannot be null");
    }

    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(double result) {
        this.result = Double.toString(result);
    }
}
