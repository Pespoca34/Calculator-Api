package Calculator.calculator.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import Calculator.calculator.service.CalculatorService;

@Component
public class CalculationConsumer {

    @Autowired
    private CalculatorService calculatorService;

    @KafkaListener(topics = "${calculator.kafka.topic:calculator-requests}", groupId = "${spring.kafka.consumer.group-id:calculator-service-group}")
    public void listen(CalculationRequest request) {
        try {
            double result = calculatorService.calculating(request.getOperator(), request.getA(), request.getB());
            System.out.println("[CalculationConsumer] Received request: " + request.getOperator() + " " + request.getA() + ", " + request.getB() + " => result=" + result);
        } catch (Exception e) {
            System.err.println("[CalculationConsumer] Error processing request: " + e.getMessage());
        }
    }
}
