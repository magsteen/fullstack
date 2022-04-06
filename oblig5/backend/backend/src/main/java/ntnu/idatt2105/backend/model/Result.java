package ntnu.idatt2105.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private double result;

    public Result(@JsonProperty("result") double result) {
        this.result = result;
    }

    @JsonProperty("result")
    public double getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(double result) {
        this.result = result;
    }
}
