package pl.devmentoring.devmentoringspring.model;

import org.springframework.stereotype.Component;

@Component
public class AddOperation implements CalculationStrategy {

    @Override
    public int execute(int a, int b) {
        return a + b;
    }

    @Override
    public Operation getStrategy() {
        return Operation.ADD;
    }
}
