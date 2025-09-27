package Calculator.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int calculating(int a, int b, String operator){
        String operatorUnder = operator.toLowerCase();

        if("sum".equals(operatorUnder)){
            return a + b;
        }else if("sub".equals(operatorUnder)){
            return a - b;
        } else if("mult".equals(operatorUnder)){
            return a * b;
        } else if("div".equals(operatorUnder)){
            if(b == 0){
                throw new ArithmeticException("Division not possible!");
            }
            return a / b;
        }
        throw new IllegalArgumentException("Invalid operator!");
    }
}
