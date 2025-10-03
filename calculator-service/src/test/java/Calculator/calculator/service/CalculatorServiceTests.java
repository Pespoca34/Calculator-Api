package Calculator.calculator.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTests {
 
    @Test
    public void shouldAdd(){
        CalculatorService calculatorService = new CalculatorService();
        String operator = "sum";

        double result = calculatorService.calculating(operator, 3, 2);

        assertEquals(5, result);
    }

    @Test
    public void shouldSubtract(){
        CalculatorService calculatorService = new CalculatorService();
        String operator = "sub";

        double result = calculatorService.calculating(operator, 5, 3);

        assertEquals(2, result);
    }

    @Test
    public void shouldDiv(){
        CalculatorService calculatorService = new CalculatorService();
        String operator = "div";

        double result = calculatorService.calculating(operator, 10, 2);

        assertEquals(5, result);
    }

    @Test
    public void shouldMult(){
        CalculatorService calculatorService = new CalculatorService();
        String operator = "mult";

        double result = calculatorService.calculating(operator, 3, 2);

        assertEquals(6, result);
    }

    @Test
    public void shoulDivideByZero(){
        CalculatorService calculatorService = new CalculatorService();
        String operator = "div";

        try {
            calculatorService.calculating(operator, 5, 0);
        } catch (IllegalArgumentException e){
            assertEquals("Cannot divide by zero", e.getMessage());
        }
    }

    @Test
    public void shouldInvalidOperator(){
        CalculatorService calculatorService = new CalculatorService();
        String operator = "invalid";

        try{
            calculatorService.calculating(operator,5, 3);
        } catch (IllegalArgumentException e){
            assertEquals("Invalid operator", e.getMessage());
        }
    }

}