package ntnu.idatt2105.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import ntnu.idatt2105.backend.model.Expression;
import ntnu.idatt2105.backend.model.Result;
import ntnu.idatt2105.backend.model.jpa.Calculation;
import ntnu.idatt2105.backend.service.CalculationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/calculator")
@EnableAutoConfiguration
public class CalculationController {

    @Autowired
    private CalculationService service;

    Logger logger = LoggerFactory.getLogger(CalculationController.class);

    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Result calculate(@RequestBody Expression expression) {
        logger.info("Recieved expression..." + expression.getExpression());
        Result result = service.calculate(expression);

        logger.info("Sending result..." + result.getResult());

        return result;
    }

    @GetMapping(value = "/calculations", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Calculation> getCalculations() {
        logger.info("Request to give calculations...");
        List<Calculation> calculations = service.getCalculations();

        logger.info("Sending result..." + calculations);

        return calculations;
    }
}
