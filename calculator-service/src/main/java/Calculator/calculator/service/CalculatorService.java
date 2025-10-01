package Calculator.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int calculating(String operator, int a, int b){
        String operatorUnder = operator.toLowerCase();

        switch (operatorUnder){
            case "sum":
                return a + b;
            case "sub":
                return a - b;
            case "div":
                if (b == 0) {
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