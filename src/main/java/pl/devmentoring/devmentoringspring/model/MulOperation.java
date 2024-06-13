package pl.devmentoring.devmentoringspring.model;

import org.springframework.stereotype.Component;

@Component
public class MulOperation implements CalculationStrategy {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }

    @Override
    public Operation getStrategy() {
        return Operation.MUL;
    }
}
