package Calculator.calculator.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Calculator.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import Calculator.calculator.kafka.CalculationRequest;
import org.springframework.beans.factory.annotation.Value;


@RestController
public class CalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

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
        double result = calculatorService.calculating("sum", a, b);
        logger.info("sum request: a={}, b={} => result={}", a, b, result);
        return result;
    }
    
    @GetMapping("/sub")
    public double sub(@RequestParam double a, @RequestParam double b){
        if (kafkaTemplate != null) {
            kafkaTemplate.send(kafkaTopic, new CalculationRequest("sub", a, b));
        }
        double result = calculatorService.calculating("sub", a, b);
        logger.info("sub request: a={}, b={} => result={}", a, b, result);
        return result;
    }
    
    @GetMapping("/div")
    public double div(@RequestParam double a, @RequestParam double b){
        if (kafkaTemplate != null) {
            kafkaTemplate.send(kafkaTopic, new CalculationRequest("div", a, b));
        }
        double result = calculatorService.calculating("div", a, b);
        logger.info("div request: a={}, b={} => result={}", a, b, result);
        return result;
    }
    
    @GetMapping("/mult")
    public double mult(@RequestParam double a, @RequestParam double b){
        if (kafkaTemplate != null) {
            kafkaTemplate.send(kafkaTopic, new CalculationRequest("mult", a, b));
        }
        double result = calculatorService.calculating("mult", a, b);
        logger.info("mult request: a={}, b={} => result={}", a, b, result);
        return result;
    }
}