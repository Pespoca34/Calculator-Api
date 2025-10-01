package Calculator.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Calculator.calculator.controller.CalculatorController;
import Calculator.calculator.service.CalculatorService;

public class CalculatorControllerTest {
    
    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSum(){
        String operator = "sum";
        when(calculatorService.calculating(operator, 3, 2)).thenReturn(5);
        
        int result = calculatorController.sum(3, 2);

        assertEquals(5, result);
        verify(calculatorService, times(1)).calculating(operator, 3, 2);
    }

    @Test
    public void testSub(){
        String operator = "sub";
        when(calculatorService.calculating(operator, 5, 3)).thenReturn(2);

        int result = calculatorController.sub(5, 3);
        
        assertEquals(2, result);
        verify(calculatorService, times(1)).calculating(operator, 5, 3);
    }

    @Test
    public void testDiv(){
        String operator = "div";
        when(calculatorService.calculating(operator, 10, 2)).thenReturn(5);

        int result = calculatorController.div(10, 2);

        assertEquals(5, result);
        verify(calculatorService, times(1)).calculating(operator, 10, 2);
    }

    @Test
    public void testMult(){
        String operator = "mult";
        when(calculatorService.calculating(operator, 10, 2)).thenReturn(20);

        int result = calculatorController.mult(10, 2);

        assertEquals(20, result);
        verify(calculatorService, times(1)).calculating(operator, 10, 2);
    }
}
