package Calculator.calculator.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Calculator.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import Calculator.calculator.kafka.CalculationRequest;
import org.springframework.beans.factory.annotation.Value;


@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired(required = false)
    private KafkaTemplate<String, CalculationRequest> kafkaTemplate;

    @Value("${calculator.kafka.topic:calculator-requests}")
    private String kafkaTopic;

    @GetMapping("/sum")
    public double sum(@RequestParam double a, @RequestParam double b){
        if (kafkaTemplate != null) {
            kafkaTemplate.send(kafkaTopic, new CalculationRequest("sum", a, b));
        }
        return calculatorService.calculating("sum", a, b);
    }
    
    @GetMapping("/sub")
    public double sub(@RequestParam double a, @RequestParam double b){
        if (kafkaTemplate != null) {
            kafkaTemplate.send(kafkaTopic, new CalculationRequest("sub", a, b));
        }
        return calculatorService.calculating("sub", a, b);
    }
    
    @GetMapping("/div")
    public double div(@RequestParam double a, @RequestParam double b){
        if (kafkaTemplate != null) {
            kafkaTemplate.send(kafkaTopic, new CalculationRequest("div", a, b));
        }
        return calculatorService.calculating("div", a, b);
    }
    
    @GetMapping("/mult")
    public double mult(@RequestParam double a, @RequestParam double b){
        if (kafkaTemplate != null) {
            kafkaTemplate.send(kafkaTopic, new CalculationRequest("mult", a, b));
        }
        return calculatorService.calculating("mult", a, b);
    }
}