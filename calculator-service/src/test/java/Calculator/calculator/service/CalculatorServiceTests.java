package Calculator.calculator.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTests {
 
    @Test
    public void shouldAdd(){
        CalculatorService calculatorService = new CalculatorService();
        String operator = "sum";
        
        int result = calculatorService.calculating(operator, 3, 2);
        
        assertEquals(5, result);
    }

    @Test
    public void shouldSubtract(){
        CalculatorService calculatorService = new CalculatorService();
        String operator = "sub";
        
        int result = calculatorService.calculating(operator, 5, 3);
        
        assertEquals(2, result);
    }

    @Test
    public void shouldDiv(){
        CalculatorService calculatorService = new CalculatorService();
        String operator = "div";

        int result = calculatorService.calculating(operator, 10, 2);

        assertEquals(5, result);
    }

    @Test
    public void shouldMult(){
        CalculatorService calculatorService = new CalculatorService();
        String operator = "mult";

        int result = calculatorService.calculating(operator, 3, 2);

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
}