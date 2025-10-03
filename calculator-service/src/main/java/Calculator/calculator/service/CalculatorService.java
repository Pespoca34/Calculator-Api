package Calculator.calculator.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    public double calculating(String operator, double a, double b){
        String operatorUnder = operator.toLowerCase();
        logger.debug("Calculating operator={}, a={}, b={}", operatorUnder, a, b);

        try {
            switch (operatorUnder){
                case "sum":
                    return a + b;
                case "sub":
                    return a - b;
                case "div":
                    if (b == 0.0) {
                        throw new IllegalArgumentException("Cannot divide by zero");
                    }
                    return a / b;
                case "mult":
                    return a * b;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        } catch (Exception e) {
            logger.error("Error calculating operator={}: {}", operatorUnder, e.getMessage(), e);
            throw e;
        }
    }
}