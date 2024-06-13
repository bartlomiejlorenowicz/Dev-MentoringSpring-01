package pl.devmentoring.devmentoringspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.devmentoring.devmentoringspring.model.CalculationStrategy;
import pl.devmentoring.devmentoringspring.model.Operation;
import pl.devmentoring.devmentoringspring.service.CalculationService;

import java.util.Map;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    private CalculationService calculationService;

    public CalculatorController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/{operation}")
    public int calculate(@PathVariable Operation operation,
                         @RequestParam int a,
                         @RequestParam int b) {
        logger.info("Received request to calculate: operation={}, a={}, b={}", operation, a, b);
        CalculationStrategy strategy = calculationService.getCalculationStrategyMap().get(operation);
        if (strategy != null) {
            int result = strategy.execute(a, b);
            logger.info("Operation: {} a: {}, b: {}, result: {}", operation, a, b, result);
            return result;
        } else {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
