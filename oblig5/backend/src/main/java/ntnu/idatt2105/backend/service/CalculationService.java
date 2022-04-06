package ntnu.idatt2105.backend.service;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import org.springframework.stereotype.Service;

import ntnu.idatt2105.backend.model.Expression;
import ntnu.idatt2105.backend.model.Result;
import ntnu.idatt2105.backend.utils.exceptions.IllegalExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CalculationService {

    Logger logger = LoggerFactory.getLogger(CalculationService.class);

    public Result calculate(Expression expression) throws IllegalExpressionException {
        Result result = new Result(0.0);
        try {
            logger.info("Calculating..." + expression.getExpression());
            result.setResult(new DoubleEvaluator().evaluate(expression.getExpression()));
        } catch (IllegalArgumentException e) {
            throw new IllegalExpressionException(e.getMessage());
        }
        return result;
    }
}
