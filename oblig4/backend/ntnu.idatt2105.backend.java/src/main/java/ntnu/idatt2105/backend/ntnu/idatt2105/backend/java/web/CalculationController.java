package ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.model.Calculation.Expression;
import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.model.Calculation.Result;
import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.service.CalculationService;
import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.utils.exceptions.IllegalExpressionException;
import com.fathzer.soft.javaluator.DoubleEvaluator;

@RestController
@RequestMapping(value = "/calculation")
@EnableAutoConfiguration
@CrossOrigin
public class CalculationController {
    // @GetMapping("/hello/{name}")
    // public String hello(@PathVariable("name") String name) {
    // return String.format("Hello %s!", name);
    // }

    private CalculationService service;

    Logger logger = LoggerFactory.getLogger(CalculationController.class);

    // public String index() {
    // logger.trace("A TRACE Message");
    // logger.debug("A DEBUG Message");
    // logger.info("An INFO Message");
    // logger.warn("A WARN Message");
    // logger.error("An ERROR Message");

    // return "Calculation logs...";
    // }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Result calculate(@RequestBody Expression expression) {
        logger.info("Calculating..." + expression.getExpression());
        Result result = new Result(0.0);
        try {
            result.setResult(new DoubleEvaluator().evaluate(expression.getExpression()));
        } catch (IllegalArgumentException e) {
            throw new IllegalExpressionException(e.getMessage());
        }
        return result;
    }

    // Oppgave til deg som leser!
    // Legg til muligheten for å slette en bruker
}
