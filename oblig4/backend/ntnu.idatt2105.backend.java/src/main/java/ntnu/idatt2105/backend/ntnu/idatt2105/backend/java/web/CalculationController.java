package ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.model.Calculation.Expression;
import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.model.Calculation.Result;
import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.service.CalculationService;
import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.utils.exceptions.IllegalExpressionException;

@RestController
@RequestMapping(value = "/calculation")
@EnableAutoConfiguration
@CrossOrigin
public class CalculationController {

    @Autowired
    private CalculationService service;

    Logger logger = LoggerFactory.getLogger(CalculationController.class);

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Result calculate(@RequestBody Expression expression) {
        logger.info("Recieved expression..." + expression.getExpression());
        Result result = service.calculate(expression);
        logger.info("Sending result..." + result.getResult());

        return result;
    }
}
