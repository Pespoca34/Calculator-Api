package Calculator.calculator.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Calculator.calculator.service.CalculatorService;

@Component
public class CalculationConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CalculationConsumer.class);

    @Autowired
    private CalculatorService calculatorService;

    @KafkaListener(topics = "${calculator.kafka.topic:calculator-requests}", groupId = "${spring.kafka.consumer.group-id:calculator-service-group}")
    public void listen(CalculationRequest request) {
        try {
            double result = calculatorService.calculating(request.getOperator(), request.getA(), request.getB());
            logger.info("Received request: {} {} , {} => result={}", request.getOperator(), request.getA(), request.getB(), result);
        } catch (Exception e) {
            logger.error("Error processing request: {}", e.getMessage(), e);
        }
    }
}
