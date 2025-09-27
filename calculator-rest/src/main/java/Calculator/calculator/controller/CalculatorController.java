package Calculator.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Calculator.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/sum")
    public int sum(@RequestParam int a, @RequestParam int b){
        return calculatorService.calculating("sum", a, b);
    }
    
    @GetMapping("/sub")
    public int sub(@RequestParam int a, @RequestParam int b){
        return calculatorService.calculating("sub", a, b);
    }
    
    @GetMapping("/div")
    public int div(@RequestParam int a, @RequestParam int b){
        return calculatorService.calculating("div", a, b);
    }
    
    @GetMapping("/mult")
    public int mult(@RequestParam int a, @RequestParam int b){
        return calculatorService.calculating("mult", a, b);
    }
}