package ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.service;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.model.Calculation.Expression;
import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.model.Calculation.Result;
import ntnu.idatt2105.backend.ntnu.idatt2105.backend.java.utils.exceptions.IllegalExpressionException;

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
