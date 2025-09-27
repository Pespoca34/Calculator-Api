package Calculator.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Calculator.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calc")
    public int calculating(@RequestParam int a, @RequestParam int b, @RequestParam String operator){
        return calculatorService.calculating(a, b, operator);
    }
}
