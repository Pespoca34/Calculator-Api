package Calculator.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculating(String operator, double a, double b){
        String operatorUnder = operator.toLowerCase();

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
    }
}