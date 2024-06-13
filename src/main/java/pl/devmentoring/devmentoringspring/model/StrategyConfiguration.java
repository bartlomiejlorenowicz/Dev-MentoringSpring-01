package pl.devmentoring.devmentoringspring.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Configuration
public class StrategyConfiguration {

    private Set<CalculationStrategy> calculationStrategySet;

    public StrategyConfiguration(Set<CalculationStrategy> calculationStrategySet) {
        this.calculationStrategySet = calculationStrategySet;
    }

    @Bean
    public Map<Operation, CalculationStrategy> loadStrategies() {
        Map<Operation, CalculationStrategy> strategyMap = new HashMap<>();
        calculationStrategySet.forEach(el -> {
            strategyMap.put(el.getStrategy(), el);
        });
        return strategyMap;
    }
}
