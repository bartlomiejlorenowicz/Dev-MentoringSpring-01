package pl.devmentoring.devmentoringspring.service;

import org.springframework.stereotype.Service;
import pl.devmentoring.devmentoringspring.model.CalculationStrategy;
import pl.devmentoring.devmentoringspring.model.Operation;

import java.util.Map;

@Service
public class CalculationService {

    private Map<Operation, CalculationStrategy> calculationStrategyMap;

    public CalculationService(Map<Operation, CalculationStrategy> calculationStrategyMap) {
        this.calculationStrategyMap = calculationStrategyMap;
    }

    public Map<Operation, CalculationStrategy> getCalculationStrategyMap() {
        return calculationStrategyMap;
    }
}
