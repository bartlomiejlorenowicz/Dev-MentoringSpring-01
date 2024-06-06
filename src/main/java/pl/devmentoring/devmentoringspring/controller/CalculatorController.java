package pl.devmentoring.devmentoringspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.devmentoring.devmentoringspring.model.Calculation;
import pl.devmentoring.devmentoringspring.service.CalculationService;

@RestController
public class CalculatorController {

    private CalculationService calculationService;

    @Autowired
    public CalculatorController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/operation")
    public int getOperation(@RequestBody Calculation calculation) {
        return calculationService.operationResult(calculation);
    }

}
