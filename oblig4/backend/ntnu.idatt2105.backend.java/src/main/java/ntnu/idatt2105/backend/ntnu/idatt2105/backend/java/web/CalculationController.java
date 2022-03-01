package ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.web;

import org.springframework.web.bind.annotation.*;
import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.utils.exceptions.IllegalExpressionException;
import com.fathzer.soft.javaluator.DoubleEvaluator;

@RestController
// @RequestMapping("v1")
public class CalculationController {
    // @GetMapping("/hello/{name}")
    // public String hello(@PathVariable("name") String name) {
    // return String.format("Hello %s!", name);
    // }

    @GetMapping(value = "/calculate", consumes = "application/json", produces = "application/json")
    public double calculate(@RequestBody String expression) {
        double result;
        try {
            result = new DoubleEvaluator().evaluate(expression);
        } catch (IllegalArgumentException e) {
            throw new IllegalExpressionException(e.getMessage());
        }
        return result;
    }

    // Oppgave til deg som leser!
    // Legg til muligheten for å slette en bruker
}
